package com.enum_;

public class Enum01 {
    public static void main(String[] args) {
        System.out.println(Season.season1.getDesc());
    }
}
class Season{
    private String name;
    private String desc;
    // 1. 将构造器私有化
    // 2. 去掉Setter
    // 3. 在内部直接创建对象
    // 4. 优化 加入final修饰符
    public static Season season1 = new Season("season1", "desc1");
    public static Season season2 = new Season("season2", "desc2");
    public static Season season3 = new Season("season3", "desc3");
    public static Season season4 = new Season("season4", "desc4");
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}