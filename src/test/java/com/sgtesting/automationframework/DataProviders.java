package com.sgtesting.automationframework;

import org.testng.annotations.DataProvider;

public class DataProviders
{
    @DataProvider(name = "appUrl")
    public Object [][] getUrl()
    {
        return new Object[][] {{"http://localhost/login.do"}};
    }

    @DataProvider(name = "loginData")
    public Object [][] getLoginCredential()
    {
        return new Object[][] {{"admin","manager"}};
    }

    @DataProvider(name = "createUserData")
    public Object[][] getUserData()
    {
        return new Object[][] {{"Hanamant","Mudalagi","hanamant@gmail.com","hanamantm","han@123"}};
    }

    @DataProvider(name = "ModifyUserdata")
    public Object[][] getModifyUserData()
    {
        return new Object[][] {{"Hanamant","Mudalagi","Pavan","Gouda"}};
    }
    @DataProvider(name = "deleteUserdata")
    public Object[][] getDeleteUserData()
    {
        return new Object[][] {{"Pavan, Gouda"}};
    }
}
