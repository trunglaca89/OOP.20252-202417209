package hw13a;

public class CalculatorLogic {
    
    public double evaluateExpression(double leftOperand, double rightOperand, String operator) throws ArithmeticException {
        if (operator == null || operator.isEmpty()) {
            throw new IllegalArgumentException("Operator is required");
        }

        switch (operator) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
            case "x":
                return leftOperand * rightOperand;
            case "/":
                if (rightOperand == 0.0) {
                    throw new ArithmeticException("Division by zero");
                }
                return leftOperand / rightOperand;
            case "%":
                if (rightOperand == 0.0) {
                    throw new ArithmeticException("Modulo by zero");
                }
                return leftOperand % rightOperand;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
