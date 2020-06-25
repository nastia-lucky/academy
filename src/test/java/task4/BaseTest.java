package task4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.time.Month;

@Listeners({Listener.class})
public class BaseTest {

    protected static Girl girlTrue;
    protected static Girl girlFalse;
    protected static Boy boyTrue;
    protected static Boy boyForSpendingMoneyByGirl;
    protected static Girl girlForSpendingBoyfriendMoney;
    protected static Girl girlForTestingShoes;
    protected static Boy boyForBuyingShoes;

    @Parameters({"wealth"})
    @BeforeClass(groups = {"mood", "money"})
    static void createUsers(double wealth) {
        girlTrue = new Girl(true, true, boyTrue);
        boyTrue = new Boy(Month.MAY, wealth, girlTrue);
        girlFalse = new Girl(false, false);
        boyForSpendingMoneyByGirl = new Boy(Month.MAY, wealth, girlForSpendingBoyfriendMoney);
        girlForSpendingBoyfriendMoney = new Girl(true, true, boyForSpendingMoneyByGirl);
        boyForBuyingShoes = new Boy(Month.MAY, 1000000, girlForTestingShoes);
        girlForTestingShoes = new Girl(true, true, boyForBuyingShoes);
    }
}
