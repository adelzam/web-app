<#-- @ftlvariable name="id" type="java.lang.Long" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | About"/>
<#macro m_body>


<div class="container">
    <h2>Редактирование информации о пассажире</h2>
    <br><br>
    <div class="form-group">
        <@form.form commandName="updatePForm" action="/admin/update/passenger/${id}" acceptCharset="UTF-8" method="post">
            <table class="table">
                <tr>
                    <td>
                        <span style="font-size: 25px">Имя<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="firstName" cssClass="update_input_form"/>
                        <@form.errors path="firstName" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Фамилия<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="lastName" cssClass="update_input_form"/>
                        <@form.errors path="lastName" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Документ<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="passport" cssClass="update_input_form"/>
                        <@form.errors path="passport" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Дата рождения (YYYY-MM-DD)<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="birth" cssClass="update_input_form"/>
                        <@form.errors path="birth" cssClass="form_error"/>
                    </td>
                </tr>
            </table>
            <div align="center"><input type="submit" value="Сохранить"></div>
        </@form.form>
    </div>

    <#include "components/footer.ftl" />

</div>

</#macro>