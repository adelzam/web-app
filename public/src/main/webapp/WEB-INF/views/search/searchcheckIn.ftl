<#-- @ftlvariable name="tickets" type="java.util.List<com.springapp.mvc.common.TicketInfo>" -->
<#-- @ftlvariable name="book" type="java.lang.String" -->
<#include "../template.ftl">
<@mainTemplate title="Airline tickets  | Cabinet" />
<#macro m_body>

<div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Онлайн-регистрация на рейс <br>
                <small>Начинается <b>за 30 часов</b> и <b>заканчивается за 50 минут</b> до вылета</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/">Home</a>
                </li>
                <li><a href="/services">Services</a>
                </li>
                <li class="active">Online check</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <#if !tickets??>
        <span>Билетов не найдено. Проверте введенные данные.</span>
    </#if>
    <#if tickets??>
        <#if book??>
            <h2>Билеты доступные по брони № <label style="color: red">${book}</label></h2>
        </#if>
        <table class="table">
            <tr>
                <th>Пассажир</th>
                <th>Рейс</th>
                <th>Дата</th>
                <th>Время</th>
                <th>Класс</th>
                <th>Регистрация на рейc</th>
                <th>Билет</th>
            </tr>
            <#list tickets as ticket>
                <tr>
                    <td>${ticket.passenger.firstName} ${ticket.passenger.lastName}</td>
                    <td>${ticket.flight.number}</td>
                    <td>${ticket.flight.date}</td>
                    <td>${ticket.flight.time}</td>
                    <td>${ticket.flight_class.type}</td>
                    <td><#if ticket.check_in==true>
                        <a href="/boardingpass/${ticket.id}" target="_blank">
                            <button style="background-color: red; color: white">Посадочный талон</button>
                        </a>
                    <#elseif true==ticket.flight.checkInOpen>
                        <a href="/checkin/${ticket.id}">
                            <button style="background-color: red; color: white">
                                Зарегестрироваться
                            </button>
                        </a>
                    <#elseif false==ticket.flight.checkInOpen>
                        <div style="background-color: lightgray; color: black">Регистрация недоступна</div>
                    </#if>
                    </td>
                    <td>
                        <a href="/ticket/${ticket.id}" target="_blank">
                            <button style="background-color: red; color: white">
                                Билет
                            </button>
                        </a>
                    </td>
                </tr>
            </#list>
        </table>
    </#if>
    <hr>
    <#include "../components/footer.ftl" />
</div>

</#macro>