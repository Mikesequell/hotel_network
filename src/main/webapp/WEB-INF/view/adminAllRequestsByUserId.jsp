<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>
<c:forEach items="${allRequests}" var="request">
    ${request.id} -- status:${request.status} -- arrival date:${request.arrivalDate} -- departure date:${request.departureDate} </a> <br>
</c:forEach>
</body>
</html>