package JUnitTest;

import org.junit.*;

import static org.junit.Assert.*;

public class MyMathTest {
    MyMath myMath = new MyMath();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @Test
    public void sum_with3numbers() {
        System.out.println("test 1");

        assertEquals(6, myMath.sum(new int[] {1, 2, 3}));
    }

    @Test
    public void sum_with1number() {
        System.out.println("test 2");

        assertEquals(3, myMath.sum(new int[] {3}));
    }
}