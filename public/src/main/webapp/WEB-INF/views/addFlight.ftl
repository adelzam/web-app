
<#-- @ftlvariable name="routes" type="java.util.List<com.springapp.mvc.common.RouteInfo>" -->
<#-- @ftlvariable name="planes" type="java.util.List<com.springapp.mvc.common.PlaneInfo>" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | About"/>
<#macro m_body>


<div class="container">
    <h2>Редактирование информации о рейсе</h2>
    <br><br>
    <div class="form-group">
        <@form.form commandName="updateFForm" action="/admin/add/flight" acceptCharset="UTF-8" method="post">
            <table class="table">
                <tr>
                    <td>
                        <span style="font-size: 25px">Номер<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="number" cssClass="update_input_form"/>
                        <@form.errors path="number" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Маршрут<label>*</label></span>
                    </td>
                    <td>
                        <@form.select path="route" cssClass="update_input_form" cssStyle="height:43px;">
                            <#list routes as route>
                                <@form.option value = "${route.departure.name} : ${route.arrival.name}" cssClass="update_input_form" />
                            </#list>
                        </@form.select>
                        <@form.errors path="route" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Борт<label>*</label></span>
                    </td>
                    <td>
                        <@form.select path="plane" cssClass="update_input_form" cssStyle="height:43px;">
                            <#list planes as plane>
                                <@form.option value = "${plane.name}" cssClass="update_input_form" />
                            </#list>
                        </@form.select>
                        <@form.errors path="plane" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Дата вылета(YYYY-MM-DD)<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="date" cssClass="update_input_form"/>
                        <@form.errors path="date" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Время вылета (HH:MМ:SS)<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="time" cssClass="update_input_form"/>
                        <@form.errors path="time" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Дата прилета(YYYY-MM-DD)<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="ardate" cssClass="update_input_form"/>
                        <@form.errors path="ardate" cssClass="form_error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span style="font-size: 25px">Время прилета (HH:MМ:SS)<label>*</label></span>
                    </td>
                    <td>
                        <@form.input path="artime" cssClass="update_input_form"/>
                        <@form.errors path="artime" cssClass="form_error"/>
                    </td>
                </tr>
            </table>
            <div align="center"><input type="submit" value="Сохранить"></div>
        </@form.form>
    </div>

    <#include "components/footer.ftl" />

</div>

</#macro>