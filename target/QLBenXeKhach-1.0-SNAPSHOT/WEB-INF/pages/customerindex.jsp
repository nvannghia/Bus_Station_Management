<%-- 
    Document   : customerindex
    Created on : Sep 4, 2023, 12:24:49 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-2 mb-2">
    <div class="row">
        <c:forEach items="${buscompanies}" var="bus">
            <div class="col-md-3">
            <div class="w3-container">
                <div class="w3-card-4" >
                    <img width="150px" height="200px"  src="https://upload.wikimedia.org/wikipedia/commons/d/d2/Transport_NSW_liveried_%28mo_5436%29%2C_operated_by_Punchbowl_Bus_Co%2C_Custom_Coaches_%27CB80%27_bodied_Volvo_B7RLE_at_Central_station.jpg" alt="Alps" style="width:100%">
                    <div class="w3-container w3-center mt-2">
                        <p class="h5">Nhà xe ${bus.name}</p>
                        <p>Đánh giá:</p>
                        <a href="<c:url value="/customer/bus/detail/${bus.id}" />" class="btn btn-primary">Xem chi tiết</a>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>

