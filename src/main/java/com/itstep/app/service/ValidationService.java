package com.itstep.app.service;

public interface ValidationService {
    Boolean isValidLogin(String login);
    Boolean isValidPassword(String password);
}
