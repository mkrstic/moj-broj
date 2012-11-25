/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author mladen
 */
public class MathParser {

    private String expr;
    private ScriptEngine engine;

    public MathParser() {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("JavaScript");
    }
    public void setExpression(String txtExpression) {
        this.expr = prepare(txtExpression);
    }
    public String getExpression() {
        return expr;
    }
    private String prepare(String value) {
        return value.trim().toLowerCase();
    }
    public Double evaluate() throws IllegalArgumentException {
        try {
            engine.put("exp", expr);
            Double result = (Double) engine.eval("eval(exp);");
            return result;
        } catch (ScriptException se) {
            throw new IllegalArgumentException(se.fillInStackTrace());
        }
    }
}