package ru.natology.spring_security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class MethodSecurityController {
    @Secured({ "ROLE_READ" })
    @GetMapping("/read")
    public String getRead() {
        return "Read";
    }

    @RolesAllowed({ "ROLE_WRITE" })
    @GetMapping("/write")
    public String getWrite() {
        return "Write";
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/wd")
    public String getWriteOrDelete() {
        return "Write or Delete";
    }

}