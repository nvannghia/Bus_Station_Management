<%-- 
    Document   : customerindex
    Created on : Sep 4, 2023, 12:24:49 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<section class="d-flex flex-column align-items-center shadow-lg p-3 mb-5 bg-white rounded" style="background-image: url('https://res.cloudinary.com/dnwemzbtm/image/upload/v1694092162/bg-image_pvshyz.jpg'); background-size: cover " >
    <c:url value="/customer/index" var="action"/>
    <form class="mx-1 mx-md-4" action="${action}">
        <h1 class="text-danger">Bạn về đâu?</h1>
        <p class="h3 text-danger">Điểm đi</p>
        <select class="form-select" name="from">
            <c:forEach items="${citiesName}" var="cityName">
                <option value="${cityName}">${cityName}</option>
            </c:forEach>
        </select>
        <p class="h3 text-danger">Điểm đến</p>
        <select class="form-select" name="to">
            <c:forEach items="${citiesName}" var="cityName">
                <option value="${cityName}">${cityName}</option>
            </c:forEach>
        </select>
        <input type="submit" class="btn btn-danger mt-3" value="Tìm vé" />
    </form>
</section>

<!--tim ve-->
<c:if test="${!tickets.isEmpty()}">
    <h1>Các chuyến xe phù hợp với bạn:</h1>
    <section class="container overflow-auto shadow-lg p-3 mb-5 rounded" style="background-color: #dadde6; height:615px" >
        <c:forEach var="tk" items="${tickets}">
            <div class="">
                <article class="card fl-left mt-4">
                    <section class="date ">
                        <time datetime="23th feb">
                            <span><i class="fa-solid fa-bus"></i></span>
                            <span class="text-info">${tk.buscompaniesId.name}</span>
                        </time>
                    </section>
                    <section class="card-cont text-info">
                        <h4><i class="fa-solid fa-money-bill"></i>Giá vé: <fmt:formatNumber value="${tk.tripsId.routesId.fare}"/> vnđ</h4>
                        <div class="even-date">
                            <i class="fa-solid fa-couch"></i>
                            <h5>Ghế số: ${tk.seatNumber} </h5>
                        </div>
                        <div class="even-date">
                            <i class="fa fa-calendar"></i>
                            <time>
                                <span>Ngày khởi hành: ${tk.tripsId.departureDate}</span>
                                <span>
                                    Giờ khởi hành: 
                                    <c:choose>
                                        <c:when test="${tk.tripsId.minute == '0' }">
                                            ${tk.tripsId.hour}:00
                                        </c:when>
                                        <c:otherwise>
                                            ${tk.tripsId.hour}:${tk.tripsId.minute}
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </time>
                        </div>
                        <div class="even-info text-danger">
                            <i class="fa-solid fa-location-dot"></i>
                            <p>
                                ${tk.tripsId.routesId.departureId.getFullAddress()} 
                            </p>
                        </div>
                        <div class="even-info text-success">
                            <i class="fa fa-map-marker"></i>
                            <p>
                                ${tk.tripsId.routesId.destinationId.getFullAddress()} 
                            </p>
                        </div>
                        <c:choose>
                            <c:when test="${tk.sold == '0' }">
                                <a href="<c:url value="/customer/bus/order/${tk.id}" />" class="bg-success"> Đặt vé </a>
                            </c:when>
                            <c:otherwise>
                                <a type="button disabled-link" onclick="return false" disabled class=" bg-danger"> Đã bán </a>
                            </c:otherwise>
                        </c:choose>

                    </section>
                </article>
            </div>
        </c:forEach>
    </section>
</c:if>

<!--tim kiem nha xe-->
<c:if test="${busSearch != null}">
    <h1>Kết quả tìm kiếm nhà xe:</h1>
    <div class="container mt-2 mb-2">
        <div class="row">
            <div class="col-md-3 mt-2">
                <div class="w3-container">
                    <div class="w3-card-4 border border-info" >
                        <img 
                            width="180px" 
                            height="200px"  
                            src="${busSearch.image}" 
                            alt="Ảnh nhà xe" 
                            style="width:100%"
                            class="object-fit-cover  border rounded zoom"
                            >
                        <div class="w3-container w3-center mt-2">
                            <p class="h5">Nhà xe ${busSearch.name}</p>
                            <p>Số điện thoại: ${busSearch.phoneNumber}</p>
                            <a href="<c:url value="/customer/bus/detail/${busSearch.id}" />" class="btn btn-primary mb-2">Xem chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <hr>
    <!--tat ca nha xe-->
    <div class="container mt-2 mb-2">
        <div class="row">
            <c:forEach items="${buscompanies}" var="bus">
                <div class="col-md-3 mt-2">
                    <div class="w3-container">
                        <div class="w3-card-4 border border border-secondary" >
                            <img 
                                width="180px" 
                                height="200px"  
                                src="${bus.image}" 
                                alt="Ảnh nhà xe" 
                                style="width:100%"
                                class="object-fit-cover  border rounded zoom"
                                >
                            <div class="w3-container w3-center mt-2">
                                <p class="h5">Nhà xe ${bus.name}</p>
                                <p>Số điện thoại: ${bus.phoneNumber}</p>
                                <a href="<c:url value="/customer/bus/detail/${bus.id}" />" class="btn btn-primary mb-2">Xem chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="d-flex justify-content-center mt-5">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="<c:url value="/customer/index" />">Tất cả</a>
                </li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/customer/index" var="pageAction">
                        <c:param name="page" value="${i}"/>
                    </c:url>
                    <li class="page-item">
                        <a class="page-link" href="${pageAction}">${i}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

