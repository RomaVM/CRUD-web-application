package servlets;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "Connect", urlPatterns = "/connection")
//наследование, инкапсуляцция, полиморфизм
public class Connect extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=windows-1251");
        PrintWriter out = response.getWriter();

        try{
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/banking";

            java.sql.Driver d=new com.mysql.jdbc.Driver();
            Connection dbh = DriverManager.getConnection(url, userName, password);
        } catch (SQLException ex){
            out.println("Помилка підключення бази даних, перевітьте написаний код в сервлеті");
            return;
        }
        out.println("База даних була успішно підключена.");

    }
}