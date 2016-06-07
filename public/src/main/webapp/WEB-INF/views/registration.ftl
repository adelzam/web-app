<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Login" />
<#macro m_body>

<div class="container">
    <@form.form commandName="regForm" action="/reg" acceptCharset="UTF-8" method="post">
        <div class="row">
            <div class="col-md-8">

                <h3  style="padding: 18px 0px;">PERSONAL INFORMATION</h3>
            <#--<@form.errors path="*" cssStyle="color: red;" />-->
                <div class="control-group form-group">
                    <span>FIO<label>*</label></span>
                    <@form.input path="fio" />
                    <@form.errors path="fio" cssStyle="color: red;" />
                </div>
                <div class="control-group form-group">
                    <span>Email Address<label>*</label></span>
                    <@form.input path="email" />
                    <@form.errors path="email" cssStyle="color: red;" />
                </div>
                <div class="control-group form-group">
                    <span>Phone<label>*</label></span>
                    <@form.input path="phone" />
                    <@form.errors path="phone" cssStyle="color: red;" />
                </div>


                <div class="register-bottom-grid">
                    <h3  style="padding: 18px 0px;">LOGIN INFORMATION</h3>
                    <div class="control-group form-group">
                        <span>Password<label>*</label></span>
                        <@form.password path="password" />
                        <@form.errors path="password" cssStyle="color: red;" />
                    </div>
                    <div class="control-group form-group">
                        <span>Confirm Password<label>*</label></span>
                        <@form.password path="confirmPassword" />
                        <@form.errors path="confirmPassword" cssStyle="color: red;" />
                    </div>
                    <div class="clearfix"></div>
                </div>
                    <input type="submit" value="Join"  class="btn btn-primary">
            </div>
        </div>
    </@form.form>

    <hr>
    <#include "components/footer.ftl" />
</div>
</#macro>