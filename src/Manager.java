import java.util.ArrayList;

/**
 * @author Isaac Allen
 *
 */

public class Manager extends Employee {
	
	protected ArrayList<Employee> department;
	protected double bonus;
	
	public Manager(String firstName, String secondName, double hourlyRate, double bonus){
		this.firstName = firstName;
		this.secondName = secondName;
		if(bonus >= 0){
			this.bonus = bonus;
		}
		if(hourlyRate >= 0){
			this.hourlyRate = hourlyRate;
		}
		this.department = new ArrayList<Employee>();
		
	}
	
	protected double calculateSalary(double numHours){
		if (bonus >= 0){
			super.calculateSalary(numHours);
			salary += bonus;
		}
		return salary;
	}
	
	public void addDeptEmployee(Employee e){ //Adds Employee to a department
		department.add(e);
	}
	
	public int numberInDept(){
		return department.size();
	}
	
	//Getters
	public String getFirstName(){
		return firstName;
	}
	
	public String getSecondName(){
		return secondName;
	}
	
	public double getHourlyRate(){
		return hourlyRate;
	}
	
	public double getBonus(){
		return bonus;
	}
	
	public ArrayList<Employee> getDept(){
		return department;
	}
	
	//Setters
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setSecondName(String secondName){
		this.secondName = secondName;
	}
	
	public void setHourlyRate(double hourlyRate){
		if(hourlyRate >= 0){
		this.hourlyRate = hourlyRate;
		}
	}
	
	public void setBonus(double bonus){
		if(bonus >= 0){
			this.bonus = bonus;
		}
	}
	
	public void setDept(ArrayList<Employee> department){
		this.department = department;
	}
	
	public String toString(){
		return "Firstname="+"firstName"
				+"Secondname="+"secondName"
				+"Hourly="+"hourlyRate"
				+"Bonus="+"bonus";
	}
}