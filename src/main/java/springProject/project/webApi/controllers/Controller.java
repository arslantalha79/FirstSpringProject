package springProject.project.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import springProject.project.business.abstracts.AuthorService;
import springProject.project.business.abstracts.ProgrammingLanguageService;
import springProject.project.business.requests.CreateAuthorRequest;
import springProject.project.business.requests.CreateLanguageRequest;
import springProject.project.business.requests.UpdateAuthorRequest;
import springProject.project.business.requests.UpdateLanguageRequest;
import springProject.project.business.responses.GetAllAuthorResponse;
import springProject.project.business.responses.GetAllLanguageResponse;
import springProject.project.business.responses.GetByIdAuthorResponse;
import springProject.project.business.responses.GetByIdLanguageResponse;

@RestController
@RequestMapping("/api/programmingLanguages")
public class Controller {
	private ProgrammingLanguageService programmingLanguageService;
	private AuthorService authorService;
	
	@Autowired
	public Controller(ProgrammingLanguageService programmingLanguageService,AuthorService authorService) {
		this.programmingLanguageService = programmingLanguageService;
		this.authorService = authorService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/addLanguage")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateLanguageRequest createLanguageRequest) {
		programmingLanguageService.add(createLanguageRequest);
	}
	
	@GetMapping("/getById")
	public GetByIdLanguageResponse getById(int id) {
		return programmingLanguageService.getById(id);
	}
	
	@DeleteMapping("/deleteLanguage")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(int id) {
		programmingLanguageService.delete(id);
	}
	
	@PutMapping("/updateLanguage")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
		programmingLanguageService.update(updateLanguageRequest);
	}
	
	@GetMapping("/getAllAuthor")
	public List<GetAllAuthorResponse> getAllAuthor(){
		return authorService.getAll();
	}
	
	@PostMapping("/addAuthor")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateAuthorRequest createAuthorRequest) {
		authorService.add(createAuthorRequest);
	}
	
	@GetMapping("/getByIdAuthor")
	public GetByIdAuthorResponse getByIdAuthor(int id) {
		return authorService.getById(id);
	}
	
	@DeleteMapping("/deleteAuthor")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAuthor(int id) {
		authorService.delete(id);
	}
	
	@PutMapping("/updateAuthor")
	public void updateAuthor(@RequestBody UpdateAuthorRequest updateAuthorRequest) {
		authorService.update(updateAuthorRequest);
	}
}
