package reflect.dynamicproxytest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理, 监听开始");
        Object invoke = method.invoke(target, objects);
        System.out.println("Cglib动态代理, 监听结束");
        return invoke;
    }

    /**
     * 获取代理对象
     * @param objectTarget
     * @return
     */
    private Object getCglibProxy(Object objectTarget) {
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        //设置父类，Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);     //设置回调
        Object result = enhancer.create();      //创建并返回代理对象
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglib = new CglibProxy();
        UserManager user = (UserManager) cglib.getCglibProxy(new UserManagerImpl());
        user.delete("李四");
    }
}
