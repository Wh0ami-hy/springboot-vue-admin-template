package com.example.spring_boot.controller;

import com.example.spring_boot.entity.User;
import com.example.spring_boot.utils.JwtUtils;
import com.example.spring_boot.utils.Result;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        String token = JwtUtils.generateToken(user.getUsername());
        System.out.println("name-->" + user.getUsername() + "\npassword-->" + user.getPassword());
        return Result.ok().data("token",token);
    }
    @GetMapping("/info")
    public Result info(String token){
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        String url = "https://ts1.cn.mm.bing.net/th/id/R-C.41fea3e6b89ad55df3055ac064de1d55?rik=nOcY%2fPZmgN%2fKsQ&riu=http%3a%2f%2fww1.sinaimg.cn%2flarge%2f005NWMakgy1go4ey87o1wj30b40b4q4e.jpg&ehk=1EscN6fvijWBCmwYVk8FSiLvqoZpt4vzOllJFkIINE8%3d&risl=&pid=ImgRaw&r=0";
        return Result.ok().data("name",username).data("avatar",url);
    }
    @PostMapping("/logout")
    public Result logout(){return Result.ok();}
}
