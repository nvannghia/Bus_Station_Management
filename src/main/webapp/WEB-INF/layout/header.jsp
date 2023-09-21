<%-- 
    Document   : header
    Created on : Aug 15, 2023, 9:25:11 PM
    Author     : nghia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav ">
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item d-flex flex-row align-items-center">
                        <i class="fa-solid fa-list-check text-white fs-4 text"></i>
                        <a class="navbar-brand" href="<c:url value="/" />">Quản trị nhà xe</a>
                    </li>
                    <li class="nav-item d-flex flex-row align-items-center">
                        <i class="fa-solid fa-user-plus text-white fs-4 text"></i>
                        <a class="nav-link" href="<c:url value="/createBusCompanyAccount"/>">Thêm nhà xe</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_BUSCOMPANY')">
                    <li class="nav-item d-flex flex-row align-items-center">
                        <i class="fa-solid fa-location-arrow text-white fs-4 text"></i>
                        <a class="nav-link" href="<c:url value="/location/list"/>">Xem tất địa chỉ</a>
                    </li>
                    <li class="nav-item d-flex flex-row align-items-center">
                        <i class="fa-solid fa-road text-white fs-4 text"></i>
                        <a class="nav-link" href="<c:url value="/routes/list"/>">Xem tất cả tuyến xe</a>
                    </li>
                    <li class="nav-item d-flex flex-row align-items-center">
                        <i class="fa-solid fa-ticket text-white fs-2 text" ></i>
                        <a class="nav-link" href="<c:url value="/ticket/list"/>">Xem tất cả vé xe</a>
                    </li>
                    <li class="nav-item d-flex flex-row align-items-center">
                        <i class="fa-solid fa-coins text-white fs-4 text"></i>
                        <a class="nav-link" href="<c:url value="/buscompany/statistical"/>">Xem thống kê</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                    <li class="nav-item d-flex flex-row align-items-center ">
                        <i class="fa-solid fa-bus text-white fs-2 text"></i>
                        <a class="nav-link" href="<c:url value="/customer/index"/>">Tất cả nhà xe</a>
                    </li>
                    <li class="nav-item d-flex flex-row align-items-center">
                        <i class="fa-solid fa-ticket text-white fs-2 text" ></i>
                        <a class="nav-link" href="<c:url value="/customer/ticket/booked"/>">Xem vé đã đặt</a>
                    </li>
                    <c:url value="/customer/index" var="action"/>
                    <form class="d-flex" action="${action}">
                        <input class="form-control me-2" name="kw" type="text" placeholder="Nhập tên nhà xe...">
                        <button class="btn btn-danger" type="submit">Tìm</button>
                    </form>
                </sec:authorize>
                <c:if  test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item me-auto d-flex flex-row align-items-center">
                        <i class="fa-solid fa-right-to-bracket text-white fs-4 text"></i>
                        <a class="nav-link text-danger" href="<c:url value="/login"/>">Đăng nhập</a>
                    </li>
                    <li class="nav-item me-auto d-flex flex-row align-items-center">
                        <i class="fa-solid fa-user text-white fs-4 text"></i>
                        <a class="nav-link text-danger" href="<c:url value="/register/customer"/>">Khách hàng đăng ký</a>
                    </li>
                    <li class="nav-item me-auto d-flex flex-row align-items-center">
                        <i class="fa-solid fa-bus text-white fs-4 text"></i>
                        <a class="nav-link text-danger" href="<c:url value="/createBusCompanyAccount"/>">Nhà xe đăng ký</a>
                    </li>
                </c:if>

            </ul>
        </div>
        <ul class="navbar-nav d-flex">
            <c:if  test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item me-2 d-flex flex-row align-items-center">
                    <i class="fa-regular fa-user text-white fs-2 text"></i>
                    <a class="nav-link text-info logged h5" href="<c:url value="/"/>">
                        ${pageContext.request.userPrincipal.name}
                    </a>
                </li>
                <li class="nav-item d-flex flex-row align-items-center">
                    <i class="fa-solid fa-right-from-bracket text-danger fs-4 text"></i>
                    <a class="nav-link text-danger logout" href="<c:url value="/logout"/>">
                        Đăng xuất
                    </a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
