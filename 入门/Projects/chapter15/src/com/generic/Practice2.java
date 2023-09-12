package com.generic;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author
 */
public class Practice2 {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("user1", new User(3452432, 21, "name1"));
        dao.save("user2", new User(2346534, 22, "name2"));
        dao.save("user3", new User(4765756, 23, "name3"));
        dao.save("user4", new User(7879807, 24, "name4"));

        System.out.println(dao.get("user3"));

        dao.update("user4", new User(1984498, 55, "name5"));

        System.out.println(dao.list());

        dao.delete("user2");
        System.out.println(dao);
    }
    @Test
    public void test2(){
        DAO<User> dao = new DAO<>();
        dao.save("user1", new User(3452432, 21, "name1"));
        dao.save("user2", new User(2346534, 22, "name2"));
        System.out.println(dao.get("user3"));
    }
    @Test
    public void test1(){
        DAO<User> dao = new DAO<>();
        dao.save("user1", new User(3452432, 21, "name1"));
        dao.save("user2", new User(2346534, 22, "name2"));
        System.out.println(dao.list());
    }
}

class DAO<T>{
    private Map<String,T> map = new HashMap<>();


    public void save(String id, T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.replace(id, entity);
    }
    public List<T> list(){
        Collection<T> collection = map.values();
        ArrayList<T> ts = new ArrayList<>();
        for (T t : collection) {
            ts.add(t);
        }
        return ts;
    }
    public void delete(String id){
        map.remove(id);
    }
}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}