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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mine on 19.04.2015.
 */
@WebServlet(name = "DepositForm", urlPatterns = "/deposit_form")
public class DepositForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idsignedDeposits = request.getParameter("idsignedDeposits");
        String idClient = request.getParameter("idClient");
        String idBank = request.getParameter("idBank");
        String percent = request.getParameter("percent");
        String cy = request.getParameter("cy");
        String Amount = request.getParameter("Amount");
        String period = request.getParameter("period");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateNow = formatter.format(date.getTime());


        try{
//Підключення до БД

            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/banking";

            java.sql.Driver d=new com.mysql.jdbc.Driver();
            Connection dbh = DriverManager.getConnection(url, userName, password);
//Обєкт з нашим запитом

            String insertTemplate =
                    "INSERT INTO signeddeposits (idsignedDeposits,idClient,idBank,perCent,cy,Amount,periodMonths,dateStart) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement insert=dbh.prepareStatement(insertTemplate);
//Значення з форми, заносяться до БД
            insert.setString(1,idsignedDeposits);
            insert.setString(2,idClient);
            insert.setString(3,idBank);
            insert.setString(4,percent);
            insert.setString(5,cy);
            insert.setString(6,Amount);
            insert.setString(7,period);
            insert.setString(8,dateNow);

//Виконання апдейт запиту
            insert.executeUpdate();

            String nextJSP3 = "/congratulation.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP3);
            dispatcher.forward(request,response);

//Якщо виникла помилка, видаємо ИСКЛЮЧЕНИЕ
        }catch (SQLException ex) {

            String nextJSP4 = "/index.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP4);
            dispatcher.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
