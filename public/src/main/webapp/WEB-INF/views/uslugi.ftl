<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Services" />
<#macro m_body>

<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Услуги</h1>
            <ol class="breadcrumb">
                <li><a href="/">Home</a>
                </li>
                <li class="active">Services</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Service Tabs -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Онлайн-cервисы S7</h2>
        </div>
        <div class="col-lg-12">

            <ul id="myTab" class="nav nav-tabs nav-justified">
                <li class="active"><a href="#service-one" data-toggle="tab"><i class="fa fa-tree"></i> Управление бронированиями</a>
                </li>
                <li class=""><a href="#service-two" data-toggle="tab"><i class="fa fa-car"></i> SMS-оповещение о статусе рейса</a>
                </li>
                <li class=""><a href="#service-three" data-toggle="tab"><i class="fa fa-support"></i> Онлайн-регистрация</a>
                </li>
                <li class=""><a href="#service-four" data-toggle="tab"><i class="fa fa-database"></i> S7 Mobile</a>
                </li>
            </ul>

            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="service-one">
                    <h4>Управление бронированиями</h4>
                    <p>Легко быть в курсе всего, что касается покупок на сайте S7, с помощью сервиса «Мои бронирования»! В любой момент вы можете проверить статус своего заказа и получить о нём самую подробную информацию. А при необходимости — дополнить контакты, оформить заявку на возврат билета, исправить ошибку, допущенную вами при вводе личных данных, и многое другое.</p>
                </div>
                <div class="tab-pane fade" id="service-two">
                    <h4>SMS-оповещение о статусе рейса</h4>
                    <p>Бесплатная услуга от S7 Airlines: вся актуальная информация о рейсе в вашем мобильном телефоне! Вплоть до посадки в самолёт вы будете в курсе всех изменений в статусе вашего рейса — достаточно просмотреть SMS-сообщения от S7.</p>
                </div>
                <div class="tab-pane fade" id="service-three">
                    <h4>Онлайн-регистрация</h4>
                    <p>Мечты сбываются! Выбрать лучшие места в самолёте для себя и своих спутников, заранее позаботиться о том, чтобы сидеть в салоне рядом, — это возможно при регистрации на рейс в режиме «онлайн». Вам понадобится всего несколько минут, и никакого ожидания в очереди!</p>
                </div>
                <div class="tab-pane fade" id="service-four">
                    <h4>S7 Mobile</h4>
                    <p>Забронировать авиабилет и пройти онлайн-регистрацию на рейс можно не только через компьютер, но и с помощью любого мобильного устройства. Испытайте в действии мобильные сервисы S7!</p>
                </div>
            </div>

        </div>
    </div>

    <!-- Service List -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Услуги</h2>
        </div>
        <div class="col-md-4">

            <div class="media">
                <div class="pull-left">
                        <span class="fa-stack fa-2x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-paper-plane fa-stack-1x fa-inverse"></i>
                        </span>
                </div>
                <div class="media-body">
                    <h4 class="media-heading"><a href="/webcheckin" style="text-decoration: none">Регистрация на рейс</a></h4>
                    <p>Онлайн регистрация на рейс и выбор мест на борту самолёта доступны на сайте и в мобильном
                        приложении S7, а посадочный талон - в Вашем смартфоне.</p>
                </div>
            </div>
            <div class="media">
                <div class="pull-left">
                        <span class="fa-stack fa-2x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-database fa-stack-1x fa-inverse"></i>
                        </span>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">Багаж</h4>
                    <p>Нормы провоза багажа и ручной клади, путешествия с животными, перевозка спортивного инвентаря и
                        многое другое.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="media">
                <div class="pull-left">
                        <span class="fa-stack fa-2x">
                              <i class="fa fa-circle fa-stack-2x text-primary"></i>
                              <i class="fa fa-bank fa-stack-1x fa-inverse"></i>
                        </span>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">Бизнес-класс</h4>
                    <p>Приоритетная регистрация на рейс и посадка на борт самолета, отдельный комфортный салон и особый
                        сервис на земле и в полёте.</p>
                </div>
            </div>
            <div class="media">
                <div class="pull-left">
                        <span class="fa-stack fa-2x">
                            <i class="fa fa-circle fa-stack-2x text-primary"></i>
                            <i class="fa fa-car fa-stack-1x fa-inverse"></i>
                        </span>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">Расписания и маршруты</h4>
                    <p>Более 900 направлений по всему миру - все рейсы S7 Airlines и авиакомпаний-партнёров альянса
                        oneworld в нашей маршрутной сети.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="media">
                <div class="pull-left">
        <span class="fa-stack fa-2x">
        <i class="fa fa-circle fa-stack-2x text-primary"></i>
        <i class="fa fa-support fa-stack-1x fa-inverse"></i>
        </span>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">Дополнительные услуги</h4>
                    <p>Выбрать место в самолете заранее, оплатить места повышенной комфортности, забронировать машину или
                        номер в отеле и др.</p>
                </div>
            </div>
        </div>
    </div>

    <hr>

    <#include "components/footer.ftl" />

</div>

</#macro>