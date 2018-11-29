package reflect.classloadtest;


public class ClassLoaderAndForNameTest {
    public static void main(String[] args) {
        String wholeNameLine = "reflect.classloadtest.Line";
        String wholeNamePoint = "reflect.classloadtest.Point";
        System.out.println("ClassLoader testing...");
        testClassLoader(wholeNameLine, wholeNamePoint);
        System.out.println("======================================");
        System.out.println("Class.forName() testing...");
        testForName(wholeNameLine, wholeNamePoint);

    }

    private static void testClassLoader(String wholeNameLine, String wholeNamePoint) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class line, point;
        try {
            line = loader.loadClass(wholeNameLine);
            point = loader.loadClass(wholeNamePoint);
            System.out.println("line " + line.getName());
            System.out.println("point " + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testForName(String wholeNameLine, String wholeNamePoint) {
        try {
            Class line = Class.forName(wholeNameLine);
            Class point = Class.forName(wholeNamePoint);
            System.out.println("line " + line.getName());
            System.out.println("point " + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
