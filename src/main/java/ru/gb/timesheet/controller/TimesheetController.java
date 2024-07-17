package ru.gb.timesheet.controller;

import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.timesheet.model.Timesheet;
import ru.gb.timesheet.service.TimesheetService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {

  // GET - получить - не содержит тела
  // POST - create
  // PUT - изменение
  // PATCH - изменение
  // DELETE - удаление

  // @GetMapping("/timesheets/{id}") // получить конкретную запись по идентификатору
  // @DeleteMapping("/timesheets/{id}") // удалить конкретную запись по идентификатору
  // @PutMapping("/timesheets/{id}") // обновить конкретную запись по идентификатору

  private final TimesheetService service;

  public TimesheetController(TimesheetService service) {
      
    this.service = service;
  }

  // /timesheets/{id}
  @GetMapping("/{id}") // получить все
  public ResponseEntity<Timesheet> get(@PathVariable Long id) {
    Optional<Timesheet> ts = service.getById(id);

    if (ts.isPresent()) {
//      return ResponseEntity.ok().body(ts.get());
      return ResponseEntity.status(HttpStatus.OK).body(ts.get());
    }

    return ResponseEntity.notFound().build();
      
  }

  @GetMapping // получить все
  public ResponseEntity<List<Timesheet>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @PostMapping // создание нового ресурса
  public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {
    timesheet = service.create(timesheet);

    // 201 Created
    return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);

    // 204 No Content
    return ResponseEntity.noContent().build();
  }
    
   @GetMapping("/projects/{projectId}")
   public ResponseEntity<List<Timesheet>> getByProjectId(@PathVariable String projectId) {
     return ResponseEntity.ok(service.getAll().stream().filter(timesheet -> projectId.equals(timesheet.getProjectId())).toList());
    }

    @GetMapping("/createdAtAfter")
    public ResponseEntity<List<Timesheet>> getCreatedAfter(@RequestParam LocalDate createdAtAfter) {
        return ResponseEntity.ok(service.getAll().stream().filter(timesheet -> timesheet.getCreatedAt().isAfter(createdAtAfter)).toList());
    }

    @GetMapping("/createdAtBefore")
    public ResponseEntity<List<Timesheet>> getCreatedBefore(@RequestParam LocalDate createdAtBefore) {
        return ResponseEntity.ok(service.getAll().stream().filter(timesheet -> timesheet.getCreatedAt().isBefore(createdAtBefore)).toList());
    }

}
