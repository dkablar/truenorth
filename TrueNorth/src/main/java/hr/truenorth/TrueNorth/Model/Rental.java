package hr.truenorth.TrueNorth.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Rental")
public class Rental {
	
	@Id
	@GeneratedValue
	@Column(name = "rental_id")
	private int id;
	
	@NotNull(message = "Date from cannot be null.")
	@Column(name = "date_from")
	private Timestamp dateFrom;
	
	@NotNull(message = "Date until cannot be null.")
	@Column(name = "date_until")
	private Timestamp dateUntil;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "vhs_id")
	private VHS vhsrented;
	
	@NotNull(message = "Expired cannot be null.")
	@Column(name = "expired")
	private boolean expired;
	
	@Column(name = "lateFee")
	private int lateFee;
	
	public Rental() {
	}

	public Rental(int id, Timestamp dateFrom, Timestamp dateUntil, User user, VHS vhsrented, boolean expired) {
		super();
		this.id = id;
		this.dateFrom = dateFrom;
		this.dateUntil = dateUntil;
		this.user = user;
		this.vhsrented = vhsrented;
		this.expired = expired;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Timestamp dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Timestamp getDateUntil() {
		return dateUntil;
	}

	public void setDateUntil(Timestamp dateUntil) {
		this.dateUntil = dateUntil;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VHS getVhsrented() {
		return vhsrented;
	}

	public void setVhsrented(VHS vhsrented) {
		this.vhsrented = vhsrented;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public int getLateFee() {
		return lateFee;
	}

	public void setLateFee(int lateFee) {
		this.lateFee = lateFee;
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
		Rental other = (Rental) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", dateFrom=" + dateFrom + ", dateUntil=" + dateUntil + ", user=" + user.getUsername()
				+ ", vhsrented=" + vhsrented + ", expired=" + expired + ", lateFee=" + lateFee + "]";
	}
}
