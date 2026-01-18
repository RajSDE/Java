Java 11, released in September 2018, was the first **Long-Term Support (LTS)** version under Oracle’s new six-month release cadence. It was a "clean-up" release that removed legacy components (like JavaFX and Java EE modules) and introduced modern APIs designed for the cloud and container era.

---

# 🔵 Java 11 (LTS) - Detailed Breakdown

## 1. Local-Variable Type Inference for Lambda Parameters (JEP 323)

While Java 10 introduced `var` for local variables, Java 11 extended this to Lambda expressions.

* **The Enhancement:** You can now use `var` in the formal parameters of an implicitly typed lambda expression.
* **The "Why":** Previously, if you wanted to apply an annotation (like `@Nonnull`) to a lambda parameter, you had to write out the full manifest type. Now, you can use `var` to keep it concise while still allowing annotations.

### **Code Implementation**

```java
// Java 8/10: Must use full type for annotations
list.stream()
    .map((@Nonnull String x) -> x.toLowerCase())
    .collect(Collectors.toList());

// Java 11: Use var for conciseness with annotations
list.stream()
    .map((@Nonnull var x) -> x.toLowerCase())
    .collect(Collectors.toList());

```

---

## 2. HTTP Client API (Standard - JEP 321)

After being an "incubator" feature in Java 9 and 10, the new HTTP Client became a permanent standard in Java 11.

* **The Enhancement:** Replaces the ancient `HttpURLConnection`. The new API supports **HTTP/2** and **WebSockets** natively.
* **The "Why":** The old API was difficult to use, synchronous, and didn't support modern web protocols efficiently. The new API is asynchronous (non-blocking) and uses a fluent builder pattern.

### **Code Implementation**

```java
HttpClient client = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_2)
    .build();

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .GET()
    .build();

// Asynchronous call using CompletableFuture
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
    .thenApply(HttpResponse::body)
    .thenAccept(System.out::println)
    .join();

```

---

## 3. Launch Single-File Source-Code Programs (JEP 330)

This feature significantly improved the "on-ramping" experience for beginners and scripted automation.

* **The Enhancement:** You can run a Java source file directly with the `java` command without manually compiling it with `javac`.
* **The "Why":** It makes Java feel more like a scripting language (like Python or Bash) for small utilities.

### **Implementation**

```bash
# Instead of:
# javac HelloWorld.java
# java HelloWorld

# You can simply run:
java HelloWorld.java

```

---

## 4. New String & File Methods

Java 11 added several "quality of life" methods to the most commonly used classes.

* **String Enhancements:**
* `isBlank()`: Returns true if the string is empty or contains only white space.
* `lines()`: Returns a stream of lines extracted from the string.
* `repeat(n)`: Concatenates the string *n* times.
* `strip()`: A "Unicode-aware" version of `trim()`.


* **Files Enhancements:**
* `Files.readString(path)` / `Files.writeString(path, string)`: Read or write entire files with a single method call.



### **Code Implementation**

```java
String multiLine = "Line 1\nLine 2\nLine 3";
multiLine.lines().forEach(System.out::println);

String greeting = " Hello! ".strip().repeat(3); 
// Output: "Hello!Hello!Hello!"

Path path = Path.of("test.txt");
String content = Files.readString(path); // No more BufferedReader boilerplate!

```

---

## 5. ZGC: A Scalable Low-Latency Garbage Collector (Experimental - JEP 333)

Java 11 introduced the first version of **ZGC** (Z Garbage Collector).

* **The Enhancement:** A "no-pause" garbage collector designed for applications that require low latency (pauses less than 10ms) and very large heaps (terabytes).
* **The Result:** It performs all heavy lifting (marking, compacting) concurrently with the application threads.

---

## 6. Removal of Java EE and CORBA Modules (JEP 320)

Java 11 completed the "cleanup" started in Java 9.

* **The Shift:** Modules like JAXB, JAX-WS (Web Services), and CORBA were removed from the JDK.
* **The Impact:** If your application relies on these, you must now include them as external Maven/Gradle dependencies. This resulted in a much smaller and more secure JDK core.

---

### **Java 11 Quick Summary Table**

| Feature | Category | Primary Benefit |
| --- | --- | --- |
| **HTTP Client** | API | Modern, non-blocking networking. |
| **`var` in Lambdas** | Language | Conciseness with support for annotations. |
| **Single-file Launch** | Tooling | Faster development for scripts/prototypes. |
| **String/File APIs** | API | Massive reduction in boilerplate code. |
| **ZGC (Intro)** | Performance | Foundation for ultra-low latency GC. |
| **Epsilon GC** | Performance | A "no-op" GC for performance testing. |
