<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .wrap {
            display: flex;
            width: 100%;
        }

        .wrap-list {
            width: 400px;
            border: 1px solid black;
            background-color: lightgray;
            margin-bottom: 15px;
        }

        .wrap-item {
            width: 50%;
        }

        .list.hidden {
            display: none;
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

        .button-submit {
            width: 150px;
            padding: 8px;
            border-radius: 4px;
        }

        .button-submit:hover {
            background-color: lightgreen;
        }

        .title {
            display: block;
            background-color: lightgray;
            height: 30px;
            padding: 10px;
            margin: 0;
            text-align: center;
        }

        .list {
            background-color: white;
            padding: 10px;
        }

        .list-item {
            padding-bottom: 5px;
        }
    </style>
</head>
<body>
<div class="wrap">
    <div class="wrap-item">
        <c:url value="/admin/editRequestInProcessing" var="editRequestInProcessing"/>
        <spring_form:form cssClass="form" method="post" action="${editRequestInProcessing}" modelAttribute="request">

            <spring_form:label cssClass="form-label"
                               path="id">Request id</spring_form:label>
            <spring_form:input cssClass="form-input" path="id" readonly="true"/>

            <spring_form:label cssClass="form-label"
                               path="apartmentId.statusId.name">Apartment status</spring_form:label>
            <spring_form:input cssClass="form-input" path="apartmentId.statusId.name" readonly="true"/>

            <spring_form:label cssClass="form-label" path="apartmentId.hotelId">Hotel</spring_form:label>
            <spring_form:input cssClass="form-input" path="apartmentId.hotelId" readonly="true"/>

            <spring_form:label cssClass="form-label"
                               path="apartmentId.comfortableRank">Comfortable rank</spring_form:label>
            <spring_form:input cssClass="form-input" path="apartmentId.comfortableRank" readonly="true"/>

            <spring_form:label cssClass="form-label"
                               path="apartmentId.sleepingPlaces">Sleeping places</spring_form:label>
            <spring_form:input cssClass="form-input" path="apartmentId.sleepingPlaces" readonly="true"/>

            <spring_form:label cssClass="form-label" path="arrivalDate">Arrival date</spring_form:label>
            <spring_form:input cssClass="form-input" path="arrivalDate" readonly="true"/>

            <spring_form:label cssClass="form-label" path="departureDate">Departure date</spring_form:label>
            <spring_form:input cssClass="form-input" path="departureDate" readonly="true"/>

            <spring_form:label cssClass="form-label" path="apartmentId.id">Apartment Id</spring_form:label>
            <spring_form:input cssClass="form-input data" path="apartmentId.id"/>

            <input class="button-submit" type="submit" value="Submit changes">
        </spring_form:form>
    </div>
    <div class="wrap-item">

        <div class="wrap-list">
            <p class="title">1 Places</p>
            <ul class="list hidden">
                <c:forEach items="${freeApartments}" var="apartment">
                    <c:if test="${apartment.sleepingPlaces eq 1}">
                        <li class="list-item">id: ${apartment.id} -- status: ${apartment.statusId.name}</li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>


        <div class="wrap-list">
            <p class="title">2 Places</p>
            <ul class="list hidden">
                <c:forEach items="${freeApartments}" var="apartment">
                    <c:if test="${apartment.sleepingPlaces eq 2}">
                        <li class="list-item">id: ${apartment.id} -- status: ${apartment.statusId.name}</li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>


        <div class="wrap-list">
            <p class="title">3 Places</p>
            <ul class="list hidden">
                <c:forEach items="${freeApartments}" var="apartment">
                    <c:if test="${apartment.sleepingPlaces eq 3}">
                        <li class="list-item">id: ${apartment.id} -- status: ${apartment.statusId.name}</li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<script>
    const headerApartment = document.querySelectorAll('.title');
    console.log(headerApartment);
    for (const el of headerApartment) {
        el.addEventListener('click', (event) => {

                console.dir(event.currentTarget.nextElementSibling);
                event.currentTarget.nextElementSibling.classList.toggle("hidden");

                // console.log(event.target.nextSibling)
                // event.currentTarget.nextSibling.toggleClass('hidden');
                // event.currentTarget.
            }
        )
    }

</script>
</body>
</html>