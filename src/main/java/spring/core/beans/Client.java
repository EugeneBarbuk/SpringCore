package spring.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.StringJoiner;

@Component
@PropertySource("classpath:client.properties")
public class Client {
    private String id;
    private String fullName;
    @Value("${client.greeting}")
    private String greeting;

    public Client(@Value("${client.id}") String id, @Value("${client.name}") String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId() == client.getId() &&
                Objects.equals(getFullName(), client.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Client.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("fullName='" + fullName + "'")
                .add("greeting= '" + greeting + "'")
                .toString();
    }
}

