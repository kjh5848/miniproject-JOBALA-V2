package com.example.jobala.jobopen;

import com.example.jobala._user.User;
import com.example.jobala.resume.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

public class JobopenResponse {
    @AllArgsConstructor
    @Data
    public static class ListDTO {
        private Integer id;
        private String jobopenTitle;
        private String compLocation;
        private String career;
        private String edu;
        private String imgFilename;
    }

    @Data
    public static class DTO {
        private Integer id;
        private Integer userId;
        private String compname; //회사명
        private String jobopenTitle; //공고제목
        private String content; //내용
        private String career;// 경력
        private String edu; // 학력
        private String hopeJob; //희망직종
        private String compLocation; //근무지역
        private String jobType; // 고용형태
        private String salary; //연봉
        private java.sql.Date endTime; // 마감일
        private Integer role; // 역할 0 -> guest, 1 -> comp
        private int count;


        public DTO(Jobopen jobopen) {
            this.id = jobopen.getId();
            this.userId = jobopen.getUser().getId();
            this.compname = jobopen.getUser().getCompname();
            this.jobopenTitle = jobopen.getJobopenTitle();
            this.career = jobopen.getCareer();
            this.edu = jobopen.getEdu();
            this.hopeJob = jobopen.getHopeJob();
            this.compLocation = jobopen.getCompLocation();
            this.jobType = jobopen.getJobType();
            this.salary = jobopen.getSalary();
            this.endTime = jobopen.getEndTime();
            this.role = jobopen.getRole();
            this.count = jobopen.getId();
        }

        @CreationTimestamp
        private Timestamp createdAt; //생성일
    }

    @AllArgsConstructor
    @Data
    public static class DetailDTO {
        private Integer id;
        private String jobopenTitle;
        private String career;
        private String edu;
        private String jobType;
        private String salary;
        private String compLocation;
        private String hopeJob;
        private String skills;
        private boolean isScrap;
        private boolean isGuestScrap;
        private UserDTO userDTO;

        public DetailDTO(Jobopen jobopen, User sessionUser) {
            this.id = jobopen.getId();
            this.jobopenTitle = jobopen.getJobopenTitle();
            this.career = jobopen.getCareer();
            this.edu = jobopen.getEdu();
            this.jobType = jobopen.getJobType();
            this.salary = jobopen.getSalary();
            this.compLocation = jobopen.getCompLocation();
            this.hopeJob = jobopen.getHopeJob();
            this.skills = jobopen.getSkills();
            this.isScrap = false;
            this.isGuestScrap = false;
            this.userDTO = new UserDTO(jobopen.getUser());

            if (sessionUser != null) {
                if (sessionUser.getRole() == 0) {
                    this.isGuestScrap = true;
                }
            }
        }

        @Data
        public class UserDTO {
            private Integer userId;
            private String compname;
            private String imgFilename;

            public UserDTO(User user) {
                this.userId = user.getId();
                this.compname = user.getCompname();
                this.imgFilename = user.getImgFilename();
            }
        }
    }

    @AllArgsConstructor
    @Data
    public static class SearchDTO {
        private Integer id;
        private String jobopenTitle;
        private String compLocation;
        private String career;
        private String edu;
        private Date endTime;
    }

    @AllArgsConstructor
    @Data
    public static class ScrapDTO{
        private int id;
        private String compname;
        private String jobopenTitle;
        private String career;

        public ScrapDTO(Jobopen jobopen) {
            this.id = jobopen.getId();
            this.compname = jobopen.getUser().getCompname();
            this.jobopenTitle = jobopen.getJobopenTitle();
            this.career = jobopen.getCareer();
        }
    }

}




