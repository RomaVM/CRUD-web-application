//Its only for test, it isnt a part of application
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name = "CreatePerson", urlPatterns = "/creation")

public class CreatePerson extends HttpServlet {

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=windows-1251");
        request.setCharacterEncoding("CP1251");
        PrintWriter out = response.getWriter();
//Отримуємо список імен параметрів нашої форми
        java.util.Enumeration params = request.getParameterNames();
//Якщо поля не заповнені, видати повідомлення про неправельне заповнення
        if(!params.hasMoreElements()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Новий клієнт</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Будь-ласка, заповніть наступні поля:</h1>");
//Створюємо форму
//Оброблювати введені дані буде наш же сервлет: /servlet/Input
            out.println("<form method=\'post\'action=\'/creation\'>");
            out.println("<table>");
//Створюємо поля для вводу даних

            out.println("<tr><td>Ім`я:</td>");
            out.println("<td><input type='text' name='firstName'");
            out.println(" value=''></td></tr>");

            out.println("<tr><td>Прізвище:</td>");
            out.println("<td><input type='text' name='secName'");
            out.println(" value=''></td></tr>");

            out.println("<tr><td>По-батькові:</td>");
            out.println("<td><input type='text' name='thrdName'");
            out.println(" value=''></td></tr>");

            out.println("<tr><td>Телефон:</td>");
            out.println("<td><input type='text' name='tel'");
            out.println(" value=''></td></tr>");

            out.println("<tr><td>Дата народження:</td>");
            out.println("<td><input type='text' name='brthDay'");
            out.println(" value=''></td></tr>");

            out.println("<tr><td>Місто проживання:</td>");
            out.println("<td><input type='text' name='cityLive'");
            out.println(" value=''></td></tr>");

            out.println("</table>");
            out.println("<br>");

//Кнопка відправити
            out.println("<input type='submit' value='Відправити'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
//Якщо не пусто, то піключитися до БД
        else {
            try{
//Підключення до БД

                String userName = "root";
                String password = "root";
                String url = "jdbc:mysql://localhost/bankdb";

                java.sql.Driver d=new com.mysql.jdbc.Driver();
                Connection dbh = DriverManager.getConnection(url, userName, password);
//Обєкт з нашим запитом

                String insertTemplate =
                        "INSERT INTO clients (firstName,secName,thrdName,tel,brthDay,cityLive) VALUES (?,?,?,?,?,?)";
                PreparedStatement insert=dbh.prepareStatement(insertTemplate);
//Значення з форми, заносяться до БД
                insert.setString(1,request.getParameter("firstName"));
                insert.setString(2,request.getParameter("secName"));
                insert.setString(3,request.getParameter("thrdName"));
                insert.setString(4,request.getParameter("tel"));
                insert.setString(5,request.getParameter("brthDay"));
                insert.setString(6,request.getParameter("cityLive"));

//Виконання апдейт запиту
                insert.executeUpdate();
//Якщо виникла помилка, видаємо ИСКЛЮЧЕНИЕ
            }catch (SQLException ex) {
                out.println("Помилка підключення до бази даних.");
                out.println("Приносимо вибачення.");
                out.print(ex.getErrorCode());
                return;
            }
//Якщо все успішно, виведуться така інфа
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Робота с MySQL</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Вітаємо! Дані було додано до БД.</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
