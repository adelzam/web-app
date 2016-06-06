<#-- @ftlvariable name="flights" type="java.util.List<com.springapp.mvc.common.FlightInfo>" -->
<#-- @ftlvariable name="tickets" type="java.util.List<com.springapp.mvc.common.TicketInfo>" -->
<#-- @ftlvariable name="passengers" type="java.util.List<com.springapp.mvc.common.PassengersInfo>" -->
<#include "../template.ftl">
<@mainTemplate title="Airline tickets  | Admin" />
<#macro m_body>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Администрирование сайта</h2>
        </div>
        <div class="col-lg-12">

            <ul id="myTab" class="nav nav-tabs nav-justified">
                <li class="active"><a href="#service-one" data-toggle="tab"><i class="fa"></i> Управление
                    бронированиями пассажиров</a>
                </li>
                <li class=""><a href="#service-two" data-toggle="tab"><i class="fa"></i> Управление рейсами</a>
                </li>
                <li class=""><a href="#service-three" data-toggle="tab"><i class="fa"></i> Управления данными
                    пассажиров</a>
                </li>
            </ul>

            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="service-one">
                    <h4>Управление бронированиями</h4>
                    <table class="table">
                        <tr>
                            <th>Номер</th>
                            <th>ФИО пассажира</th>
                            <th>Бронь</th>
                            <th>Аэроопрт вылета</th>
                            <th>Вермя вылета</th>
                            <th>Дата вылета</th>
                            <th>Аэропорт прилета</th>
                            <th>Вермя прилета</th>
                            <th>Дата прилета</th>
                            <th>Класс обслуживания</th>
                            <th></th>
                        </tr>
                        <#if tickets??>
                            <#list tickets as ticket>
                                <tr style="font-weight: 300">
                                    <td>${ticket.num}</td>
                                    <td>${ticket.passenger.firstName} ${ticket.passenger.lastName}</td>
                                    <td>${ticket.book.name}</td>
                                    <td>${ticket.flight.route.departure.name}
                                        , ${ticket.flight.route.departure.city}</td>
                                    <td>${ticket.flight.time}</td>
                                    <td>${ticket.flight.date}</td>
                                    <td>${ticket.flight.route.arrival.name}, ${ticket.flight.route.arrival.city}</td>
                                    <td>${ticket.flight.artime}</td>
                                    <td>${ticket.flight.ardate}</td>
                                    <td>${ticket.flight_class.type}</td>
                                    <td>
                                        <a href="/admin/delete/ticket/${ticket.id}">
                                            <button class="button">Удалить</button>
                                        </a></td>
                                </tr>
                            </#list>
                        </#if>
                    </table>
                    <#if !tickets??>Информации не найдено</#if>
                </div>
                <div class="tab-pane fade" id="service-two">
                    <h4>Управление рейсами</h4>
                    <table class="table">
                        <tr>
                            <th>Номер</th>
                            <th>Аэроопрт вылета</th>
                            <th>Вермя вылета</th>
                            <th>Дата вылета</th>
                            <th>Аэропорт прилета</th>
                            <th>Вермя прилета</th>
                            <th>Дата прилета</th>
                            <th>Тип самолета</th>
                            <th>Номер борта</th>
                            <th>Изменить</th>
                            <th>Удалить</th>
                        </tr>
                        <#if flights??>
                            <#list flights as flight>
                                <tr style="font-weight: 300">
                                    <td>TJ${flight.number}</td>
                                    <td>${flight.route.departure.name}, ${flight.route.departure.city}</td>
                                    <td>${flight.time}</td>
                                    <td>${flight.date}</td>
                                    <td>${flight.route.arrival.name}, ${flight.route.arrival.city}</td>
                                    <td>${flight.artime}</td>
                                    <td>${flight.ardate}</td>
                                    <td>${flight.plane.type}</td>
                                    <td>${flight.plane.name}</td>
                                    <td>
                                        <a href="/admin/update/flight/${flight.id}">
                                            <button class="button">Изменить</button>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="/admin/delete/flight/${flight.id}">
                                            <button class="button">Удалить</button>
                                        </a></td>
                                </tr>
                            </#list>
                        </#if>
                    </table>
                    <a href="/admin/add/flight">
                        <button class="button">Создать новый</button>
                    </a>
                    <#if !tickets??>Информации не найдено</#if>
                </div>
                <div class="tab-pane fade" id="service-three">
                    <h4>Управления данными
                        пассажиров</h4>
                    <table class="table">
                        <tr>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Документ</th>
                            <th>Дата рождения</th>
                            <th>Изменить</th>
                            <th>Удалить</th>
                        </tr>
                        <#if passengers??>
                            <#list passengers as passenger>
                                <tr style="font-weight: 300">
                                    <td>${passenger.firstName}</td>
                                    <td>${passenger.lastName}</td>
                                    <td>${passenger.passport}</td>
                                    <td>${passenger.birth?date}</td>
                                    <td>
                                        <a href="/admin/update/passenger/${passenger.id}">
                                            <button class="button">Изменить</button>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="/admin/delete/passenger/${passenger.id}">
                                            <button class="button">Удалить</button>
                                        </a></td>
                                </tr>
                            </#list>
                        </#if>
                    </table>
                    <#if !tickets??>Информации не найдено</#if>
                </div>
            </div>

        </div>
    </div>

    <#include "../components/footer.ftl" />

</div>

</#macro>