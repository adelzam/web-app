<#-- @ftlvariable name="flight" type="java.util.List<com.springapp.mvc.common.FlightInfo>" -->
<#-- @ftlvariable name="cost" type="java.util.HashMap<Long, java.util.ArrayList<java.math.BigDecimal>>" -->
<#-- @ftlvariable name="arr" type="java.lang.String" -->
<#-- @ftlvariable name="dep" type="java.lang.String" -->
<#-- @ftlvariable name="date" type="java.lang.String" -->
<#-- @ftlvariable name="num" type="java.lang.String" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<script src="../../resources/js/script.js" xmlns="http://www.w3.org/1999/html"></script>
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Cabinet" />
<#macro m_body>

<div class="container">
    <div style="width: 1237px; height: 128px;">
        <form method="post" name="searchForm" action="/search/results">
            <div>
                <input name="dep" tabindex="1"
                       style="width: 307px; height: 48px; font-size: 25px; float: left; margin-top: 40px; margin-left: 7px"
                       list="dep_list" value="${dep}">
                </input>
                <datalist id="dep_list">
                    <#if departure??>
                        <#list departure as item>
                            <option value="${item.name}">${item.name}, ${item.city}</option>
                        </#list>
                    </#if>
                </datalist>
            </div>
            <div style="height: 48px; width: 43px; float: left ;margin-top: 40px;margin-left: 5px "></div>
            <div>
                <input tabindex="2" name="arr"
                       style="width: 307px; height: 48px; font-size: 25px; float: left; margin-top: 40px; margin-left: 5px"
                       value="${arr}" list="arr_list">
                </input>
                <datalist id="arr_list">
                    <#if arrival??>
                        <#list arrival as item>
                            <option value="${item.name}">${item.name}, ${item.city}</option>
                        </#list>
                    </#if>
                </datalist>
            </div>
            <div>
                <input type="date" name="date" value="${date}"
                       style="width: 268px; height: 48px; font-size: 25px; float: left; margin-top: 40px; margin-left: 5px">
            </div>
            <div>
                <input type="number" name="num" max="6" min="1" value="${num}"
                       style="width: 182px; height: 48px; font-size: 25px; float: left; margin-top: 40px;margin-left: 5px">
            </div>
            <div>
                <input type="submit" value="НАЙТИ" style="width: 88px; height: 48px; float: left; margin-top: 40px; margin-left: 5px
                " min="0" max="6">
            </div>
        </form>
    </div>
    <#if !flight??>
        <h2>Рейсов не найдено</h2>
    </#if>
    <#if flight??>
        <h2>Выберете рейс</h2>
        <h2>${dep}&#8594;${arr}</h2>
        <form>
            <table class="table" id="flights">
                <tr>
                    <th style="text-align: center">Рейсы</th>
                    <th style="text-align: center">Базовый Эконом</th>
                    <th style="text-align: center">Гибкий Эконом</th>
                    <th style="text-align: center">Базовый Бизнес</th>
                    <th style="text-align: center">Гибкий Бизнес</th>
                </tr>
                <#list flight as item>
                    <tr style="cursor: pointer">
                        <td>
                            <h3 style="color: red">TJ${item.number}</h3>
                        ${item.time}<br><br>
                        ${item.route.departure.city},${item.route.departure.name}<br>
                        ${item.route.arrival.city},${item.route.arrival.name}<br><br>
                            Борт: ${item.plane.type}
                        </td>
                        <#assign costitem = cost?values[item_index]>
                        <#list costitem as prise>
                            <td>
                                <div align="center">
                                    <br>
                                    <h3 style="color: green">
                                        <input type="radio" id="${item.id}:${prise_index}"
                                               onchange="showflight('TJ${item.number}','${item.route.departure.name}, ${item.route.departure.city}', '${item.time}', '${prise}')"
                                               name="choice" value="${item.id}:${prise_index}"/>&nbsp;<label
                                            for="${item.id}:${prise_index}">${prise}
                                    </label>
                                    </h3>
                                    <br>
                                    <h6>Здесь прописаны <br>условия тарифа</h6>
                                </div>
                            </td>
                        </#list>
                    </tr>
                </#list>
            </table>
        </form>
    <br>
    <br>
        <div id="show" style="display: none">
                <h3>Выбранный рейс<br>
                    <label id="flight" style="color: red"></label>
                    <br>
                Время вылета<br>
                    <label id="time"  style="color: red"></label><br>
                Аэропорт вылета<br>
                    <label id="dep"  style="color: red"></label><br>
                Стоимость
                    <br>
                    <label id="cost"  style="color: red"></label></h3>
            <button onclick="/personal" style="color: white; background-color: red">Продолжить</button>
        </div>
    </#if>

</div>
</#macro>