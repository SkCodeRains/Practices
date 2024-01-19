package com.coderains.rainsbank.filter;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthoritiesLoggingAfterFilter extends OncePerRequestFilter {

	private final Logger LOG = Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null != authentication) {
			LOG.info("User " + authentication.getName() + " is successfully authenticated and " + "has the authorities "
					+ authentication.getAuthorities().toString());
		}
		filterChain.doFilter(request, response);
	}

}
