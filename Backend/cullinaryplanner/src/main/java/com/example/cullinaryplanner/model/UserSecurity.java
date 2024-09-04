package com.example.cullinaryplanner.model;



import javax.persistence.*;
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
    
    private String username;
    private String password;
    private String email;
    private String profilePicture;
    
}
