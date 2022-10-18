package tn.esprit.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Aspect
@Slf4j
public class LoggingAspect {
	
	private long t1 , t2 ;
//wa9teh d5alna llmethode
	@Before("execution(public * tn.esprit.spring.service.*.* (..))")
	public void logMethodEntry(JoinPoint thisjoinPoint) {
		t1 = System.currentTimeMillis(); // tsajel wa9teh bdit
		log.info("In method : " + thisjoinPoint.getSignature().getName() + " : ");
	}

	@AfterReturning("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit1(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.info("Out of method without errors : " + name );
	}

	@AfterThrowing("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit2(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.error("Out of method with erros : " + name );
	}
//wa9teh 5rajna 
	@After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint thisjoinPoint) {
		t2 = System.currentTimeMillis(); // tsajel wa9teh 5rajt
		String name = thisjoinPoint.getSignature().getName();
		log.info("Out of method : " + name );
		log.info("execution time of methode " + thisjoinPoint.getSignature()+" is " + (t2 - t1) +" ms");
	}
}