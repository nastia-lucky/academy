package task4;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.time.Month.JANUARY;
import static java.time.Month.MAY;

@Listeners({Listener.class})
public class BoyCreationTest extends BaseTest {

    private static Boy boyMonth;

    @BeforeClass(groups = {"mood", "money"})
    public static void createBoys() {
        boyMonth = new Boy(JANUARY);
    }

    @Test
    public void getUserMonth() {
        Assert.assertEquals(boyMonth.getBirthdayMonth(), JANUARY);
    }

    @Test(groups = "money", priority = 1)
    public void checkBoyData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(boyTrue.getBirthdayMonth(), MAY);
        softAssert.assertEquals(boyTrue.getWealth(), 3000000.0);
        softAssert.assertEquals(boyTrue.getGirlFriend(), girlTrue);
    }


    @Test(dependsOnMethods = "checkBoyData", groups = "money", priority = 2)
    public void checkSpendMoney() {
        double spendedMoney = boyTrue.getWealth() - 1;
        double expectedWealth = boyTrue.getWealth() - spendedMoney;
        boyTrue.spendSomeMoney(spendedMoney);
        Assert.assertEquals(boyTrue.getWealth(), expectedWealth);
    }

    @Test(expectedExceptions = RuntimeException.class, groups = "money", priority = 2)
    public void checkSpendMoneyException() {
        double spendedMoney = boyTrue.getWealth() + 1;
        boyTrue.spendSomeMoney(spendedMoney);
    }


}
