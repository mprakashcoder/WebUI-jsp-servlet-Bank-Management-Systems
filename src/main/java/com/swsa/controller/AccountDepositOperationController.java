package com.swsa.controller;
import com.swsa.model.Account;
import com.swsa.service.AccountDepositOperationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import static java.lang.System.out;

@WebServlet("/deposit")
    public class AccountDepositOperationController extends HttpServlet
{
        private AccountDepositOperationService accountOperationService = new AccountDepositOperationService();
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
                boolean isInserted = accountOperationService.deposit(account);
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");

                if (isInserted) {
                    out.println("<h1> Deposit  object inserted to db</h1>");
                } else {
                    out.println("<h1> Deposit  object in NOT inserted to db</h1>");
                }
                out.println("</body></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            request.getRequestDispatcher("confirmation.jsp").forward(request, response);

        }

    }



//
//        try {
//
//        if (accountService.insertAccount(account)) {
//            response.getWriter().println("<p>Account created successfully.</p>");
//        } else {
//            response.getWriter().println("<p>Account creation failed. Account may already exist.</p>");
//        }
//
//        if (accountService.deposit(account))
//        {
//            response.getWriter().println("<p>deposit money successfully.</p>");
//        } else {
//            response.getWriter().println("<p>deposit money failed.</p>");
//        }
//
//        if (accountService.withdraw(account)) {
//            response.getWriter().println("<p>withdraw  money successfully.</p>");
//        } else {
//            response.getWriter().println("<p>withdraw money failed.</p>");
//        }
//
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//
//
//        out.println("</body></html>");
//}
//
//public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//            out.println("--------------- inside the service() method ---------------");
//            if (request.getMethod().equals("POST")) {
//                this.doPost(request, response);
//            } else {
//                this.doGet(request, response);
//            }
//        }
//    }









