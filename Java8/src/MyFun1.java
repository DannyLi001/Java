public interface MyFun1 {
    // 默认方法
    default void getName(){
        System.out.println("interface");;
    }

    public static void show(){
        System.out.println("static func");
    }
}
