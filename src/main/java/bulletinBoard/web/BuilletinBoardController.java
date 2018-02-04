package bulletinBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bulletinBoard.domain.Account;
import bulletinBoard.domain.AccountUserDetails;
import bulletinBoard.domain.RoleName;
import bulletinBoard.security.AccountUserDetail;
import bulletinBoard.service.AccountService;

@Controller
public class BuilletinBoardController {
	@Autowired
	AccountService accountService;
	
	
	@RequestMapping("/top")
	public String top(@AuthenticationPrincipal AccountUserDetails accountUserDetails ,Model model) {
		model.addAttribute("userName",accountUserDetails.getAccount().getUserName());
		return "top";
	}
	@RequestMapping("/loginForm")
	public String login(Model model) {
		return "loginForm";
	}
	@RequestMapping("/builletinBoard")
	public String builletinBoard(Model model) {
		return "builletinBoard";
	}
	@RequestMapping("/test")
	public String test(Model model) {
		return "test";
	}
	//新規登録画面
	@RequestMapping("/registrationForm")
	public String registrationForm(Model model) {
		//ここで権限リストを格納して登録画面でセレクトボックスで表示
		model.addAttribute("rolename",RoleName.values());
		return "registrationForm";
	}
	//新規登録
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registration(Account account) {
		
		accountService.createAccount(account);
		
		return "registrationSuccess";
	}
	

}
