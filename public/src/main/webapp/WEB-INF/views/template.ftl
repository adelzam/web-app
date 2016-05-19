<#macro mainTemplate title="Airline tickets | Home" styles=[] scripts=[] >
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>

    <#include "components/header.ftl" />

    <@m_body />

<#--<div class="container">-->
    <#---->
    <#--<@m_body />-->

    <#--<#include "components/footer.ftl" />-->
    <#---->
<#--</div>-->

</body>
</html>
</#macro>