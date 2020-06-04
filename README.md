# Holiday Drills - Java 8
Here you can find the most important language features introduced with Java 8.

## Static Interface Methods
With Java 8 it is possible to define static methods in interfaces.
### How do I use it?
Just declare a method as static and provide an implementation as you would do in a plain old Java class:
```
interface MyFancyInterface {

    static void myFancyStaticMethod() {
        System.out.println("This is a static interface method");

    }
}
```
You can call such static interface methods only within the interface itself or through the interface. 
What that means is, that you can't call a static interface method through an instance of a class that is implementing
the interface:
```
public class myFancyClass {
  
    public void doSomethingFancy() {
        //As you see below, you call the method through the interface itself. 
        //You don't need a class that implements the interface in order to call it.
        //In fact, it's even not possible to call the method through the instance of a class implementing the interface.
        MyFancyInterface.myFancyStaticMethod();
    }

}
```
  
### Why should I use it?
Suppose you have a situation where you want to make sure that all classes that implement an interface 
behave in the same way regarding a specific task. A static interface method provides you the means to do exactly that.
### Use case   
>(You can find the implementation of the use case in this repository in the 
>[src/com/holidaydrills/interfaces](./src/com/holidaydrills/interfaces) directory).  

Say you have an [FormValidator](./src/com/holidaydrills/interfaces/FormValidator.java). This validator has some 
functionality to check the form inputs of
users in the checkout process of online shops, like addresses, emails, additional information.  
You have several implementations of that form validator for different online shops. This is because each online shop 
has specific validations for some fields. 
The shops are located in different countries, so maybe addresses are validated in different ways. Or the a field 
like "Additional Information" could allow 200 characters in one shop, in another it could have up to 1000 characters.  
But some of the fields - like the email address - have to be validated in exactly the same way even across locations. 
With a static interface method you can provide an implementation for such a validation and make sure, that implementing
classes will not override it.  
A sample implementation of the [FormValidator](./src/com/holidaydrills/interfaces/FormValidator.java) can be found 
[here](./src/com/holidaydrills/interfaces/FormValidatorImpl.java). You will recognize that it doesn't contain an 
implementation of the `validateEmail` method as it is already implemented as a static interface method within the
[FormValidator](./src/com/holidaydrills/interfaces/FormValidator.java).
  