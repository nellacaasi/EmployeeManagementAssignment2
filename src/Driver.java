import java.util.ArrayList; //Imports ArrayList Library
import java.util.Scanner; //Imports Scanner Library

/**
 * <h1>Employee Management Assignment 2</h1><hr>
 * Programming Fundamentals 2 - Assignment 2<br>
 * First Year - BSc (Hons) in Applied Computing
 * 
 * <h3>Driver Class:</h3>
 * 
 * This class runs the application and its' user interface.
 * 
 * For more information, please refer to the accompanied ReadMe text file or view online at:
 * <a>http://www.nellacaasi.com/programming_fundamentals/2/assignment2/readme</a>
 *  
 * @author Isaac Allen - Student No: 20070915
 * @version 1.0 (22/04/2016)
 */

public class Driver {
	private Scanner input;
	private ArrayList <Employee> Employees;	
	
    public Driver(){ //Constructors
        input = new Scanner(System.in);
        Employees = new ArrayList<Employee>(); //Constructing Employees Array
    }
    
	public static void main(String[] args) throws Exception { //Main Starting Method
		Driver driver = new Driver();
		driver.runMainMenu();
	}
	
    private int mainMenu(){ //Main Menu
    	System.out.println("---------");
        System.out.println("Employee Management Main Menu");
        System.out.println("---------");
        System.out.println("  1) Configure Employees");    
        System.out.println("  2) Calculate Salaries");
        System.out.println("  3) Print Employee Details");
        System.out.println("---------");    
        System.out.println("  4) Load Existing Employees");
        System.out.println("  5) Save Existing Employees");
        System.out.println("---------");   
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    
    private void runMainMenu() throws Exception{ //Runs Main Menu
        int option = mainMenu();
        while (option != 0){
           
            switch (option){
               case 1:    runConfigureEmployeeMenu();
            	          	break;
               case 2:    runCalculateSalariesMenu();
                          	break;
               case 3:	  runPrintEmployeeDetails();
               			 	break;
               case 4:	  load();	
               				break;
               case 5:	  save();
              default:    System.out.println("Invalid option entered: " + option);
                          break;
            }
            option = mainMenu();
        }
        
    }
    
    public void load() throws Exception //Loads Employees ArrayList from XML File
    {
        Employees = HandleXML.read("Employees.xml");
    }

    public void save() throws Exception
    {
        HandleXML.write(Employees, "Employees.xml");
    }    
    
    private int configureEmployeeMenu(){ //Configure Employees Menu
    	System.out.println("---------");
        System.out.println("Employee Management Configure Employees Menu");
        System.out.println("---------");
        System.out.println("  1) Add a new Employee");
        System.out.println("  2) Edit Existing Employee");
        System.out.println("  3) Remove an Employee");
        System.out.println("---------"); 
        System.out.println("  4) Add an existing Employee to a Managers department");
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    
    private void runConfigureEmployeeMenu(){ //Runs Configure Employees Menu
    	int option = configureEmployeeMenu();
        while (option != 0)
        {
           
            switch (option)
            {
               case 1:    addEmployee();
            	          	break;
               case 2:    editEmployee();
                          	break;
               case 3:	  removeEmployee();
               				break;
               case 4:	  addToDepartment();
               				break;
              default:    System.out.println("Invalid option entered: " + option);
                          break;
            }
            option = configureEmployeeMenu();
        }
    }

	private void addToDepartment() { //Adds Employees under a Managers Department
		if (Employees.size() > 0){
			System.out.println("Choose an Employee to put under a managers department:");
			for(int i = 0; i < Employees.size(); i++){
				if ((Employees.get(i) instanceof SalesWorker)||(Employees.get(i) instanceof TempWorker)){
					System.out.println((i+1)+") "+Employees.get(i).getFirstName()+" "+Employees.get(i).getSecondName());
				}
			}
			System.out.println("Enter Employee: ");
			int whichEmployee = input.nextInt();
			
			System.out.println("Choose a Manager to put the Employee under:");
			for(int i = 0; i < Employees.size(); i++){
				if (Employees.get(i) instanceof Manager){
					System.out.println((i+1)+") "+Employees.get(i).getFirstName()+" "+Employees.get(i).getSecondName());
				}
			}
			System.out.print("Enter Manager: ");
			int whichManager = input.nextInt();
			
			Manager man =(Manager)Employees.get(whichManager-1);
			man.addDeptEmployee(Employees.get(whichEmployee-1));
			
			System.out.println("Employee added to department successfully");
		}
		else {
			System.out.println("No Employees Available");
		}
	}

	private void removeEmployee(){ //Removes Employee from Employees ArrayList
    	if(Employees.size() > 0){
	    	System.out.println("Please choose an Employee to delete:");
	    	for(int i = 0; i < Employees.size(); i++){
	    		System.out.println((i+1)+") "+Employees.get(i).getFirstName()+" "+Employees.get(i).getSecondName());
	    	}
	    	
	    	int chosenEmployee = input.nextInt();
	    	
	    	if((chosenEmployee-1 >= 0)&&(chosenEmployee-1 < Employees.size())){
	    		Employees.remove(chosenEmployee-1);
	    		System.out.println("Chosen Employee Removed Successfully");
	    	}
	    	else{
	    		System.out.println("Invalid Choice - No Employee found in position ("+chosenEmployee+") of the list");
	    	}
    	}
    	else{
    		System.out.println("No Employees Found");
    	}
	}

	private void addEmployee(){ //Adds a new Employee to the Employees ArrayList
    	System.out.print("Employee First Name: ");
    	String firstName = input.nextLine();
    	firstName = input.nextLine();
    	
    	System.out.print("Employee Second Name: ");
    	String secondName = input.nextLine();
    	
    	System.out.print("Employee Hourly Rate: \u20ac");
    	double hourlyRate = input.nextDouble();
    	
    	System.out.println("---------");
    	System.out.println("Employee Type: ");
    	System.out.println("---------");
    	System.out.println("  1)Manager  "+"2)Sales Worker  "+"3)Temporary Worker");
    	int employeeType = input.nextInt();
    	
    	if (employeeType == 1){
    		System.out.println("Please enter in terms of euro the value of this Managers Bonus");
    		System.out.print("Amount of Manager Bonus: \u20ac");
    		double managerBonus = input.nextDouble();
    		Employees.add(new Manager(firstName, secondName, hourlyRate, managerBonus));
    	}
    	else if (employeeType == 2){
    		System.out.print("Percentage Sales Bonus:");
    		double salesBonusPercentage = input.nextDouble();
    		Employees.add(new SalesWorker(firstName, secondName, hourlyRate, salesBonusPercentage));
    	}
    	else if (employeeType == 3){
    		Employees.add(new TempWorker(firstName, secondName, hourlyRate));
    	}
    	else{
    		System.out.println(employeeType+" is not a valid option - Please pick one of the provided Employee Types");
    	}
    }
    
    private void editEmployee(){ //Edit and Existing Employee
    	
    	System.out.println("Please choose an Employee to edit");
    	for(int i = 0; i < Employees.size(); i++){
    		System.out.println((i+1)+") "+Employees.get(i).getFirstName()+" "+Employees.get(i).getSecondName());
    	}
    	
    	int chosenEmployee = input.nextInt();
    	
    	System.out.println("Do you want to change "+Employees.get(chosenEmployee-1).getFirstName()+"'s First Name? (Y/N)");
    	String firstNameChoice = input.next();
    	
    	if(firstNameChoice.toLowerCase().equals("y") == true){
	    	System.out.println("New First Name: ");
	    	String newFirstName = input.next();
	    	Employees.get(chosenEmployee-1).setFirstName(newFirstName);
    	}
    	else{
    		System.out.println("First Name not edited");
    	}
    	
    	System.out.println("Do you want to change "+Employees.get(chosenEmployee-1).getFirstName()+"'s Second Name? (Y/N)");
    	String secondNameChoice = input.next();
    	if(secondNameChoice.toLowerCase().equals("y") == true){
	    	System.out.println("New Second Name: ");
	    	String newSecondName = input.next();
	    	Employees.get(chosenEmployee-1).setSecondName(newSecondName);
    	}
    	else{
    		System.out.println("Second Name not edited");
    	}
    	
    	System.out.println("Do you want to change "+Employees.get(chosenEmployee-1).getFirstName()+"'s Hourly Rate? (Y/N)");
    	String hourlyRateChoice = input.next();
    	if(hourlyRateChoice.toLowerCase().equals("y") == true){
	    	System.out.println("New Hourly Rate: ");
	    	double newHourlyRate = input.nextDouble();
	    	Employees.get(chosenEmployee-1).setHourlyRate(newHourlyRate);
    	}
    	else{
    		System.out.println("Hourly Rate not edited");
    	}
    }
    
    private int calculateSalariesMenu(){ //Calculate Salaries Menu
        System.out.println("---------");
        System.out.println("Employee Management Calculate Salaries Menu");
        System.out.println("---------");
        System.out.println("  1) Calculate an Employees Salary");
        System.out.println("---------");    
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    
    private int runCalculateSalariesMenu(){ //Run Calculate Salaries
    	int option = calculateSalariesMenu();
        while (option != 0)
        {
           
            switch (option)
            {
               case 1:    calculateEmployeeSalary();
            	          	break;
              default:    System.out.println("Invalid option entered: " + option);
                          break;
            }
            option = runCalculateSalariesMenu();
        }
		return option;
    }

	private void calculateEmployeeSalary() { //Calculate an Employees Salary
    	if (Employees.size() > 0){
			System.out.println("Which Employee did you want to configure: ");
			for(int i = 0; i < Employees.size();i++){
				System.out.println((i+1)+") "+Employees.get(i).getFirstName()+" "+Employees.get(i).getSecondName());
			}
			int chosenEmployee = input.nextInt();
			if((chosenEmployee >0)&&((chosenEmployee-1) <= Employees.size())){
				System.out.print("How many hours did "+Employees.get(chosenEmployee-1).getFirstName()+" work: ");
				double numHours = input.nextDouble();
				Employees.get(chosenEmployee-1).calculateSalary(numHours);
				System.out.println(Employees.get(chosenEmployee-1).getFirstName()+" earned: \u20ac"+ Employees.get(chosenEmployee-1).getSalary());
			}
			else{
				System.out.println("Invalid Option, Try Again - There is no Employee at "+chosenEmployee+" on the list.");
			}
    	}
    	else {
    		System.out.println("No Employees Available");
    	}
		
	}

	private void runPrintEmployeeDetails(){ //Print Employee Details Recursively
    	for(int i = 0; i < Employees.size(); i++){
    		System.out.println("~~~~~~~~~~~~~~~~~~~");
    		System.out.println((i+1)+") "+Employees.get(i).getFirstName()+" "+Employees.get(i).getSecondName());
    		System.out.println("~~~~~~~~~~~~~~~~~~~");
    		System.out.println("Hourly Rate: \u20ac"+Employees.get(i).getHourlyRate());
    		System.out.println("Salary: \u20ac"+Employees.get(i).getSalary());
    		System.out.println("Overtime done: "+Employees.get(i).overTime);
    	}
    }

	public ArrayList <Employee> getEmployees() {
		return Employees;
	}

	public void setEmployees(ArrayList <Employee> employees) {
		Employees = employees;
	}
}