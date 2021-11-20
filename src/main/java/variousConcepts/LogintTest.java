package variousConcepts;

public class LogintTest {
    
	
	static WebDriver driver; 
	
	public static void main(String[] args) throws InterruptedException{
		launchBrowser();
		loginTest();
		tearDown();
		
		launchBrowser();
		negloginTest();
		tearDown();
	}

		
	public static void launchbrowser() {
		System.out.println("Launch Browser");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(60, Timeout.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void loginTest() throws InterruptedException {
		System.out.println("Login Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
	}

	
	public void negloginTest() throws InterruptedException {
		System.out.println("neg Login Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.className("btn btn-success block full-width")).click();
		Thread.sleep(5000);
	}

	
	public void tearDown() {
		System.out.println("Tear Down");

		driver.close();

	}

}
