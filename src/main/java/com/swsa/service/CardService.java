package com.swsa.service;
import java.sql.SQLException;
import java.util.List;
import com.swsa.model.Card;
import com.swsa.repository.CardRepository;

public class CardService {

    private static final CardRepository CARD_REPOSITORY = new CardRepository();

    public boolean insertCard(Card card)throws SQLException {
        if (CARD_REPOSITORY.insertCard(card)) {
            System.out.println("Card inserted successfully!");
        } else {
            System.out.println("Failed to insert Card.");
            return false;
        }
        return true;

    }
        public List<Card> retrieveCards () throws SQLException {
            return CARD_REPOSITORY.retrieveCards();
        }

    }
