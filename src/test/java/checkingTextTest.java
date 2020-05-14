import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class checkingTextTest {
    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\roseltorg\\drivers\\chromedriver.exe"); //���� � ���������� chromedriver.exe
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void checkingText() {

        // ������� �� �������� ����
        driver.get("https://yandex.ru");
        WebElement searchInput = driver.findElement(By.id("text"));
        searchInput.sendKeys("����");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//b[text()='Roseltorg.ru']")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        // ������� �� �������� ����������
        driver.findElement(By.xpath("//button[@class='auth-menu__btn auth-menu__btn--register js-register-popup-link']")).click();

        // ������� �� ����� ����������� ������ ������������
        driver.findElement(By.xpath("//a[@class='auth-window__selector-link js-supplier-register-link']")).click();
        String text = "������ ������������ ��� ������� � ������������� �������� � �������� ��������� 223-��";
        driver.findElement( By.xpath("//a[text()='" + text + "']")).click();

        // �������� ������� ������
        String foundText = "���� �� ��������� ����� ����������� ������� � ����� � ���������� ����� �������� ������, �� ��� ������� ��������� �� � ������� ������������������� ������������, � �� �������������� ������ ������������";
        if (driver.findElement(By.xpath("//div[@id='ext-gen86']")).getText().equals(foundText)){
            System.out.println("����� ������");
        } else {
            System.out.println("����� �� ������");
        }
    }

    @After
    public void stop() {
        driver.quit();
    }

}
