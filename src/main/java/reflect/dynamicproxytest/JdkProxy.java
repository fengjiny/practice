package reflect.dynamicproxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理, 监听开始");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束");
        return result;
    }

    private Object getJDKProxy(Object targetObject) {
        this.target = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserManager user = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());
        user.add("张三", "123456");
    }
}
