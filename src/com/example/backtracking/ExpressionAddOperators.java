package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(0, 0, 0, 0, new ArrayList<>(), result, target, num);
        return result;
    }

    private void backtrack(
            int index,
            long previousOperand,
            long currentOperand,
            long value,
            List<String> ops,
            List<String> result,
            int target,
            String num
    ) {
        if (index == num.length()) {
            if (value == target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(sb::append);
                result.add(sb.toString());
            }
        } else {
            // Extending the current operand by one digit
            currentOperand = currentOperand * 10 + (num.charAt(index) - '0');
            String currentValRep = Long.toString(currentOperand);

            //NO_OP
            if (currentOperand > 0) {
                backtrack(index + 1, previousOperand, currentOperand, value, ops, result, target, num);
            }

            //Addition
            ops.add("+");
            ops.add(currentValRep);
            backtrack(index + 1, currentOperand, 0, value + currentOperand, ops, result, target, num);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            if (ops.size() > 0) {
                // SUBTRACTION
                ops.add("-");
                ops.add(currentValRep);
                backtrack(index + 1, -currentOperand, 0, value - currentOperand, ops, result, target, num);
                ops.remove(ops.size() - 1);
                ops.remove(ops.size() - 1);

                // MULTIPLICATION
                ops.add("*");
                ops.add(currentValRep);
                backtrack(index + 1, currentOperand * previousOperand, 0, value - previousOperand + (currentOperand * previousOperand), ops, result, target, num);
                ops.remove(ops.size() - 1);
                ops.remove(ops.size() - 1);
            }
        }
    }
}
