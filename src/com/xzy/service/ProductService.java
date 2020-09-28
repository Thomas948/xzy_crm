package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Product;

import java.util.List;


public interface ProductService {

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer productId);

    Page getProductPages(int pageNo, int pageSize, String keyword);

    Product getProductByProductId(Integer productId);

    List<Product> getProductList();
}
