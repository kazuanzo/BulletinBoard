package bulletinBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bulletinBoard.domain.Station;
import bulletinBoard.repository.StationRepository;
@Service
public class StationService {
	@Autowired
	private StationRepository repository;
	
	public List<Station> allStation() {
		//repositoryを利用してstationを取得
		List<Station> stations=repository.findAll();
		return stations;
	}
	public Station createStation(Station station) {
		//repositoryを利用してstationを追加
		Station newStation = new Station();
		newStation = station;
		return repository.save(newStation);
	}	

}
