package com.dao_.test;

import com.dao_.dao.ActorDao;
import com.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author
 */
public class TestDao {
    @Test
    public void test(){
        ActorDao actorDao = new ActorDao();
        List<Actor> actors = actorDao.queryMulti("select * from t1 where num > ?", Actor.class, 1);
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        Actor actor = actorDao.querySingle("select * from t1 where num = ?", Actor.class, 3);
        System.out.println(actor);

        Object o = actorDao.queryScalar("select name from t1 where num = ?", 2);
        System.out.println(o);

        int update = actorDao.update("insert into t1 values(?,?)", 9, "name9");
        System.out.println(update);

    }
}
