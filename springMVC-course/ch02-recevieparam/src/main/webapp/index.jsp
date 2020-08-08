<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
    <p>提交参数给controller</p>
    <from action="receiveproperty.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </from>

    <br/>

    <p>请求参数和形参不一样</p>
    <from action="receiveparam.do" method="post">
        姓名：<input type="text" name="rname"><br/>
        年龄：<input type="text" name="rage">
        <input type="submit" value="提交参数">
    </from>

    <br/>

    <p>使用Java对象接收参数</p>
    <from action="receiveobject.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </from>
</body>
</html>