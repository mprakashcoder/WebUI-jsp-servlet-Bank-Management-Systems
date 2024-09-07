// CheckBalanceController.java
package com.swsa.controller;
import com.swsa.service.AccountService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkBalance")
public class CheckBalanceController extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");

        if (accountNumber != null && !accountNumber.isEmpty()) {
            double balance = accountService.checkBalance(accountNumber);
            request.setAttribute("balance", balance);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayBalance.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("displayBalance.jsp");
        }
    }
}
