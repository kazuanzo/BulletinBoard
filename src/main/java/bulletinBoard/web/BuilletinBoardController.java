package bulletinBoard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuilletinBoardController {
	
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		return "top";
	}

}
