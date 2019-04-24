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
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_name")
	private String name;

	@Column(name = "price")
	private double price;

	@OneToMany(mappedBy = "product", cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,
												CascadeType.REMOVE,CascadeType.PERSIST}, orphanRemoval = true)
	private List<CustomerOrder> orders;

	public Product(String productCode, String name, double price) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
	}

	public Product() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", name=" + name + ", price=" + price + "]";
	}
}
