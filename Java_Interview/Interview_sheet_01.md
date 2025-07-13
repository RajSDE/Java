### **1. What is the difference between JDK, JRE, and JVM?**

| Component                          | Description                                                                                                                     |
| ---------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| **JVM (Java Virtual Machine)**     | Runtime engine that executes Java bytecode (`.class` files). Platform-dependent. Doesn't understand Java source, only bytecode. |
| **JRE (Java Runtime Environment)** | JVM + standard Java class libraries + runtime resources. Used to run Java applications. Doesn't include compiler/debugger.      |
| **JDK (Java Development Kit)**     | JRE + compilers (`javac`) + tools like `javadoc`, `javap`, etc. Full development kit to write, compile, and debug Java apps.    |

> ✅ **Use JDK** for development, **JRE** to run, and **JVM** is the execution engine.

---

### **2. What are the main principles of Object-Oriented Programming?**

1. **Encapsulation** – Binding data and methods in one unit (class). Access is controlled via access modifiers.
2. **Abstraction** – Hiding implementation details and showing only functionality. Achieved via interfaces/abstract classes.
3. **Inheritance** – Acquiring properties and behavior from a parent class.
4. **Polymorphism** – Ability to take many forms.

   * **Compile-time (method overloading)**
   * **Runtime (method overriding)**

---

### **3. What is the difference between `==` and `.equals()` method?**

| Comparison | `==`                                              | `.equals()`                                                     |
| ---------- | ------------------------------------------------- | --------------------------------------------------------------- |
| Type       | Reference comparison                              | Content/logical comparison                                      |
| Use        | Checks if two references point to the same object | Checks actual values (overridden in most classes like `String`) |

```java
String a = new String("test");
String b = new String("test");

a == b        // false (different objects)
a.equals(b)   // true  (same content)
```

---

### **4. Why is String immutable in Java?**

* **Security**: Used in class loaders, file paths, network connections.
* **Thread-safe**: No synchronization needed as value can’t change.
* **Caching**: Interned strings (pooling) save memory.
* **HashCode stability**: Hash-based collections (like HashMap) depend on immutability.

Internally, `String` uses a final `char[]` and doesn't expose mutators.

---

### **5. What is the difference between `String`, `StringBuilder`, and `StringBuffer`?**

| Class           | Mutable?    | Thread-safe?                 | Performance                         |
| --------------- | ----------- | ---------------------------- | ----------------------------------- |
| `String`        | ❌ Immutable | ✅ (Safe because immutable)   | Slowest (new object on each concat) |
| `StringBuilder` | ✅ Mutable   | ❌ Not thread-safe            | Fastest for single-thread           |
| `StringBuffer`  | ✅ Mutable   | ✅ Thread-safe (synchronized) | Slower than StringBuilder           |

Use `StringBuilder` in most cases unless thread-safety is needed.

---

### **6. What is method overloading and method overriding?**

* **Overloading** (Compile-time polymorphism):

  * Same method name, different **parameters** (type/number/order) in same class.
  * Happens **within** a class.

```java
void print(int a) {}
void print(String a) {}
```

* **Overriding** (Runtime polymorphism):

  * Subclass provides a **specific implementation** of a superclass method.
  * Requires **same signature** and **@Override annotation**.

```java
class A { void show() {} }
class B extends A { @Override void show() {} }
```

---

### **7. What is the difference between abstract class and interface?**

| Feature     | Abstract Class               | Interface (Java 8+)                                       |
| ----------- | ---------------------------- | --------------------------------------------------------- |
| Methods     | Can have concrete + abstract | All are abstract by default; can have `default`, `static` |
| Variables   | Instance variables allowed   | Only constants (`public static final`)                    |
| Inheritance | Single inheritance           | Multiple interfaces                                       |
| Constructor | Yes                          | No                                                        |

> Use **interface** to define contract, **abstract class** to provide base with shared logic.

---

### **8. What are access modifiers in Java?**

| Modifier              | Class | Package | Subclass | World |
| --------------------- | ----- | ------- | -------- | ----- |
| `private`             | ✅     | ❌       | ❌        | ❌     |
| Default (no modifier) | ✅     | ✅       | ❌        | ❌     |
| `protected`           | ✅     | ✅       | ✅        | ❌     |
| `public`              | ✅     | ✅       | ✅        | ✅     |

> Helps encapsulate access at class, method, and variable levels.

---

### **9. What is the difference between static and non-static methods?**

| Method Type | Static                                    | Non-static                            |
| ----------- | ----------------------------------------- | ------------------------------------- |
| Binding     | Class-level                               | Object-level                          |
| Access      | Can’t access instance members directly    | Can access both static and instance   |
| Use Case    | Utility/helper methods (e.g., `Math.max`) | Behavior that depends on object state |

> You don’t need an object to call a static method.

---

### **10. What is constructor chaining in Java?**

* Calling one constructor **from another constructor** of the same class (using `this(...)`) or superclass (using `super(...)`).
* Ensures **single initialization logic path**.

```java
class A {
    A() { this(10); } // calls A(int)
    A(int x) { System.out.println("X: " + x); }
}
```

* First line of constructor must be `this(...)` or `super(...)`.

---

### **11. What is the difference between ArrayList and LinkedList?**

| Feature                | `ArrayList`                | `LinkedList`                  |
| ---------------------- | -------------------------- | ----------------------------- |
| Internal Structure     | Dynamic array              | Doubly-linked list            |
| Access Time            | Fast (O(1) random access)  | Slow (O(n) traversal)         |
| Insert/Delete (middle) | Slow (O(n) shift elements) | Fast (O(1) if node is known)  |
| Memory                 | Less (only data)           | More (data + node pointers)   |
| Use Case               | Read-heavy ops             | Frequent insertions/deletions |

> ✅ Use `ArrayList` when random access is frequent, `LinkedList` for frequent `add/remove` operations.

---

### **12. What is the difference between HashMap and Hashtable?**

| Feature          | `HashMap`                             | `Hashtable`           |
| ---------------- | ------------------------------------- | --------------------- |
| Thread-safe      | ❌ Not synchronized                    | ✅ Synchronized        |
| Null Keys/Values | Allows one null key, many null values | ❌ No null key/value   |
| Performance      | Faster (no locking)                   | Slower (synchronized) |
| Introduced In    | Java 1.2                              | Legacy (Java 1.0)     |

> ✅ Use `ConcurrentHashMap` for thread-safe operations instead of `Hashtable`.

---

### **13. How does HashMap work internally?**

1. **Hashing**: `hashCode()` is called on the key to get hash.
2. **Index Calculation**: `index = hash & (n - 1)` where `n` is capacity.
3. **Bucket Storage**: Entry is placed in a **bucket array**.
4. **Collision Handling**:

   * Java 7: **Linked list**
   * Java 8+: **TreeNode (Red-Black Tree)** if bucket size > 8
5. **Retrieval**: Uses `equals()` to find key match in the bucket.

> ✅ Keys must implement proper `hashCode()` and `equals()` for consistent behavior.

---

### **14. What is the difference between HashSet and TreeSet?**

| Feature      | `HashSet`            | `TreeSet`                                          |
| ------------ | -------------------- | -------------------------------------------------- |
| Order        | Unordered            | Sorted (natural/custom order)                      |
| Performance  | Faster (O(1) insert) | Slower (O(log n) insert/search)                    |
| Null Element | Allows 1 null        | ❌ Null not allowed (throws `NullPointerException`) |
| Backed By    | HashMap              | TreeMap (Red-Black tree)                           |

> ✅ Use `TreeSet` when **sorted uniqueness** is required.

---

### **15. What is the Collections framework in Java?**

A **unified architecture** for storing and manipulating groups of objects.

**Key Interfaces:**

* `Collection` → `List`, `Set`, `Queue`
* `Map`

**Core Implementations:**

* `ArrayList`, `LinkedList`, `HashSet`, `TreeSet`, `HashMap`, `TreeMap`, etc.

**Utilities:**

* `Collections` class – static methods like `sort()`, `reverse()`, `synchronizedList()`
* `Arrays` – for array operations

> ✅ Promotes **code reuse**, **type safety**, and **interoperability**.

---

### **16. What is the difference between Iterator and ListIterator?**

| Feature               | `Iterator`                        | `ListIterator`                                       |
| --------------------- | --------------------------------- | ---------------------------------------------------- |
| Direction             | Forward only                      | Forward + backward                                   |
| Supported Collections | Any Collection                    | Only List (ArrayList, LinkedList)                    |
| Methods               | `hasNext()`, `next()`, `remove()` | `add()`, `set()`, `hasPrevious()`, `previous()` etc. |
| Index Access          | ❌                                 | ✅ (`nextIndex()`, `previousIndex()`)                 |

> ✅ Use `ListIterator` when you need **bidirectional traversal** or want to modify the list during iteration.

---

### **17. What is the difference between Comparable and Comparator?**

| Feature     | `Comparable<T>`                 | `Comparator<T>`                 |
| ----------- | ------------------------------- | ------------------------------- |
| Package     | `java.lang`                     | `java.util`                     |
| Method      | `compareTo(T o)`                | `compare(T o1, T o2)`           |
| Use         | Natural ordering (inside class) | Custom ordering (outside class) |
| One or Many | One compare logic               | Multiple comparators possible   |

```java
class Employee implements Comparable<Employee> {
  public int compareTo(Employee e) { return this.id - e.id; }
}

Comparator<Employee> bySalary = (e1, e2) -> e1.salary - e2.salary;
```

---

### **18. What happens when you add duplicate elements to a HashSet?**

* HashSet **does not allow duplicates**.
* When you add:

  * It checks `hashCode()` and then `equals()` to ensure uniqueness.
* If the element is already present, the `add()` method returns `false`.

> ✅ Make sure custom classes used in a `HashSet` override both `equals()` and `hashCode()` correctly.

---

### **19. What is the difference between List and Set?**

| Feature         | `List`                    | `Set`                                  |
| --------------- | ------------------------- | -------------------------------------- |
| Order           | Maintains insertion order | Unordered (HashSet) / Sorted (TreeSet) |
| Duplicates      | ✅ Allowed                 | ❌ Not allowed                          |
| Index Access    | ✅ (get by index)          | ❌ No index                             |
| Implementations | `ArrayList`, `LinkedList` | `HashSet`, `LinkedHashSet`, `TreeSet`  |

> ✅ Use `List` for ordered duplicates, `Set` for unique elements.

---

### **20. What is the difference between Array and ArrayList?**

| Feature     | `Array`                         | `ArrayList`                                  |
| ----------- | ------------------------------- | -------------------------------------------- |
| Size        | Fixed                           | Dynamic                                      |
| Type        | Can store primitives            | Only objects (Generics)                      |
| Performance | Fast (no boxing/unboxing)       | Slightly slower (boxing + resizing overhead) |
| Flexibility | Less flexible (manual resizing) | More flexible (auto-resizes)                 |

```java
int[] arr = new int[5];
ArrayList<Integer> list = new ArrayList<>();
```

> ✅ Use `Array` for performance-critical primitive handling, `ArrayList` for flexible, resizable collections.

---

### **21. What is exception handling in Java?**

**Exception handling** ensures program stability when unexpected runtime errors occur.

**Key constructs:**

* `try` – Block to monitor for exceptions
* `catch` – Handles specific exceptions
* `finally` – Always executes (cleanup)
* `throw` – Manually throw exception
* `throws` – Declares exceptions a method might throw

```java
try {
    int x = 5 / 0;
} catch (ArithmeticException e) {
    // handle
} finally {
    // cleanup
}
```

> ✅ Prevents system crashes and helps in graceful error recovery.

---

### **22. What is the difference between checked and unchecked exceptions?**

| Type           | Checked                       | Unchecked                                                |
| -------------- | ----------------------------- | -------------------------------------------------------- |
| Package        | `java.lang.Exception`         | `java.lang.RuntimeException`                             |
| Compiler Check | ✅ Must handle/declare         | ❌ No requirement                                         |
| Examples       | `IOException`, `SQLException` | `NullPointerException`, `ArrayIndexOutOfBoundsException` |

> ✅ Use checked when recovery is possible, unchecked for programming bugs.

---

### **23. What is the difference between `throw` and `throws`?**

| Feature | `throw`                          | `throws`                                |
| ------- | -------------------------------- | --------------------------------------- |
| Purpose | Actually throws exception        | Declares potential exception            |
| Used In | Method body                      | Method signature                        |
| Syntax  | `throw new IOException("error")` | `public void read() throws IOException` |

> ✅ `throw` is for **actual action**, `throws` is for **method contract**.

---

### **24. What is the finally block and when is it executed?**

* `finally` is **always executed** after `try` and `catch`, whether:

  * An exception is thrown or not.
  * An exception is caught or not.
  * `return` or `System.exit()` is used (except exit kills JVM).

Used for:

* Resource cleanup (`close DB/file/socket`)
* Logging

```java
try {
   // risky code
} finally {
   // always runs
}
```

---

### **25. Can we have multiple catch blocks for a single try block?**

✅ Yes.

* Used to handle different exception types **independently**.
* Order matters – place child exceptions first.

```java
try {
  // risky
} catch (IOException e) {
  // handle IO
} catch (Exception e) {
  // handle all others
}
```

> ✅ Java 7+ supports **multi-catch**: `catch (IOException | SQLException e)`

---

### **26. What is the difference between final, finally, and finalize?**

| Keyword      | Purpose                                                                           |
| ------------ | --------------------------------------------------------------------------------- |
| `final`      | Keyword to declare **constants**, prevent method overriding or class inheritance. |
| `finally`    | Block that **always executes** after try-catch. Used for **cleanup**.             |
| `finalize()` | Method called by GC before reclaiming memory (deprecated since Java 9).           |

> ✅ `final` = cannot change, `finally` = cleanup, `finalize` = GC hook (avoid using it).

---

### **27. What is multithreading in Java?**

**Multithreading** enables concurrent execution of two or more threads (units of a process).

Benefits:

* Efficient CPU utilization
* Faster processing
* Non-blocking I/O

Java supports:

* `Thread` class
* `Runnable` interface
* `ExecutorService` (preferred for production)

---

### **28. What is the difference between Thread class and Runnable interface?**

| Feature     | `Thread`                                   | `Runnable`                             |
| ----------- | ------------------------------------------ | -------------------------------------- |
| Inheritance | Extends `Thread` (no multiple inheritance) | Implements interface (flexible)        |
| Reusability | Less (tight coupling)                      | More (decoupled)                       |
| Syntax      | `class MyThread extends Thread`            | `class MyRunnable implements Runnable` |

```java
new Thread(new MyRunnable()).start();
```

> ✅ Prefer `Runnable` or `Callable` with `ExecutorService` in scalable apps.

---

### **29. What is synchronization in Java?**

**Synchronization** ensures that only one thread can access a **critical section** at a time.

Achieved via:

* `synchronized` block/method
* Locks (`ReentrantLock`, `ReadWriteLock`)

Purpose:

* Prevent data inconsistency
* Avoid race conditions

```java
synchronized(this) {
   // thread-safe block
}
```

> ✅ Use fine-grained locking to avoid performance bottlenecks.

---

### **30. What is the difference between wait() and sleep()?**

| Method                   | `wait()`                                | `sleep()`              |
| ------------------------ | --------------------------------------- | ---------------------- |
| Package                  | `java.lang.Object`                      | `java.lang.Thread`     |
| Monitor Lock             | Releases lock                           | Doesn't release lock   |
| Usage                    | Thread coordination (producer-consumer) | Pause thread execution |
| Needs synchronized block | ✅ Yes                                   | ❌ No                   |

```java
synchronized(obj) {
    obj.wait();  // releases lock
    obj.notify();
}

Thread.sleep(1000); // pauses for 1 second
```

> ✅ Use `wait()`/`notify()` for inter-thread communication, `sleep()` for timing.

---

### **31. What is a deadlock and how can you avoid it?**

**Deadlock** occurs when two or more threads wait indefinitely for each other’s locks.

#### Example scenario:

```java
Thread-1 locks A → waits for B  
Thread-2 locks B → waits for A  
→ both wait forever
```

#### Prevention strategies:

* **Lock ordering** – Always acquire locks in the same order.
* **Try-lock** – Use `tryLock()` from `ReentrantLock` with timeout.
* **Avoid nested locks** – Keep locking granular and minimal.

> ✅ In production, monitor threads via `jstack` or Java Flight Recorder for deadlock detection.

---

### **32. What is the volatile keyword in Java?**

* Ensures visibility of changes to variables across threads.
* Prevents CPU caching / reordering by compiler or hardware.
* Doesn’t ensure **atomicity**.

```java
volatile boolean flag = true;
```

> ✅ Use for **flags or state indicators**, not for compound operations like `i++`.

---

### **33. What is the difference between heap and stack memory?**

| Memory        | Stack                         | Heap                     |
| ------------- | ----------------------------- | ------------------------ |
| Stores        | Method calls, local variables | Objects, class instances |
| Size          | Smaller                       | Larger                   |
| Access        | LIFO                          | Random                   |
| Thread-safety | Each thread has own stack     | Shared among threads     |
| GC'd          | No (popped on method return)  | Yes (by JVM GC)          |

> ✅ Memory leaks happen in **heap**, `StackOverflowError` occurs in **stack** due to deep recursion.

---

### **34. How does garbage collection work in Java?**

* GC frees memory occupied by unreachable objects.
* Managed by JVM, runs automatically (can be triggered with `System.gc()` but not recommended).

#### Phases:

1. **Mark** – Identify referenced objects
2. **Sweep** – Delete unreferenced
3. **Compact** – Rearranging memory (optional)

#### GC Types (HotSpot):

* Serial GC, Parallel GC, CMS, G1 (default now), ZGC, Shenandoah

> ✅ Always nullify heavy objects post-use, prefer weak references when necessary.

---

### **35. What is the difference between shallow copy and deep copy?**

| Copy Type      | Shallow Copy                     | Deep Copy                                             |
| -------------- | -------------------------------- | ----------------------------------------------------- |
| Field Copy     | Copies references                | Copies actual data                                    |
| Nested Objects | Shared between original and copy | Independent copies                                    |
| Tools          | `clone()` default                | Custom copy logic / Serialization / Copy constructors |

```java
Shallow: newObj.field = oldObj.field
Deep: newObj.field = new Field(oldObj.field)
```

> ✅ For mutable object graphs, prefer **deep copy** to avoid side effects.

---

### **36. What are wrapper classes in Java?**

Java provides **object equivalents** for primitive types:

| Primitive | Wrapper     |
| --------- | ----------- |
| `int`     | `Integer`   |
| `char`    | `Character` |
| `boolean` | `Boolean`   |
| `double`  | `Double`    |
| ...       | ...         |

> ✅ Useful for working with **Collections**, **generics**, and **nullability**.

---

### **37. What is autoboxing and unboxing?**

* **Autoboxing**: Auto conversion from primitive → wrapper.
* **Unboxing**: Wrapper → primitive

```java
Integer i = 5;          // autoboxing
int j = i;              // unboxing
```

> ✅ Introduced in Java 5 to simplify code working with generics and collections.

---

### **38. What are generics in Java and why are they used?**

* Allow classes, interfaces, and methods to operate on **typed objects**.
* Ensures **compile-time type safety**, removes need for casting.

```java
List<String> names = new ArrayList<>();
names.add("Raj");
String s = names.get(0); // No cast needed
```

> ✅ Use bounded generics (`<T extends Number>`) for constraints.

---

### **39. What are lambda expressions in Java 8?**

* **Anonymous function syntax** to simplify implementation of functional interfaces.

```java
Runnable r = () -> System.out.println("Hello");
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(s -> System.out.println(s));
```

> ✅ Used heavily in Streams, Collections, and event-driven logic.

---

### **40. What is a functional interface in Java?**

* An interface with **exactly one abstract method**.
* Can have `default` and `static` methods.
* Annotated with `@FunctionalInterface` (optional but recommended)

```java
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
```

**Examples**:

* `Runnable`, `Callable`, `Comparator`, `Function<T,R>`

> ✅ Enables usage of **lambdas** and **method references**.

---

### **41. What are functional interfaces in Java?**

A **Functional Interface**:

* Has **exactly one abstract method** (SAM — Single Abstract Method).
* Enables use of **lambda expressions** and **method references**.

```java
@FunctionalInterface
interface MyFunc {
    void apply();
}
```

> ✅ Java 8 provides many built-ins: `Runnable`, `Function<T, R>`, `Predicate<T>`, `Consumer<T>`, etc.

---

### **42. What is Optional class in Java 8?**

* A **container object** to represent a **nullable value**.
* Avoids `NullPointerException`.

```java
Optional<String> name = Optional.ofNullable(getName());
name.ifPresent(n -> System.out.println(n));
```

**Key methods**:

* `of()`, `ofNullable()`, `isPresent()`, `ifPresent()`, `orElse()`, `map()`

> ✅ Use `Optional` as return type — **never as method argument or field**.

---

### **43. What is the Stream API in Java 8?**

* Functional-style operations on **collections or arrays**.
* **Lazy evaluation**, **parallelism**, **pipelining**.

```java
List<String> result = names.stream()
    .filter(s -> s.startsWith("R"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

**Key stream operations**:

* `filter()`, `map()`, `sorted()`, `collect()`, `reduce()`, `flatMap()`

> ✅ Improves **readability**, **declarative logic**, and **parallel processing** (`.parallelStream()`)

---

### **44. What is method reference in Java 8?**

* **Shortcut syntax** for lambda that calls an existing method.

```java
list.forEach(System.out::println); // instead of s -> System.out.println(s)
```

**Types**:

* Static: `Class::staticMethod`
* Instance: `obj::instanceMethod`
* Constructor: `Class::new`

> ✅ Makes code more concise and readable when lambdas only delegate.

---

### **45. What is the difference between Serialization and Deserialization?**

| Concept  | Serialization                | Deserialization                |
| -------- | ---------------------------- | ------------------------------ |
| Purpose  | Convert object → byte stream | Convert byte stream → object   |
| Use Case | File, DB, network transfer   | Reading back serialized data   |
| API      | `ObjectOutputStream`         | `ObjectInputStream`            |
| Marker   | `implements Serializable`    | Same class needed at read time |

```java
// Serialize
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"));
oos.writeObject(obj);

// Deserialize
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));
Object obj = ois.readObject();
```

> ✅ Custom serialization via `writeObject`/`readObject` methods.

---

### **46. What is the transient keyword in Java?**

* Marks fields to be **excluded from serialization**.
* Useful for **sensitive data** or **non-serializable resources**.

```java
transient String password;
```

> ✅ Transient fields are **reset to default values** during deserialization.

---

### **47. What is reflection in Java?**

* Allows inspection and modification of classes, methods, fields at runtime.

```java
Class<?> clazz = Class.forName("com.MyClass");
Method m = clazz.getMethod("doSomething");
m.invoke(obj);
```

**Uses**:

* Frameworks (Spring, Hibernate)
* Dependency injection
* Annotation processing

> ⚠️ **Avoid excessive use** in production – slow, breaks encapsulation, impacts security.

---

### **48. What is the difference between composition and inheritance?**

| Aspect      | Inheritance            | Composition                         |
| ----------- | ---------------------- | ----------------------------------- |
| Relation    | "is-a"                 | "has-a"                             |
| Coupling    | Tightly coupled        | Loosely coupled                     |
| Flexibility | Less (rigid hierarchy) | More (runtime polymorphism)         |
| Usage       | Extending behavior     | Reusing functionality by delegation |

```java
// Composition
class Car {
    private Engine engine; // has-a relationship
}
```

> ✅ Prefer **composition over inheritance** for maintainability.

---

### **49. What is encapsulation and how do you achieve it?**

**Encapsulation** = Wrapping data (fields) and code (methods) into one unit — the **class**.

**How:**

* Declare fields `private`
* Provide `public` getters/setters

```java
class User {
    private String name;
    public String getName() { return name; }
    public void setName(String n) { name = n; }
}
```

> ✅ Improves **security**, **maintainability**, and **loose coupling**.

---

### **50. What is the difference between static and instance variables?**

| Variable     | Static                           | Instance                    |
| ------------ | -------------------------------- | --------------------------- |
| Memory       | Class-level (one copy)           | Object-level (per instance) |
| Accessed via | Class name                       | Object reference            |
| Lifecycle    | Lives as long as class is loaded | Lives as long as object     |
| Use Case     | Constants, counters, config      | Per-user/object data        |

```java
class User {
    static int userCount;
    String name;
}
```

> ✅ Use static for shared state/config, avoid it for user-specific data in multi-threaded systems.

---

### **51. What is the difference between static and instance variables?**

| Feature   | Static Variable                                  | Instance Variable                    |
| --------- | ------------------------------------------------ | ------------------------------------ |
| Scope     | Shared across **all instances**                  | Unique per **object**                |
| Memory    | Stored in **Method Area / MetaSpace** (JVM-wide) | Stored in **Heap** (object-specific) |
| Access    | Access via class (`ClassName.var`)               | Access via object (`obj.var`)        |
| Lifecycle | Exists **till class is loaded**                  | Exists **till object is GC’d**       |

#### Real-world example:

```java
class BankAccount {
    static String bankName = "SBI";
    String accountHolder;
}
```

* Changing `bankName` affects all accounts — **shared config**.
* `accountHolder` is unique per object — **state encapsulation**.

> ✅ Use static for **config**, **counters**, **utility constants** — never for request-scoped or user data.

---

### **52. What is method hiding in Java?**

* Occurs when a **static method** in subclass has **same signature** as one in superclass.

```java
class Parent {
    static void show() { System.out.println("Parent"); }
}

class Child extends Parent {
    static void show() { System.out.println("Child"); }
}
```

* Called based on **reference type**, not object type.

```java
Parent obj = new Child();
obj.show();  // prints "Parent"
```

> ✅ It's **not polymorphism**. Runtime dispatch doesn't apply to static methods.

---

### **53. What is the difference between `this` and `super` keywords?**

| Keyword         | `this`                                  | `super`                                            |
| --------------- | --------------------------------------- | -------------------------------------------------- |
| Refers To       | Current object                          | Immediate parent class                             |
| Use Cases       | Resolve shadowing, constructor chaining | Access overridden methods, superclass constructors |
| Constructor Use | `this(args)` for internal constructor   | `super(args)` to call parent constructor           |

```java
this.name = name;        // resolve field shadowing
super.toString();        // call parent's method
```

> ✅ Use `super` for **inheritance-based delegation**, `this` for **self-reference or chaining**.

---

### **54. Can you override private methods in Java?**

❌ **No**.

* **Private methods are not visible** to child classes.
* So they’re **not inherited** → can’t be overridden.
* If a child class defines a method with the same signature → it's a **new method**, not override.

```java
class A {
    private void show() {}
}

class B extends A {
    private void show() {} // This is NOT an override
}
```

> ✅ Use `@Override` annotation — it will **fail compilation** if no actual override.

---

### **55. What is constructor overloading?**

* Defining **multiple constructors** with different parameter lists.

```java
class Employee {
    Employee() {}
    Employee(String name) {}
    Employee(String name, int age) {}
}
```

#### Why:

* **Flexibility** during object creation.
* Support for **optional parameters** without setters.

> ✅ Use constructor overloading when object creation depends on **context/state**. Avoid telescoping constructors — prefer **Builder pattern** for many fields.

---

### **56. What happens if you don’t provide a constructor in a class?**

* The compiler provides a **default no-arg constructor** *only* if:

  * No constructor is explicitly defined.

```java
class A {
    // Compiler adds: A() {}
}
```

* If any constructor is defined (e.g., with params), compiler won’t add default one.

```java
class B {
    B(int x) {}  // Now B() {} is NOT auto-generated
}
```

> ✅ Always define **explicit no-arg constructors** if frameworks like Hibernate or Jackson need them for reflection.

---

### **57. What is the difference between default and protected access modifiers?**

| Access Level                  | `default` (package-private) | `protected` |
| ----------------------------- | --------------------------- | ----------- |
| Same Class                    | ✅                           | ✅           |
| Same Package                  | ✅                           | ✅           |
| Subclass in Different Package | ❌                           | ✅           |
| Other Classes                 | ❌                           | ❌           |

```java
class A {
    void show() {}           // default
    protected void print() {} // protected
}
```

> ✅ Use `protected` for **inheritance reuse** across packages, and `default` when encapsulation is limited to a module.

---

### **58. What is the `instanceof` operator used for?**

* Checks whether an object is an instance of a specific class or interface.

```java
if (obj instanceof String) {
    String s = (String) obj;
}
```

#### Java 16+ (Pattern Matching for `instanceof`):

```java
if (obj instanceof String s) {
    System.out.println(s.toLowerCase());
}
```

> ✅ Avoid overuse. Prefer polymorphism (like `obj.doWork()`) instead of type checks.

---

### **59. What is the difference between `break` and `continue` statements?**

| Statement     | `break`                         | `continue`              |
| ------------- | ------------------------------- | ----------------------- |
| Use           | Exit loop or switch             | Skip current iteration  |
| Scope         | Affects loop/switch as a whole  | Only current loop cycle |
| Often Used In | `switch-case`, loop termination | Filtering in loops      |

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;      // exits loop
    if (i % 2 == 0) continue; // skips even
}
```

> ✅ For nested loops, use **labeled break/continue** to precisely control flow.

---

### **60. What is the `switch` statement and how does it work?**

* Controls flow based on value of a variable (`int`, `char`, `enum`, `String`, etc.)
* Introduced in Java:

  * Java 7: Support for `String`
  * Java 14+: Enhanced `switch` expressions (`yield`)

```java
switch (status) {
    case "STARTED":
        start();
        break;
    case "STOPPED":
        stop();
        break;
    default:
        handleUnknown();
}
```

#### Java 14+ Expression Style:

```java
String result = switch (code) {
    case 1 -> "ONE";
    case 2 -> "TWO";
    default -> "UNKNOWN";
};
```

> ✅ Prefer **enhanced switch** for **cleaner**, **more readable** logic.

---

### **61. What is the difference between `for` loop and enhanced `for-each` loop?**

| Feature       | Traditional `for`                       | Enhanced `for-each`                                       |
| ------------- | --------------------------------------- | --------------------------------------------------------- |
| Index Access  | ✅ (via index `i`)                       | ❌ (no index)                                              |
| Applicable To | Arrays, Lists, etc.                     | Arrays, Iterable                                          |
| Modification  | Supports modification/removal via index | No index or control; can't modify during iteration safely |
| Use Case      | When index or position is needed        | When just values are needed                               |

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

for (int value : arr) {
    System.out.println(value);
}
```

> ✅ Prefer `for-each` for **read-only iteration**, use classic `for` for **indexed logic** or **modification**.

---

### **62. What is the difference between `while` and `do-while` loops?**

| Loop Type           | `while`               | `do-while`                 |
| ------------------- | --------------------- | -------------------------- |
| Condition Check     | Before loop starts    | After first iteration      |
| Execution Guarantee | 0 or more times       | At least once              |
| Syntax              | `while(condition) {}` | `do { } while(condition);` |

```java
int i = 0;
while (i < 5) {
    System.out.println(i++);
}

int j = 0;
do {
    System.out.println(j++);
} while (j < 5);
```

> ✅ Use `do-while` when **one-time execution is mandatory**, like **menu loops**.

---

### **63. What are nested classes in Java?**

Nested classes are **classes defined inside another class**. Four types:

1. **Static nested class**:

   * Does **not have access** to outer instance.
   * Use when it doesn’t need outer state.

2. **Non-static inner class**:

   * Has access to **outer class instance**.
   * Declared without `static`.

3. **Local class**:

   * Defined inside method/block.
   * Limited to scope.

4. **Anonymous class**:

   * Inline class without a name.
   * Used for one-time implementation.

```java
class Outer {
    static class StaticNested {}
    class Inner {}
}
```

> ✅ Use nested classes to **group related functionality** and **reduce namespace clutter**.

---

### **64. What is the difference between static nested class and inner class?**

| Feature                 | Static Nested                                        | Inner Class                                  |
| ----------------------- | ---------------------------------------------------- | -------------------------------------------- |
| Belongs To              | Outer class                                          | Instance of outer class                      |
| Access to Outer Members | ❌ Only static                                        | ✅ Can access all                             |
| Object Creation         | `Outer.StaticNested obj = new Outer.StaticNested();` | `Outer.Inner obj = new Outer().new Inner();` |

> ✅ Use **static nested** when you don’t need outer class state. Use **inner** when you want tight coupling with the outer instance.

---

### **65. What is an anonymous class in Java?**

* A class **without a name**, declared and instantiated in a single expression.
* Commonly used to implement **interfaces** or **abstract classes** inline.

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Running");
    }
};
```

> ✅ Prior to lambdas, widely used in event handling (like in Swing, listeners). Now replaced by lambdas for functional interfaces.

---

### **66. What is the difference between local class and anonymous class?**

| Feature                   | Local Class            | Anonymous Class         |
| ------------------------- | ---------------------- | ----------------------- |
| Has Name                  | ✅                      | ❌                       |
| Can Extend Multiple Times | ✅                      | ❌ One-off use           |
| Readability               | Easier to debug        | Harder to debug         |
| Use Case                  | Reusable inside method | One-time implementation |

```java
void method() {
    class LocalHelper {}
    
    new Thread(new Runnable() {
        public void run() {}
    }).start(); // anonymous class
}
```

> ✅ Prefer local class for **multi-method use**, anonymous for **short-lived implementations**.

---

### **67. What is a package in Java and why is it used?**

A **package** is a namespace for organizing classes, interfaces, and sub-packages.

#### Benefits:

* Avoids **name conflicts**
* Controls **accessibility**
* Provides **modular structure**

```java
package com.orchestrationengine.ums.service;
```

> ✅ Follow domain-reversed naming (e.g., `com.yourcompany.module.submodule`) for **clean architecture**.

---

### **68. What is the `import` statement and how does it work?**

* Brings **external classes/interfaces** into scope from other packages.

```java
import java.util.List;
import static java.lang.Math.PI; // static import
```

#### Types:

* **Single class**: `import java.util.List;`
* **Wildcard**: `import java.util.*;` (not preferred for clarity)
* **Static**: `import static ...` to call static members directly

> ✅ Explicit imports are **preferred in production** for readability and IDE support.

---

### **69. What is the classpath in Java?**

* The **search path** where the JVM and compiler look for `.class` files and JARs.

#### Ways to define classpath:

* Command-line:

  ```bash
  java -cp myapp.jar com.example.Main
  ```
* Environment variable: `CLASSPATH`
* Build tools: Maven/Gradle auto-manage it via `target/classes`, `dependencies`

> ✅ Incorrect classpath leads to **`ClassNotFoundException` / `NoClassDefFoundError`**.

---

### **70. What is the main method and why is it static?**

```java
public static void main(String[] args) {
}
```

| Keyword         | Purpose                                      |
| --------------- | -------------------------------------------- |
| `public`        | Accessible by JVM                            |
| `static`        | JVM doesn't need to create object to call it |
| `void`          | Doesn't return anything                      |
| `String[] args` | Accepts command-line arguments               |

#### Why static?

* Entry point should be callable **without object instantiation**.
* Allows JVM to bootstrap your app independently.

> ✅ Java 5+ also allows `public static void main(String... args)` due to varargs support.

---

### **71. What is the difference between `StringTokenizer` and `split()` method?**

| Feature       | `StringTokenizer`                  | `split()`                               |
| ------------- | ---------------------------------- | --------------------------------------- |
| Package       | `java.util`                        | `java.lang.String`                      |
| Return Type   | Enumeration of tokens              | String array                            |
| Regex Support | ❌ No regex (single-char delimiter) | ✅ Full regex support                    |
| Flexibility   | Limited                            | More control (trimming, empty handling) |
| Performance   | Slightly faster (low overhead)     | Slightly heavier (regex engine)         |

```java
// split
String[] parts = "a,b,c".split(",");

// StringTokenizer
StringTokenizer st = new StringTokenizer("a,b,c", ",");
while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
```

> ✅ Prefer `split()` for **modern use** — more flexible and readable.

---

### **72. What is the difference between `Vector` and `ArrayList`?**

| Feature     | `Vector`                | `ArrayList`                 |
| ----------- | ----------------------- | --------------------------- |
| Thread-safe | ✅ Yes (synchronized)    | ❌ No                        |
| Performance | Slower (due to locking) | Faster                      |
| Grow Factor | Doubles in size         | Increases by 50%            |
| Legacy      | Yes (pre-Java 2)        | Modern collection framework |

> ✅ Use `ArrayList` in non-threaded scenarios. For concurrent use, prefer `CopyOnWriteArrayList` or synchronized wrappers (`Collections.synchronizedList`).

---

### **73. What is the difference between Stack and Queue?**

| Structure       | `Stack`                    | `Queue`                                                |
| --------------- | -------------------------- | ------------------------------------------------------ |
| Order           | LIFO (Last In First Out)   | FIFO (First In First Out)                              |
| Use Cases       | Undo, backtracking         | Scheduling, task queues                                |
| Java Class      | `java.util.Stack` (legacy) | `java.util.Queue` interface                            |
| Preferred Types | `Deque`, `ArrayDeque`      | `LinkedList`, `PriorityQueue`, `ConcurrentLinkedQueue` |

```java
Deque<String> stack = new ArrayDeque<>();
Queue<String> queue = new LinkedList<>();
```

> ✅ Avoid `Stack` class in production — use `Deque` (`push`, `pop`) for LIFO behavior.

---

### **74. What is `LinkedHashMap` and when would you use it?**

* A **HashMap variant** that maintains **insertion order**.
* Implemented as a **doubly-linked list** of buckets.

```java
Map<Integer, String> map = new LinkedHashMap<>();
```

#### Use cases:

* Cache-like behavior
* Predictable iteration
* LRU cache with `accessOrder = true`

```java
new LinkedHashMap<>(16, 0.75f, true); // access-order
```

> ✅ Use `LinkedHashMap` when you need **consistent order + fast access**.

---

### **75. What is `WeakHashMap` in Java?**

* A `Map` implementation where **keys are weak references**.
* If a key has **no strong references**, it can be **GC’d**.

```java
Map<Object, String> map = new WeakHashMap<>();
Object key = new Object();
map.put(key, "value");

key = null;
System.gc(); // entry may be removed
```

#### Use Cases:

* Caches
* Metadata holders
* Avoid memory leaks (like with ClassLoader)

> ✅ Use when you want the map to **auto-clean up unused keys**.

---

### **76. What is the difference between fail-fast and fail-safe iterators?**

| Behavior        | Fail-Fast                                | Fail-Safe                                   |
| --------------- | ---------------------------------------- | ------------------------------------------- |
| On Modification | Throws `ConcurrentModificationException` | No exception                                |
| Works On        | Original collection                      | Cloned copy                                 |
| Examples        | `ArrayList`, `HashSet`                   | `CopyOnWriteArrayList`, `ConcurrentHashMap` |

```java
List<String> list = new ArrayList<>();
for (String s : list) {
    list.add("new"); // Fail-Fast
}
```

> ✅ For concurrent read/write, use **fail-safe** collections from `java.util.concurrent`.

---

### **77. What is the difference between synchronized block and synchronized method?**

| Feature     | Synchronized Method    | Synchronized Block |
| ----------- | ---------------------- | ------------------ |
| Lock On     | `this` or class object | Custom object      |
| Granularity | Coarse                 | Fine               |
| Flexibility | Limited                | High               |

```java
public synchronized void method() { ... } // locks `this`

public void method() {
    synchronized(lockObj) {
        // fine-grained control
    }
}
```

> ✅ Prefer **block-level sync** for higher concurrency and reduced contention.

---

### **78. What is `ThreadLocal` class in Java?**

* Provides thread-isolated variables.
* Each thread accessing the variable has its **own independent copy**.

```java
ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() ->
    new SimpleDateFormat("yyyy-MM-dd")
);
```

#### Use Cases:

* Date formatting (non-thread-safe)
* DB connections
* Per-thread context (request, security)

> ✅ Use `ThreadLocal` for **per-thread state** in multithreaded services (e.g., REST request context).

---

### **79. What is the difference between `notify()` and `notifyAll()`?**

| Feature  | `notify()`              | `notifyAll()`       |
| -------- | ----------------------- | ------------------- |
| Wakes    | A single waiting thread | All waiting threads |
| Fairness | Unpredictable           | All get a chance    |
| Use Case | Single consumer         | Multiple consumers  |

```java
synchronized (lock) {
    lock.notify();      // wakes 1
    // lock.notifyAll(); // wakes all
}
```

> ✅ Use `notifyAll()` when you have **multiple condition waits**, e.g., in **producer-consumer** with many waiting consumers.

---

### **80. What is thread pool in Java?**

A **thread pool** manages a fixed number of threads for executing tasks.

* Reuses threads → avoids overhead of creating/destroying threads.
* Managed via `ExecutorService`.

```java
ExecutorService pool = Executors.newFixedThreadPool(10);
pool.submit(() -> {
    // task logic
});
```

#### Benefits:

* Improved performance
* Resource control
* Task queueing

> ✅ Use `ThreadPoolExecutor` for advanced tuning: core pool size, queue size, rejection policy.

---

### Additional Points to know as Java developer

## 🔹 **1. Java Memory Model (JMM)**

Understanding how Java handles memory in multi-threaded applications is **vital**.

* **Happens-before relationship**: Ensures memory visibility.
* **Volatile vs synchronized**: Volatile gives visibility; synchronized gives visibility + atomicity + mutual exclusion.
* Know the **thread lifecycle**, `Thread.State`, and **memory leaks due to long-living threads**.

> ✅ Critical for writing correct concurrent code.

---

## 🔹 **2. Immutability and Defensive Copying**

Immutable objects are thread-safe, cache-friendly, and easier to reason about.

* Use `final` for fields.
* Avoid setters.
* For collections: return `Collections.unmodifiableList(...)`.

```java
private final List<String> items = new ArrayList<>();

public List<String> getItems() {
    return Collections.unmodifiableList(items); // defensive
}
```

---

## 🔹 **3. Effective Java Practices**

From Joshua Bloch's book (should be your go-to reference):

* Prefer composition over inheritance.
* Use `Enum` instead of constants.
* Use static factory methods over constructors (`of`, `valueOf`).
* Always override `equals()` and `hashCode()` **together**.

---

## 🔹 **4. Java Concurrency Utilities**

Master the following for real-world concurrency:

* `ReentrantLock`, `ReadWriteLock`
* `CountDownLatch`, `CyclicBarrier`
* `Semaphore`, `BlockingQueue`
* `CompletableFuture` (Java 8+ async processing)

> ✅ Use `ForkJoinPool` or `CompletableFuture` for parallel streams and async workflows.

---

## 🔹 **5. Clean Coding and SOLID Principles**

* **Single Responsibility Principle**: One reason to change.
* **Open/Closed Principle**: Open for extension, closed for modification.
* **Dependency Inversion**: Rely on abstractions.

> ✅ Build **loosely-coupled**, **testable** code — align with Spring DI patterns.

---

## 🔹 **6. Java 8–21 Feature Awareness**

Don't just stop at Java 8:

* Java 9: Modules
* Java 10: `var` for local variables
* Java 14: Records (data classes)
* Java 16+: Pattern matching for `instanceof`
* Java 21+: Virtual Threads (Project Loom)

> ✅ Stay updated — leverage language evolution for **concise and efficient** code.

---

## 🔹 **7. JVM Internals and Performance Tuning**

* Understand **GC types** (G1, ZGC, Shenandoah).
* Know `-Xms`, `-Xmx`, and GC tuning flags.
* Use tools like `jvisualvm`, `jconsole`, `Java Flight Recorder`, `YourKit`.

> ✅ Always measure before optimizing. Use **profilers and benchmarks**, not guesswork.

---

## 🔹 **8. Annotation Processing and Reflection**

* Use custom annotations + reflection for:

  * AOP
  * Framework development
  * Code generation (via Annotation Processors)

> ✅ Learn how Spring, Lombok, and JPA work under the hood.

---

## 🔹 **9. Error Handling and Resilience**

* Build **resilient systems**:

  * Retry logic (`RetryTemplate`, `Resilience4j`)
  * Circuit breakers
  * Graceful fallbacks

> ✅ Production systems should **degrade gracefully**, not fail completely.

---

## 🔹 **10. Integration and API Design**

* REST: Use proper HTTP verbs, status codes, versioning (`/v1/`, `/v2/`).
* JSON serialization (Jackson/Gson): Customize field names, handle nulls, formats.
* API docs: Swagger/OpenAPI
* Security: OAuth2, JWT, Spring Security

> ✅ Think **idempotency**, **rate limiting**, and **input validation** always.

---

## 🔹 **11. Logging and Observability**

* Use structured logs (`logback`, `log4j2`).
* Correlate logs with request ID / trace ID.
* Integrate with ELK, Grafana, Prometheus.

> ✅ Logs are not just for debugging — they are your **primary tool in prod**.

---

## 🔹 **12. Testing Strategy**

* **Unit testing**: JUnit 5, Mockito, AssertJ
* **Integration testing**: `@SpringBootTest`, `TestContainers`
* **Contract testing**: Pact
* **Load testing**: JMeter, Gatling

> ✅ Aim for **fast, isolated, repeatable** tests — CI-friendly.

---

## 🔹 **13. Build and Dependency Management**

* Maven / Gradle mastery: `dependencyManagement`, scopes, exclusions
* BOM files, fat JARs, multi-module builds
* CI/CD tools: Jenkins, GitHub Actions

> ✅ Ensure reproducible builds. Keep transitive dependencies **under control**.

---

## 🔹 **14. Secure Coding Practices**

* Always validate input (even internal).
* Avoid reflection-based injection unless sandboxed.
* Use **parameterized queries** to prevent SQL injection.
* Encrypt sensitive data at rest and in transit.

> ✅ **Security is a first-class concern**, not a post-deployment patch.

---

## 🔹 **15. Understand Spring Ecosystem (for backend devs)**

* Spring Boot / MVC / Security
* Spring Data JPA / Redis
* Spring Cloud (Config, Eureka, Feign, Resilience)
* Spring AOP for cross-cutting concerns

> ✅ Your Java skills multiply with Spring mastery.

---




