package springProject.project.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthorRequest {
	private int id;
	private String name;
	private String surname;
	private int age;
}
