<#-- @ftlvariable name="flight" type="com.springapp.mvc.common.FlightInfo" -->
<#-- @ftlvariable name="ticket" type="com.springapp.mvc.common.TicketInfo" -->
<#-- @ftlvariable name="seats" type="java.util.List<java.util.ArrayList<java.lang.Boolean>>" -->
<#-- @ftlvariable name="class" type="java.lang.String" -->
<#-- @ftlvariable name="num" type="java.lang.Integer" -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="../../../resources/js/script.js" type="text/javascript"></script>
<div>
<#assign a = ['A', 'B', 'C', 'D', 'E','F']>
    <div style="display: inline-block; float: left">
        <table class="table" style="width: 100pt;">
            <tr>
                <th></th>
                <th>A</th>
                <th>B</th>
                <th>C</th>
                <th></th>
                <th>D</th>
                <th>E</th>
                <th>F</th>
                <th></th>
            </tr>
        <#list seats as seats1>
            <tr>
                <td>${num}</td>
                <#list seats1 as seat>
                    <td><#if seat><img src="../../../resources/img/book.jpg"> <#else>  <a
                            href="#${num}${a[seat_index]}"
                            onclick="hide_show('${num}${a[seat_index]}');return false;"><img alt="" class="notActive"
                                                                                             src="../../../resources/img/free.png">
                    </a></#if></td>
                    <#if ((seat_index+1)==3)>
                        <td></td>
                    </#if>
                </#list>
                <td>${num}</td>
                <#assign num=num+1>
            </tr>
        </#list>
        </table>
    </div>
    <div style="display: inline-block; float: left; margin-left: 80pt">
    <#list 3..num-1 as seat2>
        <#list 0..5 as j>
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
                    <a href="/checkinres/${ticket.id}/${seat2}${a[j]}"><button class="button  button--primary js-submit"
                            style="color: aliceblue; background-color: red" >ПОДТВЕРДИТЬ
                    </button>
                    </a>
            </div>
        </#list>
    </#list>

    </div>
</div>