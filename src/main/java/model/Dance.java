package model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table(name = "dance")
public class Dance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_man")
    private Man man;

    @ManyToOne
    @JoinColumn(name = "id_woman")
    private Woman woman;

    @Column(name = "dance")
    private String dance;

    public Dance() {
    }

    public Dance(Man man, Woman woman, String dance) {
        this.man = man;
        this.woman = woman;
        this.dance = dance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    public String getDance() {
        return dance;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dance dance1 = (Dance) o;

        if (!id.equals(dance1.id)) return false;
        if (!man.equals(dance1.man)) return false;
        if (!woman.equals(dance1.woman)) return false;
        return dance.equals(dance1.dance);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + man.hashCode();
        result = 31 * result + woman.hashCode();
        result = 31 * result + dance.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DanceDao{" +
                "id=" + id +
                ", man=" + man +
                ", woman=" + woman +
                ", dance='" + dance + '\'' +
                '}' + '\n';
    }
}
