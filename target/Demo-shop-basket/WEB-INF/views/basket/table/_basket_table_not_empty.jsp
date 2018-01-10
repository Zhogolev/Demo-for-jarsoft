<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<table border="1" style="margin-top : 10px;">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Add</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${basket}" var="item" >
        <tr>
            <td align="center"><c:out value="${item.name}"/></td>
            <td align="center"><c:out value="${item.price}"/></td>
            <td align="center"><c:out value="${item.quantity}"/></td>
            <td align="center">
                <a  href="addOnePosition?id=${item.nomenclatureId}&sessionid=${item.session}">+</a>
            </td>
            <td align="center">
                <a href="deleteOnePosition?id=${item.nomenclatureId}&sessionid=${item.session}">-</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
