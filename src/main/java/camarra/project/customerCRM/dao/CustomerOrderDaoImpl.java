package camarra.project.customerCRM.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import camarra.project.customerCRM.entity.CustomerOrder;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	private EntityManager entityManager;

	@Autowired
	public CustomerOrderDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public CustomerOrder getCustomerOrder(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		CustomerOrder theCustomerOrder = currentSession.get(CustomerOrder.class, theId);

		return theCustomerOrder;

	}

	@Override
	public List<CustomerOrder> getCustomerOrders() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<CustomerOrder> theQuery = currentSession.createQuery("FROM CustomerOrder", CustomerOrder.class);

		return theQuery.getResultList();
	}

	@Override
	public void saveCustomerOrder(CustomerOrder theCustomerOrder) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theCustomerOrder);

	}

	@Override
	public void deleteCustomerOrder(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession
				.createQuery("delete from CustomerOrder where id= :customerOrderId")
				.setParameter("customerOrderId", theId);
		
		int result=theQuery.executeUpdate();
	}
}
