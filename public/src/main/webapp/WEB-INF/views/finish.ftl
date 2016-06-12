<#-- @ftlvariable name="ticket" type="com.springapp.mvc.common.TicketInfo" -->
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Book" />
<#macro m_body>

<div class="container">

    <h2>Покупка прошла успешно</h2>
    <h3>Бронь номер: <label style="color: red">${ticket.book.name}</label></h3>
    <div>
        <div style="width: 840px; background-color: lightyellow; display: inline-block; float: left">
            <h3 style="margin-left: 2%;">
                <label>Пассажир: ${ticket.passenger.firstName}, ${ticket.passenger.lastName}</label>
                <br>
                <label id="dep" style="font-weight: 400">${ticket.flight.route.departure.name}
                    , ${ticket.flight.route.departure.city} </label>
                &#8594; <label id="arr" style="font-weight: 400">${ticket.flight.route.arrival.name}
                , ${ticket.flight.route.arrival.city}</label></h3>
            <h4 style="margin-left: 2%;"><label id="info" style="font-weight: 200">
            ${ticket.flight.date}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.flight.time}&nbsp;&nbsp;${ticket.flight.route.departure.name}&nbsp;&#8594;&nbsp;${ticket.flight.route.arrival.name}&nbsp;&nbsp;${ticket.flight.artime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TJ${ticket.flight.number}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.flight_class.type}
            </label>
            </h4>
        </div>
        <div style="width: 270px; background-color: lightyellow; display: inline-block; float: right">
            <table>
                <tr>
                    <#if ticket.check_in==true>
                        <a href="/boardingpass/${ticket.id}" target="_blank">
                            <button style="background-color: red; color: white">Посадочный талон</button>
                        </a>
                    <#elseif true == ticket.flight.checkInOpen>
                        <a href="/checkin/${ticket.id}">
                            <button style="background-color: red; color: white">
                                Зарегестрироваться
                            </button>
                        </a>
                    <#elseif false == ticket.flight.checkInOpen>
                        <div style="background-color: lightgray; color: black">Регистрация недоступна</div>
                    </#if>
                    <br>
                    <a href="/ticket/${ticket.id}" target="_blank">
                        <button style="background-color: red; color: white">
                            Билет
                        </button>
                    </a>
                    <br>
                    <br>
                    <a href="/"><h4 style="text-decoration: none; color: red">На главную</h4></a>
                    <a href="/webcheckin"><h4 style="text-decoration: none; color: red">К бронированиям</h4></a>
                    <br>
                    <br>
                </tr>
            </table>
        </div>
    </div>

    <hr>
    <#include "components/footer.ftl" />

</div>

</#macro>