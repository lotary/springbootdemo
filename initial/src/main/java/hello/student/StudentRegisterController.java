package hello.student;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRegisterController {

	@RequestMapping(method= RequestMethod.POST, value="/register/student")
	StudentRegistrationReply registerStudent(@RequestBody StudentRegistration studentregd) {
		StudentRegistrationReply stdRegReply = new StudentRegistrationReply();
		stdRegReply.setName(studentregd.getName());
		stdRegReply.setAge(studentregd.getAge());
		stdRegReply.setRegistrationNumber("12345667");
		stdRegReply.setRegistrationStatus("Successful");
		
		return stdRegReply;
	}
	
}
