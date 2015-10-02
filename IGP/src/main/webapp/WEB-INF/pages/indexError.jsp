<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <title>IGP</title>
</head>
<body>
<h1>Прайс-лист</h1>

<div>
  <form method="get" action="search.form" >
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
    <div><span style="color: Red; "><b>Вы не ввели ни одного параметра поиска! Введите хотя бы один параметр и нажмите кнопку Найти</b></span></div>
  </form>
</div>

</body>
</html>
