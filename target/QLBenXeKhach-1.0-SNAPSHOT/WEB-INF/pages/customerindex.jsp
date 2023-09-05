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
            <div class="col-md-3 mt-2">
               <div class="w3-container">
                   <div class="w3-card-4 " >
                       <img 
                           width="180px" 
                           height="200px"  
                           src="${bus.image}" 
                           alt="Ảnh nhà xe" 
                           style="width:100%"
                           class="object-fit-cover  border rounded zoom"
                       >
                       <div class="w3-container w3-center mt-2">
                           <p class="h5">Nhà xe ${bus.name}</p>
                           <p>Đánh giá:</p>
                           <a href="<c:url value="/customer/bus/detail/${bus.id}" />" class="btn btn-primary mb-2">Xem chi tiết</a>
                       </div>
                   </div>
               </div>
            </div>
        </c:forEach>
    </div>
</div>

