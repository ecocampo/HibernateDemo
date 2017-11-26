/**
 * 
 */
package ph.com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;


/**
 * @author Eddie
 *
 */
@Entity
@Table(appliesTo = "Employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2971660592411985261L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="position")
	private String position;
	@Column(name="contact_number")
	private String contact_number;
	@Column(name="email_address")
	private String email_address;
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, String position, String contact_number, String email_address) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.contact_number = contact_number;
		this.email_address = email_address;
	}
	
	public Employee(int id, String name, int age, String position, String contact_number, String email_address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.position = position;
		this.contact_number = contact_number;
		this.email_address = email_address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
}
