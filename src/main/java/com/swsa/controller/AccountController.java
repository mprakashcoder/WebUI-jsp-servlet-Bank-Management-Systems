package com.swsa.controller;
import com.swsa.model.Account;
import com.swsa.service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import static java.lang.System.out;

@WebServlet({"/account", "/accountRetrieveServlet"})
public  class AccountController extends HttpServlet {
    private AccountService accountService = new AccountService();
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // list of Addresses for demonstration purposes
        List<Account> accounts;
        try {
            System.out.println("Inside / account");
            accounts = accountService.retrieveAccount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Set the list of Addresses as a request attribute
        request.setAttribute("accountList", accounts);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/displayaccounts.jsp").forward(request, response);

    }
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
            boolean isInserted = accountService.insertAccount(account);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");

            if (isInserted) {
                out.println("<h1> Account object inserted to db</h1>");
            } else {
                out.println("<h1> Account  object in NOT inserted to db</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("confirmation.jsp").forward(request, response);

    }

}







