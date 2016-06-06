<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Login" />
<#macro m_body>


    <#if error?has_content>
    <div style="color: red;">Error! Please, check your email and password!</div>
    </#if>
<form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
    <div>
        <span>Email*</span>
        <input type="text" name="j_username"/>
    </div>
    <div>
        <span class="pass">Password*</span>
        <input type="password" name="j_password"/>
    </div>
    <div style="padding-top: 30px;margin-left: 33px;">
        <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
        <label for="remember_me" class="inline">Remember me</label>
    </div>
    <input type="submit" value="Login" class="submit" style="margin-left: 32px;"/>
    <a href="/reg" style="margin-left: 15px;">Create an account</a>
</form>


<#--<@form.form commandName="contactForm" action="/contacts" acceptCharset="UTF-8" method="post">-->
<#--<div class="row">-->
    <#--<div class="col-md-8">-->
        <#--<h3>Отправьте нам сообщение</h3>-->
        <#--<form name="sentMessage" id="contactForm" novalidate>-->
            <#--<div class="control-group form-group">-->
                <#--<div class="controls">-->
                    <#--<label>Полное имя :</label>-->
                    <#--<@form.input path="fio" />-->
                    <#--<@form.errors path="fio" cssStyle="color: red;" />-->
                <#--&lt;#&ndash;<input type="text" class="form-control" id="name" required&ndash;&gt;-->
                <#--&lt;#&ndash;data-validation-required-message="Please enter your name.">&ndash;&gt;-->
                <#--&lt;#&ndash;<p class="help-block"></p>&ndash;&gt;-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="control-group form-group">-->
                <#--<div class="controls">-->
                    <#--<label>Номер телефона :</label>-->
                    <#--<@form.input path="phone" />-->
                    <#--<@form.errors path="phone" cssStyle="color: red;" />-->
                <#--&lt;#&ndash;<input type="tel" class="form-control" id="phone" required&ndash;&gt;-->
                <#--&lt;#&ndash;data-validation-required-message="Please enter your phone number.">&ndash;&gt;-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="control-group form-group">-->
                <#--<div class="controls">-->
                    <#--<label>Email Address :</label>-->
                    <#--<@form.input path="email" />-->
                    <#--<@form.errors path="email" cssStyle="color: red;" />-->
                <#--&lt;#&ndash;<input type="email" class="form-control" id="email" required&ndash;&gt;-->
                <#--&lt;#&ndash;data-validation-required-message="Please enter your email address.">&ndash;&gt;-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="control-group form-group">-->
                <#--<div class="controls">-->
                    <#--<label>Сообщение :</label>-->
                    <#--<@form.textarea path="message" rows="10" cols="100" />-->
                    <#--<@form.errors path="message" cssStyle="color: red;" />-->

                <#--&lt;#&ndash;<textarea rows="10" cols="100" class="form-control" id="message" required&ndash;&gt;-->
                <#--&lt;#&ndash;data-validation-required-message="Please enter your message" maxlength="999"&ndash;&gt;-->
                <#--&lt;#&ndash;style="resize:none">&ndash;&gt;-->
                <#--&lt;#&ndash;</textarea>&ndash;&gt;-->
                <#--</div>-->
            <#--</div>-->
            <#--<div id="success"></div>-->
            <#--<!-- For success/fail messages &ndash;&gt;-->
            <#--<button type="submit" class="btn btn-primary">Отправить</button>-->
        <#--</form>-->
    <#--</div>-->

<#--</div>-->
<#--</@form.form>-->

</#macro>