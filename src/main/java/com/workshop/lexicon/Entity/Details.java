package com.workshop.lexicon.Entity;

import org.apache.tomcat.jni.Time;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer detaildId;
    @Column(unique = true)
    private String email;
    @Column(length = 255)
    private String name;
    private LocalDate birthdate;

    public Details() {
    }

    public Details(String email, String name, LocalDate birthdate) {
        this.email = email;
        this.name = name;
        this.birthdate = birthdate;
    }


    /**
     * get field
     *
     * @return detaildId
     */
    public Integer getDetaildId() {
        return this.detaildId;
    }

    /**
     * set field
     *
     * @param detaildId
     */
    public void setDetaildId(Integer detaildId) {
        this.detaildId = detaildId;
    }

    /**
     * get field
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set field
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set field
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get field
     *
     * @return birthdate
     */
    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    /**
     * set field
     *
     * @param birthdate
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Details{" +
                "detaildId=" + detaildId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
