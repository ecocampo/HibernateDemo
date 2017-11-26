/**
 * 
 */
package ph.com.hibernate.dao;

import java.util.Map;

import ph.com.hibernate.model.Employee;

/**
 * @author Eddie
 *
 */
public interface SpringHibernateDao {
	
	public Map<String,String> insertEmployee(Employee employee);
	public Map<String,String> deleteEmployee(int id);
	public Map<String,String> updateEmployee(Employee employee);
	public Map<String,Object> getAllEmployee();

}
