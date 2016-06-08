<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "template.ftl">
<@mainTemplate title="Airline tickets  | Contacts" />
<#macro m_body>

<div class="container">
    <!-- Contact Form -->
    <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <div class="row">
        <div class="col-md-8">

            <@form.form commandName="TPForm" action="/personal" acceptCharset="UTF-8" method="post">
                <h3>Введите данные о пасажире латинскими буквами</h3>
                <form name="sentMessage" id="contactForm" novalidate>
                    <div class="control-group form-group">
                        <div class="controls">
                            <span>First name<label>*</label></span>
                            <@form.input path="firstname" />
                            <@form.errors path="firstname" cssStyle="color: red;" />
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <span>Last name<label>*</label></span>
                            <@form.input path="lastname" />
                            <@form.errors path="lastname" cssStyle="color: red;" />
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <span>Birthday(yyyy-MM-dd)<label>*</label></span>
                            <@form.input path="bdate"/>
                            <@form.errors path="bdate" cssStyle="color: red;" />
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <span>Document number<label>*</label></span>
                            <@form.input path="numdoc" />
                            <@form.errors path="numdoc" cssStyle="color: red;" />
                        </div>
                    </div>


                    <div class="control-group form-group">
                        <div class="controls">
                            <span>Phone<label>*</label></span>
                            <@form.input path="phone" />
                            <@form.errors path="phone" cssStyle="color: red;" />
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <span>Email Address<label>*</label></span>
                            <@form.input path="email" />
                            <@form.errors path="email" cssStyle="color: red;" />
                        </div>
                    </div>


                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <input type="submit" class="btn btn-primary"></input>
                </form>
            </@form.form>

        </div>

    </div>
    <!-- /.row -->

    <hr>

    <#include "components/footer.ftl" />

</div>

</#macro>