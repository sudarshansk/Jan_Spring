public aspect MyAspect{
	private pointcut logTime(): call(* Employee.work(..));
	
	before(): logTime(){
		System.out.println("***Before calling " + thisJoinPoint + " at " + new java.util.Date());
	}
	
	after(): logTime(){
		System.out.println("***After calling " + thisJoinPoint + " at " + new java.util.Date());
	}
}