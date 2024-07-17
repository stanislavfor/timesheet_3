# Фреймворк Spring (семинары)
## Урок 3. Использование Spring для разработки серверного приложения

### Описание
- Создание простого Spring Boot приложения.
- Настройка и использование Spring Dependency Injection.
- Создание простого REST контроллера.

<br><br>

### Домашнее задание


1. Повторить все, что на семинаре.<br><br>
2. В объект timesheet в поле createdAt должно подставляться текущее время на стороне сервера!
Т.е. не клиент присылает, а сервер устанавливает.<br>
- необходимо, чтобы createdAt устанавливался автоматически на сервере.
3. Создать отдельный контроллер для проектов (поле Timesheet.project)<br>
3.1 Создать класс **Project** с полями id, name<br>
3.2 Создать CRUD-контроллер для класса Project, сервис и репозиторий<br>
3.3 В ресурсе **Timesheet** поле project изменить на projectId<br>
3.4 При создании Timesheet проверять, что project с идентификатором **projectId** существует<br><br>

4. Создать ресурс 
```/projects/{id}/timesheets ``` - загрузить таймашиты для конкретного проекта<br><br>
5. Создать ресурс ```/timesheets?createdAtAfter=2024-07-04```<br>
- ручка для получения всех таймшитов, которые созданы ПОСЛЕ указанного параметра.<br>
- Аналогично createdAtBefore<br>


<br><br>

### Решение

1. В классе Timesheet.java добавляем поле private String projectId вместо private String project и указываем конструктор класса для поля private LocalDate createdAt.
2. Добавляем класс проекта Project.java с полями id и name.
3. Создаем репозиторий, сервис и контроллер для Project анналогично Timesheet в соответствующих директориях.
4. Обновляем сервис TimesheetService и контроллер TimesheetController для работы существующего проекта с добавленными данными.
5. Обновляем импорт зависимостей в классах проекта или зависимости и конфигурацию Maven (pom.xml). 

### Установка Postman

1. Скачать Postman с официального сайта Postman: https://www.postman.com/downloads/ и установить в ПК. Запустить Postman в ПК.<br><br>

2. После установки открыть приложение Postman и создать новый запрос. Для этого нажать кнопку New в верхнем левом углу и выбрать Request. <br>Можно ввести имя запроса и сохранить его в новой или существующей коллекции.<br><br>

3. Настройка запроса<br>
3.1 Выбрать метод (GET, POST, PUT, DELETE и т.д.). Ввести URL-адрес API, <br> например <br>
http://localhost:8080/timesheets 
```
http://localhost:8080/timesheets 
```
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;или <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;http://localhost:8080/projects 

```
http://localhost:8080/projects 

```
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2 Для POST, PUT запросов перейти на вкладку Body, выбрать raw и формат JSON, затем ввести JSON данные.  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSON данных для POST запроса:

```
{
    "projectId": "1",
    "project": "spring",
    "minutes": 120,
    "createdAt": "2024-07-04"
}
```
 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Нажать кнопку Send и проверить ответ в нижней части окна Postman.<br><br><br>