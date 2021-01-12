package study.hibernate.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "testphones", schema = "simplenn_test")
public class TestphonesEntity {

    private int id;
    private String name;
    private Integer phone;

    @Basic
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PHONE", nullable = true)
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestphonesEntity that = (TestphonesEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone);
    }
}
