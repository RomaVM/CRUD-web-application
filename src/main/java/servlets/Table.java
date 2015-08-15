package servlets;
import com.mysql.jdbc.Statement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "Table", urlPatterns = "/view")

public class Table extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=windows-1251");
        PrintWriter out = response.getWriter();

        String pagecontent = "";

        try{
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/bankdb";

            java.sql.Driver d=new com.mysql.jdbc.Driver();
            Connection dbh = DriverManager.getConnection(url, userName, password);

            Statement query = (Statement) dbh.createStatement();
            ResultSet qresult = query.executeQuery("SELECT * FROM clients");

            while (qresult.next()) {
                pagecontent +=
                        "<tr><td>" + qresult.getBigDecimal("idClients") + "</td>" +
                        "<td>" + qresult.getString("firstName") + "</td>" +
                        "<td>" + qresult.getString("secName") + "</td>" +
                        "<td>" + qresult.getString("thrdName") + "</td>" +
                        "<td>" + qresult.getString("tel") + "</td>" +
                        "<td>" + qresult.getString("brthDay") + "</td>" +
                        "<td>" + qresult.getString("cityLive") + "</td></tr>\n";
            }
        } catch (SQLException ex) {
                out.println("Помилка підключення до бази даних");
                return;
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Виведення даних з таблиці</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<!-Виводимо заголовок списку товарів->");
        out.println("<h1>Довідник клієнтів банку</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Код клієнта</th>");
        out.println("<th>І`мя</th>");
        out.println("<th>Прізвище</th>");
        out.println("<th>По-батькові</th>");
        out.println("<th>Телефон</th>");
        out.println("<th>Дата народження</th>");
        out.println("<th>Місто проживання</th>");
        out.println("</tr>");
        out.println(pagecontent);
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");



    }
}
