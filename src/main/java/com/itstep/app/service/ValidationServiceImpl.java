package com.itstep.app.service;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public Boolean isValidLogin(String login) {
        return !login.isEmpty();
    }

    @Override
    public Boolean isValidPassword(String password) {
        return !password.isEmpty();
    }
}
