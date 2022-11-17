<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>
<%--    <form action="/createRequest">--%>
<%--        <label>Choose comfortable rank</label> <input name="comfortableRank"> <br>--%>
<%--        <input type="submit" value="Create Request">--%>
<%--    </form>--%>
<c:url value="/createRequest" var="createRequestAction"/>
<spring_form:form method="post" action="${createRequestAction}" modelAttribute="createRequest">
    <spring_form:label path="hotelId">Choose hotel </spring_form:label>
    <spring_form:select path="hotelId">
        <c:forEach items="${hotels}" var="hotel">
            <spring_form:option value="${hotel.id}">${hotel.name}</spring_form:option> <br>
        </c:forEach>
    </spring_form:select> <br>
    <spring_form:label path="comfortableRank">Choose comfortable rank </spring_form:label>
    <spring_form:select path="comfortableRank">
        <option value=1>1</option>
        <option value=2>2</option>
        <option value=3>3</option>
        <option value=4>4</option>
        <option value=5>5</option>
    </spring_form:select> <br>
    <spring_form:label path="sleepingPlaces">Choose sleeping places </spring_form:label>
    <spring_form:select path="sleepingPlaces">
        <option value=1>1</option>
        <option value=2>2</option>
        <option value=3>3</option>
    </spring_form:select> <br>
    <spring_form:label path="arrivalDate">Choose arrival date </spring_form:label>
    <spring_form:input type="date"
                       value="${createRequest.currentDate}"
                       min="${createRequest.currentDate}"
                       path="arrivalDate"/>
    <br>
    <spring_form:label path="departureDate">Choose departure date </spring_form:label>
    <spring_form:input type="date"
                       min="${createRequest.currentDate}"
                       path="departureDate"/>
    <br>
    <input type="submit" value="Create Request">
</spring_form:form>
</body>
</html>