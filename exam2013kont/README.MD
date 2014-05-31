enum
=

```
public enum Currency {PENNY(1), NICKLE(5), DIME(10), QUARTER(25)};
```
But for this to work you need to define a member variable and a constructor because PENNY (1) is actually calling a constructor which accepts int value , see below example.
```   
public enum Currency {
        PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
        private int value;

        private Currency(int value) {
                this.value = value;
        }
        
        public int getValue() {
            return value;
        }
} 
```

Enumeration Types
-
In many programs, you use variables that can hold one of a finite number of values. For example, in the tax return class, the status instance variable holds one of the values SINGLE or MARRIED. We arbitrarily declared SINGLE as the number 1 and MARRIED as 2. If, due to some programming error, the status variable is set to another integer value (such as -1, 0, or 3), then the programming logic may produce invalid results.

In a simple program, this is not really a problem. But as programs grow over time, and more cases are added (such as the “married filing separately” status), errors can slip in. Java version 5.0 introduces a remedy: enumeration types. An enumeration type has a finite set of values,
for example

```
public enum FilingStatus { SINGLE, MARRIED, MARRIED_FILING_SEPARATELY }
```
You can have any number of values, but you must include them all in the enum declaration.
    You can declare variables of the enumeration type:
```
FilingStatus status = FilingStatus.SINGLE;
```

If you try to assign a value that isn’t a FilingStatus, such as 2 or "S", then the compiler reports an error.

Use the == operator to compare enumeration values, for example:
```
if (status == FilingStatus.SINGLE) . . .
```
Place the enum declaration inside the class that implements your program, such as

```
public class TaxReturn {
    public enum FilingStatus { SINGLE, MARRIED, MARRIED_FILING_SEPARATELY }
    .. . 
}
```
-----

Enum Types
-

An enum type is a special data type that enables for a variable to be a set of predefined constants. The variable must be equal to one of the values that have been predefined for it. Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.

Because they are constants, the names of an **enum type's fields are in uppercase letters**.

In the Java programming language, you define an enum type by using the enum keyword. For example, you would specify a days-of-the-week enum type as:

```
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}
```

You should use enum types any time you need to represent a fixed set of constants. That includes natural enum types such as the planets in our solar system and data sets where you know all possible values at compile time—for example, the choices on a menu, command line flags, and so on.

Here is some code that shows you how to use the Day enum defined above:

```
public class EnumTest {
    Day day;
    
    public EnumTest(Day day) {
        this.day = day;
    }
    
    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
    
    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
```

The output is:

    Mondays are bad.
    Midweek days are so-so.
    Fridays are better.
    Weekends are best.
    Weekends are best.

---
Sources:

 - Cay S. Horstmann 2014: *Big Java: Early Objects*, 5th Edition
 - Oracle
