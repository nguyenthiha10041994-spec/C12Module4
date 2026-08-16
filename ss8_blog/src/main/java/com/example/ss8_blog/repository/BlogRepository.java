package com.example.ss8_blog.repository;

import com.example.ss8_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByOrderByCreatedAtDesc();

    Page<Blog> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Page<Blog> findByTitleContainingIgnoreCase(
            String title,
            Pageable pageable
    );

    Page<Blog> findByCategoryId(
            Long categoryId,
            Pageable pageable
    );
}