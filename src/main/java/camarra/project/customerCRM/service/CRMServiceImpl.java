package camarra.project.customerCRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import camarra.project.customerCRM.dao.CustomerDao;
import camarra.project.customerCRM.dao.CustomerOrderDao;
import camarra.project.customerCRM.dao.ProductDao;
import camarra.project.customerCRM.entity.Customer;
import camarra.project.customerCRM.entity.CustomerOrder;
import camarra.project.customerCRM.entity.Product;
import camarra.project.customerCRM.entity.TotalPriceView;

@Service
public class CRMServiceImpl implements CRMService {

	@Autowired
	private CustomerDao customerRepo;

	@Autowired
	private ProductDao productRepo;

	@Autowired
	private CustomerOrderDao customerOrderRepo;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerRepo.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerRepo.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerRepo.getCustomer(theId);

	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerRepo.deleteCustomer(theId);

	}

	@Override
	@Transactional
	public Product getProduct(int theId) {

		return productRepo.getProduct(theId);
	}

	@Override
	@Transactional
	public List<Product> getProducts() {

		return productRepo.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {

		productRepo.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {

		productRepo.deleteProduct(theId);
	}

	@Override
	@Transactional
	public CustomerOrder getCustomerOrder(int theId) {
		return customerOrderRepo.getCustomerOrder(theId);
	}

	@Override
	@Transactional
	public List<CustomerOrder> getCustomerOrders() {

		return customerOrderRepo.getCustomerOrders();
	}

	@Override
	@Transactional
	public void saveCustomerOrder(CustomerOrder theCustomerOrder) {

		customerOrderRepo.saveCustomerOrder(theCustomerOrder);
	}

	@Override
	@Transactional
	public void deleteCustomerOrder(int theId) {

		customerOrderRepo.deleteCustomerOrder(theId);

	}

	@Override
	@Transactional
	public List<CustomerOrder> getOrdersMadeByCustomer(int customerId) {

		return customerRepo.getOrdersMadeByCustomer(customerId);
	}

	@Override
	@Transactional
	public TotalPriceView getCustomerTotalPrice(int customerId) {

		return customerRepo.getCustomerTotalPrice(customerId);
	}

	@Override
	@Transactional
	public List<TotalPriceView> getTotalPricePerCustomer() {

		return customerRepo.getTotalPricePerCustomer();

	}

	
	@Override
	@Transactional
	public List<Customer> customerSearch(String searchKey) {
		
		return customerRepo.customerSearch(searchKey);
	}

	@Override
	public List<Product> productSearch(String searchKey) {
		
		return productRepo.productSearch(searchKey);
	}
}
