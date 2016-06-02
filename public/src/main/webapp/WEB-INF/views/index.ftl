<#include "template.ftl">
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<@mainTemplate title="Airline tickets  | Home" />
<#macro m_body>

    <#include "components/slider.ftl" />
<div class="container">

    <#include "components/uslugi.ftl" />

    <#include "components/news.ftl" />

    <#include "components/footer.ftl" />

</div>

</#macro>