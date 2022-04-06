package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RequestResponseLoggers implements Filter
{
	private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggers.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		logger.info("Request URI :  {} " , httpServletRequest.getRequestURI());
		logger.info("Request Method :  {} " , httpServletRequest.getMethod());
		logger.info("Request Body :  {} " , httpServletRequest.getInputStream().toString());
		chain.doFilter(request, response);
		
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
	}

}
