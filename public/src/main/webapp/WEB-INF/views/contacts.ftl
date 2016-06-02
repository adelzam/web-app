<#include "template.ftl">
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<@mainTemplate title="Airline tickets  | Contacts" />
<#macro m_body>

<div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Контакты</h1>
            <ol class="breadcrumb">
                <li><a href="/">Home</a>
                </li>
                <li class="active">Contacts</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Contact Details Column -->
    <div class="col-md-4">
        <h3>Контактная информация</h3>
        <p>
            3481 Melrose Place<br>Beverly Hills, CA 90210<br>
        </p>
        <p><i class="fa fa-phone"></i>
            <abbr title="Phone">P</abbr>: (123) 456-7890</p>
        <p><i class="fa fa-envelope-o"></i>
            <abbr title="Email">E</abbr>: <a href="mailto:name@example.com">name@example.com</a>
        </p>
        <p><i class="fa fa-clock-o"></i>
            <abbr title="Hours">H</abbr>: Monday - Friday: 9:00 AM to 5:00 PM
        </p>
    </div>

    <!-- /.row -->

    <!-- Contact Form -->
    <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <@form.form commandName="contactForm" action="/contacts" acceptCharset="UTF-8" method="post">
    <div class="row">
        <div class="col-md-8">
            <h3>Отправьте нам сообщение</h3>
            <form name="sentMessage" id="contactForm" novalidate>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Полное имя :</label>
                        <@form.input path="fio" />
                        <@form.errors path="fio" cssStyle="color: red;" />
                        <#--<input type="text" class="form-control" id="name" required-->
                               <#--data-validation-required-message="Please enter your name.">-->
                        <#--<p class="help-block"></p>-->
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Номер телефона :</label>
                        <@form.input path="phone" />
                        <@form.errors path="phone" cssStyle="color: red;" />
                        <#--<input type="tel" class="form-control" id="phone" required-->
                               <#--data-validation-required-message="Please enter your phone number.">-->
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Email Address :</label>
                        <@form.input path="email" />
                        <@form.errors path="email" cssStyle="color: red;" />
                        <#--<input type="email" class="form-control" id="email" required-->
                               <#--data-validation-required-message="Please enter your email address.">-->
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Сообщение :</label>
                        <@form.textarea path="message" rows="10" cols="100" />
                        <@form.errors path="message" cssStyle="color: red;" />

                    <#--<textarea rows="10" cols="100" class="form-control" id="message" required-->
                              <#--data-validation-required-message="Please enter your message" maxlength="999"-->
                              <#--style="resize:none">-->
                    <#--</textarea>-->
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary">Отправить</button>
            </form>
        </div>

    </div>
    </@form.form>
    <!-- /.row -->

    <hr>

    <#include "components/footer.ftl" />

</div>

</#macro>