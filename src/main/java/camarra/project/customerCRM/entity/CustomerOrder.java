package camarra.project.customerCRM.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="customer_order")
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_order_id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="quantity")
	private int quantity;
	
	//@Column(name="date_of_order",columnDefinition="DATETIME default CURRENT_TIMESTAMP")
	@CreationTimestamp
	private LocalDate dateOfOrder;

	
	@Transient
	private int productId;
	
	//use customer's first and last name when saving a new order. then get the customer's id using first and last name in query
	@Transient
	private String customerFirstName;
	
	@Transient 
	String customerLastName;
	
	public CustomerOrder() {
		
	}

	public CustomerOrder(Customer customer, Product product, int quantity, LocalDate dateOfOrder) {
		this.customer= customer;
		this.product = product;
		this.quantity = quantity;
		this.dateOfOrder = dateOfOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int customerOrderId) {
		this.id = customerOrderId;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer=customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
		
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	
	public int getProductId() {
		return this.productId;
	}
	
	public void setProductId(int productId) {
		this.productId=productId;
	}
	
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	@Transient
	public double getPriceOfOrder() {
		
		double price= this.product.getPrice()*this.quantity;
		return price;
	}

	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", customer=" + customer + ", product=" + product + ", quantity=" + quantity
				+ ", dateOfOrder=" + dateOfOrder + "]";
	}
 
	

}
