<#import "header.ftl" as header>
<@header.page>
    <div class="row m-1">
        <div class="col-3 m-1">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Понедельник</th>
                </tr>
                </thead>
                <tbody>
                <#list l0l as record>
                    <tr>
                        <td>${record.toString()}</td>
                    </tr>
                    <#else>
                        <tr>
                            <td></td>
                        </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-3 m-1">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Вторник</th>
                </tr>
                </thead>
                <tbody>
                <#list l1l as record>
                    <tr>
                        <td>${record.toString()}</td>
                    </tr>
                <#else>
                    <tr>
                        <td></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-3 m-1">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Среда</th>
                </tr>
                </thead>
                <tbody>
                <#list l2l as record>
                    <tr>
                        <td>${record.toString()}</td>
                    </tr>
                <#else>
                    <tr>
                        <td></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row m-1">
        <div class="col-3 m-1">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Четверг</th>
                </tr>
                </thead>
                <tbody>
                <#list l3l as record>
                    <tr>
                        <td>${record.toString()}</td>
                    </tr>
                <#else>
                    <tr>
                        <td></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-3 m-1">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Пятница</th>
                </tr>
                </thead>
                <tbody>
                <#list l4l as record>
                    <tr>
                        <td>${record.toString()}</td>
                    </tr>
                <#else>
                    <tr>
                        <td></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-3 m-1">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Суббота</th>
                </tr>
                </thead>
                <tbody>
                <#list l5l as record>
                    <tr>
                        <td>${record.toString()}</td>
                    </tr>
                <#else>
                    <tr>
                        <td></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@header.page>