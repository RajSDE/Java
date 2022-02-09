## Java ArrayList
Java ArrayList class uses a `dynamic array` for storing the elements. It is like an array, but there is no size limit. We can add or remove elements anytime. So, it is much more flexible than the traditional array. It is found in the `java.util` package. It is like the `Vector` in C++.

The ArrayList in Java can have the duplicate elements also. An ArrayList class extends `AbstractList` class which implements `List interface`. The List interface extends the `Collection` and `Iterable interfaces` in hierarchical order.

The important points about Java ArrayList class are:

- Java ArrayList class can contain duplicate elements.
- Java ArrayList class maintains insertion order.
- Java ArrayList class is non synchronized.
- Java ArrayList allows random access because array works at the index basis.
- In ArrayList, manipulation is little bit slower than the LinkedList in Java because a lot of shifting needs to occur if any element is removed from the array list.

The difference between a `built-in array` and an `ArrayList` in Java, is that the size of an array cannot be modified (if we want to add or remove elements to/from an array, we have to create a new one). While elements can be added and removed from an ArrayList whenever we want.

**ArrayList class declaration**
Let's see the declaration for java.util.ArrayList class.

```

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
```

**Create an ArrayList object called list**
Elements in an ArrayList are actually objects. To use other types, such as int, we must specify an equivalent wrapper class: `Integer`. For other primitive types, use: `Boolean` for boolean, `Character` for char, `Double` for double, etc:
```
import java.util.ArrayList;   // import the ArrayList class
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    ArrayList<Character> list3 = new ArrayList<Character>();
    ArrayList<Boolean> list3 = new ArrayList<Boolean>();
```

### `add()`
Add Items
```
ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
```
#### `add(int index, E element)`
```
List<String> colors = new ArrayList<>();  
colors.add("red");          // ["red"]  
colors.add("blue");         // ["red" , "blue"]  
colors.add(1, "white");     // ["red" , "white", "blue"]  
colors.add(0, "black");     // ["black", "red" , "white", "blue"]  
System.out.println(colors); // ["black", "red" , "white", "blue"]  
```

#### `addAll(Collection c)`
```
ArrayList<String> letters = new ArrayList<>();  
letters.add("A");  
letters.add("B");  
letters.add("C");  
    System.out.println(letters);      // [A, B, C]  
    ArrayList<String> words = new ArrayList<>();  
words.add("Apple");  
words.add("Ball");  
words.add("Cat");  
    System.out.println(words);       // [Apple, Ball, Cat]  
    System.out.println (letters.addAll(words)); //true  
    System.out.println(letters);     // [A, B, C, Apple, Ball, Cat]  
```


### `get()`
Access an Item
```
cars.get(0);
```

### `set()`
Change an Item
```
cars.set(0, "Opel");
```

### `remove()`
Remove an Item
```
cars.remove(0);
```

### `clear()`
Remove all the elements
```
cars.clear();
```

### `size`
ArrayList Size
```
cars.size();
```

### `sort()`

- Sort an ArrayList in `Ascending Order`
Another useful class in the java.util package is the Collections class, which include the sort() method for sorting lists alphabetically or numerically:
```
ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    Collections.sort(cars);  // Sort cars
    for (String i : cars) {
        System.out.println(i);
```

- Sort an ArrayList in `Descending Order`
```
Collections.sort(ArrayList, Collections.reverseOrder());
```