package study.hibernate;

import java.util.Set;

public class Company {
    private int id;
    private String companyName;
    private Set<Developer> developers;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Company:" +
                "\nCompany ID: " + id +
                "\nCompany Name: " + companyName + "\n";
    }
}
