package AUCA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_registration")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_Id")
	public String student_Id;
	
	@Column(name = "first_name")
	public String first_name;
	
	@Column(name = "last_name")
	public String last_name;
	
	@Column(name = "date_of_birth")
	public String date_of_birth;

	public Student(String student_Id) {
		super();
		this.student_Id = student_Id;
	}
	


	public Student() {

}
	
public Student(String student_Id, String first_name, String last_name, String date_of_birth) {
		
		this.student_Id = student_Id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
	}

	public String getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(String student_Id) {
		this.student_Id = student_Id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}



}
