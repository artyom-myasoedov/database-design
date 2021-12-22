<#macro page>
    <!DOCTYPE HTML>
    <html lang="ru">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                crossorigin="anonymous">
        </script>
        <title>Проектирование бд</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/pupil/byFirstNameAndLastName">Ученики</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/teacher/byFirstNameAndLastName">Преподаватели</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/pupil/addingPage">Добавить ученика</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/teacher/addingPage">Добавить преподавателя</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/teacher/agregate">Агрегативная информация</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <#nested>
    </div>
    </body>
    </html>
</#macro>