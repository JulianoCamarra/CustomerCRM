package camarra.project.customerCRM.dao;

import java.util.List;

import camarra.project.customerCRM.entity.CustomerOrder;

public interface CustomerOrderDao {
	
	public CustomerOrder getCustomerOrder(int theId);
	
	public List<CustomerOrder> getCustomerOrders();
	
	public void saveCustomerOrder(CustomerOrder theCustomerOrder);
	
	public void deleteCustomerOrder(int theId);
	

}
