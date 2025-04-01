package com.example;

import javax.script.ScriptEngine;

public class App {
    public static void main(String[] args) throws Exception {
        javax.script.ScriptEngineFactory factory = new org.jruby.embed.jsr223.JRubyEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        engine.eval("""
                puts "JRuby Version: #{JRUBY_VERSION}"
                puts "JRuby Revision: #{JRUBY_REVISION}"

                [1, 2].each do 
                    puts it
                end
                """);
    }
}

