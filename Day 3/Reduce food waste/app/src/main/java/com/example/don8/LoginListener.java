package com.example.don8;

public interface LoginListener {
    /**
     * If successful, this supplies the user's name, last 4 numbers of a single credit card,
     * and a list of recent transactions for that card.
     */
    void onLoginSuccess(String email, String password);

    /**
     * If the login call fails, return the error information.
     */
    void onLoginError(Exception exception);
}