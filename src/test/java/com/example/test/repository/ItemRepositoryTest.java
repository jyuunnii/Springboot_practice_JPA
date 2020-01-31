package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class ItemRepositoryTest extends TestApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("testitem01");
        item.setPrice(20000);
        item.setStatus("teststatus01");
        item.setTitle("testtitle01");
        item.setPartnerId(1L);
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("testadmin");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

}
