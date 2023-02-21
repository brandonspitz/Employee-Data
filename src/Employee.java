import java.text.NumberFormat;
import java.util.Currency; //importing packages to help with currency formatting
import java.util.Locale;

public class Employee {

	Locale usa = new Locale("en", "US"); //formatting currency to usa standards
	Currency dollars = Currency.getInstance(usa);
	NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
	
	private String name = "???"; //declaring variables with nothing to start off
	private double salary = 0.0;
	private int years = 0;
	double raise = 0.0;
	public static int TOTAL_EMPLOYEES; //used to increment whenever a new employee is created
		
	public Employee(String name, double salary, int years) { // parameters needed for employee
		TOTAL_EMPLOYEES++;
		this.name = name; //using this. to declare variables for specific employee
		this.salary = salary;
		this.years = years;
	}
	public Employee(String str) {
		TOTAL_EMPLOYEES++;
	}
	
	public String getName() {
		return name; //returns name specified in code
	}
	public double getSalary() {
		return salary; //returns salary
	}
	public int getYears() { 
		return years; //returns years of experience
	}
	
	public void setYears() { 
		this.years = years; //sets variable years to new value
	}
	public void yearIncrement() {
		years++; // increments years when called to do so
	}
	public void raiseSalary(double raise) {
		this.salary = salary + ((raise / 100) * salary); //uses formula to apply given raise to employee
	}
	
	public boolean makesMore(Employee x) {
		return this.salary > x.getSalary(); //compares salary between employees
	}
	
	public static int getNumEmployees() {
		return TOTAL_EMPLOYEES; //returns amount of times employees have been created
	}
	
	public String toString() {
		return 	"Name: " + name + "\n" + "Salary: " + dollarFormat.format(salary) + "\n" + "Years of Experience: " + years; //produces info about employee
	}
}