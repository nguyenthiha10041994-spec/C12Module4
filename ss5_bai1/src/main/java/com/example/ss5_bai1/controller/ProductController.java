package com.example.ss5_bai1.controller;

import com.example.ss5_bai1.model.Product;
import com.example.ss5_bai1.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/create")
    public String createProduct(
            @ModelAttribute Product product) {

        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(
            @PathVariable("id") int id,
            Model model) {
        Product product = productService.findById(id);

        if (product == null) {
            return "redirect:/products";
        }

        model.addAttribute("product", product);

        return "product/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateProduct(
            @PathVariable("id") int id,
            @ModelAttribute Product product) {

        product.setId(id);

        productService.update(product);

        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(
            @PathVariable("id") int id) {

        productService.remove(id);

        return "redirect:/products";
    }
    @GetMapping("/{id}")
    public String showDetail(
            @PathVariable("id") int id,
            Model model) {

        Product product = productService.findById(id);

        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/detail";
    }
    @GetMapping("/search")
    public String searchProduct(
            @RequestParam("name") String name,
            Model model) {
        model.addAttribute(
                "products",
                productService.searchByName(name)
        );
        model.addAttribute("name", name);
        return "product/list";
    }
}