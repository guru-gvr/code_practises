package src.test.java.com.learning.jpaBasics;

import com.learning.domain.Guardian;
import com.learning.domain.Student;
import com.learning.repo.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaBasicsApplicationTests {


	@Autowired
	private StudentRepository studentRepository;
	@Test
	void contextLoads() {
		Student student = new Student();
		student.setAge(23);
		student.setEmailId("guruvedkrish12@gmail.com");
		student.setFirstName("Guru");
		student.setLastName("VedhaRamanan");
		studentRepository.save(student);
	}

	@Test
	public void saveStudentWithGuardian(){
		Student student = new Student();
		student.setAge(25);
		student.setEmailId("guruvedkrish123@gmail.com");
		student.setFirstName("Guru");
		student.setLastName("VedhaRamanan");
		student.setName("Guru VedhaRamanan.R");
		Guardian guardian = new Guardian();
		guardian.setName("Padmavathi");
		guardian.setMail("pad@gmail.com");
		guardian.setMobile("8971123450");
		student.setGuardian(guardian);

		studentRepository.save(student);

	}

}
