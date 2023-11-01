package com.npci.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Employee;

// DriverManagerDataSource >> LocalSessionFactoryBean >> HibernateTEmplate>> EmployeeDaoORMImpl
// Sprig container must create this dao object and supply the HibernateTemplate
// <bean id="dao" class="com.npci.dao.EmployeeDaoORMImpl">
// <property name ="template" ref="hibernateTemplateBean">  </bean>

@Repository // bean id=employeeDaoORMImpl
public class EmployeeDaoORMImpl implements EmployeeDao {
     @Autowired
	private HibernateTemplate template; // generate setter

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
//	@Transactional 
	public Employee save(Employee employee) {
		//save method returns serializable id that is generated
		int id=(int)template.save(employee);
		//now using the id you can get the employee object
		return findById(id) ;
	}

	@Override
	public Employee findById(int id) {
		//internally query select * from employee where primaryKey=idValue
		// returns null if not present
		return template.get(Employee.class , id) ;
	}

	@Override
	public List<Employee> findAll() {
		// loadAll() -> select * from employee -> each record is added as an employee in the List<T>
		// it always gives in List hence we have use List as return Type
		return template.loadAll(Employee.class);
	}

	@Override
//	@Transactional
	public void delete(int id) {
		Employee e=findById(id);
		if(e!=null)
		{
			// delete(T t) -> delete from employee where id=employee.getId();
			// delete based on primary key condition
			template.delete(e);
		}
		
	}
	   
   
}
