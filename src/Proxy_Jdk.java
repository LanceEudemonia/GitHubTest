import java.lang.reflect.Proxy;

/**
 * @author: liyi
 * @date: 2019/10/11 下午3:52
 */
public class Proxy_Jdk {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
//        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
//                userService.getClass().getInterfaces(), invocationHandler);
//        userServiceProxy.addUser();
        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), myInvocationHandler);

        userServiceProxy.addUser();
    }
}
