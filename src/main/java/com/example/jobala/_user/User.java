package com.example.jobala._user;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 15)
    private String username; // 아이디
    private String compNum; //
    private String password;

    @Column(length = 15)
    private String name;
    private String compname;

    @Column(nullable = false)//널 값 허용 안하는 어노테이션
    private String email;
    private String phone;
    private String ceo;
    private String address;
    private Date age;
    private Integer role; // 0 -> guest, 1 -> comp
    private LocalDateTime createdAt;
}
