package com.example.lib.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.lib.model.Role;
import com.example.lib.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    @PreAuthorize("hasRole('User')")
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}