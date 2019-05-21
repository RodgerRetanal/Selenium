import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Parameter;

//@RunWith(Parameter.class)
public class UtilTest {
    @Test
    public void boxPlotTest() {
        System.out.println("Testing Box Plot");
    }

    @Test
    public void heatMapTest() {
        System.out.println("Testing Heat Map");
    }

    @Test
    public void timeSeriesSTest() {
        System.out.println("Testing Time Series (Single)");
    }

    @Test
    public void timeSeriesMTest() {
        System.out.println("Testing Time Series (Multi)");
    }

}
