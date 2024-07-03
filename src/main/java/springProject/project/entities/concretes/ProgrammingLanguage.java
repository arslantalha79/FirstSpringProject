package springProject.project.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "languages")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ProgrammingLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@Column(name = "name")
	private String name;
	
	
	
	
}
