package com.coderains.world.instaclone.user;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {

    /*
     * @OneToMany(mappedBy = "user")
     * 
     * @JsonIgnore
     * private List<Post> lsPost;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Size(min = 4, message = "name must be greater than 4 character")
    @JsonProperty("person_name")
    private String name;

    @Past(message = "Birth Date Should Not Be Greater Than TodaTE")
    @JsonFormat(pattern = "M-d-yyyy")
    private LocalDate birthDate;

    @Past(message = "Birth Date Should Not Be Greater Than TodaTE")
    private String password;

    private String email;

    private String username;

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Object getAuthorities() {
        return "user";
    }

    /*
     * public List<Post> getLsPost() {
     * return lsPost;
     * }
     * 
     * public void setLsPost(List<Post> lsPost) {
     * this.lsPost = lsPost;
     * }
     */

}
