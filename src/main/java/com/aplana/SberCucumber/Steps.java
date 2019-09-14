package com.aplana.SberCucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.IpotekaPage;
import pages.MainPage;
import steps.BaseSteps;
import util.TestProperties;

import java.util.concurrent.TimeUnit;

public class Steps extends BaseSteps {

    WebDriver driver;
    BasePage basePage = new BasePage();
    IpotekaPage ipotekaPage = new IpotekaPage();
    MainPage mainPage = new MainPage();



    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", TestProperties.getInstance().getProperty("path.chrome"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TestProperties.getInstance().getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*mainPage = PageFactory.initElements(driver, MainPage.class);
        ipotekaPage = PageFactory.initElements(driver, IpotekaPage.class);*/
    }



    @Когда("открывается главная страница")
    public void openMain(){
    }
    @Когда("на меню \"Ипотека\" наведен курсор")
    public void cursor() {
        new MainPage().menu();
    }

    @Тогда("проверено, что открылось выпадающее меню")
    public void checkmenu() {
        new MainPage().goToIpoteka();
    }

    @Когда("заполнено поле стоимость недвижимости значением (.*)")
    public void fillPropVal(String propertyPriceVal) {
        new IpotekaPage().fillPropertyPrice(propertyPriceVal);
    }

    @Когда("заполнено поле первоначальный взнос значением (.*)")
    public void fillInitialFee(String initialFeeVal) {
        new IpotekaPage().fillInitialFee(initialFeeVal);
    }

    @Когда("заполнено поле скрок кредита значением (.*)")
    public void fllPropVal(String creditTermVal) {
        new IpotekaPage().fillCreditTerm(creditTermVal);
    }

    @Когда("выставляем галочку молодая семья")
    public void set() {
        new IpotekaPage().offSalaryCard();
        new IpotekaPage().waitForTextReference();
        new IpotekaPage().onYoungFamily();
        new IpotekaPage().offReference();
    }

    @Тогда("проверяем значение поля Сумма кредита (.*)")
    public void check1(String creditSumVal) {
        new IpotekaPage().checkCreditSum(creditSumVal);
    }

    @Тогда("проверяем значение поля Ежемесячный платеж (.*)")
    public void check2(String monthlyPaymentVal) {
        new IpotekaPage().checkMonthlyPayment(monthlyPaymentVal);
    }

    @Тогда("проверяем значение поля Необходимый доход (.*)")
    public void check3(String requiredIncomeVal) {
        new IpotekaPage().checkRequiredIncome(requiredIncomeVal);
    }

    @Тогда("проверяем значение поля Процентная ставка (.*)")
    public void check4(String interestRateVal) {
        new IpotekaPage().checkInterestRate(interestRateVal);
    }




}
