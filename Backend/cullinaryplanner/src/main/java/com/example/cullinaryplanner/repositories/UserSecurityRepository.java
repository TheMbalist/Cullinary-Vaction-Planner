package com.example.cullinaryplanner.repositories;


import com.example.cullinaryplanner.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, Integer> {
    // You can add custom query methods here if needed

}
