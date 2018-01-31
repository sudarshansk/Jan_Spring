package com.intuit;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
	
	@Before("execution (* Employee.work(..))")
	public void printTimeBeforeCalling(JoinPoint joinPoint) {
		System.out.println("****Before calling " + joinPoint.getSignature() + " at " + new Date());
	}
	
	@After("execution (* Employee.work(..))")
	public void printTimeAfterCalling(JoinPoint joinPoint) {
		System.out.println("****After calling " + joinPoint.getSignature() + " at " + new Date());
	}
}
