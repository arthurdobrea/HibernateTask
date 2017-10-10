import dao.DanceDao;
import dao.ManDao;
import dao.WomanDao;
import model.Dance;
import model.Woman;
import model.Man;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Man man = ManDao.getById(7L);
        Woman woman = WomanDao.getById(7L);
        Dance dance = new Dance(man,woman,"Tango");


        DanceDao.save(dance);
        System.out.println(DanceDao.getAllHisDances(man));
        System.out.println(DanceDao.getAllHerDances(WomanDao.getById(5L)));
    }
}
