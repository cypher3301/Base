package study.hibernate.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hibernate_devs", schema = "simplenn_test")
public class HibernateDevsEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String speciality;
    private Integer experience;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = true, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "SPECIALITY", nullable = true, length = 30)
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Basic
    @Column(name = "EXPERIENCE", nullable = true)
    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HibernateDevsEntity that = (HibernateDevsEntity) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(speciality, that.speciality) && Objects.equals(experience, that.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, speciality, experience);
    }
}
