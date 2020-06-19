//package com.java.meetingRoom.utils;
//
//package cgg.gov.studentresults.security;
//
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
////import java.util.stream.Collectors;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private final String uri = "/*";
//	@Value("${webservice.studentresult.allowedips}")
//	private String ipRanges;
//	
//	 static Logger log = Logger.getLogger(SecurityConfig.class.getName());
//	 
//	
//	 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.csrf().disable();
//        http.headers().httpStrictTransportSecurity().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.antMatcher(uri).authorizeRequests().anyRequest().permitAll();
//	}
//	
//	  public static String getRequestRemoteAddr(){
//	        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
//	                   .getRequest(); 
//	        return request.getRemoteAddr();
//	}
//
//	private String createHasIpRangeExpression() {
//
//		String validIp = "";
//		
//		if ((!ipRanges.isEmpty()) && ipRanges.contains(",")) {
//
//			ArrayList<String> allowedIpList = new ArrayList<String>(Arrays.asList(ipRanges.split("\\s*,\\s*")));
//			for (int i = 0; i < allowedIpList.size(); i++) {
//				validIp += "hasIpAddress('";
//				validIp += allowedIpList.get(i);
//				if (i < allowedIpList.size() - 1) {
//					validIp += "') or ";
//				} else {
//					validIp += "')";
//				}
//
//			}
//		}
//		
//		System.out.println("validIp is "+validIp);
//		Log.logger.info("debug validIp is "+validIp);
//		return validIp;
//	}
//
//
//}
//
