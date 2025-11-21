package com.project.Diary.Service;

import com.project.Diary.DTO.Login_DTO;
import com.project.Diary.Model.LoginModel;
import com.project.Diary.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository userRepository;

    public String login(Login_DTO request) {

        LoginModel user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return "User not found";
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return "Invalid password";
        }

        return "Login Successful";
    }
}
