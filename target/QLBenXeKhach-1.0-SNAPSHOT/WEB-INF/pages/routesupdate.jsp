<%-- 
    Document   : routesupdate
    Created on : Aug 28, 2023, 6:34:51 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section id="register" class="vh-100" style="background-color: #F1F1F1;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Thêm Tuyến</p>
                                <c:url value="/routes/update" var="action" />
                                <form:form modelAttribute="route"  class="mx-1 mx-md-4" method="post" action="${action}">
                                    <form:hidden path="id" />
                                    <form:hidden path="buscompaniesId" />
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-coins fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:errors path="fare" element="div" cssClass="text-danger"/>
                                            <form:input  type="text" path="fare"  id="fare" name="fare" class="form-control" placeholder="Nhập tiền vé"/>
                                            <label class="form-label" for="fare">Tiền vé</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-map-location-dot fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:select class="form-select" path="departureId" name="departureId" id="departureId">
                                                <c:forEach items="${locationes}" var="locate">
                                                    <c:choose>
                                                        <c:when test="${locate.id == route.departureId.id}">
                                                            <option value="${locate.id}" selected>
                                                                ${locate.streetName},
                                                                ${locate.districtName},
                                                                ${locate.cityName}
                                                            </option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${locate.id}">
                                                                ${locate.streetName},
                                                                ${locate.districtName},
                                                                ${locate.cityName}
                                                            </option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </form:select>
                                            <label class="form-label" for="departureId">Điểm xuất phát</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-map-location fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:select class="form-select" path="destinationId" name="destinationId" id="destinationId">
                                                <c:forEach items="${locationes}" var="locate">
                                                    <c:choose>
                                                        <c:when test="${locate.id == route.destinationId.id}">
                                                            <option value="${locate.id}" selected>
                                                                ${locate.streetName},
                                                                ${locate.districtName},
                                                                ${locate.cityName}
                                                            </option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${locate.id}">
                                                                ${locate.streetName},
                                                                ${locate.districtName},
                                                                ${locate.cityName}
                                                            </option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </form:select>
                                            <label class="form-label" for="destinationId">Điểm đến</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Thêm</button>
                                    </div>
                                </form:form>
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="https://www.axestrack.com/wp-content/uploads/2022/02/Untitled-design-41.png"
                                     class="img-fluid shadow-lg p-3 mb-5 bg-white rounded" alt="Sample image" >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
