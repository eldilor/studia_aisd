package Lab5;

public class InfixToPostfixConverter {
    private final char[] ALLOWED_OPERATORS = {'+', '-', '*', '/', '%', '(', ')'};
    private Stack<Character> operators;
    private String postfix;

    public String convert(String infix) throws Exception {
        this.operators = new Stack<>();
        this.postfix = "";
        char[] charInfixArray = infix.toCharArray();

        for (char charInfix : charInfixArray) {
            if (Character.isDigit(charInfix)) {
                this.postfix += charInfix;
            } else if (this.isOperator(charInfix)) {
                this.processOperator(charInfix);
            } else {
                throw new Exception("Wyrażenie jest nie poprawne");
            }
        }

        while (!this.operators.isEmpty()) {
            char topOperator = this.operators.pop();
            if (topOperator != this.ALLOWED_OPERATORS[5] && topOperator != this.ALLOWED_OPERATORS[6]) {
                this.postfix += topOperator;
            }
        }

        return this.postfix;
    }

    public double calculate() throws Exception {
        Stack<Double> score = new Stack<>();
        char[] expressionArray = this.postfix.toCharArray();

        for (char expressionChar : expressionArray) {
            if (Character.isDigit(expressionChar)) {
                score.push((double) Character.digit(expressionChar, 10));
            } else if (this.isOperator(expressionChar)) {
                double arg1 = score.pop();
                double arg2 = score.pop();
                double result = 0;

                if (expressionChar == this.ALLOWED_OPERATORS[0]) {
                    result = arg1 + arg2;
                } else if (expressionChar == this.ALLOWED_OPERATORS[1]) {
                    result = arg1 - arg2;
                } else if (expressionChar == this.ALLOWED_OPERATORS[2]) {
                    result = arg1 * arg2;
                } else if (expressionChar == this.ALLOWED_OPERATORS[3]) {
                    result = arg1 / arg2;
                } else if (expressionChar == this.ALLOWED_OPERATORS[4]) {
                    result = arg1 % arg2;
                } else {
                    throw new Exception("Nie ma takiego operatora");
                }

                score.push(result);
            } else {
                throw new Exception("Wystąpił błąd");
            }
        }

        return score.pop();
    }

    private void processOperator(char operator) throws Exception {
        if (this.operators.isEmpty() || operator == this.ALLOWED_OPERATORS[5]) {
            this.operators.push(operator);
        } else {
            char topOperator = this.operators.peek();
            int topOperatorPriority = this.getOperatorPriority(topOperator);
            int currentOperatorPriority = this.getOperatorPriority(operator);

            if (currentOperatorPriority > topOperatorPriority) {
                this.operators.push(operator);
            } else {
                while (!this.operators.isEmpty() && currentOperatorPriority <= topOperatorPriority) {
                    topOperator = this.operators.pop();

                    if (topOperator == this.ALLOWED_OPERATORS[5]) {
                        break;
                    }

                    topOperatorPriority = this.getOperatorPriority(topOperator);
                    this.postfix += topOperator;
                }

                if (topOperator != this.ALLOWED_OPERATORS[6]) {
                    this.operators.push(operator);
                }
            }
        }
    }

    private int getOperatorPriority(char operator) throws Exception {
        int priority = 0;

        if (operator == this.ALLOWED_OPERATORS[0]) {
            priority = 1;
        } else if (operator == this.ALLOWED_OPERATORS[1]) {
            priority = 1;
        } else if (operator == this.ALLOWED_OPERATORS[2]) {
            priority = 2;
        } else if (operator == this.ALLOWED_OPERATORS[3]) {
            priority = 2;
        } else if (operator == this.ALLOWED_OPERATORS[4]) {
            priority = 2;
        } else if (operator == this.ALLOWED_OPERATORS[5]) {
            priority = -1;
        } else if (operator == this.ALLOWED_OPERATORS[6]) {
            priority = -1;
        } else {
            throw new Exception("Nie ma takiego operatora");
        }


        return priority;
    }

    private boolean isOperator(char character) {
        boolean isOperator = false;

        for (char allowedOperation : this.ALLOWED_OPERATORS) {
            if (character == allowedOperation) {
                isOperator = true;
                break;
            }
        }

        return isOperator;
    }
}
