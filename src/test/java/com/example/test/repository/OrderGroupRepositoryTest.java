package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.OrderGroup;
import jdk.vm.ci.meta.Local;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends TestApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus("teststatus01");
        orderGroup.setOrderType("testtype01");
        orderGroup.setRevAddress("testrevadd01");
        orderGroup.setRevName("testrevname01");
        orderGroup.setPaymentType("testtype01");
        orderGroup.setArrivalDate(LocalDateTime.now().plusDays(5));
        orderGroup.setTotalPrice(BigDecimal.valueOf(80000));
        orderGroup.setTotalQuantity(800);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("testadmin");
//        orderGroup.setUserId(1L);

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assert.assertNotNull(newOrderGroup);
    }
}
