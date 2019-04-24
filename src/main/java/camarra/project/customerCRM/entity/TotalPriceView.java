package camarra.project.customerCRM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="totalpricepercustomer")
public class TotalPriceView {
	
	@Id
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="totalprice")
	private double totalPrice;
	
	public TotalPriceView() {
		
	}
	
	public TotalPriceView(int customerId, String firstName, String lastName, double totalPrice) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalPrice = totalPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "TotalPriceView [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	

}
