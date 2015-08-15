<%@ page import="servlets.Info" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.mysql.jdbc.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>

<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <title>myBank</title>
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
          <li class="current"><a href="view.jsp">База клієнтів</a></li>
          <li><a href="new_client.jsp">Реєстрація клієнта</a></li>
          <li><a href="view_deposits.jsp">База депозитів</a></li>
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

            <h1>Клієнтська база:</h1>
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
                <td>Код клієнта</td>
                <td>І`мя</td>
                <td>Прізвище</td>
                <td>По-батькові</td>
                <td>Телефон</td>
                <td>Дата народження</td>
                <td>Місто проживання</td>
                </tr>


          <%
            try{

              String userName = "root";
              String password = "root";
              String url = "jdbc:mysql://localhost/banking";

              java.sql.Driver d=new com.mysql.jdbc.Driver();
              Connection dbh = DriverManager.getConnection(url, userName, password);

              Statement query = (Statement) dbh.createStatement();
              ResultSet qresult = query.executeQuery("SELECT * FROM clients");

              while (qresult.next()){%>

                        <tr>
                        <td> <%=qresult.getBigDecimal("idClients")%> </td>
                                <td> <%=qresult.getString("firstName")%> </td>
                                <td> <%=qresult.getString("secName")%> </td>
                                <td> <%=qresult.getString("thrdName")%> </td>
                                <td> <%=qresult.getString("tel")%> </td>
                                <td> <%=qresult.getString("brthDay")%> </td>
                                <td> <%=qresult.getString("cityLive")%> </td>
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
