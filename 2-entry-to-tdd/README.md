# Basics

Test-Driven-Development (short: TDD)

## What is TDD?

### How-to

### Best Practices & Tips

## Exercise

The exercises are split up into two folders, one containing the exercise material and one containing the solutions.
When you don't know any further, ask a trainer, or as a last resort, look into the solutions folder.

The exercise is the following:

---
[ENG]
```
The following is a conversation with a customer. Focus on the requirements.

 >> I would like to be able to enter a password into the console and then be informed
whether the password complies with the guidelines.
You should not enter less than five characters, but also not more than ten. Otherwise it will be too long.
For the characters I thought that there should be one of each kind. 
So of course any number and letters, but also special characters would be quite good. But spaces should not be possible. 
If the password is not correct I want to see an output in the console that it is not valid. Otherwise it should say that it is ok.
```
---

<details>
  <summary>[GER] - Hier klicken, wenn eine Deutsche Übersetzung benötigt wird</summary>

  ```
  Das folgende ist ein Gespräch mit einem Kunden. Konzentriere dich auf die gestellten Anforderungen.

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

To start your journy, go to this file: [OutputFormatterTest.java](password-example/uebung/src/test/java/output/OutputFormatterTest.java), 
or this file: [PasswordValidatorTest.java](password-example/uebung/src/test/java/validator/PasswordValidatorTest.java)
and start writing your tests. after you are done writing them, edit the source code to make the tests green.

## Resources

[Test-Driven Development bei Example - Kent Beck](http://94.83.148.19/L/books/Test%20Driven%20Development%20By%20Example%20-%20Kent%20Beck.pdf)
