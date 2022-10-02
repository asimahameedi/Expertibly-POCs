package com.asima.secureApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asima.secureApp.models.AuthenticationRequest;
import com.asima.secureApp.models.AuthenticationResponse;
import com.asima.secureApp.services.MyUserDetailsService;
import com.asima.secureApp.util.jwtUtil;

@RestController
public class HelloResource {
	
	@Autowired
	private AuthenticationManager authenticationMananger;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private jwtUtil jwtTokenUtil;
	
	@RequestMapping({"/hello"})
	@ResponseBody
	public String hello() {
		System.out.println("inside helloResource hello");
		return "Hello World";
	}
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		System.out.println("inside createAuthenticateToken ");
		try {
			// this returns a **** standard token 
//			System.out.println("inside helloResource createAuthenticate");
			authenticationMananger.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password");

		}
		System.out.println("inside helloResource createAuthenticate2222");
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		System.out.println("inside hello resource  " + jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

}
