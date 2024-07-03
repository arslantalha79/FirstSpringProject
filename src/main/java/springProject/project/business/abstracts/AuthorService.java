package springProject.project.business.abstracts;

import java.util.List;

import springProject.project.business.requests.CreateAuthorRequest;
import springProject.project.business.requests.UpdateAuthorRequest;
import springProject.project.business.responses.GetAllAuthorResponse;
import springProject.project.business.responses.GetByIdAuthorResponse;

public interface AuthorService {
	List<GetAllAuthorResponse> getAll();
	GetByIdAuthorResponse getById(int id);
	void add(CreateAuthorRequest createAuthorRequest);
	void delete(int id);
	void update(UpdateAuthorRequest updateAuthorRequest);
}
