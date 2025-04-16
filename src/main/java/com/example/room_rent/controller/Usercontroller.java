package com.example.room_rent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.room_rent.dtos.Userdto;
import com.example.room_rent.enitity.Userentity;
import com.example.room_rent.service.Userservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/users")
public class Usercontroller {
    @Autowired
    private Userservice uservice;
    @PostMapping("/")
    public String add(@RequestBody Userdto dt) {
        return this.uservice.adduser(dt);
    }
    @GetMapping("/")
    public List<Userdto> getMethodName() {
        return uservice.getall();
    }
    @GetMapping("/{id}")
    public Userdto getone(@PathVariable Integer id) {
        return uservice.gettingbyid(id);
    }
    @PutMapping("/{id}")
    public String putMethodName(@PathVariable Integer id, @RequestBody Userdto updatevalue)
    {
        return uservice.update(id,updatevalue);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id)
    {
        return uservice.delete(id);
    }
}
