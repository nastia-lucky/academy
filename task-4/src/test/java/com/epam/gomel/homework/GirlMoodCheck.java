package com.epam.gomel.homework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class GirlMoodCheck extends BaseTest {

    private static Girl girlGoodMood;
    private static Girl girlNotPrettyNotSlim;


    @BeforeClass(groups = {"mood", "money"})
    public void createGirls() {

    }

    @Test(groups = "mood", priority = 2)
    public static void checkExellentMood() {
        Assert.assertEquals(girlTrue.getMood(), Mood.EXCELLENT);
    }

    @DataProvider(name = "data for good mood")
    public Object[][] createGirldata() {
        return new Object[][]{
                {true, false, null},
                {false, false, boyTrue}
        };
    }

    @Test(dataProvider = "data for good mood", groups = "mood", priority = 2)
    public static void checkGoodMood(boolean pretty, boolean fatfriend, Boy boy) {
        girlGoodMood = new Girl(pretty, fatfriend, boy);
        Assert.assertEquals(girlGoodMood.getMood(), Mood.GOOD);
    }

    @Test(groups = "mood", priority = 2)
    public static void checkNeutralMood() {
        girlNotPrettyNotSlim = new Girl(false, true);
        Assert.assertEquals(girlNotPrettyNotSlim.getMood(), Mood.NEUTRAL);
    }

    @Test(groups = "mood", priority = 2)
    public static void checkHateMood() {
        Assert.assertEquals(girlFalse.getMood(), Mood.I_HATE_THEM_ALL);

    }
}
