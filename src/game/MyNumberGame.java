/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import utils.MathParser;
import utils.PermutationGenerator;

/**
 *
 * @author mladen
 */
public class MyNumberGame implements Serializable {

    public static String[] getVariables() {
        return variables;
    }
    private final String[] operations;
    private String[] operators;
    private static String[] variables;
    private Integer[] operands;
    private Integer targetValue;
    private boolean foundExp;
    private String winningExp;
    private MathParser parser;

    public MyNumberGame() {
        operations = new String[]{"+", "-", "*", "/"};
        variables = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        foundExp = false;
        winningExp = null;
        parser = new MathParser();
    }
    public MyNumberGame(Integer[] operands, Integer targetValue) {
        this();
        this.operands = operands;
        this.targetValue = targetValue;
    }
    public void play() throws IllegalArgumentException {
        if (!isGameReady())
            throw new IllegalArgumentException("Not ready for game, please specify valid game parameters");
        foundExp = false;
        winningExp = null;
        operators = new String[operands.length * operations.length];
        for (int i = 1, k = 0; i <= operands.length; i++) {
            for (int j = 0; j < operations.length; j++) {
                String operator = operations[j].concat(variables[i]);
                operators[k++] = operator;
            }
        }
        String rootValue = variables[0];
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootValue);
        DefaultTreeModel tree = new DefaultTreeModel(root);
        generateChildren(tree, root, 1);
    }

    public String[] getOperations() {
        return operations;
    }

    public Integer[] getOperands() {
        return operands;
    }

    public void setOperands(Integer[] operands) {
        this.operands = operands;
    }

    public Integer getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Integer targetValue) {
        this.targetValue = targetValue;
    }

    public boolean isFoundExp() {
        return foundExp;
    }

    public String getWinningExp() {
        return winningExp;
    }

    private boolean isGameReady() {
        if (operands == null) return false;
        for (int i = 0; i < operands.length; i++) {
            if (operands[i] <= 0) {
                return false;
            }
        }
        return (operands.length > 1) && (operands.length <= variables.length) && (targetValue != null);
    }

    /**
     * @return the operators
     */
    public String[] getOperators() {
        return operators;
    }

    private void generateChildren(DefaultTreeModel tree, DefaultMutableTreeNode currentNode, int level) {
        int lastOperator = level*4;
        if (lastOperator >= operators.length) { // end of game, not found
            return;
        }
        String currentValue = (String) currentNode.getUserObject();
        int numChildren = 0;
        for (int i = lastOperator-operations.length; i < lastOperator+2; i++) {
            String newChildValue = null;
            if (i < lastOperator) { // basic operation, e.g +b
                newChildValue = currentValue.concat(operators[i]);
            } else if (isNeededParenthesis(currentValue)) { // if contains at least two operands
                newChildValue = "(".concat(currentValue).concat(")").concat(operators[i-2]);
            } else { // no need parant. so skip it
                continue;
            }
            if (level == operands.length-1) { // last level
                winningExp = findWinningExpression(newChildValue);
                if (winningExp != null) {
                    foundExp = true;
                    return;
                }
            }
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(newChildValue);
            tree.insertNodeInto(child, currentNode, numChildren);
            numChildren++;
            generateChildren(tree, child, level+1);
            if (foundExp == true) return;
        }
    }

    private boolean isNeededParenthesis(String currentValue) {
        int openParenth = currentValue.indexOf("(");
        int lastParanth = currentValue.lastIndexOf(")");
        if ((lastParanth > 0) && (openParenth > 0) && (lastParanth - openParenth) > 0)
            currentValue.replace(currentValue.substring(openParenth, lastParanth), "x"); // unify paranthezis
        return (currentValue.length() > 1) && (currentValue.contains("+") || currentValue.contains("-"));
    }
    private String findWinningExpression(final String pattern) {
        StringBuilder combination = new StringBuilder(pattern);
        PermutationGenerator positions = new PermutationGenerator(operands.length);
        while (positions.hasMore()) {
            int[] indices = positions.getNext();
            for (int i = 0; i < indices.length; i++) {
                String nextOperand = String.valueOf(operands[indices[i]]);
                int variableIndex = combination.indexOf(variables[i]);
                if (variableIndex == -1) {
                    return null; // internal error, certain variable not found
                } else if (variableIndex == combination.length()-1) {
                    combination.deleteCharAt(variableIndex).append(nextOperand);
                } else {
                    combination.replace(variableIndex, variableIndex+1, nextOperand);
                }
            }
            parser.setExpression(combination.toString());
            try {
                Double candidate = parser.evaluate();
                if (((Math.floor(candidate) - candidate) == 0) && candidate.intValue() == targetValue) {
                    return combination.toString(); // found winning expression!
                }
            } catch (IllegalArgumentException iae) {
                return null;
            }
            combination = new StringBuilder(pattern);
        }
        return null; // obviosly not found...
    }
}
