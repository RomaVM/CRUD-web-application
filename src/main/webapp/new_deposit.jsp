<%--
  Created by IntelliJ IDEA.
  User: Mine
  Date: 19.04.2015
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <title>myBank</title>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<div id="header_container">
  <div id="header">
    <div id="banner">
      <h1><span>my</span>Banking24</h1>
    </div><!--close banner-->
    <div id="banner_slogan">
      <h2>Гроші вкладаєте - капітал назбираєте</h2>
    </div><!--close banner_slogan-->
    <div id="menubar">
      <ul id="menu">
        <li><a href="index.html">Головна</a></li>
        <li><a href="view.jsp">База клієнтів</a></li>
        <li><a href="new_client.jsp">Реєстрація клієнта</a></li>
        <li><a href="view_deposits.jsp">База депозитів</a></li>
        <li class="current"><a href="new_deposit.jsp">Оформити депозит</a></li>
        <li><a href="calc_depos.jsp">calcDepos</a></li>
      </ul>
    </div><!--close menubar-->
  </div><!--close header-->
</div><!--close header_container-->
<div id="main">
  <div id="site_content">

    <div id="content">
      <div class="content_item">
        <h1>Заповніть дані:</h1>
        <form action="deposit_form" method="post">

          <select name="idsignedDeposits">
            <option value="" disabled selected>Тип депозиту</option>
            <option value="1">Стандартний uah</option>
            <option value="2">Стандартний usd</option>
            <option value="3">Стандартний eur</option>
            <option value="4">Депозит+ uah</option>
            <option value="5">Депозит+ usd</option>
            <option value="6">Депозит+ eur</option>
            <option value="7">MB вклад uah</option>
            <option value="8">MB вклад usd</option>
            <option value="9">MB вклад eur</option>
          </select><br/>
          <input type="text" name="idClient" placeholder="Код клієнта"/><br/>
          <input type="text" name="idBank" placeholder="Код відділення банку"/><br/>
          <select name="percent">
            <option value="" disabled selected>Відсоткова ставка</option>
            <option value="21">21% uah</option>
            <option value="23">23% uah</option>
            <option value="24">24% uah</option>
            <option value="9,5">9.5% usd</option>
            <option value="10,5">10.5% usd</option>
            <option value="11,5">11.5% usd</option>
            <option value="12,5">12.5% usd</option>
            <option value="9,5">9.5% eur</option>
            <option value="10,5">10.5% eur</option>
            <option value="11,5">11.5% eur</option>
            <option value="12,5">12.5% eur</option>

          </select><br/>
          <select name="cy">
            <option value="" disabled selected>Оберіть валюту</option>
            <option value="uah">Гривня</option>
            <option value="usd">Доллар</option>
            <option value="eur">Євро</option>
          </select><br/>
          <input type="text" name="Amount" placeholder="Сума вкладу"/><br/>
          <select name="period" >
            <option value="" disabled selected>Період в місяцях</option>
            <option value="3">3 міс.</option>
            <option value="6">6 міс.</option>
            <option value="12">12 міс.</option>
            <option value="24">24 міс.</option>
            <option value="36">36 міс.</option>
          </select><br/>
          <input type="submit" value="Відправити"/>
        </form>

      </div><!--close content_item-->
    </div><!--close content-->
  </div><!--close site_content-->
</div><!--close main-->

</body>
</html>