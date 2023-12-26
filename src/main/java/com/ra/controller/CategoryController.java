package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String index(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/category";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/add_category";
    }

    @PostMapping("/add")
    public String createCategory(@ModelAttribute("category") Category category) {
        if (categoryService.saveOrUpdate(category)) {
            return "redirect:/admin/category";
        } else {
            return "admin/add_category";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/edit_category";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") Integer id, @ModelAttribute("category") Category category) {
        if (categoryService.saveOrUpdate(category)) {
            return "redirect:/admin/category";
        }
        return "redirect:admin/edit_category" + id;
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return "redirect:/admin/category";
    }
}
