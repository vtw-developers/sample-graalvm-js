package com.vtw.dna;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ReturnString {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("graal.js");
        System.out.println("engine name: " + engine.getFactory().getEngineName());

        String code = """
                let str = "Hello";
                str += " World!!";
                """;

        try (Context context = Context.create("js")) {
            Value result = context.eval("js", code);
            String str = result.asString();
            System.out.println("str: " + str);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
