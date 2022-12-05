<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        a {
            text-decoration: none;
            color: inherit;
        }

        .button {
            border: 1px solid black;
            border-radius: 4px;
            padding: 4px 6px;
            cursor: pointer;
            /*display: block;*/
        }
        .button:hover.red {
            background-color: red;
        }
        .button:hover.green {
            background-color: lightgreen;
        }
        .button:hover {
            background-color: aliceblue;
        }

        table {
            table-layout: fixed;
            /*width: 100%;*/
            border-collapse: collapse;
            border: 3px solid purple;
            text-align: center;
        }
        thead {
            background-color: azure;
        }

        th, td {
            border-right: 1px solid black;
            border-collapse: collapse;
            padding: 10px;
        }

        tr {
            border-top: 1px solid black;
            border-collapse: collapse;
        }

    </style>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>Arrival date</th>
            <th>Departure date</th>
            <th>Status</th>
            <th>Apartment number</th>
            <th>Sleeping places</th>
            <th>Comfortable rank</th>
            <th>Hotel name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allRequestsByUser}" var="request">
            <tr>
                <td>${request.arrivalDate}</td>
                <td>${request.departureDate}</td>
                <td>${request.statusId.name}</td>
                <td>${request.apartmentId.id}</td>
                <td>${request.apartmentId.sleepingPlaces}</td>
                <td>${request.apartmentId.comfortableRank}</td>
                <td>${request.apartmentId.hotelId.name}</td>
                <td>
                    <c:if test="${request.statusId.name eq 'in processing'}">
                        <a class="button red" href="<c:url value="/user/cancelRequest?id=${request.id}"/>">Cancel</a>
                    </c:if>
                    <c:if test="${request.statusId.name eq 'response awaiting'}">
                        <a class="button red" href="<c:url value="/user/cancelRequest?id=${request.id}"/>">Cancel</a>
                        <a class="button green" href="<c:url value="/user/applyRequest?id=${request.id}"/>">Apply</a>
                    </c:if>
                    <c:if test="${request.statusId.name eq 'awaiting payment'}">
                        <a class="button red" href="<c:url value="/user/cancelRequest?id=${request.id}"/>">Cancel</a>
                        <a class="button green" href="<c:url value="/user/payRequest?id=${request.id}"/>">Pay</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>


    </table>

</div>

</body>
</html>