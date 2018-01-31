public class Employee {
	private String name;
	public void setName(String name){
		this.name = name;
	}
	public void work(){
		System.out.println(name + " is on Facebook");
		try {
			Thread.sleep(5000);
		}catch(Exception ex){}	
	}
}