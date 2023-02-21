import java.util.Scanner; //importing scanner

public class EmployeeData {
	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner (System.in)) {
			String choice; //variables for menu options
			char command;
			
			String name; //variables to create employees
			double salary;
			int years;
			double raise;
			int TOTAL_EMPLOYEES = 0; //variable to keep track of amount of employees
			
			System.out.println("Enter name of the employee?"); //enter initial info for employee here
			name = scan.nextLine();
			System.out.println("Enter salary for " + name + "?");
			salary = scan.nextDouble();
			System.out.println("Enter number of years for " + name + "?");
			years = scan.nextInt();
			
			Employee hopper = new Employee(name, salary, years); //instantiate new employee with info above
			
			Employee bond = new Employee("Bond", 70000.00, 20); //instantiate new employee manually
			
				printMenu(); //prints menu
				do {
					System.out.println("\nPlease enter a command or type ?");
					choice = scan.next().toLowerCase();
					command = choice.charAt(0); //uses lower case characters for menu
					
					switch (command) {
					case 'a': 
						System.out.println(hopper.toString()); //calls toString to bring up info on employee
						System.out.println();
						System.out.println(bond.toString());
					break;
					case 'b':
						System.out.println("Enter the amount of raise: ");
						raise = scan.nextDouble(); //scans raise
						hopper.raiseSalary(raise); //applies raise to employees
						bond.raiseSalary(raise);
						System.out.println(hopper.toString()); //prints info on them again
						System.out.println();
						System.out.println(bond.toString());
					break;
					case 'c':
						System.out.println("Year has been added.");
						hopper.yearIncrement(); //uses method to increment years for employees
						bond.yearIncrement();
					break;
					case 'd':
						boolean hopperMakesMore = hopper.makesMore(bond); //uses comparison method
						if (hopperMakesMore) {
							System.out.println(name + " is making more"); //uses if statement to determine which makes more
						} else { 
							System.out.println("Bond is making more");
						}
					break;
					case 'e':
						System.out.println("There are " + hopper.getNumEmployees() + " employees."); //calls method to show amount of employees
					break;
					case '?':
						printMenu(); //prints menu again
					break;
					case 'q': //terminates 
					break;
					
					default:
						System.out.println("Invalid input");//error message
					}
				} while (command != 'q'); //while loop facilitates menu
		}
	}
	
	public static void printMenu() { //menu options
		System.out.print("\nCommand Options\n"
						+"-----------------------------------\n"
						+"'a': prints info\n"
						+"'b': raise salary\n"
						+"'c': increment the years of experience\n"
						+"'d': who makes more\n"
						+"'e': number of employees\n"
						+"'?': Displays the help menu\n"
						+"'q': quits\n\n");
	}	
}