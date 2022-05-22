<%--
  Created by IntelliJ IDEA.
  User: 91342
  Date: 2021/12/29
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/ssmtest/regist" method="post">
    <table border="1px" bordercolor="red" bgcolor="lightgray" cellspacing="0px" cellpadding="5px" align="center">
        <caption>注册用户</caption>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
