<#import "header.ftl" as header>
<@header.page>
    <div class="row">
        <div class="col-2">
            <h3 class="m-2">Поиск по имени и фамилии</h3>
            <form method="get" action="/teacher/byFirstNameAndLastName">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="firstNameSpan">Имя:</span>
                    <input type="text" class="form-control" placeholder="Имя" aria-label="Имя"
                           aria-describedby="firstName"
                           name="firstName">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="lastNameSpan">Фамилия:</span>
                    <input type="text" class="form-control" placeholder="Фамилия" aria-label="Фамилия"
                           aria-describedby="lastName"
                           name="lastName">
                </div>
                <button class="btn btn-primary m-2" type="submit">Найти</button>
            </form>
            <form method="get" action="/teacher/findAndSort">
                <button class="btn btn-primary m-2" type="submit">Отсортировать по имени</button>
            </form>
        </div>
        <div class="col-10">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Логин</th>
                    <th scope="col">Образование</th>
                    <th scope="col">Предметы</th>
                    <th scope="col">Действия</th>
                </tr>
                </thead>
                <tbody>
                <#list teachers as teacher>
                    <tr>
                        <td>${teacher.getFirstName()}</td>
                        <td>${teacher.getLastName()}</td>
                        <td>${teacher.getUsername()}</td>
                        <td>${teacher.getEducation()}</td>
                        <td>${teacher.getSubjectString()}</td>
                        <td>
                            <div class="container-fluid">
                                <form action="/teacher/deleteById" method="get" class="m-2">
                                    <button class="btn btn-danger" type="submit" name="id" value="${teacher.getId()}">
                                        Удалить
                                    </button>
                                </form>
                                <form action="/teacher/getTimetable" method="get" class="m-2">
                                    <button class="btn btn-primary" type="submit" name="id" value="${teacher.getId()}">
                                        Посмотреть расписание
                                    </button>
                                </form>
                            </div>
                        </td>
                    </tr>
                <#else>
                    <p class="m-3">Отсутствуют записи об учителях</p>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@header.page>