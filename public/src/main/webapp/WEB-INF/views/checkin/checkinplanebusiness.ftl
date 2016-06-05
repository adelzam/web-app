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
                <td>${num}</td>
                <#list seats1 as seat>
                    <td><#if seat>
                        <img src="../../../resources/img/book.jpg"> <#else>
                        <a href="#${num}${a[seat_index]}"><img src="../../../resources/img/free.png"> </a>
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
    <div style="display: inline-block">
    <#list 1..num as i>
        <#list 0..6 as j>
            <div class="tab-pane fade active in" id="${i}${a[j]}">
                <h3>Ваше место <label style="color: red">${i}${j}</label></h3>
            </div>
        </#list>
    </#list>
    </div>
</div>