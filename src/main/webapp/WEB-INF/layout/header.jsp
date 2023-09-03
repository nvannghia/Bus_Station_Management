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
                    <a class="navbar-brand" href="<c:url value="/" />">Quản trị nhà xe</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/createBusCompanyAccount"/>">Thêm nhà xe</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Xác nhận nhà xe</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_BUSCOMPANY')">
                    <li class="nav-item ">
                        <a class="nav-link" href="<c:url value="/location/list"/>">Xem tất địa chỉ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/routes/list"/>">Xem tất cả tuyến xe</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/ticket/list"/>">Xem tất cả vé xe</a>
                    </li>
                </sec:authorize>
                <c:if  test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item me-auto">
                        <a class="nav-link text-danger" href="<c:url value="/login"/>">Đăng nhập</a>
                    </li>
                    <li class="nav-item me-auto">
                        <a class="nav-link text-danger" href="<c:url value="/register/customer"/>">Khách hàng đăng ký</a>
                    </li>
                    <li class="nav-item me-auto">
                        <a class="nav-link text-danger" href="<c:url value="/register/buscompany"/>">Nhà xe đăng ký</a>
                    </li>
                </c:if>

            </ul>
        </div>
        <ul class="navbar-nav d-flex">
            <c:if  test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item me-2 ">
                    <a class="nav-link text-info logged h5" href="<c:url value="/"/>">
                        Tài khoản: ${pageContext.request.userPrincipal.name}
                    </a>
                </li>
                <li class="nav-item  ">
                    <a class="nav-link text-danger logout" href="<c:url value="/logout"/>">
                        Đăng xuất
                    </a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
