package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.daos.ProductDao;
import com.app.daos.ProductDaoImpl;
import com.app.pojos.Category;
import com.app.pojos.Product;

import static com.app.Utils.HibernateUtils.*;

import java.util.Scanner;

public class HibernateTester {

	public static void main(String[] args) {

		ProductDao productDao = new ProductDaoImpl();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println(
					"product name(unique), category (BAKERY|SHOES|CLOTHES|STATIONAY),price,available quantity");
			System.out.println(productDao.addProduct(
					new Product(sc.next(), Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(), sc.nextInt())));
			sc.nextLine();
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter the Id Of Product :: ");
			System.out.println(productDao.fetchProduct(sc.nextLong()));
		}
	}
}
