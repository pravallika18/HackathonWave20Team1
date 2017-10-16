package com.wipro.SpringRest.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.StackRoute.Goplaces.domain.Places;
import com.wipro.SpringRest.HackathonWave20Team1Application;
import com.wipro.SpringRest.domain.User;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonWave20Team1Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {


    @LocalServerPort

    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();
    User user;
    

    @Before

    public void setUp() throws Exception {
   User user=new User(1,"abcd","abc@gmail.com");
         

    }
    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;

    }

	@Test
	public void testAllPlaces() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(

                createURLWithPort("/v0.1/PlaceSearch/places"),

                HttpMethod.GET, entity, String.class);
       System.out.println(response);
        assertNotNull(response);
	}
	 @Test
	    public void testSaveUser() throws Exception {

	        HttpEntity<User> entity = new HttpEntity<User>(user, headers);

	        ResponseEntity<String> response = restTemplate.exchange(

	                createURLWithPort("/v0.1/PlaceSearch/places"),

	                HttpMethod.POST, entity, String.class);

	        assertNotNull(response);
	        System.out.println(response);
	        
	        String actual = response.getBody();

	        System.out.println(actual);

	        assertEquals("Places created successfully",actual);

	    }
}
		
