package springProject.project.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import springProject.project.business.abstracts.AuthorService;
import springProject.project.business.requests.CreateAuthorRequest;
import springProject.project.business.requests.UpdateAuthorRequest;
import springProject.project.business.responses.GetAllAuthorResponse;
import springProject.project.business.responses.GetByIdAuthorResponse;
import springProject.project.core.utilities.mappers.ModelMapperService;
import springProject.project.dataAccess.abstracts.AuthorRepository;
import springProject.project.entities.concretes.Author;

@Service
@AllArgsConstructor
public class AuthorManager implements AuthorService{
	private AuthorRepository authorRepository;
	private ModelMapperService modelMapper;
	
	@Override
	public List<GetAllAuthorResponse> getAll() {
		List<Author> authors = authorRepository.findAll();
		List<GetAllAuthorResponse> authorResponses = authors.stream()
				.map(author->modelMapper.forResponse()
				.map(author,GetAllAuthorResponse.class)).collect(Collectors.toList());
		
		return authorResponses;
	}

	@Override
	public GetByIdAuthorResponse getById(int id) {
		Author author = authorRepository.findById(id).get();
		GetByIdAuthorResponse authorResponse = modelMapper.forResponse().map(author, GetByIdAuthorResponse.class);
		return authorResponse;
	}

	@Override
	public void add(CreateAuthorRequest createAuthorRequest) {
		Author author = modelMapper.forRequest().map(createAuthorRequest, Author.class);
		this.authorRepository.save(author);
	}

	@Override
	public void delete(int id) {
		Author author = authorRepository.findById(id).get();
		this.authorRepository.delete(author);
	}

	@Override
	public void update(UpdateAuthorRequest updateAuthorRequest) {
		Author author = authorRepository.findById(updateAuthorRequest.getId()).get();
		author = modelMapper.forRequest().map(updateAuthorRequest, Author.class);
		authorRepository.save(author);
	}

}
