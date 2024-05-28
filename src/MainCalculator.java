import java.util.Scanner;

// Abstraction in the following class.
abstract class Calculator {
    abstract double calculate(double x, double y);
}

// Addition operation.
class Addition extends Calculator {
    @Override
    double calculate(double x, double y) {
        return x + y;
    }
}

// Subtraction operation.
class Subtraction extends Calculator {
    @Override
    double calculate(double x, double y) {
        return x - y;
    }
}

// Multiplication operation.
class Multiplication extends Calculator {
    @Override
    double calculate(double x, double y) {
        return x * y;
    }
}

// Division operation.
class Division extends Calculator {
    @Override
    double calculate(double x, double y) {
        if (y == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0; // Returning 0 or any other appropriate value
        } else {
            return x / y;
        }
    }
}

// Remainder operation.
class Remainder extends Calculator {
    @Override
    double calculate(double x, double y) {
        if (y == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0; // Returning 0 
        } else {
            return x % y;
        }
    }
}

// Calculator class encapsulating the operations
public class MainCalculator {
    private Calculator operation;

    // Setter method for operation
    public void setOperation(Calculator operation) {
        this.operation = operation;
    }

    public double performCalculation(double x, double y) {
        return operation.calculate(x, y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();

        MainCalculator calculator = new MainCalculator();

        // Encapsulation and abstraction.
        calculator.setOperation(new Addition());
        System.out.println("Addition = " + calculator.performCalculation(num1, num2));
        System.out.println("==============================");

        calculator.setOperation(new Subtraction());
        System.out.println("Subtraction = " + calculator.performCalculation(num1, num2));
        System.out.println("==============================");

        calculator.setOperation(new Multiplication());
        System.out.println("Multiplication = " + calculator.performCalculation(num1, num2));
        System.out.println("==============================");

        calculator.setOperation(new Division());
        double divisionResult = calculator.performCalculation(num1, num2);
        if (num2 != 0) {
            System.out.println("Division = " + divisionResult);
        }
        System.out.println("==============================");

        calculator.setOperation(new Remainder());
        double remainderResult = calculator.performCalculation(num1, num2);
        if (num2 != 0) {
            System.out.println("Remainder = " + remainderResult);
        }
        System.out.println("==============================");

        scanner.close(); 
    }
}