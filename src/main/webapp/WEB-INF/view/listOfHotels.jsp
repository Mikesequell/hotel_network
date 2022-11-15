<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>

    </head>
    <body>
        <c:forEach items="${hotels}" var="hotel">
            <a href="<c:url value="/hotel?id=${hotel.id}"/>">${hotel.name}</a> <br>
        </c:forEach>
    </body>
</html>