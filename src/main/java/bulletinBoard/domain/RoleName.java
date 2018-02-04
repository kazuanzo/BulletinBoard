package bulletinBoard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleName {
	ADMIN("ADMIN", "ADMIN"),
	USER("USER", "USER");
	
	private final String value;
    private final String text;

}
