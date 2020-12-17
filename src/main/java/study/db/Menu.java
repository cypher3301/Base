package study.db;

import java.util.Scanner;

public class Menu {
    private String id;
    private String name;
    private String phone;
    private String resultInput;
    private String result;
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("---------------------");
        System.out.println("0: Show item");
        System.out.println("1: Add item");
        System.out.println("2: Show all");
        System.out.println("3: Delete item");
        System.out.println("4: Change");
        System.out.println("5: Exit");
        System.out.print("->:");
        resultInput = scanner.nextLine();
        System.out.println("---------------------");
        getInputMenu(resultInput);
    }

    private void getInputMenu(String input) {
        switch (input) {
            case "0":
                result = "showitem";
                enterId();
                break;
            case "1":
                result = "1";
                enterName();
                enterPhone();
                break;
            case "2":
                result = "showall";
                break;
            case "3":
                result = "delete";
                break;
            case "4":
                result = "change";
                break;
            case "5":
                System.out.println("Exit");
                System.exit(1);
                break;
            default:
                System.out.println("Not correct value!");
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    private void enterId(){
        System.out.print("Enter Id:");
        setId(scanner.nextLine());
    }

    private void enterName(){
        System.out.print("Enter name:");
        setName(scanner.nextLine());
    }

    private void enterPhone(){
        System.out.print("Enter phone: ");
        setPhone(scanner.nextLine());
    }

}
