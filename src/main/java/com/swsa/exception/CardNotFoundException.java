package com.swsa.exception;

    public  class CardNotFoundException extends RuntimeException {
        public CardNotFoundException(int CardId) {
            super("Card Not Found " + CardId);
        }
    }