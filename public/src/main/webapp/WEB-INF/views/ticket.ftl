<#-- @ftlvariable name="ticket" type="com.springapp.mvc.common.TicketInfo" -->
<#-- @ftlvariable name="checkIn" type="java.lang.String" -->
<html>
<head>
    <meta http-equiv=Content-Type content="text/html; charset=UTF-8">
    <link href="../../resources/css/ticket.css" rel="stylesheet">
</head>
<body>
<div style="position:absolute;left:50%;margin-left:-297px;top:0px;width:595px;height:842px;border-style:outset;overflow:hidden">
    <div style="position:absolute;left:0px;top:0px">
        <img src="../../resources/img/background1.jpg" style="width:595px; height:842px"></div>
    <div style="position:absolute;left:78.52px;top:31.64px" class="cls_003"><span
            class="cls_003">Маршрутная квитанция</span></div>
    <div style="position:absolute;left:78.52px;top:62.95px" class="cls_004"><span class="cls_004">Внимание! Это не посадочный талон</span>
    </div>
    <div style="position:absolute;left:437.38px;top:97.09px" class="cls_008"><span
            class="cls_008">Бронирование </span><span class="cls_009">/ PNR</span></div>
    <div style="position:absolute;left:35.15px;top:102.92px" class="cls_005"><span
            class="cls_005">Пассажиры </span><span class="cls_006">/ Passengers</span></div>
    <div style="position:absolute;left:437.38px;top:106.79px" class="cls_010"><span class="cls_010">${ticket.book.name}</span></div>
    <div style="position:absolute;left:179.71px;top:123.39px" class="cls_007"><span class="cls_007">Документ</span>
    </div>
    <div style="position:absolute;left:256.25px;top:123.39px" class="cls_007"><span class="cls_007">Номер билета</span>
    </div>
    <div style="position:absolute;left:346.96px;top:123.39px" class="cls_007"><span class="cls_007">Номер ЧЛП</span>
    </div>
    <div style="position:absolute;left:437.38px;top:139.32px" class="cls_008"><span
            class="cls_008">Оформлено </span><span class="cls_009">/ Issued</span></div>
    <div style="position:absolute;left:35.15px;top:143.63px" class="cls_008"><span class="cls_008">${ticket.passenger.lastName} ${ticket.passenger.firstName}</span>
    </div>
    <div style="position:absolute;left:179.71px;top:143.63px" class="cls_008"><span class="cls_008">${ticket.passenger.passport}</span>
    </div>
    <div style="position:absolute;left:256.25px;top:143.63px" class="cls_008"><span class="cls_008">9262353759859</span>
    </div>
    <div style="position:absolute;left:346.96px;top:143.63px" class="cls_008"><span class="cls_008">-</span>
    </div>
    <div style="position:absolute;left:437.38px;top:149.02px" class="cls_010"><span class="cls_010">06 июн 2016</span>
    </div>
    <div style="position:absolute;left:437.38px;top:180.14px" class="cls_008"><span class="cls_008">Статус </span><span
            class="cls_009">/ Status</span></div>
    <div style="position:absolute;left:437.38px;top:189.84px" class="cls_010"><span class="cls_010">Подтверждено</span>
    </div>
    <div style="position:absolute;left:35.15px;top:232.45px" class="cls_005"><span class="cls_005">Маршрут </span><span
            class="cls_006">/ Route</span><span class="cls_011"> Указано местное время</span></div>
    <div style="position:absolute;left:35.15px;top:254.63px" class="cls_007"><span class="cls_007">Рейс</span></div>
    <div style="position:absolute;left:116.50px;top:254.63px" class="cls_007"><span class="cls_007">Отправление</span>
    </div>
    <div style="position:absolute;left:201.26px;top:254.63px" class="cls_007"><span class="cls_007">Прибытие</span>
    </div>
    <div style="position:absolute;left:286.01px;top:254.63px" class="cls_007"><span class="cls_007">Класс и Тариф</span>
    </div>
    <div style="position:absolute;left:360.56px;top:254.63px" class="cls_007"><span class="cls_007">Багаж</span></div>
    <div style="position:absolute;left:438.23px;top:254.63px" class="cls_007"><span
            class="cls_007">Регистрация до</span></div>
    <div style="position:absolute;left:286.01px;top:272.39px" class="cls_019"><span class="cls_019">Эконом</span></div>
    <div style="position:absolute;left:360.56px;top:272.39px" class="cls_019"><span class="cls_019">Нет</span></div>
    <div style="position:absolute;left:35.15px;top:272.01px" class="cls_012"><span class="cls_012">TJ ${ticket.flight.number}</span></div>
    <div style="position:absolute;left:116.50px;top:272.01px" class="cls_012"><span class="cls_012">${ticket.flight.date}</span></div>
    <div style="position:absolute;left:201.26px;top:272.01px" class="cls_012"><span class="cls_012">${ticket.flight.ardate}</span></div>
    <div style="position:absolute;left:438.23px;top:272.01px" class="cls_012"><span class="cls_012">${checkIn}</span></div>
    <div style="position:absolute;left:360.56px;top:282.74px" class="cls_007"><span class="cls_007">Ручная кладь</span>
    </div>
    <div style="position:absolute;left:35.15px;top:287.00px" class="cls_007"><span class="cls_007">TJ Airlines</span>
    </div>
    <div style="position:absolute;left:116.50px;top:287.00px" class="cls_018"><span class="cls_018">${ticket.flight.time}<br> ${ticket.flight.route.departure.city},</span>
    </div>
    <div style="position:absolute;left:201.26px;top:287.00px" class="cls_018"><span class="cls_018">${ticket.flight.artime}<br> ${ticket.flight.route.arrival.city},</span>
    </div>
    <div style="position:absolute;left:286.01px;top:286.99px" class="cls_007"><span class="cls_007">Базовый</span></div>
    <div style="position:absolute;left:438.23px;top:287.00px" class="cls_018"><span class="cls_018">${ticket.flight.time} ${ticket.flight.route.departure.city},<br> ${ticket.flight.route.departure.name}</span>
    </div>
    <div style="position:absolute;left:360.56px;top:291.59px" class="cls_007"><span class="cls_007">до 10 кг</span>
    </div>
    <div style="position:absolute;left:35.15px;top:295.84px" class="cls_007"><span class="cls_007">${ticket.flight.plane.type}</span>
    </div>
    <div style="position:absolute;left:116.50px;top:295.84px" class="cls_018"><span class="cls_018"><br>${ticket.flight.route.departure.name}</span>
    </div>
    <div style="position:absolute;left:201.26px;top:295.84px" class="cls_007"><span class="cls_018"><br>${ticket.flight.route.arrival.name}</span>
    </div>
    <div style="position:absolute;left:286.01px;top:295.84px" class="cls_007"><span class="cls_007">Эконом</span></div>
    <div style="position:absolute;left:35.15px;top:313.81px" class="cls_004"><span class="cls_004">Это важно!</span>
    </div>
    <div style="position:absolute;left:35.15px;top:324.96px" class="cls_013"><span class="cls_013">Тариф </span><span
            class="cls_014">Эконом Базовый</span><span class="cls_013"> имеет ограничения по норме провоза багажа. Вы можете провезти только ручную</span>
    </div>
    <div style="position:absolute;left:35.15px;top:333.46px" class="cls_013"><span class="cls_013">кладь весом до 10 кг и габаритами 55х40х20 см.</span>
    </div>
    <div style="position:absolute;left:35.15px;top:363.40px" class="cls_005"><span class="cls_005">Информация</span>
    </div>
    <div style="position:absolute;left:319.46px;top:363.40px" class="cls_005"><span class="cls_005">Стоимость</span>
    </div>
    <div style="position:absolute;left:35.15px;top:380.41px" class="cls_006"><span class="cls_006">/ Information</span>
    </div>
    <div style="position:absolute;left:319.46px;top:380.41px" class="cls_006"><span class="cls_006">/ Payment</span>
    </div>
    <div style="position:absolute;left:35.15px;top:405.74px" class="cls_015"><span class="cls_015">Быстрый доступ к информации о вашем бронировании: проверьте</span>
    </div>
    <div style="position:absolute;left:319.46px;top:404.06px" class="cls_009"><span class="cls_009">Тариф</span></div>
    <div style="position:absolute;left:437.38px;top:404.06px" class="cls_008"><span class="cls_008"><#assign payment = ticket.flight.route.cost*ticket.flight_class.cost>${payment}RUB</span>
    </div>
    <div style="position:absolute;left:35.15px;top:414.24px" class="cls_015"><span class="cls_015">детали вашего маршрута, отправьте билет родным и близким или</span>
    </div>
    <div style="position:absolute;left:319.46px;top:414.94px" class="cls_009"><span class="cls_009">Таксы</span></div>
    <div style="position:absolute;left:437.38px;top:414.94px" class="cls_008"><span class="cls_008"><#assign taxes= (ticket.flight.route.departure.taxes+ticket.flight.route.arrival.taxes)*ticket.flight_class.cost+100>${taxes}RUB</span>
    </div>
    <div style="position:absolute;left:35.15px;top:422.75px" class="cls_015"><span class="cls_015">внесите изменения в данные пассажиров.</span>
    </div>
    <div style="position:absolute;left:35.15px;top:439.47px" class="cls_015"><span class="cls_015">Пожалуйста, ознакомьтесь с правилами применения выбранных</span>
    </div>
    <div style="position:absolute;left:35.15px;top:447.97px" class="cls_015"><span class="cls_015">тарифов.</span></div>
    <div style="position:absolute;left:35.15px;top:464.70px" class="cls_016"><span class="cls_016">Возврат:</span></div>
    <div style="position:absolute;left:35.15px;top:473.20px" class="cls_015"><span
            class="cls_015">Невозможен для тарифа </span><span class="cls_017">Эконом Базовый</span></div>
    <div style="position:absolute;left:319.46px;top:464.82px" class="cls_005"><span class="cls_005">ИТОГО</span></div>
    <div style="position:absolute;left:437.38px;top:460.92px" class="cls_010"><span class="cls_010"><#assign total = taxes+payment>${total}</span><span
            class="cls_020">RUB</span></div>
    <div style="position:absolute;left:35.15px;top:488.22px" class="cls_016"><span class="cls_016">Изменение бронирования:</span>
    </div>
    <div style="position:absolute;left:35.15px;top:496.72px" class="cls_015"><span class="cls_015">Разрешено до вылета рейса со сбором</span>
    </div>
    <div style="position:absolute;left:437.38px;top:497.41px" class="cls_013"><span class="cls_013">Оплачено __ __ 2016 IVAN</span>
    </div>
    <div style="position:absolute;left:437.38px;top:505.91px" class="cls_013"><span class="cls_013">IVANOV</span>
    </div>
    <div style="position:absolute;left:54.99px;top:512.03px" class="cls_015"><span class="cls_015">Выбор места для тарифа </span><span
            class="cls_017">Эконом Базовый</span><span class="cls_015"> доступен только</span></div>
    <div style="position:absolute;left:437.38px;top:514.41px" class="cls_015"><span class="cls_015">Master Card 5***** ** **** *****</span>
    </div>
    <div style="position:absolute;left:54.99px;top:520.53px" class="cls_015"><span class="cls_015">при онлайн-регистрации на рейс на s7.ru - от 350 руб. Онлайн</span>
    </div>
    <div style="position:absolute;left:54.99px;top:529.04px" class="cls_015"><span class="cls_015">регистрация открывается за 30 часов и закрывается за 40 минут</span>
    </div>
    <div style="position:absolute;left:54.99px;top:537.54px" class="cls_015"><span class="cls_015">до вылета.</span>
    </div>
    <div style="position:absolute;left:54.99px;top:552.84px" class="cls_015"><span class="cls_015">Если вес, количество или габариты вашего багажа превышают</span>
    </div>
    <div style="position:absolute;left:54.99px;top:561.35px" class="cls_015"><span class="cls_015">бесплатную норму, свяжитесь с нашим Контактным центром для</span>
    </div>
    <div style="position:absolute;left:54.99px;top:569.85px" class="cls_015"><span
            class="cls_015">его оформления.</span></div>
    <div style="position:absolute;left:54.99px;top:584.02px" class="cls_015"><span class="cls_015">Статусный участник S7 Priority может провозить дополнительный</span>
    </div>
    <div style="position:absolute;left:54.99px;top:592.53px" class="cls_015"><span
            class="cls_015">багаж БЕСПЛАТНО!</span></div>
    <div style="position:absolute;left:54.99px;top:607.83px" class="cls_013"><span class="cls_013">Остались вопросы? Свяжитесь с нашим круглосуточным</span>
    </div>
    <div style="position:absolute;left:54.99px;top:616.33px" class="cls_013"><span class="cls_013">Контактным Центром по телефону 8-800-200-000-7 (бесплатно</span>
    </div>
    <div style="position:absolute;left:54.99px;top:624.84px" class="cls_013"><span class="cls_013">для звонков из России) или +7(495)777-9999</span>
    </div>
    <div style="position:absolute;left:34.87px;top:770.33px" class="cls_002"><span class="cls_002">Внимание: перевозка и другие предоставляемые перевозчиком услуги подчиняются всем условиям договора перевозки с S7 Airlines</span>
    </div>
    <div style="position:absolute;left:34.87px;top:777.47px" class="cls_002"><span class="cls_002">или иного перевозчика, фактически выполняющего ваш рейс, а также правилам применения выбранного вами тарифа. Условия</span>
    </div>
    <div style="position:absolute;left:34.87px;top:784.62px" class="cls_002"><span class="cls_002">вашего договора перевозки, а также вышеуказанные условия применения тарифа и правила перевозки включены в настоящий</span>
    </div>
    <div style="position:absolute;left:34.87px;top:791.76px" class="cls_002"><span class="cls_002">авиабилет посредством ссылки на таковые. С условиями договора перевозки (правилами перевозки, правилами применения</span>
    </div>
    <div style="position:absolute;left:34.87px;top:798.90px" class="cls_002"><span class="cls_002">тарифов) можно ознакомиться в офисах продаж, на сайте S7 Airlines или перевозчика, фактически выполняющего ваш рейс. К</span>
    </div>
    <div style="position:absolute;left:34.87px;top:806.04px" class="cls_002"><span class="cls_002">перевозке, имеющей пункт назначения или остановку не в стране отправления, могут применяться положения варшавской или</span>
    </div>
    <div style="position:absolute;left:34.87px;top:813.18px" class="cls_002"><span class="cls_002">монреальской конвенции, которые определяют и могут ограничивать ответственность перевозчика за смерть или причинение</span>
    </div>
    <div style="position:absolute;left:34.87px;top:820.33px" class="cls_002"><span class="cls_002">вреда здоровью пассажира, а также за утрату или повреждение багажа.</span>
    </div>
</div>
</body>
</html>
