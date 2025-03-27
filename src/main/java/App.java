package com.example;

import javax.script.ScriptEngine;

public class App {
    public static void main(String[] args) throws Exception {
        javax.script.ScriptEngineFactory factory = new org.jruby.embed.jsr223.JRubyEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        engine.eval("puts 'Hello, JRuby!'");

        engine.eval("""
                require "bundler/inline"
                require "openssl"

                gemfile(true) do
                    source "https://rubygems.org"
                    gem "httparty"
                end
                """);
    }
}

