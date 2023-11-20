package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.endPoints.EndPoints;
import com.shaft.driver.SHAFT;

import io.restassured.response.Response;

public class Api_TC {
	   private Response response;
	   private static SHAFT.API api = new SHAFT.API("https://www.boredapi.com/api/");
	  
	   @Test
	   public void VerifyActivitySchema() {
		   response = api.get(EndPoints.activity).perform();
		   int actualStatusCode = response.getStatusCode();
		   Assert.assertEquals(actualStatusCode, 200);
		   api.assertThatResponse().matchesSchema("src/main/resources/Schema/Activity_Schema.json").perform();
	   }

}
