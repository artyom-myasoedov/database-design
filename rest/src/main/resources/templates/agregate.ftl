<#import "header.ftl" as header>
<@header.page>
    <div class="row">
        <div class="col-4 m-3">
            <table class="table">
                <thead>
                Агрегирующая информация
                </thead>
                <tbody>
                <tr>
                    <td>
                        Количество учителей
                    </td>
                    <td>
                        ${tCount}
                    </td>
                </tr>
                <tr>
                    <td>
                        Количество учеников
                    </td>
                    <td>
                        ${pCount}
                    </td>
                </tr>
                <tr>
                    <td>
                        Количество классов
                    </td>
                    <td>
                        ${cCount}
                    </td>
                </tr>
                <tr>
                    <td>
                        Среднее количество учеников в классе
                    </td>
                    <td>
                        ${average}
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-4 m-3">
            <table class="table">
                <thead>
                Количество учеников в классах
                </thead>
                <tbody>
                <#list classes as item>
                    <tr>
                        <td>
                            ${item}
                        </td>

                    </tr>
                </#list>

                </tbody>
            </table>
        </div>
    </div>
</@header.page>
