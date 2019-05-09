package camarra.project.customerCRM.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.NumberUtils;

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

	@Override
	public List<Product> productSearch(String searchKey) {

		/*
		 * if user enters a product number, we can search for it by initializing an int
		 * and parsing it and then adding it to the query parameter
		 */
		int idKey = 0;

		if (searchKey.matches("[0-9]+")) {
			idKey = Integer.parseInt(searchKey);
		}

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Product> theQuery = currentSession
				.createQuery(
						"FROM Product where id=:idKey OR " 
						 + "productCode=:searchKey OR " 
						 + "name LIKE:nameSearchKey",
						   Product.class)
					.setParameter("idKey", idKey)
					.setParameter("searchKey", searchKey)
					.setParameter("nameSearchKey", "%" + searchKey + "%");

		return theQuery.getResultList();

	}

}
