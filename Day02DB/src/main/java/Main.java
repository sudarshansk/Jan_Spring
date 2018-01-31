import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.intuit.lab02.service.AccountService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		AccountService accountService = context.getBean(AccountService.class);
		accountService.deposit(1, "Deposit", 100);
		accountService.deposit(1, "Interest", 1);
		accountService.withdraw(1, "Withdraw", 10);
		accountService.withdraw(1, "Fees", 1);
		System.out.println("Done");
	}
}
