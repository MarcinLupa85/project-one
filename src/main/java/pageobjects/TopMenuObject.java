package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class TopMenuObject {


    public TopMenuObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/kontakt'].nav-link")
    private WebElement contactLink;

    @FindBy(css = "a[href='/team'].nav-link")
    private WebElement aboutUsLink;

    @FindBy(css = "a[href='/spørsmål-og-svar/on-the-go'].nav-link")
    private WebElement faqLink;

    @FindBy(css = "a[href='/home'].navbar-brand")
    private WebElement homeLink;

    @FindBy(css = "a[href='/ladestasjoner'].nav-link")
    private WebElement otgLink;

    @FindBy(css = "a[href='/hjemmelading'].nav-link")
    private WebElement houseLink;

    @FindBy(css = "a[href='/sameie-borettslag'].nav-link")
    private WebElement apartmentLink;

    //czy openUtbyggerPage() zadziala, jesli ten element jest na poczatku niewidoczny?
    @FindBy(css = "a[href='/utbygger'].nav-link")
    private WebElement utbyggerLink;

    @FindBy(css = "a[href='/bedrift'].nav-link")
    private WebElement businessLink;

    @FindBy(css = "a[href='/ladekart'].nav-link")
    private WebElement stationMapLink;

    @FindBy(css = "a[href='/nyheter/1'].nav-link")
    private WebElement newsLink;

    @FindBy(css = "a[href='/ladeapp'].nav-link")
    private WebElement joinUsLink;

    @FindBy(css = "a[href='https://www.facebook.com/circleknorge/']")
    private WebElement facebookLink;

    @FindBy(css = "a[href='https://www.instagram.com/circleknorge/']")
    private WebElement instagramLink;

    @FindBy(css = "a[href='https://www.youtube.com/playlist?list=PLOt-ClfT-VEgU-nxudMqsINMByvW94ala']")
    private WebElement youtubeLink;

    public WebElement getContactLink() {
        return contactLink;
    }
    public WebElement getAboutUsLink() {
        return aboutUsLink;
    }
    public WebElement getFaqLink() {
        return faqLink;
    }
    public WebElement getOtgLink() {
        return otgLink;
    }
    public WebElement getHouseLink() {
        return houseLink;
    }
    public WebElement getApartmentLink() {
        return apartmentLink;
    }
    public WebElement getUtbyggerLink() {
        return utbyggerLink;
    }
    public WebElement getBusinessLink() {
        return businessLink;
    }
    public WebElement getStationMapLink() {
        return stationMapLink;
    }
    public WebElement getNewsLink() {
        return newsLink;
    }
    public WebElement getJoinUsLink() {
        return joinUsLink;
    }
    public WebElement getHomeLink() {
        return homeLink;
    }
    public WebElement getFacebookLink() {
        return facebookLink;
    }
    public WebElement getInstagramLink() {
        return instagramLink;
    }
    public WebElement getYoutubeLink() {
        return youtubeLink;
    }
}
