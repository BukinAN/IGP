<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <title>IGP</title>
</head>
<body>
<h1>PriseList</h1>
<div>
  <c:if test = "${!empty products}">
    <table>
      <tr>
        <th>Category</th>
        <th>Name</th>
        <th>Price</th>
      </tr>
      <c:forEach items = "${products}" var = "product">
        <tr>
          <td>${product.category.name}</td>
          <td>${product.name}</td>
          <td>${product.price}<td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</div>
</body>
</html>
