package com.app.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.Utils.HibernateUtils;
import com.app.pojos.Product;

public class ProductDaoImpl implements ProductDao {

	Session session = null;

	@Override
	public String addProduct(Product product) {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String message = "product add is failed!!";
		try {
                Long id = (Long) session.save(product);
			   tx.commit();
			message = "product add is Successfully!!" + id;
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public Product fetchProduct(Long id) {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Product product = null;
		try {
              product = session.get(Product.class, id);
			   tx.commit();
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return product;
}
}
