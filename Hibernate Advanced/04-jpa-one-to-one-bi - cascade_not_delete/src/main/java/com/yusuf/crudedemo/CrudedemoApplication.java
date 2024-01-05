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

//			findInstructorDetail(appDao);
//			Silme İşlemini gerçekleştirken de cascade olduğu için instructor'da silinecektir
			deleteInstructorDetail(appDao);

		};
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
		Instructor tempInstructor = new Instructor("Dusab","Tadic","salladim@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com","play a football match");
		tempInstructor.setInstructorDetail(instructorDetail);

		// Cascade all olduğu için aynı zamanda InstrutorDetail'e de kaydedilmiş olacak.

		System.out.println("Saving instructor: "+ tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done");
	}
}
