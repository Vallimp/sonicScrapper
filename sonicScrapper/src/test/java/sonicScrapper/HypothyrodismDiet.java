package sonicScrapper;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HypothyrodismDiet extends BaseClass {
	 List<String> recID=new ArrayList<String>();
	  List<String> recName=new ArrayList<String>();
	  List<String> PrepTime=new ArrayList<String>();
	  List<String> CookTime=new ArrayList<String>();
	  List<String> Ingredient=new ArrayList<String>();
	  List<String> Method=new ArrayList<String>();
	  List<String> Nutrientvalues=new ArrayList<String>();
	  List<String> RecURL=new ArrayList<String>();
	  
	
//  ********************************** LAUNCH BROWSER AND OPEN PAGE  **********************************
		@Test(priority=1)
		public void hypertensionCategory() throws InterruptedException, IOException, InvalidFormatException {
		System.out.println("Opening tarladalal website ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//    
	Thread.sleep(500);
		
		WebElement search=driver.findElement(By.xpath("//div[@id='search']/input[@id='ctl00_txtsearch']"));
		search.sendKeys("vegetarian recipes for high blood pressure"+Keys.ENTER);
		
		}

		@Test(priority=2)
		public  void scrapeData() throws InterruptedException, IOException {
	
	
	  WebElement recipies = driver.findElement(By.xpath("//div[contains(text(),'RECIPES')]"));
	  
	  recipies.click();
	  	  Thread.sleep(500);
	 
	  //Thread.sleep(500);
	  
	  WebElement diabeticrecipes = driver.findElement(By.xpath("//a[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealtht335']"));
	  diabeticrecipes.click();
	  

	List<String> diabeticEliminateSet = new LinkedList<String>();
	diabeticEliminateSet.add("Cakes");
	diabeticEliminateSet.add("Pastries");
	diabeticEliminateSet.add("White bread"); 
	diabeticEliminateSet.add("Fried food");
	diabeticEliminateSet.add("Pizza"); 
	diabeticEliminateSet.add("Burger");
	diabeticEliminateSet.add("Carbonated beverages"); 
	diabeticEliminateSet.add("Sugary foods (sweets, icecreams) and beverages (soda, juices)");
	diabeticEliminateSet.add("Red meat");
	diabeticEliminateSet.add("Processed meat");
	diabeticEliminateSet.add("Dairy");
	diabeticEliminateSet.add("Soy products");
	diabeticEliminateSet.add("Gluten"); 
	diabeticEliminateSet.add("Pasta");
	diabeticEliminateSet.add("White rice");
	diabeticEliminateSet.add("Doughnuts");
	diabeticEliminateSet.add("Fries");
	diabeticEliminateSet.add("Coffee");
	diabeticEliminateSet.add("Seed oils- vegetable oil, soybean oil, canola oil, rapeseed oil, sunflower oil, safflower oil");


	  String xlpath="C:\\Users\\mohan\\eclipse-workspace\\sonicScrapper\\src\\test\\java\\sonicScrapper\\Eliminated_List.xlsx";
	  XLUtility xlutil=new XLUtility(xlpath);
	  
	  
	  //Write headers in excel sheet
	  xlutil.setCellData("PCOS", 0, 0, "Recipe ID");
	  xlutil.setCellData("PCOS", 0, 1, "Recipe Name");
	  xlutil.setCellData("PCOS", 0, 2, "Preaption Time");
	  xlutil.setCellData("PCOS", 0, 3, "Cooking Time");
	  xlutil.setCellData("PCOS", 0, 4, "Ingredients");
	  xlutil.setCellData("PCOS", 0, 5, "Method");
	  xlutil.setCellData("PCOS", 0, 6, "Nutrient values");
	  xlutil.setCellData("PCOS", 0, 7, "Recipe URL");
	  xlutil.setCellData("PCOS", 0, 8, "Targeted Morbidity condition");
	  xlutil.setCellData("PCOS", 0, 9, "Food Category");
	  
	  
	 
	  Thread.sleep(500);
	  int  sizePagination = driver.findElements(By.xpath("//*[@id=\"pagination\"]/a")).size();
	  System.out.println("No of Page" +sizePagination);
	  
	 
	   
	  int noofrecipes=driver.findElements(By.xpath("//div[2]//article[@class='rcc_recipecard']")).size();
	  System.out.println("No of Recipe" +noofrecipes);
	  
	  int k = 1;
	  for(int i=1;i<=sizePagination;i++)  //this is for Pagination
	  {
	    for(int j=1;j<=noofrecipes;j++)   //this is for recipes card
	    {
	     // Thread.sleep(2000);
			
			  WebElement recipeID =
			  driver.findElement(By.xpath("//article["+j+"]/div[2]/span"));
			  
			  System.out.println(recipeID.getText());
			  recID.add(driver.findElement(By.xpath("//article["+j+"]/div[2]/span")).
			  getText());
			 
	      
			/*
			 * WebElement ReceipeId =
			 * driver.findElement(By.xpath("(//div[@class='recipelist']//article)["+i+
			 * "]/div[@class='rcc_rcpno']/span")); String ReceiptIdSubstring =
			 * ReceipeId.getText(); String FinalReceiptId =
			 * ReceiptIdSubstring.split("\\n")[0].split(" ")[1]; recID.add(FinalReceiptId);
			 * System.out.println(FinalReceiptId);
			 */
	      
	      
	      //Thread.sleep(2000);
	      WebElement recipeName= driver.findElement(By.xpath("//article["+j+"]/div[3]/span[1]/a"));
	      
	      System.out.println(recipeName.getText());
	      recName.add(driver.findElement(By.xpath("//article["+j+"]/div[3]/span[1]/a")).getText());
	      
	      //Thread.sleep(2000);
	      System.out.println(recID.size());
	      //System.out.println(recName.size());
	    
	  
	      recipeName.click();
	      
	     // Thread.sleep(2000);
	      WebElement preaptime=driver.findElement(By.xpath("//time[@itemprop='prepTime']"));
	      System.out.println(preaptime.getText());


	      PrepTime.add(driver.findElement(By.xpath("//time[@itemprop='prepTime']")).getText());
	      
	     // Thread.sleep(2000);
	      WebElement cooktime=driver.findElement(By.xpath("//time[@itemprop='cookTime']"));
	      System.out.println(cooktime.getText());
	      CookTime.add(driver.findElement(By.xpath("//time[@itemprop='cookTime']")).getText());
	      
	      //Thread.sleep(2000);
	      WebElement ingredient=driver.findElement(By.xpath("//*[@id=\"rcpinglist\"]"));
	      System.out.println(ingredient.getText());
	      Ingredient.add(driver.findElement(By.xpath("//*[@id=\"rcpinglist\"]")).getText());
	      
	      List<WebElement> ingredientDivs = driver.findElements(By.xpath("//*[@id='rcpinglist']/div/span"));
	      Boolean isIngFoundInElList = false;  
	      System.out.println("ingredientDivs Size: " + ingredientDivs.size());
	      for(int ing=0;ing<ingredientDivs.size();ing++) {
	      // if(isIngFoundInElList) {
	        //break;
	       //}
	       WebElement ingDiv = ingredientDivs.get(ing);
	       String ingredientText = ingDiv.getText();
	       System.out.println("Ing Div Text: " + ingDiv.getText());
	       
	       for(int x=0;x<diabeticEliminateSet.size();x++) {
	         if(ingredientText.contains(diabeticEliminateSet.get(x))) {
	           isIngFoundInElList = true;
	           break;
	          
	         }
	       
	       }
	       if(isIngFoundInElList)
	       {
	         break;
	       }
	       
	     }
	     if(isIngFoundInElList) 
	     {
	       System.out.println("******************Skipping current recipe.***************** " +recName);
	       //continue;
	     }
	     else 
	     {
	      
	      //Thread.sleep(2000);
	      WebElement method=driver.findElement(By.xpath("//*[@id=\"ctl00_cntrightpanel_pnlRcpMethod\"]"));
	      System.out.println(method.getText());
	      Method.add(driver.findElement(By.xpath("//*[@id=\"ctl00_cntrightpanel_pnlRcpMethod\"]")).getText());
	      
	      
	      
	      
	      //Thread.sleep(2000);
	      WebElement nutrivalue=driver.findElement(By.xpath("//*[@id=\"rcpnuts\"]"));
	      System.out.println(nutrivalue.getText());
	      Nutrientvalues.add(driver.findElement(By.xpath("//*[@id=\"rcpnuts\"]")).getText());
	      
	      //Thread.sleep(3000);
	      String url=driver.getCurrentUrl();   
	      System.out.println( driver.getCurrentUrl());
	      RecURL.add(url);
	      
	      
	      
	      k++;
	      
	        xlutil.setCellData("PCOS",k,0,recID.get(0));
	        xlutil.setCellData("PCOS",k,1, recName.get(0));
	        xlutil.setCellData("PCOS",k, 2, PrepTime.get(0));
	        xlutil.setCellData("PCOS", k, 3, CookTime.get(0));
	        xlutil.setCellData("PCOS", k, 4, Ingredient.get(0));
	        xlutil.setCellData("PCOS", k, 5, Method.get(0));
	        xlutil.setCellData("PCOS", k, 6, Nutrientvalues.get(0));
	        xlutil.setCellData("PCOS", k, 7, RecURL.get(0));
	        xlutil.setCellData("PCOS", k, 8, "PCOS");
	        xlutil.setCellData("PCOS", k, 9, "Vegetarian");
	        
	     
	  
	    }
	    recID.clear();
	     recName.clear();
	     PrepTime.clear();
	     CookTime.clear();
	     Ingredient.clear();
	     Method.clear();
	     Nutrientvalues.clear();
	     RecURL.clear();
	     
	     
	    driver.navigate().back();
	  }
	  driver.findElement(By.xpath("//*[@id=\"pagination\"]/a["+i+"]")).click();
	  
	  
	}


	}

	}

