package study.Streams;

public class Phone {
    private String name;
    private int price;
    private String company;

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Phone(String name, String company, int price) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    public static int compare(Phone one, Phone two) {
        if (one.getPrice() > two.getPrice()) return 1;
        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Price: " + price +
                (company == null ? "" : (", Company: " + company));
    }
}
