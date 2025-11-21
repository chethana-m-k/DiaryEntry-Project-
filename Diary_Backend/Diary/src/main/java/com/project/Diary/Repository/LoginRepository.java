package com.project.Diary.Repository;

import com.project.Diary.Model.LoginModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<LoginModel,String> {

    LoginModel findByEmail(String email);
}
