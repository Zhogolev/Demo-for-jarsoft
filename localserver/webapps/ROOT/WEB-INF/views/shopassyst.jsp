<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Shop</title>
    <jsp:include page="_header.jsp"></jsp:include>
</head>
<body>
    <table border="1">
        <tr>
            <th>Article</th>
            <th>Name</th>
            <th>Price</th>
            <th>Put into basket</th>
        </tr>
        <c:forEach items="${shop}" var="item" >
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.price}"/></td>
            <td><a name="add_ref" href="addOnePosition?id=${item.id}&from=shop">+</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
