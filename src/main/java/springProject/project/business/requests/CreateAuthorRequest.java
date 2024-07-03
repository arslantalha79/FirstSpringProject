package springProject.project.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorRequest {
	@NotNull
	@NotBlank
	private String name;
	private String surname;
	private int age;
	
}
