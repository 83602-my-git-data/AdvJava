package com.app.daos;

import com.app.pojos.Product;

public interface ProductDao {
   String addProduct(Product product);
   Product fetchProduct(Long id);
}
