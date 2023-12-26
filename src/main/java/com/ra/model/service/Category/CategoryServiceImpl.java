package com.ra.model.service.Category;

import com.ra.model.dao.Category.CategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Category category) {
        return categoryDAO.saveOrUpdate(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDAO.delete(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDAO.findById(id);
    }
}
