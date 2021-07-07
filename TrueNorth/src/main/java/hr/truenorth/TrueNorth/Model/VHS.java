package hr.truenorth.TrueNorth.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VHS")
public class VHS {

	@Id
	@GeneratedValue
	@Column(name = "vhs_id")
	private int id;
	
	@NotNull(message = "Title can not be empty.")
	@Column(name = "title")
	private String title;
	
	@OneToOne(mappedBy = "vhsrented")
	private Rental rental;
	
	public VHS() {
	}

	public VHS(int id, String title, Rental rental) {
		this.id = id;
		this.title = title;
		this.rental = rental;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VHS other = (VHS) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return title;
	}
}
