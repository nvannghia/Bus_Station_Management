<%-- 
    Document   : tripsadd
    Created on : Aug 28, 2023, 9:43:20 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section id="register" class="vh-100" style="background-color: #F1F1F1;">
    ${now}
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Thêm Chuyến Xe</p>

                                <c:url value="/trips/add" var="action" />
                                <form:form modelAttribute="trip"  class="mx-1 mx-md-4" method="post" action="${action}">

                                    <c:if test="${!msgErr.isEmpty()}">
                                        <div class=" text-danger h5">${msgErr} </div>
                                    </c:if>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-regular fa-calendar-days fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input  type="text" path="departureDate"  id="departureDate" name="departureDate" class="form-control" placeholder="VD: 1/1/2023"/>
                                            <label class="form-label" for="departureDate">Ngày khởi hành</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-clock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input min="0" max="23" type="number" path="hour"  id="hour" name="hour" class="form-control" placeholder="Chọn giờ"/>
                                            <label class="form-label" for="hour">Giờ</label>
                                        </div>

                                        <div class="form-outline flex-fill mb-0 ">
                                            <form:input step="5" min="0" max="55"  type="number" path="minute"  id="minute" name="minute" class="form-control" placeholder="Chọn phút"/>
                                            <label class="form-label" for="minute">Phút</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-bus-simple fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input  type="text" path="licensePlates"  id="licensePlates" name="licensePlates" class="form-control" placeholder="VD: 70B-099.99"/>
                                            <label class="form-label" for="licensePlates">Biển số xe</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-couch fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:select class="form-select" path="seatNumber" name="seatNumber" id="seatNumber">
                                                <option value="16">16</option>                                                    
                                                <option value="30">30</option>
                                                <option value="35">35</option>
                                                <option value="45">45</option>
                                            </form:select>
                                            <label class="form-label" for="seatNumber">Số ghế</label>
                                        </div>
                                    </div>

                                    <form:hidden path="routesId"/>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-map-location-dot fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input 
                                                value="${route.departureId.streetName}, ${route.departureId.districtName}, ${route.departureId.cityName}"
                                                disabled
                                                type="text" path="departureTime"  
                                                id="departureTime" name="departureTime" 
                                                class="form-control" placeholder="Nhập tiền vé"/>
                                            <label class="form-label" for="departureTime">Điểm xuất phát</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-map-location fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input 
                                                value="${route.destinationId.streetName}, ${route.destinationId.districtName}, ${route.destinationId.cityName}"
                                                disabled
                                                type="text" path="departureTime"  
                                                id="departureTime" name="departureTime" 
                                                class="form-control" placeholder="Nhập tiền vé"/>
                                            <label class="form-label" for="departureTime">Điểm đến</label>
                                        </div>
                                    </div>


                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Thêm</button>
                                    </div>
                                </form:form>
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="https://www.trinetrawireless.com/wp-content/uploads/2017/12/Efficient-Fleet-Route-Optimization-With-Trinetra-Wireless.jpg"
                                     class="img-fluid shadow-lg p-3 mb-5 bg-white rounded" alt="Sample image" >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
