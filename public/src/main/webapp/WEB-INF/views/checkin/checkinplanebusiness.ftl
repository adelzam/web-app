<#-- @ftlvariable name="flight" type="com.springapp.mvc.common.FlightInfo" -->
<#-- @ftlvariable name="ticket" type="com.springapp.mvc.common.TicketInfo" -->
<#-- @ftlvariable name="seats" type="java.util.List<java.util.ArrayList<java.lang.Boolean>>" -->
<#-- @ftlvariable name="class" type="java.lang.String" -->
<#-- @ftlvariable name="num" type="java.lang.Integer" -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="../../../resources/js/script.js" type="text/javascript"></script>
<div>
    <table class="table" style="width: 100pt; display: inline-block">
    <#assign a = ['A', 'C', 'D','F']>
        <tr>
            <th></th>
            <th>A</th>
            <th></th>
            <th>C</th>
            <th></th>
            <th></th>
            <th>D</th>
            <th></th>
            <th>F</th>
            <th></th>
        </tr>
    <#list seats as seats1>
        <tr>
            <th>${num}</th>
            <#list seats1 as seat>
                <td><#if seat>
                    <img src="../../../resources/img/book.jpg"> <#else>
                    <a href="#${num}${a[seat_index]}"
                       onclick="hide_show('${num}${a[seat_index]}');return false;">
                        <img alt="" class="notActive" src="../../../resources/img/free.png"> </a>
                </#if></td>
                <#if !((seat_index+1)==4)>
                    <td></td>
                </#if>
                <#if ((seat_index+1)==2)>
                    <td></td>
                </#if>
            </#list>
            <th>${num}</th>
            <#assign num=num+1>
        </tr>
    </#list>
    </table>
    <div style="display: inline-block; float: right; margin-right: 330pt">
    <#list 1..num-1 as seat2>
        <#list 0..3 as j>
            <div class="tab-pane fade active in" id="${seat2}${a[j]}" style="display: none">
                <h3>Вы выбрали место <br><label
                        style="color: red; font-size: 30pt; font-family: 'Kozuka Gothic Pro'">${seat2}${a[j]}</label>
                </h3>
                <br>
                <br>
                <h3>Пассажир</h3>
                <h2>${ticket.passenger.firstName+" "+ticket.passenger.lastName}</h2>
                <br>
                <br>
                <a href="/checkinres/${ticket.id}/${seat2}${a[j]}">
                    <button class="button  button--primary js-submit"
                            style="color: aliceblue; background-color: red">ПОДТВЕРДИТЬ
                    </button>
                </a>
            </div>
        </#list>
    </#list>

    </div>
</div>