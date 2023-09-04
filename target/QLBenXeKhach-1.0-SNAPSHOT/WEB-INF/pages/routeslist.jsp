<%-- 
    Document   : list
    Created on : Aug 28, 2023, 12:25:23 PM
    Author     : nghia
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<a href="<c:url value="/routes/add" />" class="btn btn-success mt-2 mb-2">Thêm Tuyến</a>
<c:if test="${routes.isEmpty()}">
    <h1 class="text-danger"> Chưa có tuyến xe chỉ nào ! </h1>
</c:if>
<c:if test="${!routes.isEmpty()}">
    <h1 class="text-center text-success">Tất cả các tuyến xe</h1>
    <table class="table table-success table-striped ">
        <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Giá Vé</th>
                <th scope="col">Điểm Xuất Phát</th>
                <th scope="col">Điểm Đến</th>
                <th scope="col">Sửa</th>
                <th scope="col">Tạo Chuyến Xe</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="route" items="${routes}">
                <tr>
                    <th scope="row"></th>
                    <td>
                        <fmt:formatNumber value="${route.fare}"/> vnđ
                    </td>

                    <td>
                        ${route.departureId.streetName}, 
                        ${route.departureId.districtName},
                        ${route.departureId.cityName}
                    </td>
                    <td> 
                        ${route.destinationId.streetName}, 
                        ${route.destinationId.districtName},
                        ${route.destinationId.cityName}
                    </td>
                    <td >
                        <a 
                            onclick=" return confirm('Việc chỉnh sửa có thể sẽ ảnh hưởng đến các chuyến xe, bạn chắc chứ?')"
                            class="btn btn-warning" 
                            href="<c:url value="/routes/update/${route.id}"/>"
                            >
                            <i class="fa-solid fa-pencil"></i>
                        </a>
<!--                        <a 
                            onclick=" return confirm('Việc xóa có thể sẽ ảnh hưởng đến các chuyến xe, bạn chắc chứ?')"
                            class="btn btn-danger" 
                            href="<c:url value="/routes/delete/${route.id}"/>"
                            disabled="disabled"
                        >
                            <i class="fa-regular fa-trash-can"></i>

                        </a>-->
                    </td>
                    <td>
                        <a 
                            class="btn btn-success" 
                            href="<c:url value="/trips/add/${route.id}"/>"
                            >
                            Tạo chuyến
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
