package com.ra.model.service.Category;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Boolean saveOrUpdate(Category category);
    void delete(Integer id);
    Category findById(Integer id);
}
