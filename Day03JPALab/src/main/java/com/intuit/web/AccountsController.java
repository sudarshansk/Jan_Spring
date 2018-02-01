package com.intuit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.service.AccountService;

@RestController
public class AccountsController {

	@Autowired
	private AccountService accountService;
	
}
