package heritage.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Home {
    public WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Ayushi Automation\\Heritage_\\src\\main\\java\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  // Allow all origins for WebSocket connections
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://heritagepartscentre.com/uk/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("Heritage"));
        return driver;
    }

    public void takeScreenshot(WebDriver driver) {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("Homepage.png"));
            System.out.println("Full-page screenshot taken and saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Home home = new Home();
        WebDriver driver = home.setup();
        home.takeScreenshot(driver);

        Smoketesting smoketesting = new Smoketesting(driver);
        smoketesting.runTests();


    }
    }

