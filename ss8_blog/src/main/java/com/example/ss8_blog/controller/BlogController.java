package com.example.ss8_blog.controller;

import com.example.ss8_blog.model.Blog;
import com.example.ss8_blog.service.BlogService;
import com.example.ss8_blog.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;
    private final CategoryService categoryService;

    public BlogController(BlogService blogService,
                          CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "desc") String sort,
            @RequestParam(defaultValue = "") String keyword,
            Model model) {

        Sort sortOrder;

        if ("asc".equals(sort)) {
            sortOrder = Sort.by("createdAt").ascending();
        } else {
            sortOrder = Sort.by("createdAt").descending();
        }

        Pageable pageable = PageRequest.of(
                page,
                2,
                sortOrder
        );

        Page<Blog> blogPage;

        if (keyword == null || keyword.trim().isEmpty()) {
            blogPage = blogService.findAll(pageable);
        } else {
            blogPage = blogService.searchByTitle(keyword, pageable);
        }

        model.addAttribute("blogs", blogPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", blogPage.getTotalPages());
        model.addAttribute("sort", sort);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories", categoryService.findAll());

        return "blog/list";
    }
    @GetMapping("/category/{id}")
    public String blogsByCategory(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Pageable pageable = PageRequest.of(
                page,
                2,
                Sort.by("createdAt").descending()
        );

        Page<Blog> blogPage =
                blogService.findByCategory(id, pageable);

        model.addAttribute("blogs", blogPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", blogPage.getTotalPages());
        model.addAttribute("sort", "desc");
        model.addAttribute("keyword", "");
        model.addAttribute("categories", categoryService.findAll());

        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());

        return "blog/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog) {

        blogService.save(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/{id}")
    public String viewBlog(
            @PathVariable Long id,
            Model model) {

        Blog blog = blogService.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy blog"));

        model.addAttribute("blog", blog);

        return "blog/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        Blog blog = blogService.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy blog"));

        model.addAttribute("blog", blog);
        model.addAttribute("categories", categoryService.findAll());

        return "blog/edit";
    }

    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog) {

        blogService.save(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {

        blogService.deleteById(id);

        return "redirect:/blogs";
    }
}