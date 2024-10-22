package entites;

public class Customer {

//	attributes
	int idCustomer;
	String firstname;
	String lastname;
	String email;

	//	constructors
	public Customer(int idCustomer, String firstname, String lastname, String email) {
		this.idCustomer = idCustomer;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public Customer(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + "]";
	}

//	 accessors
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
