package camarra.project.customerCRM.service;


import camarra.project.customerCRM.dao.CustomerDao;
import camarra.project.customerCRM.dao.CustomerOrderDao;
import camarra.project.customerCRM.dao.ProductDao;

public interface CRMService extends CustomerDao,ProductDao,CustomerOrderDao {

	
}