import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.intuit.lab02.service.AccountService;

public class Main {
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		AccountService accountService = context.getBean(AccountService.class);
		accountService.transferFund(1, 2, 500);
		//System.out.println(accountService.getClass().getName());
		
		//accountService.deposit(1, "Deposit", 100);
		
		//accountService.withdraw(1, "Withdraw", 10);
		
		
//		accountService.deposit(1, "Deposit", 100);
//		accountService.deposit(1, "Interest", 1);
		
//		accountService.withdraw(1, "Fees", 1);
		System.out.println("Done");
	}
}
