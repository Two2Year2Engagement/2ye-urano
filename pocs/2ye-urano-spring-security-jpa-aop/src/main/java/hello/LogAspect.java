package hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	
	
	 		@Before("execution(* hello..*(..))")	
	 	    public void logServiceAccess(JoinPoint joinPoint) {
	 			 Logger LOGGER =LoggerFactory.getLogger(joinPoint.getSignature().getName());
	 	        LOGGER.info("Accessing {}" ,joinPoint.getSignature().getName());
	
	 	    }
	
}
