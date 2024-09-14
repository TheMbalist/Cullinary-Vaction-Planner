package com.example.cullinaryplanner.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Followers")
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followerId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "followed_user_id", nullable = false)
    private User followedUser;

    
}
