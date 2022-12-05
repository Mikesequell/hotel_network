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
<a>Choose user<a/> <br>

    <c:forEach items="${users}" var="user">
    <a href="<c:url value="/admin/showAllRequestsByUser?id=${user.id}"/>">${user.username}</a> <br>
    </c:forEach>
</body>
</html>