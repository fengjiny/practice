package reflect;

/**
 * Java反射创建实例的三种方式
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = new Person();

        //创建Class对象的方式一, 对象.getClass()
        Class class1 = p1.getClass();
        System.out.println(class1.getName());
        Class class2 = p2.getClass();
        System.out.println(class2.getName());
        System.out.println(class1 == class2);
        System.out.println("================");

        //创建class对象的方式二，类.class，需要一个明确的类
        Class class3 = Person.class;
        System.out.println(class1 == class3);

        System.out.println("================");

        //创建Class对象的方式三，forName()
        Class class4 = null;
        try {
            class4 = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(class1 == class4);

        Person person = (Person) class1.newInstance();
        System.out.println(person);

    }
}
