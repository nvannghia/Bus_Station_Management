<%-- 
    Document   : updatelocation
    Created on : Aug 27, 2023, 4:37:48 PM
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
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sửa địa chỉ</p>
                                <c:url value="/location/update" var="action" />
                                <form:form modelAttribute="location" class="mx-1 mx-md-4" method="post" action="${action}">
                                    <form:hidden path="id" />
                                    <form:hidden path="buscompaniesId" />
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-city fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:select class="form-select" path="cityName" name="cityName" id="cityName" >
                                                <c:forEach items="${citiesName}" var="cityName">
                                                    <c:choose>
                                                        <c:when test="${location.cityName == cityName}">
                                                            <option value="${cityName}" selected>
                                                                ${cityName}
                                                            </option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${cityName}">
                                                                ${cityName}
                                                            </option>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </c:forEach>
                                            </form:select>
                                            <%--<form:input type="text" path="cityName"  id="cityName" name="cityName" class="form-control" placeholder="Nhập tên thành phố"/>--%>
                                            <label class="form-label" for="cityName">Tên Thành Phố</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-brands fa-squarespace fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input type="text" path="districtName" id="districtName" name="districtName" class="form-control" placeholder="Nhập tên quận" />
                                            <label class="form-label" for="districtName">Tên Quận</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-road fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input type="text" path="streetName" id="streetName" name="streetName" class="form-control" placeholder="Nhập tên đường"/>
                                            <label class="form-label" for="streetName">Tên Đường</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Sửa</button>
                                    </div>
                                </form:form>
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="https://cdn.tgdd.vn/2020/04/campaign/thumbMap360-640x360.png"
                                     class="img-fluid shadow-lg p-3 mb-5 bg-white rounded" alt="Sample image" >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
