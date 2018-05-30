package bulletinBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulletinBoard.domain.Comment;
import bulletinBoard.repository.CommentRepository;
@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;


	public void createComment(Comment comment) {
		Comment newComment = new Comment();
		newComment = comment;
		commentRepository.save(newComment);
	}	
	public void deleteComment(int id) {
		commentRepository.delete(id);		
	}	
}
