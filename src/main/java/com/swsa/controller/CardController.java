package com.swsa.controller;
import com.swsa.model.Card;
import com.swsa.service.CardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/card", "/cardRetrieveServlet"})
public class CardController extends HttpServlet {
    private CardService cardService = new CardService();

    @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // list of Addresses for demonstration purposes
        List<Card> cards;
        try {
            System.out.println("Inside / card");
            cards = cardService.retrieveCards();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Set the list of Addresses as a request attribute
        request.setAttribute("cardList", cards);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/displaycard.jsp").forward(request, response);

    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--------------- inside the doGet() method ---------------");
        String cardId= request.getParameter("cardId");
        String cardNo = request.getParameter("cardNo");
        String accountNo = request.getParameter("accountNo");
        String accountHolderName = request.getParameter("accountHolderName");
        String cvv= request.getParameter("cvv");
        String cardType=request.getParameter("cardType");


        Card card = new Card();
        card.setCardId(Integer.parseInt(cardId));
        card.setCardNo(Long.parseLong(cardNo));
        card.setAccountNo(Long.parseLong(accountNo));
        card.setAccountHolderName(accountHolderName);
        card.setCvv(Integer.parseInt(cvv));
        card.setCardType(cardType);


        try {
            boolean isInserted = cardService.insertCard(card);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");

            if (isInserted) {
                out.println("<h1> Card object inserted to db</h1>");
            } else {
                out.println("<h1> Card object in NOT inserted to db</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    request.getRequestDispatcher("confirmation.jsp").forward(request, response);

    }

}


