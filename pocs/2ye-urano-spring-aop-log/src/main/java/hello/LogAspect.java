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

	private static Logger LOGGER = LoggerFactory.getLogger("generic");
	
	
	 		@Before("execution(* hello..*(..))")	
	 	    public void logServiceAccess(JoinPoint joinPoint) {
		 		System.out.println("testing Aspect");
	 	        LOGGER.info("Accessing {}", joinPoint.getSignature().getName());
	
	 	    }
	
}
