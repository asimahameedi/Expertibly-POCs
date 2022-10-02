package com.asima.secureApp.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.asima.secureApp.models.AuthenticationRequest;
import com.asima.secureApp.services.MyUserDetailsService;
import com.asima.secureApp.util.jwtUtil;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {
//	@Component
//	public class JwtRequestFilter  {

	@Autowired
	MyUserDetailsService userdDetailsService;
	
	@Autowired
	jwtUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub

		String jwt=null;
		String username = null;
		// this header should contain 'Bearer
//		String header = request.getHeader("Content-Type");
		String header = request.getHeader("Authorization");
		System.out.println("header " + header);
//		if (header != null){
//			System.out.println("header is not null ");
//		}
//		
//		if (header.startsWith("Bearer ")){
//			System.out.println("header starts with bearer ");
//		}
		if ((header != null) && (header.startsWith("Bearer "))) {

			jwt = header.substring(7);
			username = jwtTokenUtil.extractUsername(jwt);
			//if SecurityContextHolder has not been set so far
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userdDetailsService.loadUserByUsername(username);

				if (jwtTokenUtil.validateToken(jwt, userDetails)) {
					// creating the object
					UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					//We are taking over the default functionality and setting it manually in case it has not already set
					// springboot does this by default when authentication is done via username/password
					
					userNamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
					filterChain.doFilter(request, response);

				}
			}
			filterChain.doFilter(request, response);
		}
}
}
		 
		
		
	


