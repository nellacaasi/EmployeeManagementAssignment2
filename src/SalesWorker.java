/**
 * @author Isaac Allen
 *
 */

public class SalesWorker extends Employee{
	
	private double salesBonusPercentage;
	
	public SalesWorker(String firstName, String secondName, double hourlyRate, double salesBonusPercentage){
		this.firstName = firstName;
		this.secondName = secondName;
		if (hourlyRate >= 0){
			this.hourlyRate = hourlyRate;
		}
	}
	
	protected double calculateSalary(double numHours){
		super.calculateSalary(numHours);
		double salesBonus = ((salary/100)*(salesBonusPercentage));
		salary+= salesBonus;
		return salary;
	}
	
	//Getters
	public double getSalesBonusPercentage(){
		return salesBonusPercentage;
	}
	
	//Setters
	public void setSalesBonusPercentage(double salesBonusPercentage){
		if((salesBonusPercentage < 20)&&(salesBonusPercentage >= 0)){
			this.salesBonusPercentage = salesBonusPercentage;
		}
		else{
			this.salesBonusPercentage = 0;
		}
	}
	
	public String toString(){
		return "Firstname="+"firstName"
				+"Secondname="+"secondName"
				+"Hourly="+"hourlyRate"
				+"Salesbonuspercentage="+"salesBonusPercentage";
	}
}
