## Java Strings
**Strings** in Java are Objects that are backed internally by a char array. Since arrays are **immutable**(cannot grow), Strings are immutable as well. Whenever a change to a String is made, an entirely new String is created.

**Creating a String**

There are two ways to create a string in Java: 
- String literal: Each time you create a string literal, the JVM checks the "string constant pool" first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist in the pool, a new string instance is created and placed in the pool

```
String s = “I am a Great Person”;

String s1="Welcome";  
String s2="Welcome";    //It doesn't create a new instance  
```

- Using new keyword:  JVM will create a new string object in normal (non-pool) heap memory, and the literal "Welcome" will be placed in the string constant pool. The variable s will refer to the object in a heap (non-pool).

```
String s = new String (“I am a Great Person”);
```

## StringBuilder: 
The **StringBuilder** in Java represents a **mutable** sequence of characters. Since the String Class in Java creates an immutable sequence of characters, the StringBuilder class provides an alternate to String Class, as it creates a mutable sequence of characters.
Syntax:
```
StringBuilder str = new StringBuilder();
str.append("GFG");
```

<hr>

**The String class has a set of built-in methods that we can use on strings.**
### charAt() 
Returns the character at the specified index (position)
```
String myStr = "Hello";
char result = myStr.charAt(0);
System.out.println(result);
```

### length()
Returns the length of a specified string
```
String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
System.out.println(txt.length());
```



### compareTo()
Compares two strings lexicographically
```
String myStr1 = "Hello";
String myStr2 = "Hello";
System.out.println(myStr1.compareTo(myStr2));
```

### contains()
Checks whether a string contains a sequence of characters
```
String myStr = "Hello";
System.out.println(myStr.contains("Hel"));   // true
System.out.println(myStr.contains("e"));     // true
System.out.println(myStr.contains("Hi"));    // false
```

### contentEquals()
Checks whether a string contains the exact same sequence of characters of the specified CharSequence or StringBuffer
```
String myStr = "Hello";
System.out.println(myStr.contentEquals("Hello"));  // true
System.out.println(myStr.contentEquals("e"));      // false
System.out.println(myStr.contentEquals("Hi"));     // false
```

### copyValueOf()
Returns a String that represents the characters of the character array
```
char[] myStr1 = {'H', 'e', 'l', 'l', 'o'};
String myStr2 = "";
myStr2 = myStr2.copyValueOf(myStr1, 0, 5);
System.out.println("Returned String: " + myStr2);
```

### endsWith()
Checks whether a string ends with the specified character(s)
```
String myStr = "Hello";
System.out.println(myStr.endsWith("Hel"));   // false
System.out.println(myStr.endsWith("llo"));   // true
System.out.println(myStr.endsWith("o"));     // true
```

### equals()
Compares two strings. Returns true if the strings are equal, and false if not
```
String myStr1 = "Hello";
String myStr2 = "Hello";
String myStr3 = "Another String";
System.out.println(myStr1.equals(myStr2)); // Returns true because they are equal
System.out.println(myStr1.equals(myStr3)); // false
```

### indexOf()
Returns the position of the first found occurrence of specified characters in a string
```
String myStr = "Hello planet earth, you are a great planet.";
System.out.println(myStr.indexOf("planet"));
```

### lastIndexOf() 
Returns the position of the last found occurrence of specified characters in a string
```
String myStr = "Hello planet earth, you are a great planet.";
System.out.println(myStr.lastIndexOf("planet"));
```


### isEmpty() 
Checks whether a string is empty or not
```
String myStr1 = "Hello";
String myStr2 = "";
System.out.println(myStr1.isEmpty());
System.out.println(myStr2.isEmpty());
```
### replace() 
Searches a string for a specified value, and returns a new string where the specified values are replaced
```
String myStr = "Hello";
System.out.println(myStr.replace('l', 'p'));
```

### startsWith() 
Checks whether a string starts with specified characters
```
String myStr = "Hello";
System.out.println(myStr.startsWith("Hel"));   // true
System.out.println(myStr.startsWith("llo"));   // false
System.out.println(myStr.startsWith("o"));     // false
```

### toLowerCase() 
Converts a string to lower case letters
```
String txt = "Hello World";
System.out.println(txt.toUpperCase());
System.out.println(txt.toLowerCase());
```

### toUpperCase() 
Converts a string to upper case letters
```
String txt = "Hello World";
System.out.println(txt.toUpperCase());
System.out.println(txt.toLowerCase());
```

### trim() 
Removes whitespace from both ends of a string
```
String myStr = "       Hello World!       ";
System.out.println(myStr);
System.out.println(myStr.trim());
```

### valueOf() 
Returns the string representation of the specified value
```
int value=30;  
String s1=String.valueOf(value);  
System.out.println(s1+10);//concatenating string with 10  
```



### toString() 
Returns the value of a String object
```
public static void main(String args[]) {
      String Str = new String("Welcome to My JavaNotes");

      System.out.print("Return Value :");
      System.out.println(Str.toString());
   }
```



### toCharArray() 
Converts this string to a new character array
```
String s1="hello";  
char[] ch=s1.toCharArray();  
for(int i=0;i<ch.length;i++){  
    System.out.print(ch[i]);  
}
```



### substring() 
Returns a new string which is the substring of a specified string
```
String s1="RajSingh";  
    System.out.println(s1.substring(2,4));  //returns jS  
    System.out.println(s1.substring(2));    //returns jSingh  
```



### subSequence() 
Returns a new character sequence that is a subsequence of this sequence
```
String Str = "Welcome to my world";
  
        // prints the subsequence from 0-7, exclusive 7th index
        System.out.print("Returns: ");
        System.out.println(Str.subSequence(0, 7));
  
        System.out.print("Returns: ");
        System.out.println(Str.subSequence(10, 24));
```



### split() 
Splits a string into an array of substrings
```
String s1="java string split method";  
String[] words=s1.split("\\s");     //splits the string based on whitespace.

    //using java foreach loop to print elements of string array  
    for(String w:words){  
        System.out.println(w);  
```



### replaceAll() 
Replaces each substring of this string that matches the given regular expression with the given replacement
```
String s1="This is a very good website";  
    String replaceString=s1.replaceAll("a","e");//replaces all occurrences of "a" to "e"  
    System.out.println(replaceString);  
```



### replaceFirst() 
Replaces the first occurrence of a substring that matches the given regular expression with the given replacement
```
 String str = "This website providing free tutorials";
 
    //Only Replace first 's' with '9' 
    String str1 = str.replaceFirst("s", "9");
    System.out.println(str1);
```

### matches()
Searches a string for a match against a regular expression, and returns the matches

```
String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.matches("(.*)Tutorials(.*)"));       //True

      System.out.print("Return Value :" );
      System.out.println(Str.matches("Tutorials"));               //False

      System.out.print("Return Value :" );
      System.out.println(Str.matches("Welcome(.*)"));             //True
```



