<#-- @ftlvariable name="ticket" type="com.springapp.mvc.common.TicketInfo" -->
<#-- @ftlvariable name="board" type="java.lang.String" -->
<html>
<head><meta http-equiv=Content-Type content="text/html; charset=UTF-8">
    <link href="../../resources/css/boardingpass.css" rel="stylesheet">
</head>
<body>
<div style="position: absolute;left: 18%; top: 11%;"><img src="../../resources/img/1439364498193355131.png"></div>
<div style="position:absolute;left:50%;margin-left:-420px;top:0px;width:1000px;height:595px;overflow:hidden">
<div style="position:absolute;left:690px;top:200px" class="cls_004"><span class="cls_004">   ${ticket.passenger.firstName} ${ticket.passenger.lastName} </span><span class="cls_008"> </span></div>
<div style="position:absolute;left:234px;top:206px" class="cls_007"><span class="cls_007">${ticket.passenger.firstName} ${ticket.passenger.lastName} </span></div>
<div style="position:absolute;left:721px;top:238px" class="cls_008"><span class="cls_008">${ticket.flight.route.departure.name}, ${ticket.flight.route.departure.city} </span></div>
<div style="position:absolute;left:233px;top:237px" class="cls_007"><span class="cls_007">${ticket.flight.route.departure.name}, ${ticket.flight.route.departure.city} </span></div>
<div style="position:absolute;left:732px;top:275px" class="cls_008"><span class="cls_008"> ${ticket.flight.route.arrival.name}, ${ticket.flight.route.arrival.city}</span></div>
<div style="position:absolute;left:233px;top:275px" class="cls_007"><span class="cls_007">${ticket.flight.route.arrival.name}, ${ticket.flight.route.arrival.city} </span></div>
<div style="position:absolute;left:791px;top:317px" class="cls_008"><span class="cls_008">${ticket.flight.date} / ${ticket.flight.time} </span></div>
<div style="position:absolute;left:235px;top:310px" class="cls_007"><span class="cls_007">${ticket.flight.date} / ${ticket.flight.time}  </span></div>
<div style="position:absolute;left:829px;top:354px" class="cls_008"><span class="cls_008">TJ${ticket.flight.number} / 45 </span></div>
<div style="position:absolute;left:233px;top:348px" class="cls_007"><span class="cls_007">TJ${ticket.flight.number} / 45  </span></div>
<div style="position:absolute;left:835px;top:390px" class="cls_008"><span class="cls_008">${ticket.seat} / ${ticket.flight_class.type}</span></div>
<div style="position:absolute;left:233px;top:385px" class="cls_007"><span class="cls_007">${ticket.seat} / ${ticket.flight_class.type} </span></div>
<div style="position:absolute;left:835px;top:428px" class="cls_008"><span class="cls_008"> GATE / ${board} </span></div>
<div style="position:absolute;left:234px;top:427px" class="cls_007"><span class="cls_007"> GATE / ${board} </span></div>
<div style="position:absolute;left:266px;top:469px" class="cls_006"><span class="cls_006">9262353759859 </span></div>
<div style="position:absolute;left:718px;top:472px" class="cls_011"><span class="cls_011">9262353759859 </span></div>
</div>
</body>
</html>
