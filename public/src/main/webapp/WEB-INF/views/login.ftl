<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Login" />
<#macro m_body>

<div class="container">
    <#if error?has_content>
        <div style="color: red;">Введен неправильный пароль или пользователь не зарегестрирован в системе. <br>
            При регитрации данные были высланы на указанный Email</div>
    </#if>
    <div class="row">
        <div class="col-md-8">
            <h3  style="padding: 18px 0px;">LOGIN INFORMATION</h3>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <div class="control-group form-group">
                    <span>Email*</span>
                    <input type="text" name="j_username"/>
                </div>
                <div class="control-group form-group">
                    <span class="pass">Password*</span>
                    <input type="password" name="j_password"/>
                </div>
                <div class="control-group form-group">
                    <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Remember me</label>
                </div>
                <input type="submit" value="Login"  class="btn btn-primary"/>
                <a href="/reg" style="margin-left: 15px;">Create an account</a>
            </form>
        </div>
    </div>

    <hr>
    <#include "components/footer.ftl" />
</div>

</#macro>