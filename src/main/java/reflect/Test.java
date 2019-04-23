package reflect;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        A a = new A();

        a.print();
        try {
            Field nameFieldInA = a.getClass().getDeclaredField("name");
            nameFieldInA.setAccessible(true);
            nameFieldInA.set(a, "ccc");
            a.print();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }



        try {
            B b = new B();
            b.print();
            Field field = b.getClass().getSuperclass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(b, "B");
            b.print();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}

class A {
    private String name;
    public void print(){
        System.out.println(name);
    }
}

class B extends A {

}
