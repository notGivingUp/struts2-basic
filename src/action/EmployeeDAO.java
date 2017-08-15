package action;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class EmployeeDAO {
	private static SessionFactory factory=new Configuration().configure().buildSessionFactory();

	public void editEmployee(Employee emloyee){
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(emloyee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public Employee listEmployeeById(int employeeId) {
		Session session= factory.openSession();
		Employee employee = null;
		try {
			employee = (Employee) session.get(Employee.class, employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	public void deleteEmployee(int id){
		Session session= factory.openSession();
		Transaction transaction=null;
		try {	
			transaction = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, id);
			session.delete(employee);
			transaction.commit();
		} catch (Exception e) {

			transaction.rollback();
			e.printStackTrace();
		}finally {
	         session.close(); 
	      }
	}
	public Employee getEmployeeByID(int employeeID){
		Session session = factory.openSession();
		Employee employee=null;
		try {
			employee=(Employee) (Employee) session.get(Employee.class, employeeID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return employee;
		
	}
}
