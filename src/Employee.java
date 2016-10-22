/**
 * @author Isaac Allen
 *
 */

public abstract class Employee {
	protected String firstName;
	protected String secondName;
	
	protected double salary;
	protected double overTime;
	
	protected double hourlyRate;
	final static double NORMAL_WORKWEEK = 37.5;
	
	protected double calculateSalary(double numHours){ //Calculate Salaries
		if (hourlyRate > 0){
			if (numHours <= NORMAL_WORKWEEK){
				salary = numHours*hourlyRate;
			}
			else if (numHours > NORMAL_WORKWEEK){
				salary = NORMAL_WORKWEEK*hourlyRate;
				calculateOvertime(numHours);
				salary += overTime;				
			}
		}
		return salary;
	}
	
	protected double calculateOvertime(double numHours){
		if(numHours > NORMAL_WORKWEEK){
			overTime = (numHours - NORMAL_WORKWEEK);
			overTime = (overTime*(hourlyRate*2));
		}
		else if(numHours <= NORMAL_WORKWEEK){
			overTime = 0.00;
		}
		return overTime;
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
	
	public double getSalary(){
		return salary;
	}
	
	//Setters
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setSecondName(String secondName){
		this.secondName = secondName;
	}
	
	public void setHourlyRate(double hourlyRate){
		if (hourlyRate > 0){
			this.hourlyRate = hourlyRate;
		}
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public String toString(){
		return "Firstname="+"firstName"
				+"Secondname="+"secondName"
				+"Hourly="+"hourlyRate"
				+"Overtime="+"overTime"
				+"Salary="+"salary";
	}
}