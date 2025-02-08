package com.spring.qudorat.security.db;

import com.spring.qudorat.security.model.entity.AppUser;
import com.spring.qudorat.security.model.entity.Authority;
import com.spring.qudorat.security.service.AuthorityService;
import com.spring.qudorat.security.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {

    private final UserServices userServices;
    private final AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        if (authorityService.findAll().isEmpty()) {
            authorityService.insert(new Authority( "ROLE_ADMIN"));
            authorityService.insert(new Authority( "ROLE_MANAGER"));
            authorityService.insert(new Authority( "ROLE_USER"));
        }

        Thread.sleep(10000);

        if (userServices.findAll().isEmpty()) {
            Set<Authority> authorities = new HashSet<>();
            authorities.add(new Authority("ROLE_ADMIN"));
            AppUser appUser = new AppUser();
            appUser.setUsername("admin");
            appUser.setName("admin");
            appUser.setPassword("admin");
            userServices.save(appUser);
        }

    }
}
