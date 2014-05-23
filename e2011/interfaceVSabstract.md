Abstract Classes Compared to Interfaces
-

**Abstract classes are similar to interfaces.** 

>  1. abstract classes, you can declare fields that are not static
>     and final, and define public, protected, and private concrete
>     methods.
> 
>  2. interfaces, all fields are automatically public, static, and
>     final, and all methods that you declare or define (as default
>     methods) are public. In addition, you can extend only one class,
>     whether or not it is abstract, whereas you can implement any number
>     of interfaces.

**Consider using abstract classes** 

> if any of these statements apply to your situation:
> 
> 1. You want to share code among several closely related classes.
> 2. You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than
> public (such as protected and private).
> 3. You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the
> object to which they belong.

**Consider using interfaces** 

> if any of these statements apply to your situation:
> 
> 1. You expect that unrelated classes would implement your interface. For example, the interfaces Comparable and Cloneable are implemented
> by many unrelated classes.
> 2. You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
> 3. You want to take advantage of multiple inheritance of type.

Abstract Class
--
An abstract class is a class that is declared abstract—it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.

An abstract method is a method that is declared without an implementation (without braces, and followed by a semicolon), like this:

```
public abstract class Move {
    abstract void moveTo(double deltaX, double deltaY);
    public String toString() {
        return "string";
    }
}
```

Interface type
--
A Java interface type declares methods but does not provide their implementations.

```
public interface Measurable {
    double getMeasure(); 
}
```

 - An interface type does not have instance variables.
 - All methods in an interface type are abstract; that is, they have a name, parameters, and a return type, but they don’t have an implementation.
 - All methods in an interface type are automatically public.
 - An interface type has no constructor. Interfaces are not classes, and you cannot construct objects of an interface type.

---
Sources:

 - Oracle: [Abstract Methods and Classes][1]
 - Cay S. Horstmann 2014: *Big Java: Early Objects*, 5th Edition

  [1]: http://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
