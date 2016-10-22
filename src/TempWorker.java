/**
 * @author Isaac Allen
 *
 */

public class TempWorker extends Employee{
	
	public TempWorker(String firstName, String secondName, double hourlyRate){
		this.firstName = firstName;
		this.secondName = secondName;
		if (hourlyRate > 0){
			this.hourlyRate = hourlyRate;
		}
	}

	protected double calculateSalary(double numHours){
		super.calculateSalary(numHours);
		return salary;
	}
	
	public String toString(){
		return "Firstname="+"firstName"
				+"Secondname="+"secondName"
				+"Hourly="+"hourlyRate";
	}
}
