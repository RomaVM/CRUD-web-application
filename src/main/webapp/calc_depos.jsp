<%--
  Created by IntelliJ IDEA.
  User: Mine
  Date: 19.04.2015
  Time: 14:53
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
        <li><a href="new_deposit.jsp">Оформити депозит</a></li>
        <li class="current"><a href="calc_depos.jsp">calcDepos</a></li>
      </ul>
    </div><!--close menubar-->
  </div><!--close header-->
</div><!--close header_container-->
<div id="main">
  <div id="site_content">

    <div id="content">
      <div class="content_item">
        <h1>Депозитний калькулятор:</h1>
        <form action="calc_deposit" method="post">

          <input type="text" name="p" placeholder="Початкова сума:"/><br/>
          <input type="text" name="i" placeholder="Відсоткова ставка:"/><br/>
          <select name="period">
            <option value="" disabled selected>На період:</option>
            <option value="1">1 міс.</option>
            <option value="3">3 міс.</option>
            <option value="6">6 міс.</option>
            <option value="12">12 міс.</option>
            <option value="24">24 міс.</option>
          </select><br/>
          <input type="submit" value="Результат"/>
        </form>



      </div><!--close content_item-->
      <br/>
      <h7>Вкінці періоду, ви отримаєте ${calc} гр. од.</h7><br/>
      <br/>
      <h7>З урахуванням 20% податку ${pcalc} гр. од.</h7>
    </div><!--close content-->
  </div><!--close site_content-->
</div><!--close main-->

</body>
</html>