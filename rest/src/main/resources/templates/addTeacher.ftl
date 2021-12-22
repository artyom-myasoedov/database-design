<#import "header.ftl" as header>
<@header.page>
    <form action="/teacher/addTeacher" method="post">
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
            <span class="input-group-text" id="educationSpan">Образование:</span>
            <input type="text" class="form-control" placeholder="Образование" aria-label="Образование"
                   aria-describedby="education"
                   name="education">
        </div>
        <select class="form-select m-3" name="subjects">
            <option value="BIOLOGY" selected>Биология</option>
            <option value="RUSSIAN">Русский язык</option>
            <option value="MATHEMATICS">Математика</option>
            <option value="ENGLISH">Английский язык</option>
            <option value="HISTORY">История</option>
            <option value="GEOGRAPHY">География</option>
            <option value="LITERATURE">Литература</option>
            <option value="PHYSICAL_EDUCATION">Физкультура</option>
            <option value="SOCIAL_STUDIES">Обществознание</option>
            <option value="PHYSICS">Физика</option>
        </select>
        <button class="btn btn-primary m-3" type="submit">Добавить</button>
    </form>
</@header.page>