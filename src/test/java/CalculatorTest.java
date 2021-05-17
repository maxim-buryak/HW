import org.testng.annotations.*;
import utils.PropertiesReaderClassLoader;

import static org.testng.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @BeforeClass
    public  void  beforeClassCalculator(){
        System.out.println("Class tests are start");
    }
    @BeforeMethod
    public void beforeMethodtestSum(){
        System.out.println("Method Sum test are start");
    }

    @Test
    public void test0Sum() {
        assertEquals(calculator.sum(4, 3),7);
    }
    @Test(dependsOnMethods = {"test0Sum"})
    public void test1Sum() {
        assertEquals(calculator.sum(0, 2),2);
    }
    @Test(dependsOnMethods = {"test1Sum"})
    public void test2Sum() {
        assertEquals(calculator.sum(3, 0),3);
    }
    @Test(dependsOnMethods = {"test2Sum"})
    public void test3Sum() {
        assertEquals(calculator.sum(4, -3),1);
    }
    @Test(dependsOnMethods = {"test3Sum"})
    public void test4Sum() {
        assertEquals(calculator.sum(-3, -3),-6);
    }
    @AfterMethod
    public void afterMethodSum(){
        System.out.println("Method Sum test are complete");
    }

    @BeforeMethod
    public void beforeMethodtestDivision(){
        System.out.println("Method Multiply test are start");
    }


    @Test
    public void test0Division() {
        assertEquals(calculator.division(6, 2),3.0);
    }
    @Test(priority = 2)
    public void test1dDvision() {
        assertEquals(calculator.division(3, 2),1.5);
    }
    @Test(priority = 3)
    public void test2Division() {
        assertEquals(calculator.division(3, 3),1.0);
    }
    @Test(priority = 5)
    public void test3Division() {
        assertEquals(calculator.division(-1, 3),-0.3333333333333333);
    }
    @Test(priority = 4)
    public void testDivision() {
        assertEquals(calculator.division(-3, -1),3.0);
    }
    @Test(dataProvider = "getData")
    public void instanceDbProvider(int p1, String p2){
        System.out.println("Instance DataProvider Example: Data(" + p1 + ", " + p2 + ")");
    }
    @Test(expectedExceptions = {NullPointerException.class})
    public void test5Division(){
        assertEquals(calculator.division(3, 9), 0.3333333333333333);
    }
    @AfterMethod
    public void afterMethodDivision(){
        System.out.println("Method Multiply test are complete");
    }
    @Test(timeOut = 1000)
    public void testList() {
      assertEquals(calculator.list("John", "Galoger"), true);

    }
    @Test
    public void test2() {
        String baseUrl = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "baseUrl");
        String defaultTimeoutValue = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "defaultTimeout");
        System.out.println("baseUrl = " + baseUrl);
        System.out.println("defaultTimeoutValue = " + defaultTimeoutValue);
    }
    @Parameters({"param1"})
    @Test
    public void parameterTestOne(String param){
        System.out.println("Test one suite param is: " + param);
    }


    @AfterClass
    public void  afterClassCalculator(){
        System.out.println("Class tests are complete");
    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {2, "two"},
                {7, "seven"},
                {4, "four"},
                {9, "nine"}};

    }


}