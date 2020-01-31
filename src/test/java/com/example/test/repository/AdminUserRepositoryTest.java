package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.AdminUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends TestApplicationTests {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create(){
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("testadmin01");
        adminUser.setPassword("testpassword01");
        adminUser.setStatus("teststatus01");
        adminUser.setRole("testrole01");
        adminUser.setCreatedAt(LocalDateTime.now());
        adminUser.setCreatedBy("testadmin");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Assert.assertNotNull(newAdminUser);
    }

}
