package camarra.project.customerCRM.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
    private String lastName;
    
	@Column(name="address")
    private String address;
    
	@Column(name="telephone")
    private String telephone;
    
	@Column(name="email")
    private String email;
    
	@Column(name="enabled")
    private boolean enabled;
	
	@OneToMany(mappedBy="customer",
				cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,
							CascadeType.REMOVE,CascadeType.PERSIST}, orphanRemoval = true)
	private List<CustomerOrder> orders;
    
    public Customer() {
    	
    }

	public Customer(String firstName, String lastName, String address, String telephone, String email,
			boolean enabled) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", telephone=" + telephone + ", email=" + email + ", enabled=" + enabled+"]";
	}

   
}
