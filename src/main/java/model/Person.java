package model;

/**
 * Created by sai on 26/07/2015.
 */
public class Person {
    private final String name;
    private final String email;
    private final String country;

    public Person(final String name, final String email, final String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return !(email != null ? !email.equals(person.email) : person.email != null);

    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{ 'name': '" + name + "', 'email': '" + email + "', 'country': '" + country + "' }";
    }
}
