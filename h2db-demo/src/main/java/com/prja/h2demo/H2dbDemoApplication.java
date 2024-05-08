package com.prja.h2demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prja.h2demo.inheriance.joined_table.AppleJuice;
import com.prja.h2demo.inheriance.joined_table.Juice;
import com.prja.h2demo.inheriance.joined_table.OrangeJuice;
import com.prja.h2demo.inheriance.mapped_supper_class_annotation.Bus;
import com.prja.h2demo.inheriance.mapped_supper_class_annotation.Car;
import com.prja.h2demo.inheriance.mapped_supper_class_annotation.Vehical;
import com.prja.h2demo.inheriance.single_table.Apple;
import com.prja.h2demo.inheriance.single_table.Fruit;
import com.prja.h2demo.inheriance.single_table.Orange;
import com.prja.h2demo.inheriance.table_per_class.Potato;
import com.prja.h2demo.inheriance.table_per_class.Tomato;
import com.prja.h2demo.inheriance.table_per_class.Vegitable;
import com.prja.h2demo.manytomany.Skill;
import com.prja.h2demo.manytomany.Student;
import com.prja.h2demo.manytomany_self.People;
import com.prja.h2demo.onetomany.Department;
import com.prja.h2demo.onetomany.Employee;
import com.prja.h2demo.onetomany_self.EMP;
import com.prja.h2demo.onetoone.IDProof;
import com.prja.h2demo.onetoone.IDType;
import com.prja.h2demo.onetoone.Person;

@SpringBootApplication
//@PropertySource("classpath:application-h2.properties")
public class H2dbDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(H2dbDemoApplication.class, args);
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void run(String... args) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// o2o entity example		
		createEntityForOneToOne(session);

		// one to Many
		createEntityForOneToMany(session);
			
			
		// one to many  relation with self entity 		
		createEntityForOnetoManyWithSelfRelation(session);	
		
        // Many to Many         
        createEntityForManyToMany(session);
        //Many to  Many relation with  Self  Entity
        createEntityForManyToManyWithSelfRelation(session);
        
        //JPA Inheritance - Single Table 
        createEntityForSingleTableInheritance(session);
		
		
        //JPA Inheritance - Table Per Class
        
        createEntityForTablePerClassInheritance(session);
        
        //JPA Inheritance - Joined Table
        createEntityForJoinedTableInheritance(session);
        
        //JPA  Inheritance  with @MappedSuperclass 
        
       
                
        Car c= new Car();
        c.setCompanyName("Honda");
        c.setRegistrationNo("123455");
        c.setColor("RED");
        c.setNoOfWheel("4");
        
        Bus b= new Bus();
        b.setCompanyName("Volvo");
        b.setColor("Green");
        b.setRegistrationNo("86787979");
        b.setCommercial(true);
        
        session.persist(c);
        session.persist(b);
        
		session.getTransaction().commit();
		session.close();

		System.out.println("GoodBye World!");
		sessionFactory.close();
	}

	private void createEntityForJoinedTableInheritance(Session session) {
		Juice juice = new Juice();
        juice.setName("Fruit_Juice");

		AppleJuice aple2 = new AppleJuice();
		aple2.setName("AppleJuice");
		aple2.setColor("Green");
		aple2.setTaste("Meetha");

		OrangeJuice orange = new OrangeJuice();
		orange.setColor("Yellow");
		orange.setName("OrangeJuice");
		orange.setTaste("Khatta");
        
		session.persist(juice);
		session.persist(aple2);
		session.persist(orange);
	}

	private void createEntityForTablePerClassInheritance(Session session) {
		Vegitable vegitable = new Vegitable();
        vegitable.setName("Vegitable");

		Potato potato = new Potato();
		potato.setName("Potato");
		potato.setColor("Brown");
		potato.setTaste("no tast");

		Tomato tomato = new Tomato();
		tomato.setColor("Red");
		tomato.setName("Tomato");
		tomato.setTaste("Khatta ");
        
		session.persist(vegitable);
		session.persist(potato);
		session.persist(tomato);
	}

	private void createEntityForSingleTableInheritance(Session session) {
		Fruit fruit = new Fruit();
		fruit.setName("Fruit");

		Apple aple2 = new Apple();
		aple2.setName("Apple");
		aple2.setColor("Green");
		aple2.setTaste("Khatta");

		Orange orange = new Orange();
		orange.setColor("Yellow");
		orange.setName("Nagpurui Santara");
		orange.setTaste("Khatta Meetha");

		session.persist(fruit);
		session.persist(aple2);
		session.persist(orange);
	}

	private void createEntityForManyToManyWithSelfRelation(Session session) {
		People Person1 = new People("Prabhu", "Jaiswal");
        People Person2 = new People("Raj", "Verma");
        People Person3 = new People("Guru", "Dev");
        People Person4 = new People("Harry", "Pal");

        Person1.getFreinds().add(Person2);
        Person1.getFreinds().add(Person3);
        
        
        Person2.getFreinds().add(Person1);
        Person2.getFreinds().add(Person4);
        
        
        Person3.getFreinds().add(Person4);
        Person3.getFreinds().add(Person1);
        
        Person4.getFreinds().add(Person2);
        Person4.getFreinds().add(Person3);
        

		session.persist(Person1);
        session.persist(Person2);
        session.persist(Person3);
        session.persist(Person4);
	}

	private void createEntityForOneToOne(Session session) {
		IDProof idp = new IDProof();
		idp.setIdProofType(IDType.AADHAR);
		idp.setIdProofValue("493643244489");
		idp.setIssueDate("12-12-2012");
		idp.setExpiryDate("01-01-2018");

		Person p = new Person();
		p.setAge(33);
		p.setFirstName("Raj");
		p.setLastName("Kumar");
		p.setBithDate("12-12-2012");
		p.setIdProof(idp);
		session.persist(idp);

		session.persist(p);
	}

	private void createEntityForOneToMany(Session session) {
		Department d = new Department();
		d.setDeptName("SoftwareDept");
		List<Employee> list = new ArrayList<Employee>();
		for (int i = 1; i < 5; i++) {
			Employee e1 = new Employee();
			e1.setName("Atharv" + Math.random());
			e1.setAge(21 + (i + 8));
			e1.setSalary(2000 * i);
			e1.setJoiningdate(LocalDate.of(2015, i, 10 + i));
			e1.setDpt(d);
			list.add(e1);
			session.persist(e1);
		}

		d.setEmployees(list);
		session.persist(d);

		Department dd = new Department();
		dd.setDeptName("Admin");

		List<Employee> list2 = new ArrayList<Employee>();
		for (int i = 1; i < 5; i++) {
			Employee e1 = new Employee();
			e1.setName("Miku" + Math.random());
			e1.setAge(21 + (i + 8));
			e1.setSalary(2000 * i);
			e1.setJoiningdate(LocalDate.of(2015, i, 10 + i));
			e1.setDpt(dd);
			list2.add(e1);
			session.persist(e1);
		}
		dd.setEmployees(list2);
		session.persist(dd);
	}

	private void createEntityForOnetoManyWithSelfRelation(Session session) {
		EMP supermanager = new EMP();
		supermanager.setFirstname("Super Boss");
		supermanager.setLastname("Jai");
		
		EMP manager = new EMP();
		manager.setFirstname("Prabhu");
		manager.setLastname("Jaiswal");
		manager.setManager(supermanager);
        
		EMP employee1 = new EMP();
        employee1.setFirstname("Raj");
        employee1.setLastname("Kumar");
        
        EMP employee2 = new EMP();
        employee2.setFirstname("Rahul");
        employee2.setLastname("Barma");

        employee1.setManager(manager);
        employee2.setManager(manager);
        
        session.persist(supermanager);
        session.persist(manager);
        session.persist(employee1);
        session.persist(employee2);
	}

	private void createEntityForManyToMany(Session session) {
		Student p1 = new Student();
		p1.setAge(33);
		p1.setFirstName("Prabhu");
		p1.setLastName("Jaiswal");
		p1.setBithDate("12-12-2012");
		
		
		
		Student p2 = new Student();
		p2.setAge(33);
		p2.setFirstName("Atharva");
		p2.setLastName("Jaiswal");
		p2.setBithDate("12-12-2012");
		
		

		Skill skill = new Skill();
		skill.setName("Spring-Boot");
		skill.setExpertiseLevel("Expert");

		Skill skill2 = new Skill();
		skill2.setName("Angular");
		skill2.setExpertiseLevel("Expert");
		
		Skill skill3 = new Skill();
		skill3.setName("JPA");
		skill3.setExpertiseLevel("Expert");


		List<Student> studentlist = new ArrayList<Student>();
		studentlist.add(p1);
		studentlist.add(p2);

		List<Skill> skilllist = new ArrayList<Skill>();
		skilllist.add(skill);
		skilllist.add(skill2);
		skilllist.add(skill3);
		
		p1.setSkillList(skilllist);
		
		p2.setSkillList(skilllist);
		
		skill.setStudentList(studentlist);
		skill2.setStudentList(studentlist);
		skill3.setStudentList(studentlist);
		
		session.persist(p1);
		session.persist(p2);
	}

}
