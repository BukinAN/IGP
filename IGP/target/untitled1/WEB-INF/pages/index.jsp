<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
  <title>IGP</title>
</head>
<body>
<h1>Прайс-лист</h1>

<div>
  <form method="post" action="search.form" >
    <table>
      <tr>
        <td>Категория:</td>
        <td>Наименование:</td>
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
  <table border="1" cellspacing="0" cellpadding="5px" width="520px">
    <tr>
      <th width="165px" align="left" height="30px" bgcolor="#E1E3E3">Категория</th>
      <th width="165px" align="left" height="30px" bgcolor="#E1E3E3">Наименование</th>
      <th align="left" height="30px" bgcolor="#E1E3E3">Цена</th>
    </tr>
  </table>
  <c:if test = "${!empty products}">
   <table border="1" cellspacing="0" cellpadding="5px" width="520px">
      <c:forEach items = "${products}" var = "product">
        <tr>
          <td width="165px">${product.category.name}</td>
          <td width="165px">${product.name}</td>
          <td>${product.price}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</div>
</body>
</html>
