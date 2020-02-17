package spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.StringJoiner;

@Component
@Scope("prototype")
public class Event {
    private int id = new Random().nextInt();
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(@Value("${new java.util.Date()}" Date date) {
        this.date = date;
  //      this.df = df;
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

    @Autowired
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
                .add("date=" + df.format(date))
                .toString();
    }
}
