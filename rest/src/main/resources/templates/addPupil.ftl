<#import "header.ftl" as header>
<@header.page>
    <form action="/pupil/addPupil" method="post">
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
        <div class="input-group mb-3">
            <span class="input-group-text" id="usernameSpan">Логин:</span>
            <input type="text" class="form-control" placeholder="Логин" aria-label="Логин"
                   aria-describedby="username"
                   name="username">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="educationSpan">Класс:</span>
            <input type="text" class="form-control" placeholder="Класс" aria-label="Класс"
                   aria-describedby="education"
                   name="className">
        </div>
        <button class="btn btn-primary m-3" type="submit">Добавить</button>
    </form>
</@header.page>