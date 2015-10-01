<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <title>IGP</title>
  <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<h1>Прайс-лист</h1>

<div>
  <form method="get" action="search.form" >
    <table>
      <tr>
        <td>Категория:</td>
        <td>Название:</td>
        <td>Цена от:</td>
        <td>Цена до:</td>
      </tr>
      <tr>
        <td><label>
          <input type="text" name="category"/>
        </label></td>
        <td><label>
          <input type="text" name="name"/>
        </label></td>
        <td><label>
          <input type="text" name="priceFrom"/>
        </label></td>
        <td><label>
          <input type="text" name="priceTo"/>
        </label></td>
        <td colspan="2"><input type="submit" value="Найти"/></td>
      </tr>
    </table>
  </form>
</div>


<div class="tableSearch">
  <c:if test = "${!empty products}">
    <table border="1" cellspacing="0" cellpadding="0" width="520px">
      <tr>
        <th width="173px" align="left" height="30px" bgcolor="#E1E3E3">Категория</th>
        <th width="173px" align="left" height="30px" bgcolor="#E1E3E3">Наименование</th>
        <th width="173px" align="left" height="30px" bgcolor="#E1E3E3">Цена</th>
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
