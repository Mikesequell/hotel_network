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

        p {
            margin: 0;
        }

        .header {
            padding: 15px;

        }

        .active {
            background-color: rgb(188, 255, 233);
        }

        /* .hidden {
            opacity: 0;
            display: none;
        } */

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

        th,
        td {
            border-right: 1px solid black;
            border-collapse: collapse;
            padding: 10px;
        }

        tr {
            border-top: 1px solid black;
            border-collapse: collapse;
        }

        .sections {
            display: flex;
            padding: 15px;
        }

        .hotel-list {
            width: 500px;
        }

        .title {
            margin-bottom: 5px;
            font-weight: 700;
            font-size: 18px;
        }

        .hotel-details {
            position: relative;
        }

        .wrap-hotel {
            position: absolute;
            top: 0;
            opacity: 1;
            /* transform: translateY(0); */
            transition: opacity 250ms linear, transform 500ms linear;
        }

        .wrap-hotel.hidden {
            opacity: 0;
            /* transform: translateY(-80%); */
            /* display: none; */
            /* transition: transform 500ms linear opacity 50ms linear; */

        }

        tr[hotellistid]:hover {
            cursor: pointer;
        }

        tr[hotellistid] {
            transition: color 250ms linear, background-color 250ms linear;
        }

        tr[hotellistid]:hover:not(.active) {
            color: red;
            background-color: rgb(234, 255, 248);
        }

        tr[hotellistid]:hover.active {
            color: blue;
            background-color: rgb(208, 255, 239);


        }
    </style>
</head>
<body>
<header class="header">
    <a class="button" href="<c:url value="/user/showCreateRequest"/>">Create request</a> <br>
</header>

<div class="sections">
    <div class="hotel-list">
        <p class="title">Hotels list</p>
        <table>
            <thead>
            <tr>
                <th>Hotel name</th>
                <th>Address</th>
                <th>Total apartments</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hotels}" var="hotel">
                <tr hotelListId=${hotel.id}>
                    <td>${hotel.name}</td>
                    <td>${hotel.address}</td>
                    <td>${hotel.allQuantityApartments}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="hotel-details">
        <c:forEach items="${hotels}" var="hotel">
            <div apartmentId=${hotel.id} class="wrap-hotel hidden">
                <p class="title">${hotel.name}</p>
                <table>
                    <thead>
                    <tr>
                        <th>Sleeping places</th>
                        <th>Comfortable rank</th>
                        <th>Price</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allApartments}" var="apartment">
                        <tr>

                            <c:if test="${apartment.hotelId.id eq hotel.id}">
                                <td>${apartment.sleepingPlaces}</td>
                                <td>${apartment.comfortableRank}</td>
                                <td>${apartment.price}</td>
                                <td>${apartment.statusId.name}</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </c:forEach>
    </div>
</div>
<script>
    const hotelIdRef = document.querySelectorAll('[hotelListId]');
    const apartmentIdRef = document.querySelectorAll('[apartmentId]');
    console.log('hotelIdRef; ', hotelIdRef)
    console.log('apartmentIdRef; ', apartmentIdRef)
    let isHotelDetailActive = true;
    let currentActiveHotel = null;

    for (const hotelItem of hotelIdRef) {

        hotelItem.addEventListener('click', e => {
            const idHotelOnClick = e.currentTarget.getAttribute('hotelListId');

            for (const hotel of hotelIdRef) {
                // если мы кликнули на активный отель, сбросить все статусы и прервать цикл
                if (idHotelOnClick === currentActiveHotel && idHotelOnClick === hotel.getAttribute('hotelListId')) {
                    console.log('removev active status')
                    hotel.classList.remove('active');
                    isHotelDetailActive = false;
                    currentActiveHotel = null;
                    break;
                }

                //еслю ID кликнутого отеля совпал с перебирающим
                if (idHotelOnClick === hotel.getAttribute('hotelListId')) {
                    hotel.classList.add('active');
                    currentActiveHotel = idHotelOnClick;
                    isHotelDetailActive = true;
                } else hotel.classList.remove('active');
            }

            for (const apartment of apartmentIdRef) {
                //если правая список не активет скрываем и переходим до детале другого отеля (ранний выход)
                if (!isHotelDetailActive) {
                    apartment.classList.add('hidden');
                    continue;
                }
                if (e.currentTarget.getAttribute('hotelListId') === apartment.getAttribute('apartmentId')) {
                    apartment.classList.remove('hidden')
                } else {
                    apartment.classList.add('hidden')
                }
            }

        })
    }


</script>

</body>
</html>