package springProject.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springProject.project.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{
	boolean existsByName(String name);
}
