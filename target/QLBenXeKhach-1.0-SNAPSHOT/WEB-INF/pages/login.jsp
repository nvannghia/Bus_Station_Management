<%-- 
   Document   : login
   Created on : Aug 20, 2023, 12:47:03 PM
   Author     : nghia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${param.error != null}">
    <div class="alert alert-danger" role="alert">
        Tên đăng nhập hoặc mật khẩu không chính xác!
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger" role="alert">
        Bạn không có quyền truy cập!
    </div>
</c:if>
<section id="register" class="vh-100" style="background-color: #F1F1F1;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Đăng nhập</p>
                                <c:url value="/login" var="action" />
                                <form class="mx-1 mx-md-4" method="post" action="${action}">
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text"  id="username" name="username" class="form-control" required />
                                            <label class="form-label" for="username">Tên đăng nhập</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="password" id="password" name="password" class="form-control" required />
                                            <label class="form-label" for="password">Mật khẩu</label>
                                        </div>
                                    </div>
                                    <div class="form-check d-flex justify-content-left mb-5 ms-4">
                                        <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                                        <label class="form-check-label" for="form2Example3">
                                            Remember me
                                        </label>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Đăng Nhập</button>
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