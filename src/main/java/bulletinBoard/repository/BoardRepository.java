package bulletinBoard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bulletinBoard.domain.Board;
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{
	@Query(name = "boardSerch")
	public List<Board> findByBoard(@Param("boardType") int boardType,@Param("keyword") String keyword);

}