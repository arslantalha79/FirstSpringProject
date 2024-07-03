package springProject.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springProject.project.entities.concretes.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
