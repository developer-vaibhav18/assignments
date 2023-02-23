package com.example.dream11.repository;

import com.example.dream11.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository {
     public User updateMoneyOfUserByEmail(String email, float money);
     public User UpdateContestIdArrayOfUserByEmailDTO(String email, int id);
     public String updateUser(User user);
}
