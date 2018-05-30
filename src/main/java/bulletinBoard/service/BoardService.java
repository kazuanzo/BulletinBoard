package bulletinBoard.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bulletinBoard.domain.Board;
import bulletinBoard.domain.BoardType;
import bulletinBoard.repository.BoardRepository;
import bulletinBoard.repository.BoardTypeRepository;

@Service
public class BoardService {
	@Autowired
	BoardTypeRepository boardTypeRepository;

	@Autowired
	BoardRepository boardRepository; 

	//ボードのタイプ取得
	public List<BoardType> allBoardType() {
		//repositoryを利用してboard_typeを取得
		List<BoardType> boardType = boardTypeRepository.findAll();
		return boardType;
	}

	//ボードの検索
	@Transactional//トランザクション処理
	public List<Board> boardSerch(int boardType,String keyword) {
		//repositoryを利用してboardを検索
		List<Board> boardList = boardRepository.findByBoard(boardType, "%" + keyword + "%");
		return boardList;
	}
	
	//ボードの新規登録
		@Transactional//トランザクション処理
		public Board createBoard(Board board) {
			//repositoryを利用してboardを検索
			return boardRepository.save(board);
		}

	//idからボードの取得
	@Transactional//トランザクション処理
	public Board getBoard(int id) {
		//repositoryを利用してboardを検索
		Board board = boardRepository.findOne(id);
		return board;
	}

}
