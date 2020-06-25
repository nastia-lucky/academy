package task4;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Month;

@Listeners({Listener.class})
public class GirlTest extends BaseTest {

    private static Boy boyFriend;
    private static Girl girlWithoutData;
    private static Girl girlPrettyOnly;
    private static double amountForSpending = 300000.0;

    @Parameters({"wealth"})
    @BeforeClass(groups = {"mood", "money"})
    public static void createGirls(double wealth) {
        boyFriend = new Boy(Month.JUNE, wealth);
        girlWithoutData = new Girl();
        girlPrettyOnly = new Girl(true);
    }

    @Test(priority = 1)
    public static void checkGirlData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(girlTrue.isPretty(), true, "Pretty of created girl doesn't coincide with the setted");
        softAssert.assertEquals(girlTrue.isSlimFriendGotAFewKilos(), true, "Friend of created girl doesn't coincide with the setted");
        softAssert.assertEquals(girlTrue.getBoyFriend(), boyTrue, "Boy of created girl doesn't coincide with the setted");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public static void checkShoes() {
        Assert.assertEquals(girlForTestingShoes.isBoyFriendWillBuyNewShoes(), true, "Buying shoes doesn't work");
    }

    @Test(priority = 1)
    public static void setBoyfriend() {
        girlWithoutData.setBoyFriend(boyFriend);
        girlWithoutData.setPretty(true);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(girlWithoutData.getBoyFriend(), boyFriend, "Setting of boyfriend doesn't work");
        softAssert.assertEquals(girlWithoutData.isPretty(), true, "Setting of pretty doesn't work");
        softAssert.assertAll();
    }

    @Test(groups = "money", priority = 2)
    public static void checkSpendBoyFriendMoney() {
        double firstSumMoneyBoy = girlForSpendingBoyfriendMoney.getBoyFriend().getWealth();
        girlForSpendingBoyfriendMoney.spendBoyFriendMoney(amountForSpending);
        double expectedRemainingMoney = firstSumMoneyBoy - amountForSpending;
        Assert.assertEquals(girlForSpendingBoyfriendMoney.getBoyFriend().getWealth(), expectedRemainingMoney, "Spending boyfriend money doesn't work");
    }
}
