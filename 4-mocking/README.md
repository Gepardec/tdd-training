# Mocking

## A little bit of theory

### What is mocking?

- Mocking is used in (unit-)testing
- To mock: to replace with an imitation
- To simulate behavior of real things

### Why mock?

- Code to be tested has dependencies to other (complex) objects
- Isolate behavior
- To increase performance (e.g. mock method that creates a file to increase test performance)
- To make test-scenarios easier to implement (actual error codes are often hard to force)

### Drawbacks of mocking

- Mocks have to evolve with the real functionality (e.g. mocks have to be changed after bugfix) - a lot of refactoring
- Mocking often leads to code duplication
- Mocking can complicate the design of the software (not as much thought has to be put into code design since dependencies do not matter when mocking excessively)

### Mocking-Types

- Stubbing – simulate (only mock behavior – e.g. replace DB with some kind of in-memory-structure)
- Mocking – simulate and verify (mock the whole object – e.g create mocking-DB and verify DB state)

### Proxy based Mocking

- Mockito, EasyMock
- Create Proxy object
- On method call of object -> proxy object either calls real or mocked method
- Restrictions: no mocking of private and/or static and/or final methods/classes

### Classloader remapping based Mocking

- [PowerMock](https://github.com/powermock/powermock)
- Create Mock class
- Whole class can be mocked since classloader is told to remap to mock class(also private, static, final things)

### Notes

- Mocking in integration-testing should be used on service you have no control over

## Mockito basics step-by-step

In this example project [BookBusinessImpl](src/main/java/com/gepardec/tdd/BookBusinessImpl.java) is the class to be tested.
It performs operations on book-titles that are retrieved through the [BookService-Interface](src/test/java/com/gepardec/tdd/workdir/BookService.java)
which represents something we do not have control over like an external service.

In the [workdir package](src/test/java/com/gepardec/tdd/workdir) you already find all classes that you will need for completion of this exercise.

### Step 1: Stubbing

Implement the test already present in [BookBusinessImplStubTest](src/test/java/com/gepardec/tdd/workdir/BookBusinessImplStubTest.java), which should test
`BookBusinessImpl.retrieveAllJavaBookTitles(...)` by using [BookServiceStub](src/test/java/com/gepardec/tdd/workdir/BookServiceStub.java) to control the data returned by the external service.

### Step 2: Mockito

Now we tackle actually mocking the behavior of our external service by using Mockito. To create the mock-object we use Mockitos `mock(...)` method.
Once the object has been created we also have to specify the behavior of it. To do so, your code should look something like:

```java
Service service = mock(Service.class);
when(service.call()).thenReturn(data);
```

Again implement a test (this time in [BookBusinessImplMockitoTest](src/test/java/com/gepardec/tdd/workdir/BookBusinessImplMockitoTest.java))
on `BookBusinessImpl.retrieveAllJavaBookTitles(...)` this time by mocking the external service.

### Step 2: BDD

A popular testing practice that is closely related to TDD is Behavior Driven Development or
[BDD](https://www.tricentis.com/blog/bdd-behavior-driven-development/). It's key characteristic is a very descriptive way to write tests that can also
act as a documentation of your code. It uses a Given-When-Then-Structure when writing tests, for example:

```java
// given
user.setRole(Roles.Admin);

// when
Response respone = service.call(user);

// then
response.getReturnCode().isOk;
```

Try implementing the same test as in Step 2, but now using a BDD-like structure for your test method.
Mockito also has methods matching the BDD way of testing:

```java
given(service.call()).willReturn(data);
```

### Step 3: Verifying behaviour

When testing we also want to verify the calls we perform on mocks. We can do things like verifying how often a call took place or with which input
parameters a method has been called.

```java
verify(service, Mockito.times(n)).call(params);
```

Now write a test, again in [BookBusinessImplMockitoTest](src/test/java/com/gepardec/tdd/workdir/BookBusinessImplMockitoTest.java), that mocks the
external service and verifies the behaviour of `BookService.deleteBook(...).`

### Step 4: Capture argument

To further verify input parameters we can use `ArgumentCaptors`

```java
Mockito.verify(service).call(eq(param1), argumentCaptor.capture());
assertEquals(param2, argumentCaptor.getValue());
```

Same thing as in Step 3 now by using `ArgumentCaptors` :)

### Step 5: Mockito Annotations

To minimize repeatedly setting up mock objects Mockito can also create mocks via annotations. The following annotations will be needed for this step:

```java
// object to be mocked
@Mock

// object which holds the mocks
// mocks are injected into object
@InjectMocks

// ArgumentCaptor
@Captor
```

Who initializes those mocks for us? The `MockitoJUnitRunner`.

To use the runner we either have to annotate our class with

```java
@RunWith(MockitoJUnitRunner.class)
```

Or we can use Mockito rules which also provides us with more tools for testing(fail on timeout, file/directory creation, setting up resources, ...).
Also with rules we can create multiple rules in one test class and use them to our liking.
For this exercise you will only need:

```java
@Rule
public MockitoRule mockitoRule = MockitoJUnit.rule();
```

Try recreating all methods of [BookBusinessImplMockitoTest](src/test/java/com/gepardec/tdd/workdir/BookBusinessImplMockitoTest.java)
in [BookBusinessImplMockInjectionTest](src/test/java/com/gepardec/tdd/workdir/BookBusinessImplMockInjectionTest.java) by using only injected mocks.

### Step 6: Review

All done :)

Solutions to this exercise can be found [here](src/test/java/com/gepardec/tdd/solution) and there are some further features highlighted [here](src/test/java/com/gepardec/tdd/additional)

## Further references

**Sample Project:**

- [Good course that also inspired this tutorial A LOT](https://github.com/in28minutes/MockitoTutorialForBeginners)

**Further references:**

- [Mocking in a microservice architecture](https://circleci.com/blog/how-to-test-software-part-i-mocking-stubbing-and-contract-testing/)
