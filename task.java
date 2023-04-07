import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class task implements Comparable, Serializable {
    public String name;
    public int duration;

    public task(String s, int i){
        this.name=s;
        this.duration=i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        task task = (task) o;
        return duration == task.duration && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    @Override
    public int compareTo(Object o) {
        task t2=(task)o;
        return this.duration-t2.duration;
    }
}
