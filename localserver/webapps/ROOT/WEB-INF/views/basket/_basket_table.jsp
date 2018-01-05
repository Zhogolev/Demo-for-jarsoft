<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<body>
<c:choose>
    <c:when test="${fn:length(basket) > 0}">
        <jsp:include page="table/_basket_table_not_empty.jsp"/>
        <jsp:include page="forms/_do_order.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="table/_basket_table_empty.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>
