package ru.gb.timesheet.service;

import org.springframework.stereotype.Service;
import ru.gb.timesheet.model.Timesheet;
import ru.gb.timesheet.repository.TimesheetRepository;
import ru.gb.timesheet.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service // то же самое, что и Component
public class TimesheetService {

//  private final TimesheetRepository repository;
    private final TimesheetRepository timesheetRepository;
    private final ProjectRepository projectRepository;

//  public TimesheetService(TimesheetRepository repository) {
//    this.repository = repository;
//  }
    
  public TimesheetService(TimesheetRepository timesheetRepository, ProjectRepository projectRepository) {
    this.timesheetRepository = timesheetRepository;
    this.projectRepository = projectRepository;
  }

  public Optional<Timesheet> getById(Long id) {
//    return repository.getById(id);
      return timesheetRepository.getById(id);
  }

  public List<Timesheet> getAll() {
//    return repository.getAll();
      return timesheetRepository.getAll();
  }

  public Timesheet create(Timesheet timesheet) {
//    return repository.create(timesheet);
      if (projectRepository.findById(Long.parseLong(timesheet.getProjectId())).isPresent()) {
            return timesheetRepository.create(timesheet);
        } else {
            throw new IllegalArgumentException("Project with ID " + timesheet.getProjectId() + " does not exist");
        }
  }

  public void delete(Long id) {
//    repository.delete(id);
      timesheetRepository.delete(id);
  }

}
