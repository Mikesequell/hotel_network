<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>

    </head>
    <body>
    <a href="<c:url value="/user/showCreateRequest"/>">Create request</a> <br>
        <c:forEach items="${hotels}" var="hotel">
            <a href="<c:url value="/hotelDetails?id=${hotel.id}"/>">${hotel.name} - free address: ${hotel.address} - total apartments: ${hotel.allQuantityApartments}</a> <br>
        </c:forEach>
    </body>
</html>