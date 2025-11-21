package com.project.Diary.Service;

import com.project.Diary.DTO.Login_DTO;
import com.project.Diary.Model.LoginModel;
import com.project.Diary.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private LoginRepository userRepository;

    public String register(Login_DTO request) {

        LoginModel existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser != null) {
            return "Email already exists!";
        }

        LoginModel newUser = new LoginModel(request.getEmail(), request.getPassword());
        userRepository.save(newUser);

        return "Registration Successful!";
    }
}
