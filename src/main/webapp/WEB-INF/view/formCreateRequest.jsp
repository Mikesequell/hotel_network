<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .button {
            border: 1px solid black;
            border-radius: 4px;
            padding: 4px 6px;
            cursor: pointer;
            /*display: block;*/
        }

        .button:hover {
            background-color: aliceblue;
        }
        .form {
            display: flex;
            flex-direction: column;
            width: 30%;
        }

        .form-label {
            margin-bottom: 5px;
        }

        .form-input {
            margin-bottom: 20px;
        }
        .create-request {
            padding: 20px;
        }
    </style>
</head>
<body>
<%--    <form action="/createRequest">--%>
<%--        <label>Choose comfortable rank</label> <input name="comfortableRank"> <br>--%>
<%--        <input type="submit" value="Create Request">--%>
<%--    </form>--%>
<div class="create-request">
    <c:url value="/user/createRequest" var="createRequestAction"/>
    <spring_form:form cssClass="form" method="post" action="${createRequestAction}" modelAttribute="createRequest">
        <spring_form:label cssClass="form-label" path="apartment.hotelId">Choose hotel </spring_form:label>
        <spring_form:select cssClass="form-input" path="apartment.hotelId">
            <c:forEach items="${hotels}" var="hotel">
                <spring_form:option value="${hotel.id}">${hotel.name}</spring_form:option> <br>
            </c:forEach>
        </spring_form:select> <br>
        <spring_form:label cssClass="form-label" path="apartment.comfortableRank">Choose comfortable rank </spring_form:label>
        <spring_form:select cssClass="form-input" path="apartment.comfortableRank">
            <option value=1>1</option>
            <option value=2>2</option>
            <option value=3>3</option>
            <option value=4>4</option>
            <option value=5>5</option>
        </spring_form:select> <br>
        <spring_form:label cssClass="form-label" path="apartment.sleepingPlaces">Choose sleeping places </spring_form:label>
        <spring_form:select cssClass="form-input" path="apartment.sleepingPlaces">
            <option value=1>1</option>
            <option value=2>2</option>
            <option value=3>3</option>
        </spring_form:select> <br>
        <spring_form:label cssClass="form-label" path="arrivalDate">Choose arrival date </spring_form:label>
        <spring_form:input cssClass="form-input"
                           type="date"
                           value="${createRequest.currentDate}"
                           min="${createRequest.currentDate}"
                           path="arrivalDate"/>
        <br>
        <spring_form:label cssClass="form-label" path="departureDate">Choose departure date </spring_form:label>
        <spring_form:input cssClass="form-input"
                           type="date"
                           min="${createRequest.currentDate}"
                           path="departureDate"/>
        <br>
        <input class="button" type="submit" value="Create Request">
    </spring_form:form>
</div>
</body>
</html>