package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.ScriptEngine;

public class App {
    public static void main(String[] args) throws Exception {
        javax.script.ScriptEngineFactory factory = new org.jruby.embed.jsr223.JRubyEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        engine.eval("puts 'Hello, JRuby!'");

        Path path = Paths.get(App.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        engine.put("GEM_HOME", path.resolveSibling("gems").toString());
        engine.eval("""
                ENV["GEM_HOME"] = GEM_HOME

                require "bundler/inline"
                require "openssl"

                puts "JRuby Version: #{JRUBY_VERSION}"
                puts "GEM_HOME: #{GEM_HOME}\n\n"
                Dir.mkdir(GEM_HOME) unless Dir.exist?(GEM_HOME)

                gemfile(true) do
                    source "https://rubygems.org"
                    gem "httparty"
                end
                """);
    }
}

