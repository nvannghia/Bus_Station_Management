<%-- 
    Document   : locationlist
    Created on : Aug 27, 2023, 2:48:05 PM
    Author     : nghia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <a href="<c:url value="/location/add" />" class="btn btn-success mt-2 mb-2">Thêm địa chỉ</a>
<c:if test="${locationes.isEmpty()}">
    <h1 class="text-danger"> Chưa có địa chỉ nào ! </h1>
</c:if>
<c:if test="${!locationes.isEmpty()}" >
    <h1 class="text-center text-success">Tất cả các địa chỉ</h1>
<table class="table table-success table-striped ">
    <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Tên Đường</th>
            <th scope="col">Tên Quận</th>
            <th scope="col">Tên Thành Phố</th>
            <th scope="col">Sửa/Xóa</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="locate" items="${locationes}">
            <tr>
                <th scope="row"></th>
                <td>${locate.streetName}</td>
                <td>${locate.districtName}</td>
                <td>${locate.cityName}</td>
                <td >
                    <a  
                        onclick=" return confirm('Việc chỉnh sửa có thể sẽ ảnh hưởng đến các tuyến xe, bạn chắc chứ?')"
                        class="btn btn-warning" 
                        href="<c:url value="/location/update/${locate.id}"/>"
                        title="Sửa"
                    >
                       <i class="fa-solid fa-pencil"></i>
                    </a>
                    <a 
                        onclick=" return confirm('Việc xóa có thể sẽ ảnh hưởng đến các tuyến xe, bạn chắc chứ?')"
                        class="btn btn-danger" 
                        href="<c:url value="/location/delete/${locate.id}"/>"
                        title="Xóa"
                    >
                         <i class="fa-regular fa-trash-can"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>



