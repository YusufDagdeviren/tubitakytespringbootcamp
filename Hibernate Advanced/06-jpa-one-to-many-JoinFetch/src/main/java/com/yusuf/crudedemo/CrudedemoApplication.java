package com.yusuf.crudedemo;

import com.yusuf.crudedemo.dao.AppDao;
import com.yusuf.crudedemo.entity.Course;
import com.yusuf.crudedemo.entity.Instructor;
import com.yusuf.crudedemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudedemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
			// Ekleme İşlemini gerçekleştirken de cascade olduğu için instructor_detail'de silinecektir
//			createInstructor(appDao);

//			findInstructor(appDao);

			// Silme İşlemini gerçekleştirken de cascade olduğu için instructor_detail'de silinecektir
//			deleteInstructor(appDao);

//			findInstructorDetail(appDao);
			// Silme İşlemini gerçekleştirken de cascade olduğu için instructor'da silinecektir
//			deleteInstructorDetail(appDao);

			// Kurs ile birlikte Instructor_Detail'de beraber olmak üzere ekledik
//			createInstructorWithCourses(appDao);

			// EagerLoading ile bütün kursları çağırdık
//			findInstructorWithCourses(appDao);

			// LazyLoading ile ihtiyaç halinde çağırdık.
//			findCoursesForInstructor(appDao);

			// Projeyi EagerLoading'e bağımlı yapmadan istediğimizde Eager yapma imkanı sundu
//			findInstructorWithCoursesJoinFetch(appDao);

			updateInstructor(appDao);
		};
	}

	private void updateInstructor(AppDao appDao) {
		int theId = 1;
		// find the instructor
		System.out.println("Finding instructor id : "+theId);
		Instructor instructor = appDao.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: "+theId);

		instructor.setLastName("Tadfico");
		appDao.update(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int theId = 1;

		System.out.println("Finding instructor id : "+ theId);
		Instructor instructor = appDao.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor is : "+ instructor);
		System.out.println("Course of Instructer are: "+ instructor.getCourses());

	}

	private void findCoursesForInstructor(AppDao appDao) {
		int theId = 1;
		// Lazy loading olduğu için Instructor'ın kursları gelmedi henüz
		Instructor instructor = appDao.findInstructorById(theId);
		System.out.println("Temp Instructor: "+ instructor);

		// Lazy loading ile ihtiyacımız olduğunda kurslarımızı aldık
		List<Course> courses = appDao.findCoursesByInstructor(theId);
		instructor.setCourses(courses);
		System.out.println("the associated courses: " + instructor.getCourses());

	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		// Default olarak @OneToMany ilişkimiz lazy olduğu için aşağıdaki kodda exception alırız kısa ve kötü çözüm için eager yap.
		System.out.println("the associated courses: "+ tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Dusan","Tadic","salladim@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com","play a football match");
		tempInstructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course tempCourse1 = new Course("How to make star stealing");
		Course tempCourse2 = new Course("How to pass the ball");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		// Instructor'ı save yaptığımız zaman CascadeType.PERSIST olduğundan dolayı aynı zamanda Course ve InstructorDetail'de kaydolacak
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: "+ tempInstructor.getCourses());
		appDao.save(tempInstructor);
		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id = 3;
		System.out.println("Delete by id for InstructorId: "+id);
		appDao.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDao appDao) {
		int id = 2;
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
		System.out.println("Instructor detail's detail : "+instructorDetail);
		System.out.println("Instructor of Instructor_detail: "+instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Delete by id for Instructor: "+id);
		appDao.deleteInstructorById(id);

	}

	private void findInstructor(AppDao appDao) {
		Instructor instructor = appDao.findInstructorById(2);
		System.out.println(instructor);
	}

	private void createInstructor(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Dusan","Tadic","salladim@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com","play a football match");
		tempInstructor.setInstructorDetail(instructorDetail);

		// Cascade all olduğu için aynı zamanda InstrutorDetail'e de kaydedilmiş olacak.

		System.out.println("Saving instructor: "+ tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done");
	}
}
