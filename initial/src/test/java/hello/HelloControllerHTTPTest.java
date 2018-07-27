package hello;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerHTTPTest {
	
	@LocalServerPort
	private int port;
	
	private URL base;
	
	@Autowired
	private TestRestTemplate template;
	
	@Before
	public void setUp() throws Exception{
		this.base = new URL("http://localhost:" + port + "/");
	}
	
	@Test
	public void getHello() throws Exception{
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	}
	
	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		String defaultName = "Hello, Stranger!";
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.template.getForEntity(
				base.toString() + "/hello-world", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().get("content"), equalTo(defaultName));
	}

	@Test
	public void shouldReturnNameWhenSendingRequestToController() throws Exception {
		
		String name = "Happy_User";
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.template.getForEntity(
				base.toString() + "/hello-world?name="+name, Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().get("content"), equalTo(String.format("Hello, %s!", name)));
	}
	
}
