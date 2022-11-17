<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>
<c:forEach items="${apartments}" var="apartment">
    ${apartment.comfortableRank} - ${apartment.sleepingPlaces} - ${apartment.price} <br>
</c:forEach>
</body>
</html>