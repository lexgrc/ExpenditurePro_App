import java.util.ArrayList;
import java.util.Scanner;

abstract class Expense {
    private String name;
    private double amount;
    private String subCategory;

    public Expense(String name, double amount, String subCategory) {
        this.name = name;
        this.amount = amount;
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public abstract void displayExpenseDetails();
}

class FoodExpense extends Expense {
    public FoodExpense(String name, double amount, String subCategory) {
        super(name, amount, subCategory);
    }

    @Override
    public void displayExpenseDetails() {
        System.out.printf("\033[1;34mFood Expense:\033[0m\n"); //Dark Blue
        System.out.printf("\033[1;34mName: %s\033[0m\n", getName()); //Dark Blue
        System.out.printf("\033[1;34mAmount: %.2f\033[0m\n", getAmount()); //Dark Blue
        System.out.printf("\033[1;34mSubcategory: %s\033[0m\n", getSubCategory()); //Dark Blue
    }
}

class UtilityExpense extends Expense {
    public UtilityExpense(String name, double amount, String subCategory) {
        super(name, amount, subCategory);
    }

    @Override
    public void displayExpenseDetails() {
        System.out.printf("\033[1;36mUtility Expense:\033[0m\n"); //Light Cyan
        System.out.printf("\033[1;36mName: %s\033[0m\n", getName()); //Light Cyan
        System.out.printf("\033[1;36mAmount: %.2f\033[0m\n", getAmount()); //Light Cyan
        System.out.printf("\033[1;36mSubcategory: %s\033[0m\n", getSubCategory()); //Light Cyan
    }
}

class RentExpense extends Expense {
    public RentExpense(String name, double amount, String subCategory) {
        super(name, amount, subCategory);
    }

    @Override
    public void displayExpenseDetails() {
        System.out.printf("\033[1;32mRent Expense:\033[0m\n"); //Green
        System.out.printf("\033[1;32mName: %s\033[0m\n", getName()); //Green
        System.out.printf("\033[1;32mAmount: %.2f\033[0m\n", getAmount()); //Green
        System.out.printf("\033[1;32mSubcategory: %s\033[0m\n", getSubCategory()); //Green
    }
}

class TransportationExpense extends Expense {
    public TransportationExpense(String name, double amount, String subCategory) {
        super(name, amount, subCategory);
    }

    @Override
    public void displayExpenseDetails() {
        System.out.printf("\033[1;33mTransportation Expense:\033[0m\n"); //Yellow
        System.out.printf("\033[1;33mName: %s\033[0m\n", getName()); //Yellow
        System.out.printf("\033[1;33mAmount: %.2f\033[0m\n", getAmount()); //Yellow
        System.out.printf("\033[1;33mSubcategory: %s\033[0m\n", getSubCategory()); //Yellow
    }
}

class User {
    private String name;
    private double salary;

    public User(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void displayUserInfo() {
        System.out.println("=== User Information ===");
        System.out.println("Name: " + getName());
        System.out.printf("Salary: %.2f\n", getSalary());
    }
}

public class ExpenseTrackerApp {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static User currentUser;
    private static final String[] foodSubcategories = {"Groceries", "Dining Out", "Snacks", "Takeout"};
    private static final String[] utilitySubcategories = {"Electricity", "Water", "Internet", "Gas"};
    private static final String[] rentSubcategories = {"Rent", "Home Insurance"};
    private static final String[] transportationSubcategories = {"Public Transport", "Fuel", "Parking", "Ride-sharing"};
    private static double budgetLimit = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\033[1;34mEnter your name: \033[0m");
        String userName = scanner.nextLine();
        double userSalary = getValidSalary(scanner);

        currentUser = new User(userName, userSalary);

        boolean running = true;
        while (running) {
            clearScreen();
            displayMenu();

            int choice = getValidMenuChoice(scanner);

            switch (choice) {
                case 1:
                    setBudgetLimit(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    displayAllExpenses();
                    break;
                case 4:
                    displayExpenseBalance();
                    break;
                case 5:
                    displayTotalExpenses();
                    break;
                case 6:
                    viewUserInformation();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static double getValidSalary(Scanner scanner) {
        double salary = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("\033[1;34mEnter your salary: \033[0m"); //Dark Blue
            if (scanner.hasNextDouble()) {
                salary = scanner.nextDouble();
                if (salary > 0) {
                    valid = true;
                } else {
                    System.out.println("Salary must be positive. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return salary;
    }

    private static void displayMenu() {
        System.out.println("\033[1;36m*************************************\033[0m"); //Light Cyan
        System.out.println("\033[1;36m*           ExpenditurePro          *\033[0m"); //Light Cyan
        System.out.println("\033[1;36m*************************************\033[0m"); //Light Cyan
        System.out.println("\n\033[1;36mMenu:\033[0m"); //Light Cyan
        System.out.println("\033[1;36m1. Set Budget Limit\033[0m"); //Light Cyan
        System.out.println("\033[1;36m2. Add Expense\033[0m"); //Light Cyan
        System.out.println("\033[1;36m3. Display All Expenses\033[0m"); //Light Cyan
        System.out.println("\033[1;36m4. View Expense Balance\033[0m"); //Light Cyan
        System.out.println("\033[1;36m5. View Total Expenses\033[0m"); //Light Cyan
        System.out.println("\033[1;36m6. View User Information\033[0m"); //Light Cyan
        System.out.println("\033[1;36m7. Exit\033[0m"); //Light Cyan
        System.out.print("\033[1;34mEnter your choice: \033[0m"); //Dark Blue
    }

    private static int getValidMenuChoice(Scanner scanner) {
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= 7) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static void setBudgetLimit(Scanner scanner) {
        System.out.print("\033[1;34mEnter the budget limit (amount): \033[0m"); //Dark Blue
        budgetLimit = getValidBudgetAmount(scanner);
        System.out.println("\033[1;34mBudget limit set: \033[0m" + budgetLimit); //Dark Blue
        pause();
    }

    private static double getValidBudgetAmount(Scanner scanner) {
        double amount = 0;
        boolean valid = false;
        while (!valid) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    valid = true;
                } else {
                    System.out.println("Budget limit must be non-negative. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }
        scanner.nextLine(); 
        return amount;
    }

    private static void addExpense(Scanner scanner) {
        System.out.println("\033[1;36mSelect a category to add expense:\033[0m"); //Light Cyan
        System.out.println("\033[1;36m1. Food\033[0m"); //Light Cyan
        System.out.println("\033[1;36m2. Utility\033[0m"); //Light Cyan
        System.out.println("\033[1;36m3. Rent\033[0m"); //Light Cyan
        System.out.println("\033[1;36m4. Transportation\033[0m"); //Light Cyan

        int categoryChoice = getValidCategoryChoice(scanner);

        switch (categoryChoice) {
            case 1:
                addExpenseHelper(scanner, "Food", foodSubcategories);
                break;
            case 2:
                addExpenseHelper(scanner, "Utility", utilitySubcategories);
                break;
            case 3:
                addExpenseHelper(scanner, "Rent", rentSubcategories);
                break;
            case 4:
                addExpenseHelper(scanner, "Transportation", transportationSubcategories);
                break;
            default:
                System.out.println("Invalid category choice.");
        }
    }

    private static int getValidCategoryChoice(Scanner scanner) {
        int categoryChoice = 0;
        boolean valid = false;
        while (!valid) {
            if (scanner.hasNextInt()) {
                categoryChoice = scanner.nextInt();
                scanner.nextLine();
                if (categoryChoice >= 1 && categoryChoice <= 4) {
                    valid = true;
                } else {
                    System.out.println("Invalid category. Please select between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();
            }
        }
        return categoryChoice;
    }

    private static double getValidExpenseAmount(Scanner scanner) {
        double amount = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("\033[1;34mEnter the expense amount: \033[0m"); //Dark Blue
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine(); 
                if (amount > 0) {
                    valid = true;
                } else {
                    System.out.println("Expense amount must be positive. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.nextLine();
            }
        }
        return amount;
    }

    private static int getValidSubcategoryChoice(Scanner scanner, String[] subcategories) {
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= subcategories.length) {
                    valid = true;
                } else {
                    System.out.println("Invalid subcategory choice. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static void addExpenseHelper(Scanner scanner, String category, String[] subcategories) {
        System.out.print("\033[1;34mEnter the " + category.toLowerCase() + " expense amount: \033[0m"); //Dark Blue
        double amount = getValidExpenseAmount(scanner);

        double totalExpenses = calculateTotalExpenses();
        // Correct budget check: only check if a budget limit is set
        if (budgetLimit > 0 && totalExpenses + amount > budgetLimit) {
            System.out.println("\033[1;31mError: Expense exceeds budget limit!\033[0m"); //Red
            pause();
            return;
        }

        System.out.println("\033[1;36mSelect a subcategory for " + category + " Expense: \033[0m"); //Light Cyan
        for (int i = 0; i < subcategories.length; i++) {
            System.out.println("\033[1;36m" + (i + 1) + ". " + subcategories[i] + "\033[0m"); //Light Cyan
        }
        int subcategoryChoice = getValidSubcategoryChoice(scanner, subcategories);
        String selectedSubcategory = subcategories[subcategoryChoice - 1];

        Expense expense = createExpense(category, amount, selectedSubcategory);
        expenses.add(expense);
        System.out.println("\033[1;32mExpense added successfully!\033[0m"); //Green
        pause();
    }

    private static Expense createExpense(String category, double amount, String subcategory) {
        Expense expense = null;
        switch (category) {
            case "Food":
                expense = new FoodExpense(category, amount, subcategory);
                break;
            case "Utility":
                expense = new UtilityExpense(category, amount, subcategory);
                break;
            case "Rent":
                expense = new RentExpense(category, amount, subcategory);
                break;
            case "Transportation":
                expense = new TransportationExpense(category, amount, subcategory);
                break;
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
        return expense;
    }

    private static void displayAllExpenses() {
        System.out.println("\033[1;36m=== All Expenses ===\033[0m"); //Light Cyan
        for (Expense expense : expenses) {
            expense.displayExpenseDetails();
            System.out.println("--------------------");
        }
        pause();
    }

    private static void displayExpenseBalance() {
        double totalExpenses = calculateTotalExpenses();
        double balance = currentUser.getSalary() - totalExpenses;
        double remainingBudget = budgetLimit - totalExpenses;

        System.out.println("\033[1;36m=== Expense Balance ===\033[0m"); //Light Cyan

        if (balance < 0) {
            System.out.printf("\033[1;31mExpense Balance (Salary): %.2f (Expenses exceed salary!)\033[0m\n", balance); //Red
        } else {
            System.out.printf("\033[1;32mExpense Balance (Salary): %.2f\033[0m\n", balance); //Green
            }
        if (budgetLimit > 0) {
            if (remainingBudget < 0) {
                System.out.printf("\033[1;31mBudget Exceeded by: %.2f\033[0m\n", -remainingBudget); //Red
            } else {
                System.out.printf("\033[1;34mRemaining Budget: %.2f\033[0m\n", remainingBudget); //Dark Blue
            }
        }
        pause();
    }

    private static double calculateTotalExpenses() {
        double totalExpenses = 0;
        for (Expense expense : expenses) {
            totalExpenses += expense.getAmount();
        }
        return totalExpenses;
    }
private static void displayTotalExpenses() {
    double totalExpenses = calculateTotalExpenses();
    System.out.println("\033[1;36m=== Total Expenses ===\033[0m"); // Light Cyan
    System.out.printf("\033[1;34mTotal Expenses: %.2f\033[0m\n", totalExpenses); // Dark Blue
    if (budgetLimit > 0) {
        System.out.printf("\033[1;34mBudget Limit: %.2f\033[0m\n", budgetLimit); // Dark Blue
    }
    pause();
}


    private static void viewUserInformation() {
        System.out.println("\033[1;36m=== User Information ===\033[0m"); //Light Cyan
        currentUser.displayUserInfo();
        pause();
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pause() {
        System.out.println("\n\033[1;36mPress Enter to continue.\033[0m"); //Light Cyan
        new Scanner(System.in).nextLine();
    }
}