/**
 * 
 */
package ph.com.hibernate.component;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ph.com.hibernate.dao.SpringHibernateDao;
import ph.com.hibernate.model.Employee;

/**
 * @author Eddie
 *
 */
@Component
@RequestMapping("/SpringHibernate")
public class SpringHibernateComponent {

	@Autowired
	private SpringHibernateDao springHibernateDao;
	
	@RequestMapping("/welcome")
	public @ResponseBody String getWelcomeComponent() {
		
		String home = "<h2>Welcome!!</h2>";
		return home;
	}
	
	@RequestMapping("/insertEmployee/{name}/{age}/{position}/{contactNumber}/{emailAddress}")
	public @ResponseBody String insertEmployee(@PathVariable("name") String name, @PathVariable("age") int age,
			@PathVariable("position") String position, @PathVariable("contactNumber") String contactNumber, 
			@PathVariable("emailAddress") String emailAddress) {
		
		Employee employee = new Employee(name, age, position, contactNumber, emailAddress);
		Map<String,String> responseMap = springHibernateDao.insertEmployee(employee);
		String msg = responseMap.get("msg");
		
		return msg;
	}
	
	@RequestMapping("/removeEmployee/{id}")
	public @ResponseBody String removeEmployee(@PathVariable("id") int id) {
		
		Map<String,String> responseMap = springHibernateDao.deleteEmployee(id);
		String msg = responseMap.get("msg");
		
		return msg;
	}
	
	@RequestMapping("/updateEmployee//{id}/{name}/{age}/{position}/{contactNumber}/{emailAddress}")
	public @ResponseBody String updateEmployee(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("age") int age,
			@PathVariable("position") String position, @PathVariable("contactNumber") String contactNumber, 
			@PathVariable("emailAddress") String emailAddress) {
		
		Employee employee = new Employee(id,name, age, position, contactNumber, emailAddress);
		Map<String,String> responseMap = springHibernateDao.updateEmployee(employee);
		String msg = responseMap.get("msg");
		
		return msg;
	}
	
	@RequestMapping("/getAllEmployee")
	public @ResponseBody String getAllEmployee() {
		
		String output = "";
		Map<String,Object> responseMap = springHibernateDao.getAllEmployee();
		
		List<Employee> employeeList = (List<Employee>)responseMap.get("result");
				
		ObjectMapper mapper = new ObjectMapper();
		try {
			output = mapper.writeValueAsString(employeeList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String errMsg = (String)responseMap.get("msg"); 
		if (errMsg != null && !errMsg.isEmpty()) {
			return errMsg;
		}
		return output;
	}
}
