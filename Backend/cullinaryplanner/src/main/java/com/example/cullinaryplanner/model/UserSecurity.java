package com.example.cullinaryplanner.model;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users_Security")
public class UserSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_security_Id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userid;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "profile_picture")
    private String profilePicture;
    
}
