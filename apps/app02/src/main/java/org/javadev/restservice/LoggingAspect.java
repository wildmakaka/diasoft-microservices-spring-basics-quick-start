package org.javadev.restservice;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.stereotype.Component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
@Aspect
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
		
	@Before("execution(public Greeting org.javadev.restservice.GreetingController.greeting(..))")
    public void logBefore(JoinPoint joinPoint) {
    	Object[] signatureArgs = joinPoint.getArgs();
    	
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    try {
	         if (signatureArgs[0] != null) {
	        	 logger.log(Level.INFO, "\n Входящее значение: " + mapper.writeValueAsString(signatureArgs[0]));
	         }
	    } catch (JsonProcessingException e) {
	    	 logger.log(Level.INFO, "Exception: " );
	    	 e.printStackTrace();
	    }
    }
    
    @AfterReturning(pointcut = "execution(public Greeting org.javadev.restservice.GreetingController.greeting(..))", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {        
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
        	logger.log(Level.INFO, "\n Возвращенное значение : " + mapper.writeValueAsString(returnValue));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

}
