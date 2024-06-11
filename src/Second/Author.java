package Second;

public class Author {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return LastName;
    }

    public Author setLastName(String lastName) {
        LastName = lastName;
        return this;
    }

    private String LastName;

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
