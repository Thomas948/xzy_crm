package com.xzy.service;

import com.xzy.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategoryByCategoryId(Integer categoryId);

}
