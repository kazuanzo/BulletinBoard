package bulletinBoard.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bulletinBoard.domain.Account;
import bulletinBoard.domain.AccountUserDetails;
import bulletinBoard.domain.Board;
import bulletinBoard.domain.BoardType;
import bulletinBoard.domain.Comment;
import bulletinBoard.domain.RoleName;
import bulletinBoard.domain.Station;
import bulletinBoard.service.AccountService;
import bulletinBoard.service.BoardService;
import bulletinBoard.service.CommentService;
import bulletinBoard.service.StationService;


@SessionAttributes(value = "board")
@Controller
public class BuilletinBoardController {
	@Autowired
	AccountService accountService;

	@Autowired
	StationService stationService;

	@Autowired
	BoardService boardService;

	@Autowired
	CommentService commentService;

	@RequestMapping("/top")
	public String top(Model model) {
		return "top";
	}
	@RequestMapping("/loginForm")
	public String login(Model model) {
		return "loginForm";
	}
	@RequestMapping("/test")
	public String test(Model model) {
		return "sample";
	}
	@RequestMapping("/test2")
	public String test2(Model model) {
		return "test2";
	}
	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
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

	/**
	 *terminals返却
	 */
	@RequestMapping(value = "/terminal", method = RequestMethod.GET)
	@ResponseBody//メソッドへのリクエスト結果がJSON形式になる
	List<Station> allStation() {
		//サービスクラスを利用し、アイテムリストを取得
		List<Station> station=stationService.allStation();   
		return  station;
	}
	@RequestMapping(value = "/insertTerminal", method = RequestMethod.POST)
	public String createStation(Station station) {
		//サービスクラスを利用し、アイテムリストを取得
		stationService.createStation(station);   
		return  "top";
	}

	/**
	 * 掲示板

	 */
	//掲示板表示
	@RequestMapping("/builletinBoard")
	public String builletinBoard(Model model) {
		model.addAttribute("keyword","");
		return "builletinBoard";
	}
	@RequestMapping(value = "/boardType", method = RequestMethod.GET)
	@ResponseBody//メソッドへのリクエスト結果がJSON形式になる
	List<BoardType> boardType() {
		//サービスクラスを利用し、掲示板タイプを取得
		List<BoardType> boardType = boardService.allBoardType();   
		return  boardType;
	}	

	//新規登録画面
	@RequestMapping("/boardForm")
	public String bordForm(Model model) {
		//ここで権限リストを格納して登録画面でセレクトボックスで表示
		model.addAttribute("rolename",RoleName.values());
		return "registrationForm";
	}
	//掲示板新規登録
	@RequestMapping(value="/boardRegistration", method=RequestMethod.POST)
	public String bordRegistration(Board board,Model model) {
		model.addAttribute("board", boardService.createBoard(board));
		return "boardContent";
	}

	//コメント投稿
	@RequestMapping(value="/commentContribution", method=RequestMethod.POST)
	public String commentContribution(@AuthenticationPrincipal AccountUserDetails accountDatail, @Valid Comment comment, BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("validationError", "何か入力してください。");
			Board board = boardService.getBoard(accountDatail.getId());
			model.addAttribute("board", board);
			return "boardContent";
		}
		comment.setAccount(accountDatail.getAccount());
		comment.setBoard(boardService.getBoard(comment.getBoardId()));
		commentService.createComment(comment);
		Board board = boardService.getBoard(comment.getBoardId());
		model.addAttribute("board", board);
		return "boardContent";
	}
	//コメント削除
	@RequestMapping(value = "/commentContribution/delete/{commentId}", method = RequestMethod.GET)
	public String commentDelete(@ModelAttribute("board")Board sessionBoard,@PathVariable Integer commentId, RedirectAttributes attributes, Model model) {
		commentService.deleteComment(commentId);
		Board board = boardService.getBoard(sessionBoard.getId());
		model.addAttribute("board", board);
		return "boardContent";
	}

	//検索
	@RequestMapping(value="/boardSearch", method=RequestMethod.GET)
	public String boardSearch(@RequestParam int boardType,String keyword,Model model) {
		List<Board> boardList = boardService.boardSerch(boardType, keyword);
		model.addAttribute("boardType", boardType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("boardList",boardList);
		return "builletinBoard";
	}
	//詳細表示
	@RequestMapping(value="/boardContent", method=RequestMethod.GET)
	public String boardContent(Comment comment,@RequestParam int id,Model model) {
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		setRequestForm(board);
		return "boardContent";
	}
	//セッションのオブジェクト代入格納メソッド
    @ModelAttribute("board")
    public Board setRequestForm(Board board){
        return board;
    }


}
