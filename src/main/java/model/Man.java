package model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "man")
public class Man {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Man() {
    }

    @OneToMany(mappedBy = "man")
    public List<Dance> dances = new ArrayList<Dance>();

    public Man(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Man man = (Man) o;

        if (!id.equals(man.id)) return false;
        return name.equals(man.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
