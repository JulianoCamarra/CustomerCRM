package camarra.project.customerCRM.dao;

import java.util.List;

import camarra.project.customerCRM.entity.Customer;
import camarra.project.customerCRM.entity.CustomerOrder;
import camarra.project.customerCRM.entity.TotalPriceView;

public interface CustomerDao {
		
	public Customer getCustomer(int customerId);
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(int customerId);
	
	public List<CustomerOrder> getOrdersMadeByCustomer(int customerId);
	
	public TotalPriceView getCustomerTotalPrice(int customerId);
	
	public List<TotalPriceView> getTotalPricePerCustomer();
	
	public List<Customer> customerSearch(String searchKey);
}
