package bulletinBoard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="station")
public class Station {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="station_name")
    private String stationName;

}
