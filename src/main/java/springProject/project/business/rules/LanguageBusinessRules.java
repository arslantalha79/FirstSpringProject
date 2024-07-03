package springProject.project.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springProject.project.core.utilities.exceptions.BusinessException;
import springProject.project.dataAccess.abstracts.ProgrammingLanguageRepository;

@Service
@AllArgsConstructor
public class LanguageBusinessRules {
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public void checkIfLanguageNameExists(String name) {
		if (this.programmingLanguageRepository.existsByName(name)) {
			throw new BusinessException("Language already exists");
		}
	}
}
