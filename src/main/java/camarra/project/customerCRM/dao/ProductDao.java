package camarra.project.customerCRM.dao;

import java.util.List;

import camarra.project.customerCRM.entity.Product;

public interface ProductDao {
	
	
	public Product getProduct(int theId);
	
	public List<Product> getProducts();
	
	public void saveProduct(Product theProduct);
	
	public void deleteProduct(int theId);
	
	public Product findProductByName(String name);
	
	

}
