package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Details")
public class Details {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private int detaildId;
    @Column(unique = true)
    private String email;
    @Column(length = 255)
    private String name;
    private LocalDate birthdate;

    public Details() {
    }

    public Details(int detaildId, String email, String name, LocalDate birthdate) {
        this.detaildId = detaildId;
        this.email = email;
        this.name = name;
        this.birthdate = birthdate;
    }


    /**
     * get field
     *
     * @return detaildId
     */
    public int getDetaildId() {
        return this.detaildId;
    }

    /**
     * set field
     *
     * @param detaildId
     */
    public void setDetaildId(int detaildId) {
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
