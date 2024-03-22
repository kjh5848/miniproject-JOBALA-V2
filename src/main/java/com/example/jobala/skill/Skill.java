package com.example.jobala.skill;

import com.example.jobala._user.User;
import com.example.jobala.jobopen.Jobopen;
import com.example.jobala.resume.Resume;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Data
@Table(name = "skill_tb")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ColumnDefault("1")
    private Integer role; // 0 -> guest, 1 -> comp
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Resume resume; // 개인 null
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Jobopen jobopen; // 1
    private String name; // 스킬 이름
}
