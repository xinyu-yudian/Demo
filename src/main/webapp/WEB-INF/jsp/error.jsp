<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--开启el表达式--%>
<%@ page  isELIgnored="false"%>

<html>
<head>
    <title>错误提示</title>

    <style type="text/css">
        .error{margin: 0 auto;}
    </style>
</head>
<body>
    <h3 class="error">${message}</h3>
</body>
</html>
