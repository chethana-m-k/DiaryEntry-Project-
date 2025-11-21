package com.project.Diary.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class LoginModel {

    @Id
    private String id;

    private String email;
    private String password;

    // ⭐ Custom constructor for register (email + password only)
    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
