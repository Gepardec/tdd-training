# Basics

Test-Driven-Development (short: TDD) is a software development approach in which tests are written to specify what the code will do in the future.

In other words, you write your specifications for each feature is written first and if the test fails, new code is written in order to pass the test.
After that you will optionally do some refactoring to clean up the written code.

TDD instructs developers to write new code only if an automated test has failed first.

```text
┌────────────┐     ┌────────────┐
│            │     │            │
│ Write Test ├────►│ Write Code │
│            │     │            │
└────────────┘     └──────┬─────┘
     ▲                    │
     │    ┌──────────┐    │
     │    │          │    │
     └────┤ Refactor │◄───┘
          │          │
          └──────────┘
```

## Acceptance TDD and Developer TDD

1. Acceptance TDD (ATDD)
   - With ATDD you write a single test, that fulfills the requirement of the specification or satisfies the behavior of the system
   - ATDD is also known as Behavioral Driven Development (BDD)
2. Developer TDD (Simply TDD)
   - Here you write a single Unit Test and then just enough code to fulfill that test

## Best Practices & Tips

Follow those rules:

- Write the test before writing the implementation
- Write new code only when the test is failing
- Rerun all tests every time the implementation changes
- Pass all tests before writing a new one
- Refactor only after passing all tests

Best Practices:

- Use descriptive names for test methods
- Place the tests in the same package as the implementation
- Name test classes in a similar way as the implementation (e.g. `ClassName` -> `ClassNameTest`)
- Write the simplest code to pass the test
- Write assertions first
- Do not introduce dependencies between tests
- Tests must run fast
- Use mocks (more on that in another module of this training)

For a more detailed description [look here](https://scand.com/company/blog/test-driven-development-best-practices/).

## Exercise

The exercises are split up into two folders, one containing the exercise material and one containing the solutions.
When you don't know any further, ask a trainer, or as a last resort, look into the solutions folder.

The exercise is the following:

---

[ENG]

```text
The following is a conversation with a customer. Focus on the requirements and implement these step by step with the Test-Driven approach.

 >> I would like to be able to enter a password into the console and then be informed
whether the password complies with the guidelines.
You should not enter less than five characters, but also not more than ten. Otherwise it will be too long.
For the characters I thought that there should be one of each kind.
So of course any number and letters, but also special characters would be quite good. But spaces should not be possible.
If the password is not correct I want to see an output in the console that it is not valid. Otherwise it should say that it is ok.
```

---

<!-- markdownlint-disable MD033 -->
<details>
  <summary>[GER] - Hier klicken, wenn eine Deutsche Übersetzung benötigt wird</summary>

```text
Das folgende ist ein Gespräch mit einem Kunden. Konzentriere dich auf die gestellten Anforderungen und implementiere diese Schritt für Schritt mit dem Test-Driven Ansatz.

 >> Ich möchte ein Passwort in die Konsole eingeben können und danach informiert werden,
ob das Passwort auch den Richtlinien entspricht.
Es sollten schon nicht weniger als fünf Zeichen eingegeben werden, aber auch nicht mehr als zehn. Ansonsten wird das zu lang.
Bei den Zeichen hab ich mir überlegt, dass schon von jeder Art eins dabei sein sollte.
Also natürlich irgend eine Zahl und Buchstaben, aber auch Sonderzeichen wären sicher ganz gut.
Aber Leerzeichen sollen bitte nicht möglich sein.
Wenn das Passwort dann nicht stimmt möchte ich in der Konsole eine Ausgabe sehen, dass das nicht valide ist.
Ansonsten soll da stehen, dass es in Ordnung ist.
```

</details>

---

To start your journy, go to this file: [OutputFormatterTest.java](exercise/src/test/java/output/OutputFormatterTest.java),
or this file: [PasswordValidatorTest.java](exercise/src/test/java/validator/PasswordValidatorTest.java)
and start writing your tests. after you are done writing them, edit the source code to make the tests green.

## Resources

[Test-Driven Development bei Example - Kent Beck](http://94.83.148.19/L/books/Test%20Driven%20Development%20By%20Example%20-%20Kent%20Beck.pdf)
