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

## ArrayList Methods

| Methods   | Description|
| :---------| :----------|
| `add(int index, Object element)`  |	This method is used to insert a specific element at a specific position index in a list.    |
| `add(Object o)`   |	This method is used to append a specific element to the end of a list.  |
| `addAll(Collection C)`    |	This method is used to append all the elements from a specific collection to the end of the mentioned list, in such an order that the values are returned by the specified collection’s iterator.   |
| `addAll(int index, Collection C)` |	Used to insert all of the elements starting at the specified position from a specific collection into the mentioned list.   |
| `clear()` |	This method is used to remove all the elements from any list.   |
| `clone()` |	This method is used to return a shallow copy of an ArrayList.   |
| `contains?(Object o)` |	Returns true if this list contains the specified element.   |
| `ensureCapacity?(int minCapacity)`    |	Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument. |
| `forEach?(Consumer<? super E> action)`    |	Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.    |
| `get?(int index)` |	Returns the element at the specified position in this list. |
| `indexOf(Object O)`   |	The index the first occurrence of a specific element is either returned, or -1 in case the element is not in the list.  |
| `isEmpty?()`  |	Returns true if this list contains no elements. |
| `lastIndexOf(Object O)`   |	The index of the last occurrence of a specific element is either returned or -1 in case the element is not in the list. |
| `listIterator?()` |	Returns a list iterator over the elements in this list (in proper sequence).    |
| `listIterator?(int index)`    |	Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.    |
| `remove?(int index)`  |	Removes the element at the specified position in this list. |
| `remove?(Object o)`   |	Removes the first occurrence of the specified element from this list, if it is present. |
| `removeAll?(Collection c)`    |	Removes from this list all of its elements that are contained in the specified collection.  |
| `removeIf?(Predicate filter)` |	Removes all of the elements of this collection that satisfy the given predicate.    |
| `removeRange?(int fromIndex, int toIndex)`    |	Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive. |
| `retainAll?(Collection<?> c)` |	Retains only the elements in this list that are contained in the specified collection.  |
| `set?(int index, E element)`  |	Replaces the element at the specified position in this list with the specified element. |
| `size?()` |	Returns the number of elements in this list.    |
| `spliterator?()`  |	Creates a late-binding and fail-fast Spliterator over the elements in this list.    |
| `subList?(int fromIndex, int toIndex)`    |	Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.  |
| `toArray()`   |	This method is used to return an array containing all of the elements in the list in the correct order. |
| `toArray(Object[] O)` |	It is also used to return an array containing all of the elements in this list in the correct order same as the previous method.    |
| `trimToSize()`    |	This method is used to trim the capacity of the instance of the ArrayList to the list’s current size.   |

<hr>


### `add()`
It is used to append the specified element at the end of a list.
```
ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
```
### `add(int index, E element)`
It is used to insert the specified element at the specified position in a list.
```

List<String> colors = new ArrayList<>();  
colors.add("red");          // ["red"]  
colors.add("blue");         // ["red" , "blue"]  
colors.add(1, "white");     // ["red" , "white", "blue"]  
colors.add(0, "black");     // ["black", "red" , "white", "blue"]  
System.out.println(colors); // ["black", "red" , "white", "blue"]  
```

### `addAll(Collection c)`

It is used to append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
```
//  boolean addAll(Collection<? extends E> c)
//  boolean addAll(int index, Collection<? extends E> c)

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
Another useful class in the java.util package is the `Collections class`, which include the sort() method for sorting lists alphabetically or numerically:
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

### `isEmpty()`
It returns true if the list is empty, otherwise false.
```
    // creating an Empty Integer ArrayList
    ArrayList<Integer> arr = new ArrayList<Integer>(10);
  
    // check if the list is empty or not using function
    boolean ans = arr.isEmpty();

        if (ans == true)
            System.out.println("The ArrayList is empty");
        else
            System.out.println("The ArrayList is not empty");
```

### `Iterator()`
The ArrayList.Iterator () returns an iterator over the elements in this list.
```
ArrayList<String>arrlist = new ArrayList<String>();  
arrlist.add("d");  
arrlist.add("dd");  
arrlist.add("ddd");  
arrlist.add("dddd");  
arrlist.add("ddddd");  
System.out.println(arrlist);    // [d, dd, ddd, dddd, ddddd]  
  
Iterator<String> iterator = arrlist.iterator();  
while (iterator.hasNext())  
{  
String i = iterator.next();  
System.out.println(i);  
```

### `listIterator()`
The listIterator () method of Java ArrayList returns a list iterator over the elements in this list starting at the specified position in this list.
```
ArrayList<String> arrlist = new ArrayList<String>();  
arrlist.add("d");  
arrlist.add("dd");  
arrlist.add("ddd");  
arrlist.add("dddd");  
arrlist.add("ddddd");  
    System.out.println(arrlist);    // [d, dd, ddd, dddd, ddddd]  
  
ListIterator<String> iterator = arrlist.listIterator(2);  
while (iterator.hasNext())  
    {  
    String i = iterator.next();  
    System.out.println(i);
    }  
```
Output:
```
[d, dd, ddd, dddd, ddddd]
ddd
dddd
ddddd
```

### `lastIndexOf() `
It is used to return the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.
```
ArrayList<Integer> arr = new ArrayList<Integer>(7);
  
        // using add() to initialize values
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(30);
        arr.add(30);
        arr.add(40);
        int element = arr.lastIndexOf(30);
        if (element != -1)
            System.out.println("the lastIndexof of + " 30 is " + element);
        else
            System.out.println("30 is not in" + " the list;

        // the lastIndexof of 30 is 5
```

### `Object[] toArray()`
It is used to return an array containing all of the elements in this list in the correct order.
```
List<Integer> al = new ArrayList<Integer>();
    al.add(10);
    al.add(20);
    al.add(30);
    al.add(40);
  
Object[] objects = al.toArray();
  
    // Printing array of objects
    for (Object obj : objects)
        System.out.print(obj + " ");
```
**Note:** toArray() method returns an array of type Object(Object[]). We need to typecast it to Integer before using as Integer objects. 
```
List<Integer> al = new ArrayList<Integer>();
    al.add(10);
    al.add(20);
    al.add(30);
    al.add(40);
  
    // Error: incompatible types: Object[]
    // cannot be converted to Integer[]
    Integer[] objects = al.toArray();
  
    for (Integer obj : objects)
        System.out.println(obj);
```