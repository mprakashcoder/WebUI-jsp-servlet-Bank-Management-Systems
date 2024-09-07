package com.swsa.controller;
import com.swsa.model.Account;
import com.swsa.service.AccountDepositOperationService;
import com.swsa.service.AccountWithdrawOperationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import static java.lang.System.out;

    @WebServlet("/withdraw")
    public class AccountWithdrawOperationController  extends HttpServlet
    {
        private AccountWithdrawOperationService accountWithdrawOperationService = new AccountWithdrawOperationService();
        @Override
        //===================Account insert========================================
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            out.println("--------------- inside the doGet() method ---------------");
            String accountNumber = request.getParameter("accountNumber");
            String accountHolderName = request.getParameter("accountHolderName");
            String balance = request.getParameter("balance");
            String customerId = request.getParameter("customerId");

            Account account = new Account();
            account.setAccountNumber(accountNumber);
            account.setAccountHolderName(accountHolderName);
            account.setBalance(Double.parseDouble(balance));
            account.getCustomerId(customerId);

            try {
                boolean isInserted = accountWithdrawOperationService.withdraw(account);
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");

                if (isInserted) {
                    out.println("<h1> Withdraw  object inserted to db</h1>");
                } else {
                    out.println("<h1> Withdraw  object in NOT inserted to db</h1>");
                }
                out.println("</body></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            request.getRequestDispatcher("confirmation.jsp").forward(request, response);

        }

    }


