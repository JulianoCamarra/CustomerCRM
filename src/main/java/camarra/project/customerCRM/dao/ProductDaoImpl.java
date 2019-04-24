package camarra.project.customerCRM.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import camarra.project.customerCRM.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private EntityManager entityManager;

	@Autowired
	public ProductDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Product theProduct = currentSession.get(Product.class, theId);

		return theProduct;
	}

	@Override
	public List<Product> getProducts() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Product> theQuery = currentSession.createQuery("FROM Product", Product.class);

		return theQuery.getResultList();
	}

	@Override
	public void saveProduct(Product theProduct) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theProduct);

	}

	@Override
	public void deleteProduct(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Product where id=: productId")
				.setParameter("productId", theId);

		theQuery.executeUpdate();
	}
	
	public Product findProductByName(String name) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		Query<Product> theQuery = currentSession.createQuery("FROM Product where name=: productName")
						.setParameter("productName", name);
		
		Product theProduct= theQuery.getSingleResult();
		
		return theProduct;
	}
		
	
}
