<!-- Navigation -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Airline tickets</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/about">О нас</a>
                </li>
                <li>
                    <a href="/services">Услуги</a>
                </li>
                <li>
                    <a href="/news">Новости</a>
                </li>
                <li>
                    <a href="/contacts">Контакты</a>
                </li>

            <#--<@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">-->
                <#--<li>-->
                    <#--<a class="login" href="/login">Login</a>-->
                <#--</li>-->
                <#--<li>-->
                    <#--<a class="login" href="/reg">Registration</a>-->
                <#--</li>-->
            <#--</@sec.authorize>-->
            <#--&lt;#&ndash; Если уже авторизован, то ссылки в личный кабинет и на выход &ndash;&gt;-->
            <#--<@sec.authorize access="isAuthenticated()">-->
                <#--<li>-->
                    <#--<a class="login" href="/cabinet" style="text-transform: lowercase; color: yellow;">-->
                        <#--<@sec.authentication property="principal.username" />-->
                    <#--</a></li>-->
                <#--<li>-->
                    <#--<a class="login" href="/logout" style="color: yellow;">Logout</a>-->
                <#--</li>-->
            <#--</@sec.authorize>-->

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>