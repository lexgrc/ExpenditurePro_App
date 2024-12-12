# ExpenditurePro_App

CS211: OBJECT-ORIENTED PROGRAMMING

Submitted By:
Garcia, Reina ALexia L.

BSIT – 2106

## 1. PROJECT OVERVIEW: ExpenditurePro Expense Tracker

ExpenditurePro is a command-line application designed to help users track their expenses.  It leverages object-oriented programming principles to provide a structured and maintainable approach to expense management.  The application allows users to input expenses categorized by type (Food, Utility, Rent, Transportation) and subcategory, and provides summaries of total expenses, remaining balance, and user information.  The application aligns with Sustainable Development Goals 9 (Industry, Innovation, and Infrastructure) and 12 (Responsible Consumption and Production) by promoting responsible financial management and reducing wasteful spending.

## 2. OOP Principles Implemented in ExpenditurePro

ExpenditurePro effectively utilizes several core object-oriented programming (OOP) principles:

### Encapsulation

*   **Data Hiding:**  The `Expense` class and its subclasses (e.g., `FoodExpense`, `UtilityExpense`) encapsulate data (name, amount, subCategory) within private member variables.  This protects data integrity and prevents accidental modification from outside the class.

*   **Controlled Access:**  Getters (`getName()`, `getAmount()`, `getSubCategory()`) provide controlled access to the encapsulated data, while setters are not explicitly used (data is set in the constructor) to enforce immutability for simplicity and data consistency.


### Inheritance

The `Expense` class serves as an abstract base class.  `FoodExpense`, `UtilityExpense`, `RentExpense`, and `TransportationExpense` inherit from `Expense`, inheriting common properties (name, amount, subCategory) and the abstract method `displayExpenseDetails()`. This promotes code reusability and reduces redundancy.


### Polymorphism

*   **Dynamic Behavior:** The `displayExpenseDetails()` method is declared abstract in the `Expense` class and implemented differently in each subclass. This polymorphism allows each expense type to display its details in a tailored manner (e.g., different color-coding).

### Abstraction

The `Expense` class provides an abstract representation of an expense.  The details of each specific expense type are abstracted away, allowing the system to treat all expense types uniformly while managing their unique characteristics.


## 3. Alignment with Sustainable Development Goals (SDGs) 9 and 12

SDG 9: Industry, Innovation, and Infrastructure: Building a Sustainable Software Foundation
ExpenditurePro's contribution to SDG 9 is primarily through its efficient and well-structured design, reflecting responsible technological advancement. The application's architecture, based on object-oriented programming (OOP) principles, directly addresses several aspects of SDG 9:
* Innovation in Software Design: The use of OOP principles like inheritance and polymorphism is not merely a coding choice; it represents an innovation in software design. The modular structure, with its abstract base class (Expense) and specialized subclasses (FoodExpense, UtilityExpense, etc.), promotes code reusability and maintainability. This modularity reduces the long-term effort and resources needed for updates and improvements, minimizing the environmental impact associated with software maintenance.
* Resilient and Efficient Code: The well-structured code is more resilient to changes and easier to debug. This reduces the time and energy spent on fixing bugs and making modifications, contributing to a more efficient and sustainable software lifecycle. The choice of Java, a widely used and well-supported language, further contributes to the long-term sustainability of the application.
* Responsible Resource Utilization: The efficient design of ExpenditurePro minimizes the computational resources required for its operation. This translates to lower energy consumption during execution, aligning with the broader sustainability goals of minimizing resource utilization.

SDG 12: Responsible Consumption and Production: Empowering Conscious Spending
ExpenditurePro's contribution to SDG 12 is more directly related to its functionality and its impact on user behavior. The application promotes responsible consumption and production through:
* Empowering Informed Financial Decisions: The core functionality of ExpenditurePro—tracking expenses by category and subcategory—empowers users to make informed decisions about their spending. This promotes mindful consumption, reducing impulsive purchases and encouraging a more deliberate approach to resource allocation.
* Facilitating Waste Reduction: By providing a clear overview of spending patterns, ExpenditurePro helps users identify areas of potential waste. This awareness can lead to behavioral changes that reduce unnecessary expenditures and promote more efficient resource utilization. For example, users might identify areas where they can reduce their consumption of resources or switch to more sustainable alternatives.
* Promoting Sustainable Lifestyles: The application's focus on budgeting and expense tracking encourages users to adopt more sustainable lifestyles. By managing their finances effectively, users can make conscious choices that align with environmental and social responsibility.


## 4. Instructions for Running the Program

1. Save the Code: Save the provided Java code in a file named ExpenseTrackerApp.java.
2. Compile the Code: Open a terminal or command prompt. Navigate to the directory where you saved ExpenseTrackerApp.java. Then, compile the code using this command:
_bash
    javac ExpenseTrackerApp.java_
3. Run the Application: After successful compilation (no error messages), run the application using this command:
_bash
    java ExpenseTrackerApp_
4. Follow the On-Screen Prompts: The application will guide you through the process. You'll be asked to enter your name and salary. A menu will then appear, allowing you to add expenses, view summaries (total expenses, remaining balance), and view your user information.
   
Important Note: The application uses ANSI escape codes for color-coded output. If your terminal or command prompt doesn't support ANSI escape codes, the colors may not display correctly. The functionality of the application will remain unaffected.
