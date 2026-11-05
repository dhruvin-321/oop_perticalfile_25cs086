import java.lang.annotation.*;
import java.lang.reflect.*;

// Run Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Test class
class MyTests {

    @Run
    public void testAdd() {
        System.out.println("Test Add executed");
    }

    @Run
    public void testSub() {
        System.out.println("Test Sub executed");
    }

    public void testMul() {
        System.out.println("Test Mul executed");
    }

    @Run
    public void testDiv() {
        System.out.println("Test Div executed");
    }
}

// Mini Test Runner
class Drivers {

    public static void main(String[] args) throws Exception {

        MyTests obj = new MyTests();

        Class<?> cls = obj.getClass();

        Method[] methods = cls.getDeclaredMethods();

        int count = 0;

        System.out.println("Running Tests:");

        for (Method method : methods) {

            // Check Run annotation
            if (method.isAnnotationPresent(Run.class)
                    && method.getParameterCount() == 0) {

                method.invoke(obj);

                count++;
            }
        }

        System.out.println("Total tests run: " + count);
    }
}