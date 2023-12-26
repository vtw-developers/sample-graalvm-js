package com.vtw.dna;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MathMin {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("graal.js");
        System.out.println("engine name: " + engine.getFactory().getEngineName());

        try (Context context = Context.create("js")) {
            Value js = context.eval("js", "Math.min(2, 3)");
            int num = js.asInt();
            System.out.println(num);
        } catch (Exception e) {
            System.err.println();
        }
    }
}
