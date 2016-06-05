<#-- @ftlvariable name="flight" type="java.util.List<com.springapp.mvc.common.FlightInfo>" -->
<#-- @ftlvariable name="cost" type="java.util.HashMap<Long, java.util.ArrayList<java.math.BigDecimal>>" -->
<#-- @ftlvariable name="arr" type="java.lang.String" -->
<#-- @ftlvariable name="dep" type="java.lang.String" -->
<#-- @ftlvariable name="date" type="java.lang.String" -->
<#-- @ftlvariable name="num" type="java.lang.String" -->
<#-- @ftlvariable name="classindexlist" type="java.util.List<com.springapp.mvc.common.FlightClassInfo>" -->
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
        <h2>Количество пассажиров: <span style="color: red">${num}</span></h2>
        <form>
            <table class="table" id="flights">
                <tr>
                    <th style="text-align: center">Рейсы</th>
                    <th style="text-align: center">Базовый Эконом</th>
                    <th style="text-align: center">Гибкий Эконом</th>
                    <th style="text-align: center">Базовый Бизнес</th>
                    <th style="text-align: center">Гибкий Бизнес</th>
                </tr>
                <#assign class = ['Базовый Эконом','Гибкий Эконом','Базовый Бизнес','Гибкий Бизнес']>
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
                        <#assign classindex = classindexlist[prise_index]>
                            <td>
                                <div align="center">
                                    <br>
                                    <h3 style="color: green">
                                        <input type="radio" id="${item.id}:${prise_index}"
                                               onchange="showflight('${item.route.departure.city}, ${item.route.departure.name}',
                                                       '${item.route.arrival.city}, ${item.route.arrival.name}',
                                                       '${item.date}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.time}&nbsp;&nbsp;${item.route.departure.name}&nbsp;&#8594;&nbsp;${item.route.arrival.name}&nbsp;&nbsp;${item.artime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TJ${item.number}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${class[prise_index]}',
                                                       ${item.route.departure.taxes}, ${item.route.arrival.taxes}, ${item.route.cost}, ${num}, '${classindex.cost}' )"
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
            <h3>Вы выбрали<span style="margin-left: 700px;">Стоимость</span></h3>
            <div style="width: 840px; background-color: lightyellow; display: inline-block; float: left">
                <h3 style="margin-left: 2%;"><label id="dep" style="font-weight: 400"></label>
                    &#8594; <label id="arr" style="font-weight: 400"></label></h3>
                <h4 style="margin-left: 2%;"><label id="info" style="font-weight: 200"></label>
                </h4>
            </div>
            <div style="width: 270px; background-color: lightyellow; display: inline-block; float: right">
                <table style="margin-left: 2%">
                    <tr>
                        <td><br></td>
                    </tr>
                    <tr>
                        <td style="width: 150px">${num} Билета</td>
                        <td id="sum"></td>
                    </tr>
                    <tr>
                        <td><br></td>
                    </tr>
                    <tr>
                        <td style="width: 150px">Таксы</td>
                        <td id="taxes"></td>
                    </tr>
                    <tr>
                        <td><br></td>
                    </tr>
                    <tr>
                        <td style="width: 150px">Сборы</td>
                        <td id="assemblies"></td>
                    </tr>
                    <tr>
                        <td><br><br><br></td>
                    </tr>
                    <tr>
                        <td style="width: 150px"><h2 style="font-weight: 200">Итого</h2></td>
                        <td><h2 style="font-weight: 200" id="total"></h2></td>
                    </tr>
                </table>
                <button onclick="/personal" style="color: white; background-color: red; width: 270px; height: 50px; font-size: 30px; font-weight: 200">Продолжить</button>
            </div>
        </div>
    </#if>
    <div>
        <#include "components/footer.ftl" />
    </div>
</div>
</#macro>