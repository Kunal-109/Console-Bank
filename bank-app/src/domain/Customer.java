package domain;

public class Customer {
    private final String id;
    private final String name;
    private  String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
