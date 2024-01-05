package com.yusuf.crudedemo;

import com.yusuf.crudedemo.dao.AppDao;
import com.yusuf.crudedemo.entity.Instructor;
import com.yusuf.crudedemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudedemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
//			Ekleme İşlemini gerçekleştirken de cascade olduğu için instructor_detail'de silinecektir
//			createInstructor(appDao);

//			findInstructor(appDao);

//			Silme İşlemini gerçekleştirken de cascade olduğu için instructor_detail'de silinecektir
//			deleteInstructor(appDao);


		};
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
		Instructor tempInstructor = new Instructor("Fatma","Pehlivan","salladim@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com","Make a fitness");
		tempInstructor.setInstructorDetail(instructorDetail);

		// Cascade all olduğu için aynı zamanda InstrutorDetail'e de kaydedilmiş olacak.

		System.out.println("Saving instructor: "+ tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done");
	}
}
