import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: liyi
 * @Date: 2018/11/27 下午9:42
 */
public class TestStream {
    @Test
    public void test1(){
        Integer[] integers = new Integer[]{1,2,3,4};
        Arrays.stream(integers).map(x -> x * x)
                .forEach(System.out ::print);
    }
    @Test
    public void test2(){

    }
}
