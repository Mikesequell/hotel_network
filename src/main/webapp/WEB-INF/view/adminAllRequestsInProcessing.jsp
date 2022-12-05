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

        .block-button {
            margin: 20px;
        }
        .section {
            padding: 20px;
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
<section class="section">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>Status</th>
            <th>Arrival date</th>
            <th>Departure date</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allRequestsInProcessing}" var="request">
            <tr>
                <td>${request.id}</td>
                <td>${request.userId.username}</td>
                <td>${request.statusId.name}</td>
                <td>${request.arrivalDate}</td>
                <td>${request.departureDate}</td>
                <td>
                    <button class="button" onclick="document.location='/admin/editRequestInProcessing?id=${request.id}'"
                            <c:if test="${request.statusId.name ne 'in processing'}">
                                disabled
                            </c:if>>Edit
                    </button>
                    <button class="button" onclick="document.location='/admin/viewRequestById?id=${request.id}'">View
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>



<%--<c:forEach items="${allRequestsInProcessing}" var="request">--%>
<%--    ${request.id} -- username: ${request.userId.username} -- status: ${request.statusId.name} -- arrival date: ${request.arrivalDate} -- departure date: ${request.departureDate} </a> <br>--%>
<%--</c:forEach>--%>
</body>
</html>