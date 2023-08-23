<%-- 
    Document   : locationregister
    Created on : Aug 23, 2023, 7:17:49 PM
    Author     : nghia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="action" value="/location/add" />
<form:form modelAttribute="location" method="post" action="${action}">
    City name:<form:input type="text" path="cityName" name="cityName" />    <br/>
    District name:<form:input type="text" path="districtName" name="districtName" /><br/>
    Street name:<form:input type="text" path="streetName" name="streetName" /><br/>
    Who are you?
    <form:select class="form-select" name="buscompanies" path="buscompaniesId">
        <c:forEach items="${buscompanies}" var="b">
            <option value="${b.id}" >${b.name}</option>
        </c:forEach>
    </form:select>
    <button type="submit">Submit</button>
</form:form>

