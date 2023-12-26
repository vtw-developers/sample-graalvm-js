package com.vtw.dna;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Parameter {

    public static void main(String[] args) {
        String code = """
                (function myFun(param) {
                    return 'hello ' + param;
                })
                """;
        String parameter = "VTW";

        try (Context context = Context.create()) {
            Value value = context.eval("js", code);
            Value result = value.execute(parameter);
            System.out.println("Result: " + result.asString());
        }
    }
}
