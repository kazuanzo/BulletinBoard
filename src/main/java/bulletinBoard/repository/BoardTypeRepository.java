package bulletinBoard.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bulletinBoard.domain.BoardType;


@Repository
public interface BoardTypeRepository extends JpaRepository<BoardType, Integer>{

}

