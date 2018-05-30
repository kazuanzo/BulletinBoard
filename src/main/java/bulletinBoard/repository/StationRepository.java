package bulletinBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bulletinBoard.domain.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>{

}
