<%-- 
    Document   : statisticalBus
    Created on : Sep 6, 2023, 7:32:24 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<section id="register" class="vh-100" style="background-color: #F1F1F1;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Thống kê</p>
                                <c:url value="/buscompany/statistical/revenue" var="action" />
                                <form class="mx-1 mx-md-4"  action="${action}">
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fa-solid fa-calendar-days me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text"  id="fd" name="fd" class="form-control" required placeholder="yyyy/MM/dd" />
                                            <label class="form-label" for="fd">Từ ngày</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fa-regular fa-calendar-days me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="td" name="td" class="form-control" required placeholder="yyyy/MM/dd"/>
                                            <label class="form-label" for="td">Đến ngày</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Xem thống kê</button>
                                    </div>
                                </form>
                                <c:if test="${sum != null}">
                                    <p class="text-info bg-dark">Doanh thu từ ngày ${fd} đến ngày ${td}: <fmt:formatNumber value="${sum}"/> vnđ</p>
                                </c:if>
                                    <!--fd và td khac null de kh hien message trong the p khi ch submit form thong ke-->
                                <c:if test="${sum == null && td != null && fd!=null}"> 
                                    <p class="text-info bg-dark">Chưa có doanh thu từ ngày ${fd} đến ngày ${td}</p>
                                </c:if>
                                    
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="https://res.cloudinary.com/dnwemzbtm/image/upload/v1694005323/yhongke_b9jyru.jpg"
                                     class="img-fluid" alt="Sample image">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
                                    