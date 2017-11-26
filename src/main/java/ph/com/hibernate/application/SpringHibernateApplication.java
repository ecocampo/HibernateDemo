/**
 * 
 */
package ph.com.hibernate.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Eddie
 *
 */
@SpringBootApplication(scanBasePackages={"ph.com.hibernate"})
public class SpringHibernateApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

}
