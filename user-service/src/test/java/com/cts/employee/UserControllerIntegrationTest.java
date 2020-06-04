package com.cts.employee;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cts.employee.UserServiceApplication;

@SpringBootTest(classes = UserServiceApplication.class ,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ExtendWith(SpringExtension.class)
public class UserControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	HttpHeaders headers = new HttpHeaders();
	TestRestTemplate restTemplate = new TestRestTemplate(); 
	
	@Test
	public void test() throws Exception {
		String url = "http://localhost:"+port+"/registerall";
		System.out.println("port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		String expected ="  {\r\n" + 
				"        \"id\": 6239,\r\n" + 
				"        \"name\": \"prudhvi\",\r\n" + 
				"        \"empId\": 845138,\r\n" + 
				"        \"email\": \"prudhvi@gmail.com\",\r\n" + 
				"        \"password\": \"prudhvi@97\",\r\n" + 
				"        \"cpassword\": \"prudhvi@97\",\r\n" + 
				"        \"business_unit\": \"cde\",\r\n" + 
				"        \"location\": \"chennai\",\r\n" + 
				"        \"phone\": 9493847930,\r\n" + 
				"        \"userType\": \"ROLE_USER\",\r\n" + 
				"        \"accept\": true,\r\n" + 
				"        \"regstatus\": null,\r\n" + 
				"        \"active\": false\r\n" + 
				"    }";
		
		System.out.println("TEST ::Response body:::: "+response.getBody() );
		assertTrue(response.getBody().contains(expected));
	}

}

