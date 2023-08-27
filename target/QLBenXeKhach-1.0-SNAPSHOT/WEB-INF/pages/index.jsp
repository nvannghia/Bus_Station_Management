<%-- 
    Document   : index
    Created on : Aug 8, 2023, 7:40:45 PM
    Author     : 84967
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tên nhà xe</th>
                <th>Số điện thoại</th>                    
                <th>Giao nhận hàng</th>                    
                <th>Đang hoạt động</th>
                <th>Tài khoản</th>
                <th>Xử lí</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${companies}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>Nhà xe ${c.name}</td>
                    <td>${c.phoneNumber}</td>                   
                    <td>
                        <c:choose>
                            <c:when test="${c.delivery != 0}">
                                Có 
                            </c:when>
                            <c:otherwise>
                                Không
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${c.active != 0}">
                                <p class="text-success"> Đang hoạt động </p>
                            </c:when>
                            <c:otherwise>
                                <p class="text-danger"> Ngừng hoạt động </p>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${c.idUser}</td>
                    <td>
                        <c:url value="/update/${c.id}" var="action"/>
                        <c:choose>
                            <c:when test="${c.active != 0}">
                                <a href="${action}" class="btn btn-danger min-width"}">Khóa</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${action}" class="btn btn-success min-width">Mở Khóa</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
