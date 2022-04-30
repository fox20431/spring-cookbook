## How to generate the bean by the annotation?

Injecting the field by constructor is recommended.

If the class don't have constructor, its default no-argument constructor is adopted to instantiate.

By comparing 'Greeting' and 'SecondGreeting', we can get that if anyone constructor have only one constructor, it must be adopted to instantiate.

We can then guess the choice of the constructor is related to the order.

By comparing 'SecondGreeting' and 'ThirdGreeting', we can get that the constructor's order can't decide which constructor is called to instantiate. Select the no-argument constructor by default when the class has multiple constructors.  