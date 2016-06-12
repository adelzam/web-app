<#-- @ftlvariable name="user" type="com.springapp.mvc.common.UserInfo" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Change personal information" />
<#macro m_body>

<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Личный кабинет</h1>
            <ol class="breadcrumb">
                <li><a href="/">Home</a>
                </li>
                <li><a href="/cabinet">Cabinet</a>
                </li>
                <li class="active">Change information</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->
    <a class="btn btn-lg btn-default" href="/cabinet">Назад (Изменения не сохранятся)</a>

    <@form.form commandName="updateForm" action="/cabinet/change" acceptCharset="UTF-8" method="post">
        <div class="row">
            <div class="col-md-8">

                <h3 style="padding: 18px 0px;">CHANGE PERSONAL INFORMATION</h3>
            <#--<@form.errors path="*" cssStyle="color: red;" />-->
                <div class="control-group form-group">
                    <span>FIO<label>*</label></span>
                    <@form.input path="fio" value="${user.fio}"/>
                    <@form.errors path="fio" cssStyle="color: red;" />
                </div>
                <div class="control-group form-group">
                    <span>Phone<label>*</label></span>
                    <@form.input path="phone" value="${user.phone}"/>
                    <@form.errors path="phone" cssStyle="color: red;" />
                </div>


                <div class="register-bottom-grid">
                    <h3 style="padding: 18px 0px;">CHANGE LOGIN INFORMATION (Пароль перезапишется)</h3>
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
                <input type="submit" value="Update" class="btn btn-primary">

            </div>
        </div>
    </@form.form>

    <hr>
    <#include "components/footer.ftl" />
</div>
</#macro>