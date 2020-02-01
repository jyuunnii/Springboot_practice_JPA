package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.Partner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends TestApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = new Partner();
        partner.setName("testpartner01");
        partner.setStatus("teststatus01");
        partner.setAddress("testaddress01");
        partner.setCreatedAt(LocalDateTime.now());
        partner.setCreatedBy("testadmin");
//        partner.setCategoryId(1L);

        Partner newPartner = partnerRepository.save(partner);
        Assert.assertNotNull(newPartner);
    }
}
