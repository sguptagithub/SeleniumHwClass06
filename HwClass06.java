package class06Hw;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

    public class HwClass06 extends CommonMethods {
        public static void main(String[] args) {
        /*task: HW:
        go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
        click on PIM
        from the table choose any ID
        and print out the row number of that id
        please make sure that ur code is dynamic enough to cater if another row gets deleted ,
        it still prints the row correctly  */

            String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
            String browser="chrome";
            openBrowserAndLaunchApplication(url,browser);
            WebElement userName=driver.findElement(By.xpath("//input[@id='txtUsername']"));
            userName.sendKeys("Admin");

            WebElement passWord=driver.findElement(By.xpath("//input[@id='txtPassword']"));
            passWord.sendKeys("Hum@nhrm123");

            driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

            WebElement PIM=driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
            PIM.click();

            List<WebElement> allIDS=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

            // look for 54714A
            for(int i=0;i<allIDS.size();i++){
                String idText=allIDS.get(i).getText();
                if(idText.equals("54714A")){
                    System.out.println("The id is on row number "+(i+1));
                }
            }
        }
    }

