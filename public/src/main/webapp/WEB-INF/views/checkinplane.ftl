<#-- @ftlvariable name="flight" type="com.springapp.mvc.common.FlightInfo" -->
<#-- @ftlvariable name="seats" type="java.util.List<java.util.ArrayList<java.lang.Boolean>>" -->
<#-- @ftlvariable name="class" type="java.lang.String" -->
<#-- @ftlvariable name="num" type="java.lang.Integer" -->

<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Check in" />
<#macro m_body>
<div class="container">
    <h2 data-qa="title_searchPage">Онлайн-регистрация на рейс</h2>
    <p data-qa="details_searchPage">Начинается за <b>30 часов</b> и <b>заканчивается за 50 минут</b> до вылета</p>
    <#if !flight??>
        <span>Временная ошибка сервера. Повторите попытку позже.</span>
    </#if>
    <#if flight??>
        <h2>Регистрация на рейс TJ<label style="color: red">${flight.number}</label></h2>
        <h2>Дата вылета:<label style="color: red"> ${flight.date}</label></h2>
        <h2>Время вылета:<label style="color: red">${flight.time}</label></h2>
        <#if class="business">
            <#include "checkinplanebusiness.ftl"/>
        </#if>
        <#if class="economy">
            <#include "checkinplaneeconomy.ftl"/>
        </#if>
    </#if>
    <#include "components/footer.ftl" />
</div>

</#macro>