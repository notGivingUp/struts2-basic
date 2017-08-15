package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transaction;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Employee;
import action.EmployeeDAO;

public class EmployeeAction extends ActionSupport{
	//private static SessionFactory factory;
	private static SessionFactory factory=new Configuration().configure().buildSessionFactory();
	EmployeeDAO employeeDAO = new EmployeeDAO();
	Employee employee = new Employee();
	List<Employee> employeeList = new ArrayList<Employee>();
	public String event;
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	//save customer
	@SuppressWarnings("unchecked")
	
	public String addEmployee() throws Exception{
		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return SUCCESS;

	}

	//list all customers
	public String listEmployee() throws Exception{

		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			employeeList=session.createQuery("FROM Employee").list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return SUCCESS;

	}
//		public String delete() throws Exception {
//			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
//			employeeDAO.deleteEmployee(Integer.parseInt((request.getParameter("id"))));
//			//System.out.println(Integer.parseInt((request.getParameter("id"))));
//			listEmployee();
//			return SUCCESS;
//			
//		}
//
//		public String editDetails(){
//			Employee selectedEmployee;
//			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
//			selectedEmployee = employeeDAO.getEmployeeByID(Integer.parseInt((request.getParameter("id"))));
//			request.setAttribute("selectedEmployee", selectedEmployee);
//			try {
//				listEmployee();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return SUCCESS;
//		}
		public String edit(){
			employeeDAO.editEmployee(employee);
			
			try {
				listEmployee();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}
		
		public String eventAction() throws Exception{
			Employee selectedEmployee;
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
					.get(ServletActionContext.HTTP_REQUEST);
			String employId = request.getParameter("id");
			//String event = request.getParameter("event");
			
			if (event.equals("delete")) {
				System.out.println(event);
				employeeDAO.deleteEmployee(Integer.parseInt(employId));
				listEmployee();
				return "delete";
			} else if (event.equals("edit")) {
				// Employee selectedEmployee;
				System.out.println(event);
				System.out.println("edit" + employId);
				selectedEmployee = employeeDAO.getEmployeeByID(Integer.parseInt(employId));
				request.setAttribute("selectedEmployee", selectedEmployee);
				try {
					listEmployee();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "edit";
			} else
				return SUCCESS;
		}
}