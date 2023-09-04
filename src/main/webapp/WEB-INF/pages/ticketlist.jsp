<%-- 
    Document   : ticketlist
    Created on : Sep 1, 2023, 3:10:00 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${tickets.isEmpty()}">
    <h1 class="text-danger"> Chưa có vé xe nào ! </h1>
</c:if>

<section class="container overflow-auto " style="background-color: #dadde6">
    <c:forEach var="tk" items="${tickets}">
        <div class="">
            <article class="card fl-left mt-4">
                <section class="date ">
                    <time datetime="23th feb">
                        <span><i class="fa-solid fa-bus"></i></span>
                        <span class="text-info">${busName}</span>
                    </time>
                </section>
                <section class="card-cont text-info">
                    <h4>Giá vé: <fmt:formatNumber value="${tk.tripsId.routesId.fare}"/> vnđ</h4>
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

                        <a href="#" class=" text-info">
                        <c:choose>
                            <c:when test="${tk.sold == '0' }">
                               <a href="#" class=" bg-danger"> Chưa bán </a>
                            </c:when>
                            <c:otherwise>
                                <a href="#" class=" bg-success"> Đã bán </a>
                            </c:otherwise>
                        </c:choose>
                    
                </section>
            </article>
        </div>
    </c:forEach>
</section>