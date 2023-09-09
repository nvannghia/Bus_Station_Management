<%-- 
    Document   : register
    Created on : Aug 15, 2023, 9:10:25 PM
    Author     : nghia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<section id="register" class="vh-100 overflow-auto" style="background-color: #F1F1F1;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Đăng ký tài khoản nhà xe</p>

                                <c:url value="/createBusCompanyAccount" var="{action}" />
                                <form class="mx-1 mx-md-4" method="post" action="${action}" enctype="multipart/form-data">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="user.username" >
                                                <input type="text"  id="username" name="username" class="form-control"/>
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
                                            <input type="text" id="authentication" name="authentication" class="form-control" value="Nhà Xe" disabled/>
                                            <label class="form-label" for="authentication">Phân quyền</label>
                                        </div>
                                    </div>
                                    <hr/>
                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Đăng ký thông tin nhà xe</p>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-bus fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="buscompany.name" >
                                                <input type="text"  id="buscompanyName" name="name" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="buscompanyName">Tên nhà xe</label>
                                            <form:errors path="buscompany.name" element="div" cssClass="text-danger" />
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-phone fa-bus fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="buscompany.phoneNumber" >
                                                <input type="text"  id="phoneNumber" name="phoneNumber" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="phoneNumber">Số điện thoại</label>
                                            <form:errors path="buscompany.phoneNumber" element="div" cssClass="text-danger" />
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-truck-fast fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="buscompany.delivery" >
                                                <select class="form-select" name="delivery">                                     
                                                    <option value="1" selected>Có</option>
                                                    <option value="0">Không</option>
                                                </select>
                                            </spring:bind>
                                            <label class="form-label" for="delivery">Giao hàng</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fa-regular fa-image fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="buscompany.file" >
                                                <input type="file"  id="file" name="file" class="form-control" />
                                            </spring:bind>
                                            <label class="form-label" for="file">Ảnh nhà xe</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-solid fa-question fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <spring:bind path="buscompany.active" >
                                                <input type="text"  id="active" name="active" class="form-control" value="${msgActive}" disabled />
                                            </spring:bind>
                                            <label class="form-label" for="active">Tình trạng</label>
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
