package study.db.book;

public class Abonent extends Entity{
    private int phone;
    private String name;

    public Abonent() {
    }

    public Abonent(int id, int phone, String name) {
        super(id);
        this.phone = phone;
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Abonent{id=" +
                getId() +
                "phone=" + phone +
                ", name='" + name + '\'' +
                '}';
    }
}
