package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.PasswordValidationException;
import com.capgemini.exception.UserAlreadyExitsException;
import com.capgemini.model.User;

public interface UserService {

	public User Register(User user) throws UserAlreadyExitsException, PasswordValidationException;
	public String Login(User user);
	public List<User> getAllUser();
}