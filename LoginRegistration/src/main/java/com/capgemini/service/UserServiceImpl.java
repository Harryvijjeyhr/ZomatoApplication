package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.exception.PasswordValidationException;
import com.capgemini.exception.UserAlreadyExitsException;

import com.capgemini.model.User;
import com.capgemini.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public UserServiceImpl() {
		super();
	}
	
	public User Register(User user) throws UserAlreadyExitsException, PasswordValidationException {
		if(userRepo.existsById(user.getId())) {
			throw new UserAlreadyExitsException();
		}
		if(user.getPassword().length() < 8) {
			throw new PasswordValidationException();
		}
		System.out.println(this.bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		User res = userRepo.save(user);
		return res;
	}
	
	public String Login(User user) {
		String msg;
		if(userRepo.findByEmail(user.getEmail()) != null ) {
			User ema = userRepo.findByEmail(user.getEmail());
			String s1 = ema.getPassword();
			String s2 = user.getPassword();
			if(bCryptPasswordEncoder.matches(s2, s1)) {
				msg = "Login Successfully";
			}
			else {
				msg = "Wrong password! Please enter correct password.";
			}
		}else {
			msg = "User not found.";
		}
		return msg;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>)userRepo.findAll();
	}
}
