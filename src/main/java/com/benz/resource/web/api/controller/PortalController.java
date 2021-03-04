package com.benz.resource.web.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class PortalController {

    @GetMapping("/all")
    @PreAuthorize("permitAll()")
    public String all()
    {
        return "Hello All";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String user()
    {
        return "Hello Benzema as User";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin()
    {
        return "Hello Benzema as Admin";
    }

    //client-credentials grant type
    @GetMapping("/client")
    public String clientCredentials()
    {
        return "Hallo, You are using Client-Credentials Flow";
    }
}
