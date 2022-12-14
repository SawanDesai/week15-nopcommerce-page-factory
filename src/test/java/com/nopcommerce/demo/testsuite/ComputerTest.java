package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.Computer;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComputerTest extends BaseTest{

    Computer computer;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        computer = new Computer();
    }

    //****************************************Computer**********************
    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        computer.clickOnComputer();
        computer.clickOnDesktop();
        computer.sortProductZToA();

    }

}
