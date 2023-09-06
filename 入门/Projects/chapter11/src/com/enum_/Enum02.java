package com.enum_;

/**
 * @author
 */
public class Enum02 {
    public static void main(String[] args) {
        System.out.println(Season0.SEASON1);
    }
}

enum Season0 {
    // 如果使用enum来实现枚举
    // 1. 关键字enum代替class
    // 2. 创建方法: 常量名(实参列表)
    // 3. 如果有多个常量(对象) 使用, 号间隔
    // 4. 如果使用enum, 要求将定义常量对象写在前面
    SEASON1("season1", "desc1"),
    SEASON2("season2", "desc2"),
    SEASON3("season3", "desc3"),
    SEASON4("season4", "desc4");
    private String name;
    private String desc;


    private Season0(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season0{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}