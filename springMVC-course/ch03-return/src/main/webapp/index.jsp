<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <from action="returnString-view.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </from>
</body>
</html>