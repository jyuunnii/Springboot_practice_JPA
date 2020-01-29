package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemRepositoryTest extends TestApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("testitem01");
        item.setPrice(20000);

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

}
