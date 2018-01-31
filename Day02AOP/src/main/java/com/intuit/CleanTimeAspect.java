package com.intuit;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class CleanTimeAspect {
	
	public void checkBrowsingSite(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		String site = proceedingJoinPoint.getArgs()[0].toString();
		if("cricinfo".equalsIgnoreCase(site)) {
			System.out.println(site + " is blocked!!!Do something useful for the company");
		}
		else {
			proceedingJoinPoint.proceed();
		}
	}
	
	public void logSiteNameBeforeCalling(JoinPoint joinPoint) {
		String site = joinPoint.getArgs()[0].toString();
		System.out.println("****Before browsing " + site + " at " + new Date());
	}
	
	public void logSiteNameAfterCalling(JoinPoint joinPoint) {
		String site = joinPoint.getArgs()[0].toString();
		System.out.println("****After browsing " + site + " at " + new Date());
	}
	
	
	public void printTimeBeforeCalling(JoinPoint joinPoint) {
		System.out.println("****Before calling " + joinPoint.getSignature() + " at " + new Date());
	}
	
	public void printTimeAfterCalling(JoinPoint joinPoint) {
		System.out.println("****After calling " + joinPoint.getSignature() + " at " + new Date());
	}
}
