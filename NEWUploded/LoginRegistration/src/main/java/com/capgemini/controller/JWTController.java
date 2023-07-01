package com.capgemini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import com.capgemini.helper.JwtUtil;
import com.capgemini.model.JWTRequest;
import com.capgemini.model.JWTResponse;
import com.capgemini.service.CustomeUserDetailService;


@RestController
@CrossOrigin
@RequestMapping("/api/r1")
public class JWTController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomeUserDetailService customUserDetailsService;
	
	@Autowired
	
	private JwtUtil jwtUtil;
	
	@RequestMapping(value="/token", method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest+" Error");
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getEmail());
		
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT--"+token);
		
		return ResponseEntity.ok(new JWTResponse(token));
		
	}
}
