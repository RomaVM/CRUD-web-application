package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Mine on 20.04.2015.
 */
@WebServlet(name = "CalcDeposit", urlPatterns = "/calc_deposit")
public class CalcDeposit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Double p = Double.valueOf((request.getParameter("p")));
        Double i = Double.valueOf(request.getParameter("i"));
        Double period = Double.valueOf(request.getParameter("period"));
        Double t = period * 30;

        Double calc = p + (p*i*t)/(365*100);
        Double pcalc = p + (p*i*t)/(365*100) * 0.8;

        calc = new BigDecimal(calc).setScale(2, RoundingMode.UP).doubleValue();
        pcalc = new BigDecimal(pcalc).setScale(2, RoundingMode.UP).doubleValue();

        request.setAttribute("calc", calc);
        request.setAttribute("pcalc", pcalc);
        request.getRequestDispatcher("/calc_depos.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
