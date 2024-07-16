<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文件上传</title>
</head>
<body>
    <h1>文件下载示例</h1>
    <div>
        <div>测试不加download属性</div>
        <div>浏览器能识别的话直接就显示出来了，而不是下载</div>
        <div><a href="static/img/test.jpeg">超链接下载图片</a></div>
        <div><a href="static/text/test.txt">超链接下载文本</a></div>
    </div>
    <br />
    <div>
        <div>测试增加download属性</div>
        <div>这次变成直接下载了，而不是显示</div>
        <div><a href="static/img/test.jpeg" download>超链接下载图片</a></div>
        <div><a href="static/text/test.txt" download>超链接下载文本</a></div>

        <div><a href="file/download">servlet下载</a></div>
    </div>

</body>
</html>