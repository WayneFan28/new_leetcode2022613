package DynamicProgram;

import org.junit.Test;

public class DynamicTest {
    @Test
    public void test1(){
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        long l=fibonacciNumber.fibonacci(25);
        System.out.println(l);
    }

}
