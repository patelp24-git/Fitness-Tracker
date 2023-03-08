package comp3350.fitnesscompanion.tests.logicLayer;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import comp3350.fitnesscompanion.logic.BmiCalculatorImplementation;

public class BmiCalculatorImplementationTest {

    private final int height = 170;
    private final int weight1 = 65,weight2 = 50 ,weight3 = 79,weight4 = 99;
    private BmiCalculatorImplementation before1,before2,before3,before4;
    private BmiCalculatorImplementation befor = new BmiCalculatorImplementation(height,weight1);
    @Mock
    BmiCalculatorImplementation before;


    @Before
    public void initialize(){
        before1 = new BmiCalculatorImplementation(height,weight1);
        before2 = new BmiCalculatorImplementation(height,weight2);
        before3 = new BmiCalculatorImplementation(height,weight3);
        before4 = new BmiCalculatorImplementation(height,weight4);
    }

    @Test
    public void Jason(){
        before = Mockito.mock(BmiCalculatorImplementation.class);
        before.result();
        Mockito.verify(before).result();
    }

    @Test
    public void Test(){
        Assert.assertEquals("Testing BMI text output",before1.result(),"Your BMI is 22.5, indicating your weight is in the Normal category for adults of your height. For your height, a normal weight range would be from 53 to 72 kilograms.");
        Assert.assertEquals("Testing BMI text output",before2.result(),"Your BMI is 17.3, indicating your weight is in the Underweight category for adults of your height. For your height, a normal weight range would be from 53 to 72 kilograms.");
        Assert.assertEquals("Testing BMI text output",before3.result(),"Your BMI is 27.3, indicating your weight is in the Overweight category for adults of your height. For your height, a normal weight range would be from 53 to 72 kilograms.");
        Assert.assertEquals("Testing BMI text output",before4.result(),"Your BMI is 34.3, indicating your weight is in the Obese category for adults of your height. For your height, a normal weight range would be from 53 to 72 kilograms.");
    }

    @After
    public void stop(){
        before1 = null;
        before2 = null;
        before3 = null;
        before4 = null;
    }
}
