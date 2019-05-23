package com.example.demo.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpSessionConfig implements HttpSessionListener{
	
	 private static final Map<String, HttpSession> sessions = new HashMap<>();

	    public Map<String, HttpSession> getActiveSessions() {
	        return sessions;
	    }

		@Override
		public void sessionCreated(HttpSessionEvent se) {
			// TODO Auto-generated method stub
			sessions.put(se.getSession().getId(), se.getSession());
			HttpSessionListener.super.sessionCreated(se);
		}

		@Override
		public void sessionDestroyed(HttpSessionEvent se) {
			// TODO Auto-generated method stub
			sessions.remove(se.getSession().getId());
			HttpSessionListener.super.sessionDestroyed(se);
		}
	    
	    
	    

//	    @Bean
//	    public HttpSessionListener httpSessionListener() {
//	        return new HttpSessionListener() {
//	            @Override
//	            public void sessionCreated(HttpSessionEvent hse) {
//	                sessions.put(hse.getSession().getId(), hse.getSession());
//	            }
//
//	            @Override
//	            public void sessionDestroyed(HttpSessionEvent hse) {
//	                sessions.remove(hse.getSession().getId());
//	            }
//	        };
//	    }

}
