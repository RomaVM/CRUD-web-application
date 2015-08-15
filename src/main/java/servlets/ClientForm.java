package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Mine on 13.04.2015.
 */
@WebServlet(name = "ClientForm", urlPatterns = "/forms")
public class ClientForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name1 = request.getParameter("name1");
        String name2 = request.getParameter("name2");
        String name3 = request.getParameter("name3");
        String tel = request.getParameter("tel");
        String date = request.getParameter("date");
        String city = request.getParameter("city");


        try{
//Підключення до БД

            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/banking";

            java.sql.Driver d=new com.mysql.jdbc.Driver();
            Connection dbh = DriverManager.getConnection(url, userName, password);
//Обєкт з нашим запитом

            String insertTemplate =
                    "INSERT INTO clients (firstName,secName,thrdName,tel,brthDay,cityLive) VALUES (?,?,?,?,?,?)";
            PreparedStatement insert=dbh.prepareStatement(insertTemplate);
//Значення з форми, заносяться до БД
            insert.setString(1,name1);
            insert.setString(2,name2);
            insert.setString(3,name3);
            insert.setString(4,tel);
            insert.setString(5,date);
            insert.setString(6,city);

//Виконання апдейт запиту
            insert.executeUpdate();

            String nextJSP = "/congratulation.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);

//Якщо виникла помилка, видаємо ИСКЛЮЧЕНИЕ
        }catch (SQLException ex) {

            String nextJSP2 = "/index.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP2);
            dispatcher.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
