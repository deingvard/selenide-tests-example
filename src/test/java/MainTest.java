import com.ivliev.properties.Config;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ivliev.steps.BaseStep;
import com.ivliev.steps.MainSteps;
import java.io.IOException;

public class MainTest {

    @BeforeTest
    public void beforeTest() {
        BaseStep.beforeTest();
    }

    @Test
    public void mainTest() throws IOException {

        MainSteps mainSteps = new MainSteps();
        Config config = new Config();

        mainSteps.openShop()
                .clickMarket()
                .chooseComputers()
                .chooseLaptopsAndNetbooksButton()
                .setLaptops()
                .setPriceMin(config.loadMinPrice("minPrice"))
                .setPriceMax(config.loadMaxPrice("maxPrice"))
                .setDiagonalMin(config.loadMinDiagonal("minDiagonal"))
                .setDiagonalMax(config.loadMaxDiagonal("maxDiagonal"))
                .clickApplyButton()
                .сountElementsPerPage()
                .sortLaptopPageASC()
                .storeFirstElement()
                .sortLaptopPageDESC()
                .lastPage();
    }
}