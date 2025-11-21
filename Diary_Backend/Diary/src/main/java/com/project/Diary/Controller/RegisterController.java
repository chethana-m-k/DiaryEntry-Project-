package com.project.Diary.Controller;

import com.project.Diary.DTO.Login_DTO;
import com.project.Diary.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public String register(@RequestBody Login_DTO request) {
        return registerService.register(request);
    }
}
