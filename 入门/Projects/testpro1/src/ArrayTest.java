public class ArrayTest {
    public static void main(String[] args) {
        int[] arr1 = {23, 12, 41, 32, 13, 42, 31, 51};
        MyTools t1 = new MyTools;
        t1.bubble(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }

}
// .var 自动补全对象创建

// ctrl + alt + l 自动对齐
// ctrl + H 查看继承关系

class Person {
    String name;
    int age;

    // alt + insert 自动生产构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


class MyTools {
    public void bubble(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }
}
