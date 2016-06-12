<#-- @ftlvariable name="books" type="java.util.List<com.springapp.mvc.common.BookInfo>" -->
<#-- @ftlvariable name="user" type="com.springapp.mvc.common.UserInfo" -->
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Cabinet" />
<#macro m_body>

<div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Личный кабинет</h1>
            <ol class="breadcrumb">
                <li><a href="/">Home</a>
                </li>
                <li class="active">Cabinet</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <#if user??>
        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Информация пользователя <small><a href="/cabinet/change">изменить</a></small></h2>
            </div>
            <div class="col-lg-12">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <h3 style="margin-top: 10px;">${user.fio} - ${user.phone}</h3>
                            </h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </#if>

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Список бронирований</h2>
        </div>
    </div>
    <!-- /.row -->

    <#if books?has_content>
        <#list books as book>
            <!-- Content Row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" href="/cabinet/${book.name}">
                                    ${book.name}
                                    </a>
                                </h4>
                            </div>
                        </div>
                    </div>
                    <!-- /.panel-group -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </#list>
    <#else>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <h3 style="margin-top: 10px;">Бронирований не найдено</h3>
                            </h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#if>

    <hr>
    <#include "components/footer.ftl" />

</div>

</#macro>