package Pages;

public class TestClass {
    public static void main(String[] args) {
        baseDP.setupBrowser("chrome");
        baseDP.navigateToURL("https://demo.nopcommerce.com/");
       
        baseDP.tearDownBrowser();
    }
}
