package com.fly.hi.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.hi.common.dto.ResponseDto;
import com.fly.hi.user.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@Api(tags = "测试")
public class UserController {

    @GetMapping("/user/{id}")
    public ResponseDto<User> getUserById(@PathVariable Integer id) {
        User user = new User(id, "测试", 23, "北京", new Date(), LocalDateTime.now());
        return new ResponseDto<>(200, "success", user);
    }

    @GetMapping("/getDate")
    public LocalDateTime getDate(@RequestParam LocalDate date,
                                 @RequestParam LocalDateTime dateTime,
                                 @RequestParam Date originalDate) {
        System.out.println(date);
        System.out.println(dateTime);
        System.out.println(originalDate);
        return LocalDateTime.now();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        System.out.println(user);
    }

}
