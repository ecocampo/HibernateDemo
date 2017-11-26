package ph.com.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ph.com.hibernate.dao.SpringHibernateDao;
import ph.com.hibernate.model.Employee;

@Repository
@Transactional
public class SpringHibernateDaoImpl implements SpringHibernateDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Map<String,String> insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Map<String,String> responseMap = new HashMap<String,String>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			//Transaction txn = session.beginTransaction();
			//txn.begin();
			session.save(employee);
			//txn.commit();
		    responseMap.put("msg","Successfully inserted employee records.");
		
		} catch (Exception e) {
			System.err.println(e);
			responseMap.put("msg", e.getMessage());
		}
		
		return responseMap;
	}

	@Override
	public Map<String, String> deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		Map<String,String> responseMap = new HashMap<String,String>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Employee employee = (Employee)session.load(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
				responseMap.put("msg", "Record deleted successfully!");
			} else {
				responseMap.put("msg", "No record has been deleted!");
			}
		
		} catch (Exception e) {
			System.err.println(e);
			responseMap.put("msg", e.getMessage());
		}
		
		return responseMap;
	}

	@Override
	public Map<String, String> updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Map<String,String> responseMap = new HashMap<String,String>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			if (employee != null) {
				session.update(employee);
				responseMap.put("msg","Record has been updated successfully!");
			} else {
				responseMap.put("msg","Record has not been updated!");
			}
					
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			responseMap.put("msg", e.getMessage());
		}
		
		return responseMap;
	}

	@Override
	public Map<String, Object> getAllEmployee() {
		// TODO Auto-generated method stub
		Map<String,Object> responseMap = new HashMap<String,Object>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			List<Employee> employeeList = (List<Employee>)session.createQuery("from Employee").list();
		    responseMap.put("result", employeeList);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			responseMap.put("msg", e.getMessage());
		}
		
		return responseMap;
	}

	
}
