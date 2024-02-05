package com.stuti;

import java.time.LocalDateTime;

public class Users {
    private Long id;
    private String name ;
    private String email;
    private Long phone ;
    private LocalDateTime createAt ;

    public Users(Long id, String name, String email, Long phone, LocalDateTime createAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }


    public void setCreatedAt(LocalDateTime now) {
    }
}
