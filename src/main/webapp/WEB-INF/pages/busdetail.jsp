<%-- 
    Document   : busdetail
    Created on : Sep 4, 2023, 3:52:06 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<style><%@include file="/WEB-INF/css/commentCss.css"%></style>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container d-flex justify-content-center">
    <div class="w3-container">
        <div class="w3-card-4" >
            <img 
                height="500px"
                width="500px"
                src="${busDetail.image}" 
                alt="Ảnh nhà xe" 
                style="width:100%"
                class="object-fit-cover  border rounded"
                >
            <div class="w3-container w3-center mt-2">
                <p class="h2 text-secondary font-weight-bold">Nhà xe ${busDetail.name}</p>
                <p class="h2 text-white bg-secondary">Đường dây nóng: ${busDetail.phoneNumber}</p>
            </div>
        </div>
    </div>
</div>


<h1>Tất cả vé xe đang bán: </h1>
<c:if test="${tickets.isEmpty()}">
    <h1 class="text-danger"> Chưa có vé xe nào ! </h1>
</c:if>

<c:if test="${!tickets.isEmpty()}">
    <section class="container overflow-auto " style="background-color: #dadde6; height:615px" >
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

<h1>Các bình luận và đánh giá: </h1>
<div class="container justify-content-center mt-5 border-left border-right">
    <c:url value="/customer/bus/rating/${busDetail.id}" var="action" />
    <form:form modelAttribute="review" method="post" action="${action}">
        <div class="d-flex justify-content-center pt-3 pb-2"> 
            <form:input path="content" type="text" name="content" placeholder="+ Thêm bình luận" class="form-control addtxt" /> 
        </div>
        <div class="d-flex justify-content-center pt-3 pb-2"> 
            <form:input path="star" value="1" min="1" max="5" type="number" name="star" placeholder="Số sao?" class="form-control addtxt" /> 
        </div>
        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
            <button type="submit" class="btn btn-primary btn-lg">Bình luận</button>
        </div>
    </form:form>
    <!--display comment-->
    <div class="d-flex flex-column align-items-center py-2">
        <c:forEach items="${rating}" var="rate">
            <div class="second py-2 px-2 mt-2"> 
                <span class="text1">${rate.content}</span>
                <div class="d-flex justify-content-between py-1 pt-2">
                    <div><img src="https://res.cloudinary.com/dnwemzbtm/image/upload/v1693906722/Hinh-anh-avatar-facebook-doc-nen-ombre_ebnzlx.jpg" width="18"><span class="text2">${rate.userId.username}</span></div>
                    <div>
                        <span class="text3">Đánh giá:</span>
                        <span class="thumbup">
                            <c:forEach begin="1" end="${rate.star}">
                                <i class="fa-solid fa-star" style="color:yellow"></i>
                            </c:forEach>
                        </span>

                    </div>

                </div>
            </div>
        </c:forEach>

    </div>
</div>
