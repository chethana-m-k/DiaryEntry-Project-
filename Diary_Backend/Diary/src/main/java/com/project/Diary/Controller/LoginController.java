package com.project.Diary.Controller;

import com.project.Diary.DTO.Login_DTO;
import com.project.Diary.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody Login_DTO request) {
        return loginService.login(request);
    }
}
