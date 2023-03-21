package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.AccountDetail;
import com.spring.model.UserHistory;
import com.spring.model.UserPass;
import com.spring.model.UserTrx;
import com.spring.service.AccountDetailService;
import com.spring.service.UserHistoryService;
import com.spring.service.UserPassService;

@Controller
public class BankController {

	@RequestMapping("/login")
	public String showlogin() {
		return "login";

	}

	@RequestMapping("/register")
	public String showreg() {
		return "registration";

	}

	@Autowired
	UserPassService userPassService;

	@Autowired
	AccountDetailService accountDetailService;

	@Autowired
	UserHistoryService userHistoryService;

// UserPass Service
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public String registeruser(@RequestParam("username") String userId, @RequestParam("password") String password,
			Model model) {
		UserPass usr = userPassService.getUserinfo(userId);
		if (usr != null) {
			model.addAttribute("msg", "User Already Exists. Please Login !!");
		} else {
			System.out.println("Inside register");
			UserPass user = new UserPass();
			user.setUsername(userId);
			user.setPassword(password);
			userPassService.addUser(user);
			model.addAttribute("msg", "User registered successfully");

		}
		return "login";
	}

	@RequestMapping(value = "/loginuser", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public String loginuser(@ModelAttribute UserPass userpass, Model model, HttpSession session) {

		UserPass user = userPassService.getUserinfo(userpass.getUsername());
		if (user != null && user.getPassword().equals(userpass.getPassword())) {
			model.addAttribute("msg", "Welcome " + user.getUsername() + ", You have successfully logged in.");
			session.setAttribute("userpass", user);
			return "mainmenu";
		} else {
			model.addAttribute("msg", "Invalid user id or password. Please Register!!");
		}
		return "login";

	}

//AccountDetail Service

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createuseraccount(@ModelAttribute AccountDetail accountdetail, Model model, HttpSession session) {
		System.out.println("Account details");
		AccountDetail acctdtl = accountDetailService.getaccountinfo(accountdetail.getAccountnumber());
		// session.setAttribute("accountdetail", accountdetail);
		if (acctdtl != null) {
			model.addAttribute("msg", "Account Number " + acctdtl.getAccountnumber() + " Already Exist!!");
		} else {
			if (accountdetail.getAcctype().equals("Savings")) { // Saving Account initial balance INR 3000
				accountdetail.setBalance(0);

			} else {
				accountdetail.setBalance(0);// Current Account initial balance INR 5000
			}
			accountDetailService.createaccount(accountdetail);
			model.addAttribute("msg", "Account Created");

		}
		return "account";
	}

	@RequestMapping(value = "/updatename/{accountnumber}/{name}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createuseraccount(@PathVariable long accountnumber, @PathVariable String name) {
		accountDetailService.updateaccountname(accountnumber, name);
	}

// Userhistory

	@RequestMapping(value = "/addtrx", method = RequestMethod.POST, params = "debit")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String debittrx(@ModelAttribute UserHistory userhistory, Model model) {
		AccountDetail acctdtl = accountDetailService.getaccountinfo(userhistory.getTempaccnum());
		if (acctdtl != null) {
			if (acctdtl.getBalance() > userhistory.getTrxamt()) {
				System.out.println(userhistory);
				Date date = Calendar.getInstance().getTime();
				SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
				String dte = format1.format(date);
				System.out.println("User History trx date:" + dte);
				int dt = Integer.parseInt(dte);
				userhistory.setTrxdate(dt);
				System.out.println("User History trx date:" + userhistory.getTrxdate());
				float balance;
				long acctnum;
				System.out.println("Withdraw trx");
				userhistory.setWithdraw(userhistory.getTrxamt());
				userhistory.setDeposit(0);
				acctnum = userhistory.getTempaccnum();
				AccountDetail accountdetail = new AccountDetail();
				accountdetail.setAccountnumber(acctnum);
				userhistory.setAccountdetail(accountdetail);
				System.out.println("Acc Number :" + acctnum);
				balance = accountDetailService.getaccbalance(acctnum);
				balance -= userhistory.getTrxamt();
				System.out.println("Balance :" + balance);
				accountDetailService.updateaccbalance(acctnum, balance);
				userhistory.setBalance(balance);
				userHistoryService.addtrx(userhistory);
				return "transaction";
			} else {
				model.addAttribute("msg", "Insufficient Balance");
			}
		} else {
			model.addAttribute("msg", "Invalid Account Number " + userhistory.getTempaccnum());
		}
		return "transaction";

	}

	@RequestMapping(value = "/addtrx", method = RequestMethod.POST, params = "credit")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String credittrx(@ModelAttribute UserHistory userhistory, Model model) {
		AccountDetail acctdtl = accountDetailService.getaccountinfo(userhistory.getTempaccnum());
		if (acctdtl != null) {
			System.out.println(userhistory);
			Date date = Calendar.getInstance().getTime();
			SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
			String dte = format1.format(date);
			System.out.println("User History trx date:" + dte);
			int dt = Integer.parseInt(dte);
			userhistory.setTrxdate(dt);
			System.out.println("User History trx date:" + userhistory.getTrxdate());
			float balance;
			long acctnum;
			System.out.println("Deposit trx");
			userhistory.setDeposit(userhistory.getTrxamt());
			userhistory.setWithdraw(0);
			System.out.println("Deposit trx :" + userhistory.getDeposit());
			acctnum = userhistory.getTempaccnum();
			AccountDetail accountdetail = new AccountDetail();
			accountdetail.setAccountnumber(acctnum);
			userhistory.setAccountdetail(accountdetail);
			System.out.println("Acc Number :" + acctnum);
			balance = accountDetailService.getaccbalance(acctnum);
			balance += userhistory.getTrxamt();
			System.out.println("Balance :" + balance);
			accountDetailService.updateaccbalance(acctnum, balance);
			userhistory.setBalance(balance);
			userHistoryService.addtrx(userhistory);
			return "transaction";
		} else {
			model.addAttribute("msg", "Invalid Account Number " + userhistory.getTempaccnum());
		}
		return "transaction";
	}

	@RequestMapping(value = "/gettrx", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public String getusertrans(@ModelAttribute UserTrx usertrx, Model model) {
		AccountDetail acctdtl = accountDetailService.getaccountinfo(usertrx.getAccountnumber());
		if (acctdtl != null) {
			System.out.println(usertrx);
			List<UserHistory> userhist = userHistoryService.gettalltrx(usertrx);
			model.addAttribute("userhist", userhist);
		} else {
			model.addAttribute("msg", "Account Number " + usertrx.getAccountnumber() + " not present !!");
		}

		return "passbook";
	}

}
