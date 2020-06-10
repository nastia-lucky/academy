package com.epam.gomel.homework;

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
        softAssert.assertEquals(girlTrue.isPretty(), true);
        softAssert.assertEquals(girlTrue.isSlimFriendGotAFewKilos(), true);
        softAssert.assertEquals(girlTrue.getBoyFriend(), boyTrue);
    }

    @Test(priority = 2)
    public static void checkShoes() {
        Assert.assertEquals(girlTrue.isBoyFriendWillBuyNewShoes(), true);
    }

    @Test(priority = 1)
    public static void setBoyfriend() {
        girlWithoutData.setBoyFriend(boyFriend);
        girlWithoutData.setPretty(true);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(girlWithoutData.getBoyFriend(), boyFriend);
        softAssert.assertEquals(girlWithoutData.isPretty(), true);
    }

    @Test(groups = "money", priority = 2)
    public static void checkSpendBoyfrienMoney() {
        girlTrue.spendBoyFriendMoney(500000.0);
        Assert.assertEquals(girlTrue.getBoyFriend().getWealth(), 500000.0);
    }


}
