package springProject.project.business.abstracts;

import java.util.List;

import springProject.project.business.requests.CreateLanguageRequest;
import springProject.project.business.requests.UpdateLanguageRequest;
import springProject.project.business.responses.GetAllLanguageResponse;
import springProject.project.business.responses.GetByIdLanguageResponse;

public interface ProgrammingLanguageService {
	List<GetAllLanguageResponse> getAll();
	GetByIdLanguageResponse getById(int id);
	void add(CreateLanguageRequest createLanguageRequest);
	void delete(int id);
	void update(UpdateLanguageRequest updateLanguageRequest);
}
