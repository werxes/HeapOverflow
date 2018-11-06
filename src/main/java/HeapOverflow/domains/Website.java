package HeapOverflow.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Website implements Serializable{

	@Transient
	private static final long serialVersionUID =1L;

	public Website() {
	}

	public Website(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
