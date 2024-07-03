package springProject.project.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springProject.project.business.abstracts.ProgrammingLanguageService;
import springProject.project.business.requests.CreateLanguageRequest;
import springProject.project.business.requests.UpdateLanguageRequest;
import springProject.project.business.responses.GetAllLanguageResponse;
import springProject.project.business.responses.GetByIdLanguageResponse;
import springProject.project.business.rules.LanguageBusinessRules;
import springProject.project.core.utilities.mappers.ModelMapperService;
import springProject.project.dataAccess.abstracts.ProgrammingLanguageRepository;
import springProject.project.entities.concretes.ProgrammingLanguage;

@Service
@AllArgsConstructor
public class PLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapper;
	private LanguageBusinessRules languageBusinessRules;
	
	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageBusinessRules.checkIfLanguageNameExists(createLanguageRequest.getName());
		ProgrammingLanguage language = modelMapper.forRequest().map(createLanguageRequest, ProgrammingLanguage.class);
		this.programmingLanguageRepository.save(language);
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.deleteById(id);;
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		ProgrammingLanguage language = programmingLanguageRepository.findById(updateLanguageRequest.getId()).get();
		language = modelMapper.forRequest().map(updateLanguageRequest, ProgrammingLanguage.class);
		programmingLanguageRepository.save(language);
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		
		List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
		List<GetAllLanguageResponse> languageResponses = languages.stream()
				.map(language->this.modelMapper.forResponse()
				.map(language, GetAllLanguageResponse.class)).collect(Collectors.toList());
			
		
		return languageResponses;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		ProgrammingLanguage language = programmingLanguageRepository.findById(id).get();
		GetByIdLanguageResponse languageResponse = modelMapper.forResponse().map(language, GetByIdLanguageResponse.class);
		return languageResponse;
	}

}
