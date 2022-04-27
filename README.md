# Binary-Converter-And-More
## Description

Program to convert values between Decimal, Binary, Oct, and ARC Assembly Commands using Java

Implementation was made with a different formula for each method, mostly using recursion.
I save a lot of the information as strings and convert between Integers and Doubles so that aspect 
of the program could definitely be made more efficient. 

The program is very easy to test as it uses MAVEN to import the JUnit 5 library for testing each
conversion method individually. I've only added a couple of tests but will add more to be confident
there is no edge cases.

I was planning on adding JSwing GUI library to the program, but I am still considering it. This is 
definable not a long-term project I just wanted to use Java to make a simple conversion calculator
with the addition of converting to Assembly ARC commands.

## License

Please see the LICENSE file inside the repository.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Documentation](#documentation)
- [Tests](#tests)

## Installation

Installing this library is rather easy. Just download the code and run it through your own IDE.
The pom.xml is included for the respective JUnit 5 library needed for the test cases, use MAVEN
to work the dependency. If you don't know how that works or don't want the JUnit test cases then
just delete the FunctionTest.java file.

## Usage

I did originally plan to make a GUI with Java Swing, but I do not think it is worth the time to 
learn it. I am trying to experience in as many languages as possible so I would rather use my 
time self teaching other languages. Maybe one day when I have more free time I'll come back and 
set up GUI for it. Therefore, the only way to use this program is by running it through your IDE
and typing in the commands.
### Commands
- Quit
- Convert
- Assembly
- Load

## Documentation

This is documentation saved for myself to better organize on what functions are currently working
or being developed:
- DecimalToBinary
- HexToDecimal

## Tests

I set up a couple tests in the test/java/FunctionTest.java file. So far I am doing 5 tests per function
I create. This is to attempt to hit any outliers and also test some basic random examples. You can write 
more if you'd like using JUnit.

## Credits

Jupiter , Maven , JUnit 5.8.2 