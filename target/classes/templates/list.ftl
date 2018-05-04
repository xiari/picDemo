<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <#--<link href="/css/index.css" rel="stylesheet"/>-->
    <script type="text/javascript">
        $(function () {



        });

    </script>
</head>
<body>
<div class="container">
    <h2>list 测试</h2>
</div>
<div>
<#list picVoList as x>
    <label>${x.picName}</label>
    <img src="${x.encodedUrl}"/>
</#list>
</div>
</body>
</html>