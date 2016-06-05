<#-- @ftlvariable name="id" type="java.lang.Long" -->
<#include "../template.ftl">
<@mainTemplate title="Airline tickets  | About" />
<#macro m_body>

<div class="container">


    <h2>Регистрация прошла успешно!</h2>
    <h3>Вы можете распечатать <a href="/boardingpass/${id}" style="color: red; text-decoration: none">посадочный талон</a> или <a href="/webcheckin" style="color: red; text-decoration: none">зарегестрироваться</a> на другие рейсы</h3>
    <#include "../components/footer.ftl" />

</div>

</#macro>