package com.vtw.dna;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Rule {

    static String JS_CODE = "(function myFun(param){console.log('hello '+param);})";

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        String code = """
                (function predicate(input, param) {
                    return input.age < param;
                })
                """;

        Map<String, Object> input = new LinkedHashMap<>();
        input.put("age", 25);
        input.put("gender", "F");

        int param = 19;

        try (Context context = Context.create()) {
            Value value = context.eval("js", code);
            Value result = value.execute(input, param);

            System.out.println("==================");
            System.out.println("Result: " + result.asBoolean());
            System.out.println("==================");
        }
    }
}
