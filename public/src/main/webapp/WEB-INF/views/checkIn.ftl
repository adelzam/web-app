<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Cabinet" />
<#macro m_body>

<div class="container">
    <h2 data-qa="title_searchPage">Онлайн-регистрация на рейс</h2>
    <p data-qa="details_searchPage">Начинается за <b>30 часов</b> и <b>заканчивается за 50 минут</b> до вылета</p>
    <div class="login-box" data-qa="login_block">
        <div class="column">
            <@form.form commandName="checkInForm" action="/webcheckin" acceptCharset="UTF-8" method="post">
                <div>
                    <label for="surmaneLogin">Фамилия пассажира (латинскими)</label>
                    <@form.input path="name" cssStyle="width: 500px; height: 43px; font-size: 32px;"/>
                    <@form.errors path="name" cssClass="form_error" /><br><br>
                </div>
                <div>
                    <label for="numberLogin">Номер брони или билета</label>
                    <@form.input path="book" cssStyle="width: 500px; height: 43px; font-size: 32px;"/>
                    <@form.errors path="book" cssClass="form_error" /><br><br>
                </div>
                <div>
                    <button class="button  button--primary js-submit"
                            style="color: aliceblue; background-color: darkblue">Найти
                    </button>
                </div>
            </@form.form>
        </div>
        <div class="column  column--right">
            <div class="form-tip">
                Регистрируйтесь онлайн и экономьте время в аэропорту.
            </div>
        </div>
    </div>
    <#include "components/footer.ftl" />
</div>

</#macro>