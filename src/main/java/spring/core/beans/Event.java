package spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.StringJoiner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Component
@Scope("prototype")
public class Event {
    private int id = new Random().nextInt();
    private String msg;
    private Date date;

    public Event(@Value("#{new java.util.Date()}") Date date) {
        this.date = date;
    }
    public String getMsg() {
        return msg;
    }


    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getId() == event.getId() &&
                Objects.equals(getMsg(), event.getMsg()) &&
                Objects.equals(getDate(), event.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMsg(), getDate());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("msg='" + msg + "'")
                .add("date=" + date)
                .toString();
    }
}
