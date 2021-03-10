package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AppUser")
public class AppUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private int appUserId;
    @Column(unique = true)
    private String username;
    private String password;
    private LocalDateTime localTime;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "Details_detail_id")
    private Details userDetails;

    public AppUser() {
    }

    public AppUser(int appUserId, String username, String password, LocalDateTime localTime, Details userDetails) {
        this.appUserId = appUserId;
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
    public int getAppUserId() {
        return this.appUserId;
    }

    /**
     * set field
     *
     * @param appUserId
     */
    public void setAppUserId(int appUserId) {
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
    public LocalDateTime getLocalTime() {
        return this.localTime;
    }

    /**
     * set field
     *
     * @param localTime
     */
    public void setLocalTime(LocalDateTime localTime) {
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
