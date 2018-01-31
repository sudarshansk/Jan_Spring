package com.intuit;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
	
	@Around("execution (* Employee.browse(..))")
	public void checkBrowsingSite(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		String site = proceedingJoinPoint.getArgs()[0].toString();
		if("cricinfo".equalsIgnoreCase(site)) {
			System.out.println(site + " is blocked!!!Do something useful for the company");
		}
		else {
			proceedingJoinPoint.proceed();
		}
	}
	
	@Before("execution (* Employee.browse(..))")
	public void logSiteNameBeforeCalling(JoinPoint joinPoint) {
		String site = joinPoint.getArgs()[0].toString();
		System.out.println("****Before browsing " + site + " at " + new Date());
	}
	
	@After("execution (* Employee.browse(..))")
	public void logSiteNameAfterCalling(JoinPoint joinPoint) {
		String site = joinPoint.getArgs()[0].toString();
		System.out.println("****After browsing " + site + " at " + new Date());
	}
	
	
	@Before("execution (* Employee.work(..))")
	public void printTimeBeforeCalling(JoinPoint joinPoint) {
		System.out.println("****Before calling " + joinPoint.getSignature() + " at " + new Date());
	}
	
	@After("execution (* Employee.work(..))")
	public void printTimeAfterCalling(JoinPoint joinPoint) {
		System.out.println("****After calling " + joinPoint.getSignature() + " at " + new Date());
	}
}
