<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div id="update" name="update">${update}</div>
<table border="1">
       <tr>
           <td colspan="6" style="text-align: center">
               俱乐部会员信息表
           </td>
       </tr>
    <tr>
        <td style="text-align: center">编号</td>
        <td style="text-align: center">姓名</td>
        <td style="text-align: center">性别</td>
        <td style="text-align: center">年龄</td>
        <td style="text-align: center">家庭住址</td>
        <td style="text-align: center">Email</td>
    </tr>
    <c:forEach items="${list}" var="m">
        <tr>
            <td><a id="a" href="update?type=sel&id=${m.mid}">
            ${m.mid}</a></td>
            <td style="text-align: center">${m.mname}</td>
            <td style="text-align: center">${m.mgender}</td>
            <td style="text-align: center">${m.mage}</td>
            <td style="text-align: center">${m.maddress}</td>
            <td style="text-align: center">${m.memail}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>