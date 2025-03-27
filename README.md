# Reproduce bundle problem in jruby10

After cloning this repo, build a jar:

```
mvn clean compile assembly:single
```

Then execute it

```
java -cp target/jruby10-bundler-1.0-SNAPSHOT-jar-with-dependencies.jar com.example.App
```

It should show the error:

```
$ java -cp target/jruby10-bundler-1.0-SNAPSHOT-jar-with-dependencies.jar com.example.App
Hello, JRuby!
Exception in thread "main" javax.script.ScriptException: Error during evaluation of Ruby in org/jruby/RubyIO.java at line 1361: (ENOENT) No such file or directory - uri:classloader:/META-INF/jruby.home/lib/ruby/gems/shared/bundler.lock
        at org.jruby.embed.jsr223.JRubyEngine.wrapRaiseException(JRubyEngine.java:282)
        at org.jruby.embed.jsr223.JRubyEngine.doEval(JRubyEngine.java:102)
        at org.jruby.embed.jsr223.JRubyEngine.eval(JRubyEngine.java:118)
        at org.jruby.embed.jsr223.JRubyEngine.eval(JRubyEngine.java:147)
        at com.example.App.main(App.java:11)
Caused by: org.jruby.exceptions.SystemCallError: (ENOENT) No such file or directory - uri:classloader:/META-INF/jruby.home/lib/ruby/gems/shared/bundler.lock
        at org.jruby.RubyIO.sysopen(org/jruby/RubyIO.java:1361)
        at org.jruby.RubyFile.initialize(org/jruby/RubyFile.java:321)
        at org.jruby.RubyClass.new(org/jruby/RubyClass.java:1054)
        at org.jruby.RubyIO.open(org/jruby/RubyIO.java:1286)
        at RUBY.open_file_with_flock(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/rubygems.rb:816)
        at RUBY.open_file_with_lock(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/rubygems.rb:802)
        at RUBY.lock(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/process_lock.rb:13)
        at RUBY.filesystem_access(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/shared_helpers.rb:105)
        at RUBY.lock(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/process_lock.rb:12)
        at RUBY.run(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/installer.rb:71)
        at RUBY.install(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/installer.rb:23)
        at RUBY.gemfile(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/inline.rb:64)
        at RUBY.temporary(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/settings.rb:159)
        at RUBY.gemfile(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/inline.rb:63)
        at RUBY.temporary(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/settings.rb:159)
        at RUBY.gemfile(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/bundler/inline.rb:58)
        at RUBY.<main>(<script>:4)
```