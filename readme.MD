#Gadget Inspector [![Build Status](https://travis-ci.org/evaldobratti/inspectorgadget.svg?branch=master)](https://travis-ci.org/evaldobratti/inspectorgadget)
##Introduction
The purpose of this project is to help you debugging and analysing your objects in runtime, even if you haven't lanched your applicatin on debug mode on your IDE, and even if you're using an already generated build of your app.
You will inspect and execute some codes, inspect the states of objects, values of their fields, relationships, call their methods, execute queries, update databases, everything that you could do programmatically in your app.


## How do I install it?
Currently you must install it in your local repository mannually, so,
```
git clone https://github.com/evaldobratti/inspectorgadget & cd inspectorgadget & git checkout 1.0 & mvn install
```

and add it to your pom
```
<dependency>
    <groupId>inpectorgadget</groupId>
    <artifactId>inspector-gadget-core</artifactId>
    <version>1.0</version>
</dependency>
```
and choose one implementation, python or groovy.
```
<dependency>
    <groupId>inpectorgadget</groupId>
    <artifactId>inspector-gadget-groovy</artifactId>
    <version>1.0</version>
</dependency>
```
or
```
<dependency>
    <groupId>inpectorgadget</groupId>
    <artifactId>inspector-gadget-python</artifactId>
    <version>1.0</version>
</dependency>
```

##How do I use it?
You will use some windows to interact with the inspector, inspecting and executing a piece of code, that can be written, currently, in groovy and python languages. You can use all power of this languages in your code, lambdas, closures, list comprehensions, declare python and groovy classes, functions, everything that languages provides you.

**CTRL + E**  executes your code  
**CTRL + I**  inspects your code

It will execute the code that is selected, if there is no code selected, it will the entire script.

The project is designed to help you to program your own windows, but it provides you ways to use as it is.
Just call

```java
new GroovyInspector().start();
```
for Groovy Inspector, or

```java
new JythonInspector().start();
```
for Python Inspector version.

The inspector will try to solve the imports that your code may use, so, you don't have to explicitly declare imports statements, inspector will search in the classpath, and if only one class with the required name is found, it will solve that dependency for you.

You can reference the object that your inspector is referencing with the 'self'\* keyword.
*: In groovy too, unfortunately you can't change 'this' reference in groovy scripts  =(

##How do I extent it?
If you want to use another language that is not currently implemented, you can just extend [inspectorgadget.Executor](https://github.com/evaldobratti/inspectorgadget/blob/master/inspector-gadget-core/src/main/java/inspectorgadget/Executor.java) and implement the abstract methods, then pass this object to [inspectorgadget.DefaultInspector](https://github.com/evaldobratti/inspectorgadget/blob/master/inspector-gadget-core/src/main/java/inspectorgadget/defaults/DefaultInspector.java).