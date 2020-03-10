import java.util.Optional;

/**
 * @author: liyi
 * @date: 2019-07-18 21:21
 */
public class MyTest {

//    public <T> T get(T C){
//       if (C.toString().equals("a")){
//           Optional<T> agencyBean = Optional.of(C);
//           return agencyBean;
//       }
//       if (C.toString().isEmpty()){
//           Class<MyTest> myTestClass = MyTest.class;
//           return new NoSuchBeanDefinitionException();
//       }
//    }
//
    public static String test1(){
        Optional<String> s = Optional.of("123");
        return s.orElseThrow(NullPointerException::new);
    }

    public static void main(String[] args) {
        System.out.println(test1());
    }
}
