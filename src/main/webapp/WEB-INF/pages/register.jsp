<%-- 
    Document   : register
    Created on : Aug 15, 2023, 9:10:25 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                                <form:form modelAttribute="buscompany" class="mx-1 mx-md-4" method="post">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input path="username" type="text"  id="username" name="username" class="form-control" />
                                            <label class="form-label" for="form3Example1c">Tên đăng nhập</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <form:input type="password" path="password" id="password" name="password" class="form-control" />
                                            <label class="form-label" for="password">Mật khẩu</label>
                                        </div>
                                    </div>
                                            
          

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input path="" type="password" id="repeatPwd" name="repeatPwd" class="form-control" />
                                            <label class="form-label" for="repeatPwd">Xác nhận mật khẩu</label>
                                        </div>
                                    </div>
                                             <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fa-solid fa-person-through-window me-3 fa-fw fa-lg"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" path="password" id="password" name="password" class="form-control" value="Nhà Xe" disabled/>
                                            <label class="form-label" for="password">Phân quyền</label>
                                        </div>
                                    </div>

                                    <div class="form-check d-flex justify-content-center mb-5">
                                        <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                                        <label class="form-check-label" for="form2Example3">
                                            I agree all statements in <a href="#!">NVN-HT Terms of service</a>
                                        </label>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="button" class="btn btn-primary btn-lg">Register</button>
                                    </div>

                                </form:form>


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
