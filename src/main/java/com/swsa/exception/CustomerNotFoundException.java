package com.swsa.exception;

    public  class CustomerNotFoundException  extends RuntimeException {
        public CustomerNotFoundException (int customerId) {
            super("customerId Not Found " + customerId);
        }
    }


