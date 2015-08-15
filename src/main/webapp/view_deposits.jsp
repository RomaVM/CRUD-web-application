<%--
  Created by IntelliJ IDEA.
  User: Mine
  Date: 19.04.2015
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.mysql.jdbc.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>

<head>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <title>myBanke</title>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <script type="text/javascript" src="jsss/poisk.js">
  </script>
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
        <li class="current"><a href="view_deposits.jsp">База депозитів</a></li>
        <li><a href="new_deposit.jsp">Оформити депозит</a></li>
        <li><a href="calc_depos.jsp">calcDepos</a></li>
      </ul>
    </div><!--close menubar-->
  </div><!--close header-->
</div><!--close header_container-->
<div id="main">
  <div id="site_content">

    <div id="content">
      <div class="content_item">

        <h1>Оформлені депозити:</h1>
        <div id="poisk">
          <input type="text" id="poisk_text"
                 onMouseOver="this.style.borderColor='#CCC';"
                 onMouseOut="this.style.borderColor='#000';"
                 placeholder="Що хочете знайти?"/>
          <div id="poisk_knopka" onClick="Poisk();">&nbsp;</div>
        </div>
      </div>
      <div class="table_item">

        <table id="clients">
          <tr>
            <td>Код назви депозиту</td>
            <td>Код зареєстрованого клієнта</td>
            <td>Код відділення банку</td>
            <td>Відсоткова ставка у %</td>
            <td>Валюта</td>
            <td>Сума</td>
            <td>Періоод в місяцях</td>
          </tr>


          <%
            try{

              String userName = "root";
              String password = "root";
              String url = "jdbc:mysql://localhost/banking";

              java.sql.Driver d=new com.mysql.jdbc.Driver();
              Connection dbh = DriverManager.getConnection(url, userName, password);

              Statement query = (Statement) dbh.createStatement();
              ResultSet qresult = query.executeQuery("SELECT * FROM signeddeposits");

              while (qresult.next()){%>

          <tr>
            <td> <%=qresult.getBigDecimal("idsignedDeposits")%> </td>
            <td><%=qresult.getInt("idClient")%> </td>
            <td><%=qresult.getInt("idBank")%> </td>
            <td> <%=qresult.getInt("perCent")%> </td>
            <td><%=qresult.getString("cy")%> </td>
            <td><%=qresult.getInt("Amount")%> </td>
            <td> <%=qresult.getString("periodMonths")+ "+" + qresult.getString("dateStart")%> </td>
          </tr>

          <%}%>
        </table>
        <%

        } catch (SQLException ex) {%>
        <p> <%=ex.getErrorCode()%></p>
        <%return;
        }

        %>
      </div><!--close table item-->
    </div><!--close content_item-->
  </div><!--close content-->
</div><!--close site_content-->
</div><!--close main-->

</body>
</html>