<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        *{
            font-weight: bold;
        }
        table{
            background-color: aqua;
        }
    </style>
    <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
    <script type="text/javascript">
       $(function () {
           $(type="submit").click(function () {
                var username=$("#mname").val();
                var gender=$("#gender").val();
                var age=$("#age").val();
                if(username==""||gender==""||age==""){
                    alert("会员姓名，性别和年龄不能为空")
                    return false;
                }
                return true;
            })
    </script>
</head>
<body>
<form action="update?type=upd" method="post">
    <table border="1">
        <tr>
            <td colspan="2">会员信息</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <input value="${info.mname}" id="name" type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td>
                <input value="${info.mage}" type="text" id="age" name="age">
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input value="${info.mgender}" type="text"  name="gender" id="gender">
            </td>
        </tr>
        <tr>
            <td>家庭住址：</td>
            <td>
                <input value="${info.maddress}" type="text" name="address" id="address">
            </td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td>
                <input value="${info.memail}" type="text" name="email" id="email">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input id="mid" name="mid" type="hidden" value="${info.mid}">
                <input type="submit" value="修改">
                <input type="reset" value="重置">
            </td>

        </tr>
    </table>
</form>
</body>
</html>