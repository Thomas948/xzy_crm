package com.xzy.test;

import com.xzy.dto.Page;
import com.xzy.entity.Product;
import com.xzy.service.ProductService;
import com.xzy.service.impl.ProductServiceImpl;
import org.junit.Test;

import java.util.Date;

public class TestProductService {

    private ProductService productService = new ProductServiceImpl();

    @Test
    public void test01() {
        Product product = new Product();
        product.setProductName("IPhone12");
        product.setProductCode("ekb32");
        product.setProductCategoryId(10000);
        product.setPrice(6098d);
        product.setFounderId(10000);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setFlag(0);
        productService.addProduct(product);
    }

    @Test
    public void test02() {
        Product product = new Product();
        product.setProductName("IMAC1");
        product.setProductCode("ekb30");
        product.setProductCategoryId(10000);
        product.setPrice(14397d);
        product.setFounderId(10000);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setFlag(0);
        product.setProductId(10005);
        productService.updateProduct(product);
    }

    @Test
    public void test03() {
        productService.deleteProduct(10005);
    }

    @Test
    public void test04() {
        Page page = productService.getProductPages(1, 2, "");
        System.out.println(page);
    }

    @Test
    public void test05() {
        Product product = productService.getProductByProductId(10001);
        System.out.println(product);
    }
}
