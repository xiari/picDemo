<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <#--<link href="/css/index.css" rel="stylesheet"/>-->
    <script type="text/javascript">

    </script>
</head>
<body>
<div class="container">
    <h2>${msg}</h2>
</div>
<div>
    <div>
        <#--<form action="http://139.199.125.191/uploadImage" method="post" enctype="multipart/form-data">-->
        <form action="http://localhost:8080/uploadImage" method="post" enctype="multipart/form-data">
        <#--<%--<label>用户名：</label><input type="text" name="name"/><br/>--%>-->
            <label>序号：</label><input type="text" name="seqNo"/><br/>
            <label>文件</label><input type="file" name="multipartFile"/><br/>
            <#--<%--<label>文件</label><input type="file" name="multipartFile"/><br/>--%>-->
            <input type="submit" value="提  交"/>
        </form>
    </div>
</div>

<div>
<h1>显示图片</h1>
    <a href="getPicList?seqNo=1100">点击获取图片</a>
    <a href="picPath?seqNo=1000">点击获取图片</a>
    <a href="qcodePicPath">点击获取二维码图片</a>
</div>
</body>
</html>