package com.arifacar.test.arif.Java8Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 Verify the Result
 Compile the class using javac compiler as follows −

 $javac Java8Tester.java
 Now run the Java8Tester as follows −

 $java Java8Tester
 It should produce the following result −

 Result =
 18
 */
public class TestScriptEngineManager {
    public static void main(String args[]) {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine testEngine = scriptEngineManager.getEngineByName("testEngine");

        String name = "Result= ";
        Integer result = null;

        try {
            testEngine.eval("print('" + name + "')");
            result = (Integer) testEngine.eval("9 * 2");

        } catch (ScriptException e) {
            System.out.println("Error executing script: " + e.getMessage());
        }

        System.out.println(result.toString());
    }

}
