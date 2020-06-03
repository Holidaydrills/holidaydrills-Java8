#Holiday Drills - Java 8
Here you can find the most important language features introduced with Java 8.

## Static Interface Methods
With Java 8 it is possible to define static methods in interfaces.
###How do I use it?
Just declare a method as static and provide an implementation as you would do in a plain old Java class:
```
interface MyFancyInterface {

    static void myFancyStaticMethod() {
        System.out.println("This is a static interface method");

    }
}
```
You can call such static interface methods only within the interface itself or through the interface. 
What that means is, that you can't call a static interface method through a class that is implementing
it:
```
public class myFancyClass {
  
    public void doSomethingFancy() {
        //As you see below, you call the method through the interface itself. 
        //You don't need a class that implements the interface in order to call it.
        //In fact, it's even not possible to call the method through the implementing class.
        MyFancyInterface.myFancyStaticMethod();
    }

}
```
  
###Why should I use it?
Suppose you have a situation where you want to make sure that all classes that implement an interface 
behave in the same way regarding a specific task. A static interface method provides you the means to do exactly that.  
**A use case could be as follows**:  
Say you have an ` interface FormValidator`. This validator has some functionality to check the form inputs of
users in the checkout process of online shops, like addresses, emails, additional information.  
You have several implementations of that form validator for different
for different online shops. This is because each online shop has specific validations for some fields. 
The shops are located in different countries, so maybe addresses are validated in different ways. Or the a field 
like "Additional Information" could allow 200 characters in one shop, in another it could have up to 1000 characters.  
But some of the fields have to be validated in exactly the same way even across locations. One example is the email 
address. This this can be validated in exactly the same way in all online shops.
 


One example could be a form validator that checks
if all fields in 