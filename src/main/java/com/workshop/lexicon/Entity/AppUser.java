package com.workshop.lexicon.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer appUserId;
    @Column(unique = true)
    private String username;
    private String password;
    private LocalDate localTime;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "details_detail_id")
    private Details userDetails;

    public AppUser() {
    }

    public AppUser(String username, String password, LocalDate localTime, Details userDetails) {
        this.username = username;
        this.password = password;
        this.localTime = localTime;
        this.userDetails = userDetails;
    }


    /**
     * get field
     *
     * @return appUserId
     */
    public Integer getAppUserId() {
        return this.appUserId;
    }

    /**
     * set field
     *
     * @param appUserId
     */
    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    /**
     * get field
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * set field
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get field
     *
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * set field
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get field
     *
     * @return localTime
     */
    public LocalDate getLocalTime() {
        return this.localTime;
    }

    /**
     * set field
     *
     * @param localTime
     */
    public void setLocalTime(LocalDate localTime) {
        this.localTime = localTime;
    }

    /**
     * get field
     *
     * @return userDetails
     */
    public Details getUserDetails() {
        return this.userDetails;
    }

    /**
     * set field
     *
     * @param userDetails
     */
    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }
}
