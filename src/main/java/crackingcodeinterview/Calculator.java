/* 
User: Urmi
Date: 12/23/2019 
Time: 1:04 PM
*/

package crackingcodeinterview;

import java.util.Stack;

public class Calculator {

    public enum Operator{
        ADD(1),
        SUBTRACT(1),
        MULTIPLY(2),
        DIVIDE(2),
        BLANK(0);

        int priority;

        Operator(int priority){
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }
    }

    public static double applyOp(double left, Operator op, double right){
        if(op == Operator.ADD){
            return left + right;
        } else if (op == Operator.SUBTRACT) {
            return left - right;
        } else if (op == Operator.MULTIPLY) {
            return left * right;
        } else if (op == Operator.DIVIDE) {
            return left / right;
        } else {
            return right;
        }
    }


    //main method
    public static double compute(String sequence) {
        Stack<Double> numberStack = new Stack<Double>();
        Stack<Operator> operatorStack = new Stack<Operator>();

        for (int i = 0; i < sequence.length(); i++) {
            try
            {
                /* Get number and push. */
                int value = parseNextNumber(sequence, i);
                numberStack.push((double) value);

                /* Move to the operator. */
                i += Integer.toString(value).length();
                if (i >= sequence.length()) {
                    break;
                }

                /* Get operator, collapse top as needed, push operator. */
                Operator op = parseNextOperator(sequence, i);
                collapseTop(op, numberStack, operatorStack);
                operatorStack.push(op);
            } catch (NumberFormatException ex) {
                return Integer.MIN_VALUE;
            }
        }

        /* Do final collapse. */
        collapseTop(Operator.BLANK, numberStack, operatorStack);
        if (numberStack.size() == 1 && operatorStack.size() == 0) {
            return numberStack.pop();
        }
        return 0;
    }


    /* Collapse top until priority(futureTop) <= priority(top).
     * Collapsing means to pop the top 2 numbers and apply the
     * operator popped from the top of the operator stack, and then
     * push that onto the numbers stack.*/
    public static void collapseTop(Operator futureTop, Stack<Double> numberStack, Stack<Operator> operatorStack){
        while(operatorStack.size() >= 1 && numberStack.size() >= 2){
            if(futureTop.getPriority() <= operatorStack.peek().getPriority()){
                double right = numberStack.pop();
                double left = numberStack.pop();
                Operator op = operatorStack.pop();
                double collapsed = applyOp(left, op, right);
                numberStack.push(collapsed);
            }else {
                break;
            }
        }
    }

    /* Return the number that starts at offset. */
    public static int parseNextNumber(String seq, int offset) {
        StringBuilder sb = new StringBuilder();
        while (offset < seq.length() && Character.isDigit(seq.charAt(offset))) {
            sb.append(seq.charAt(offset));
            offset++;
        }
        return Integer.parseInt(sb.toString());
    }

    public static Operator parseNextOperator(String sequence, int offset) {
        if (offset < sequence.length()) {
            char op = sequence.charAt(offset);
            switch(op) {
                case '+': return Operator.ADD;
                case '-': return Operator.SUBTRACT;
                case '*': return Operator.MULTIPLY;
                case '/': return Operator.DIVIDE;
            }
        }
        return Operator.BLANK;
    }




}
