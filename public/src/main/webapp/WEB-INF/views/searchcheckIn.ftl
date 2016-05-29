<#-- @ftlvariable name="tickets" type="java.util.List<com.springapp.mvc.common.TicketInfo>" -->
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Cabinet" />
<#macro m_body>

<div class="container">
    <h2 data-qa="title_searchPage">Онлайн-регистрация на рейс</h2>
    <p data-qa="details_searchPage">Начинается за <b>30 часов</b> и <b>заканчивается за 50 минут</b> до вылета</p>
    <#if tickets??>
        <#list tickets as ticket>
            <div>
                ${ticket.book.name}--${ticket.flight.number}--${ticket.flight.checkInOpen?string('yes','no')}
            </div>
        </#list>
    </#if>
    <#include "components/footer.ftl" />
</div>

</#macro>