<%-- 
    Document   : registeruser
    Created on : Sep 3, 2023, 3:48:50 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<section id="register" class="vh-100 overflow-auto" style="background-color: #F1F1F1;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h2 fw-bold mb-5 mx-1 mx-md-4 mt-4 ">Đăng ký tài khoản khách hàng</p>

                                <c:url value="/register/customer" var="{action}" />
                                <form class="mx-1 mx-md-4" method="post" action="${action}">
                                   

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="user.username" >
                                                <input type="text" id="username" name="username" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="username">Tên đăng nhập</label>
                                            <form:errors path="user.username" element="div" cssClass="text-danger" />
                                            <c:if test="${msgErr != null}">
                                                <div class="text-danger" >
                                                    Tên đăng nhập đã tồn tại!
                                                </div>
                                            </c:if>
                                           
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="user.password" >
                                                <input type="password" id="password" name="password" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="password">Mật khẩu</label>
                                            <form:errors path="user.password" element="div" cssClass="text-danger" />
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="user.retypePassword" >
                                                <input type="password" id="retypePassword" name="retypePassword" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="retypePassword">Xác nhận mật khẩu</label>
                                            <form:errors path="user.retypePassword" element="div" cssClass="text-danger" />
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fa-solid fa-person-through-window me-3 fa-fw fa-lg"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="authentication" name="authentication" class="form-control" value="Khách Hàng" disabled/>
                                            <label class="form-label" for="authentication">Phân quyền</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class=" fa-regular fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="userDetail.email" >
                                                <input type="text"  id="email" name="email" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="email">Email</label>
                                            <%--<form:errors path="buscompany.phoneNumber" element="div" cssClass="text-danger" />--%>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fa-solid fa-id-card fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="userDetail.name" >
                                                <input type="text"  id="name" name="name" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="name">Họ và tên</label>
                                            <%--<form:errors path="buscompany.name" element="div" cssClass="text-danger" />--%>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-phone fa-bus fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="userDetail.phoneNumber" >
                                                <input type="text"  id="phoneNumber" name="phoneNumber" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="phoneNumber">Số điện thoại</label>
                                            <%--<form:errors path="buscompany.name" element="div" cssClass="text-danger" />--%>
                                        </div>
                                    </div>
                                  
                                    <div class="form-check d-flex justify-content-center mb-5">
                                        <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                                        <label class="form-check-label" for="form2Example3">
                                            I agree all statements in <a href="#!">NVN-HT Terms of service</a>
                                        </label>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Đăng ký</button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>