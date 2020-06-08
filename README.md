# Holiday Drills - Java 8
Here you can find the most important language features introduced with Java 8.

## Static Interface Methods
With Java 8 it is possible to define static methods in interfaces.
### How does it work?
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
>There you will find 
>* a [FormValidator](./src/com/holidaydrills/interfaces/FormValidator.java) interface which contains a static method for
>email address validation. 
>* a [FormValidatorImpl](./src/com/holidaydrills/interfaces/FormValidatorImpl.java) class which represents the 
>implementation of the interface. It doesn't contain any email validation method.
>* a [WebShopCheckout](./src/com/holidaydrills/interfaces/WebShopCheckout.java) class which represents the checkout of
>an online shop that uses the email validation. This class calls the static email validation method of the interface.

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
  
## Default Interface Methods
With Java 8 it is possible to define not only abstract methods in interfaces, but you can also provide methods with a 
default implementation.

## How does it work?
It's quite simple: you just need to use the `default` keyword in the method declaration and provide an implementation
as you would usually do in a Java class.
```
public interface FancyInterface {

    default String sayHello() {
        System.out.println("Hi there");
    }

}
```
That's actually it. Now this method can be called through the instance of an implementing class even if this method is 
not implemented by that class:
```
public class FancyInterfaceImpl implements FancyInterface{
    // Nothing here, still you could call the 'sayHello()' method e.g. from another class
}

public class AnotherClass {
    public void callFancyMethod() {
        MyFancyInterfaceImpl fancyInstance = new MyFancyInterfaceImpl();
        fancyInstance.sayHello(); // Will print 'Hi there'
    }
}
``` 
If the class that inherits from the `FancyInterface` implements the `sayHello` method then this implementation
will be used instead of the default one: 
```
public class FancyInterfaceImpl implements FancyInterface{
    // Now the sayHello method is imeplemented in the concrete class
    public void sayHello() {
        System.out.println("Hello everyone!");
    }
}

public class AnotherClass {
    public void callFancyMethod() {
        MyFancyInterfaceImpl fancyInstance = new MyFancyInterfaceImpl();
        fancyInstance.sayHello(); // Will print 'Hello everyone!' instead of 'Hi there'
    }
}
```
## Why should I use it?
Suppose you provide an interface that is implemented by a lot of other classes. Now you want to add additional 
feature to your interface and you would do that by adding another method.  
Imagine what would happen if you just add an additional abstract method to the interface. Every implementing class would
need to adopt by implementing that additional method.  
Luckily you can avoid that by declaring the new method as a `default` one and provide an implementation right in your 
interface. All classes implementing that interface can now stay unchanged and just use the default implementation you
provided. As soon as they need or want to have an own implementation of that method they could just implement is (as in
our second example above).
## Good to know
### What happens when interfaces with default implementations get extended?
When you extend an interface that contains a default implementation of a method there are three possibilities:
1.  You just don't mention the method at all: Then the default implementation is still valid
1.  You declare the default method in the extending interface (that means you provide an abstract method with the same 
name): That makes the method abstract so that an implementing class must provide an implementation.
1.  You provide a new default implementation: That way the default implementation from the extending interface becomes 
valid  

Example 1: You don't mention the default method
```
public interface FancyInterface {

    default String sayHello() {
        System.out.println("Hi there");
    }

}

public interface EvenMoreFancyInterface extends FancyInterface {
    // Nothing here. The original default implementation is still valid.
}

public class EvenMoreFancyInterfaceImpl implements EvenMoreFancyInterface {
    // The sayHello method isn't implemented so the original default implementation will be used.
}

public class AnotherClass {
    EvenMoreFancyInterfaceImpl fancyInterfaceImpl = new EvenMoreFancyInterfaceImpl();
    fancyInterfaceImpl.sayHello(); // Will print "Hi there"
}
```  

Example 2: You declare the default method in the extending interface
```
public interface FancyInterface {

    default String sayHello() {
        System.out.println("Hi there");
    }

}

public interface EvenMoreFancyInterface extends FancyInterface {
    // No you declare the sayHello method without providing a default imeplementation.
    String sayHello();
}

public class EvenMoreFancyInterfaceImpl implements EvenMoreFancyInterface {
    // As it is now an abstract method you have to implement it.
    public String sayHello() {
        System.out.println("Hello over there!");
    }
}

public class AnotherClass {
    EvenMoreFancyInterfaceImpl fancyInterfaceImpl = new EvenMoreFancyInterfaceImpl();
    fancyInterfaceImpl.sayHello(); // Prints "Hello over there!" as it is not using the default implementation anymore.
}
```
Example 3: You provide a new default implementation
```
public interface FancyInterface {

    default String sayHello() {
        System.out.println("Hi there");
    }

}

public interface EvenMoreFancyInterface extends FancyInterface {
    // Here a new default implementation is provided.
    default String sayHello() {
        System.out.println("Hey!");
    }
}

public class EvenMoreFancyInterfaceImpl implements EvenMoreFancyInterface {
    // Nothing here. The default implementation of the second interface is valid.
}

public class AnotherClass {
    EvenMoreFancyInterfaceImpl fancyInterfaceImpl = new EvenMoreFancyInterfaceImpl();
    fancyInterfaceImpl.sayHello(); // Prints "Hey!" which is the default implementation of the second interface.
}
```