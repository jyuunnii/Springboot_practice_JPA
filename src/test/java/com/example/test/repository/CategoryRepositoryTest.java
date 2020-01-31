package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends TestApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){

        Category category = new Category();
        category.setType("tessttype01");
        category.setTitle("testtitle01");
        category.setCreatedAt(LocalDateTime.now());
        category.setCreatedBy("testadmin");

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
    }

    @Test
    public void read(){

        //Optional<Category> optionalCategory = categoryRepository.findById(1L);
        Optional<Category> optionalCategory = categoryRepository.findByType("testtype01");

        String type = "testtype01"; //Assert 위해 선언

        optionalCategory.ifPresent(c -> {
            Assert.assertEquals(c.getType(),type);
            System.out.println(c.getTitle());

        });
    }
}
