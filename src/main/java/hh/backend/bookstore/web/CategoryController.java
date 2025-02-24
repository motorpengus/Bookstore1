package hh.backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // Handler for displaying the list of categories
    @GetMapping("/categorylist")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
    }

    // Display form for adding a new category
    @GetMapping("/addcategory")
    public String showAddCategoryForm() {
        return "addcategory";
    }

    // Handle form submission for creating a new category
    @PostMapping("/addcategory")
    public String addCategory(@RequestParam("name") String name) {
        Category newCategory = new Category(name);
        categoryRepository.save(newCategory);
        return "redirect:/categorylist"; // Redirect to category list after adding
    }
}
