import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: liyi
 * @date: 2019/10/11 下午3:49
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    MyInvocationHandler() {
        super();
    }

    MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("addUser".equals(method.getName())) {
            System.out.println("start--" + method.getName());
            Object result = method.invoke(target, args);
            System.out.println("end--" + method.getName());
            return result;
        } else {
            Object result = method.invoke(target, args);
            return result;
        }
    }
}
