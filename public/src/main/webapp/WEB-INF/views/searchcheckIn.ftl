<#-- @ftlvariable name="tickets" type="java.util.List<com.springapp.mvc.common.TicketInfo>" -->
<#-- @ftlvariable name="book" type="java.lang.String" -->
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Cabinet" />
<#macro m_body>

<div class="container">
    <h2 data-qa="title_searchPage">Онлайн-регистрация на рейс</h2>
    <p data-qa="details_searchPage">Начинается за <b>30 часов</b> и <b>заканчивается за 50 минут</b> до вылета</p>
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
            </tr>
            <#list tickets as ticket>
                <tr>
                    <td>${ticket.passenger.firstName} ${ticket.passenger.lastName}</td>
                    <td>${ticket.flight.number}</td>
                    <td>${ticket.flight.date}</td>
                    <td>${ticket.flight.time}</td>
                    <td>${ticket.flight_class.type}</td>
                    <td><#if ticket.check_in==true>
                        <button href="#" style="background-color: red; color: white">Посадочный талон</button>
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
                </tr>
            </#list>
        </table>
    </#if>
    <#include "components/footer.ftl" />
</div>

</#macro>