### Java Math Functions
The Java Math class has many methods that allows you to perform mathematical tasks on numbers.

| Method    | Descriptions     | Return Type        |
| :-------- | :------- | :------------------------- |
|`abs(x)`	|   `Returns the absolute value of x`	| double / float / int / long
|`acos(x)`	|   `Returns the arccosine of x, in radians`	|   double
|`asin(x)`	|   `Returns the arcsine of x, in radians`	|   double
|`atan(x)`	|   `Returns the arctangent of x as a numeric value between -PI/2 and PI/2 radians`	|   double
|`atan2(y,x)`|    	`Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta).`	|   double
|`cbrt(x)`	|   `Returns the cube root of x`	|   double
|`ceil(x)`	|   `Returns the value of x rounded up to its nearest integer`	|   double
|`copySign(x, y)`	|   `Returns the first floating point x with the sign of the second floating point y`	|   double
|`cos(x)`	|   `Returns the cosine of x (x is in radians)`	|   double
|`cosh(x)`	|   `Returns the hyperbolic cosine of a double value`	|   double
|`exp(x)`	|   `Returns the value of E.pow(x)`	|   double
|`expm1(x)`	|   `Returns e.pow(x) -1`	|   double
|`floor(x)`	|   `Returns the value of x rounded down to its nearest integer`	|   double
|`getExponent(x)`	|   `Returns the unbiased exponent used in x`	|   int
| `hypot(x, y)`	|   `Returns sqrt(x2 +y2) without intermediate overflow or underflow`	|   double
|`IEEEremainder(x, y)`	|   `Computes the remainder operation on x and y as prescribed by the IEEE 754 standard`	|   double
|`log(x)`	|   `Returns the natural logarithm (base E) of x`	|   double
|`log10(x)`	|   `Returns the base 10 logarithm of x`	|   double
|`log1p(x)`	|   `Returns the natural logarithm (base E) of the sum of x and 1`	|   double
|`max(x, y)`	|   `Returns the number with the highest value`	|   double / float / int / long
|`min(x, y)`	|   `Returns the number with the lowest value`	|   double / float / int / long
|`nextAfter(x, y)`	|   `Returns the floating point number adjacent to x in the direction of y`	|   double / float
|`nextUp(x)`	|   `Returns the floating point value adjacent to x in the direction of positive infinity`	|   double / float
|`pow(x, y)`	|   `Returns the value of x to the power of y`	|   double
|`random()`	|   `Returns a random number between 0 and 1`	|   double
|`round(x)`	|   `Returns the value of x rounded to its nearest integer`	| int
|`rint()`	|   `Returns the double value that is closest to x and equal to a mathematical integer`	|   double
|`signum(x)`	|   `Returns the sign of x`	|   double
|`sin(x)`	|   `Returns the sine of x (x is in radians)`	|   double
|`sinh(x)`	|   `Returns the hyperbolic sine of a double value`	|   double
|`sqrt(x)`	|   `Returns the square root of x`	|   double
|`tan(x)`	|   `Returns the tangent of an angle`	|   double
|`tanh(x)`	|   `Returns the hyperbolic tangent of a double value`	|   double
|`toDegrees(x)`	|   `Converts an angle measured in radians to an approx. equivalent angle measured in degrees`	|   double
|`toRadians(x)`	|   `Converts an angle measured in degrees to an approx. angle measured in radians`	|   double
|`ulp(x)`	|   `Returns the size of the unit of least precision (ulp) of x`	|   double / float

**Note:** All Math methods are `static`.

**Math Class methods helps to perform the numeric operations like square, square root, cube, cube root, exponential and trigonometric operations**
- **What is NaN argument?**
A constant holding a Not-a-Number (NaN) value of type double. It is equivalent to the value returned by Double.longBitsToDouble(0x7ff8000000000000L).

<hr>

### `abs(), acos(), toRadians()`
```
    // Declaring the variables
    int Vali = -1;
    float Valf = .5f;
 
    // Printing the values
        System.out.println("Initial value of int  : "+Vali);
        System.out.println("Initial value of int  : "+Valf);
 
 
    // Use of .abs() method to get the absoluteValue
    int Absi = Math.abs(Vali);
    float Absf = Math.abs(Valf);
 
        System.out.println("Absolute value of int : "+Absi);
        System.out.println("Absolute value of int : "+Absf);
        System.out.println("");
 
    // Use of acos() method
    // Value greater than 1, so passing NaN
    double Acosi = Math.acos(60);
        System.out.println("acos value of Acosi : "+Acosi);
    double x = Math.PI;
 
    // Use of toRadian() method
    x = Math.toRadians(x);
    double Acosj = Math.acos(x);
        System.out.println("acos value of Acosj : "+Acosj);
```

**Output:**
```
Initial value of int  : -1
Initial value of int  : 0.5
Absolute value of int : 1
Absolute value of int : 0.5

acos value of Acosi : NaN
acos value of Acosj : 1.5159376794536454
```

<hr>

### `asin(), cbrt()`
```
    int a = 1, b = 8;
    int radd = a+b;
 
    // Use of asin() method
    // Value greater than 1, so passing NaN
    double Asini = Math.asin(radd);
        System.out.println("asin value of Asini : " + Asini);
    double x = Math.PI;
 
    // Use of toRadian() method
    x = Math.toRadians(x);
    double Asinj = Math.asin(x);
        System.out.println("asin value of Asinj : " + Asinj);
        System.out.println("");
 
    // Use of cbrt() method
    double cbrtval = Math.cbrt(216);
        System.out.println("cube root : " + cbrtval);
```
**Output:**
```
asin value of Asini : NaN
asin value of Asinj : 0.054858647341251204

cube root : 6.0
```
<hr>

### `floor(), hypot(), IEEEremainder(), log()`

```
    // Use of floor method
    double f1 = 30.56, f2 = -56.34;
    f1 =Math.floor(f1);
        System.out.println("Floor value of f1 : "+f1);
 
    f2 =Math.floor(f2);
        System.out.println("Floor value of f2 : "+f2);
        System.out.println("");
 
    // Use of hypot() method
    double p = 12, b = -5;
    double h = Math.hypot(p, b);
        System.out.println("Hypotenuse : "+h);
        System.out.println("");
 
    // Use of IEEEremainder() method
    double d1 = 105, d2 = 2;
    double r = Math.IEEEremainder(d1,d2);
        System.out.println("Remainder : "+r);
        System.out.println("");
         
    // Use of log() method
    double l = 10;
    l = Math.log(l);
        System.out.println("Log value of 10 : "+l);
```

**Output:**
```
Floor value of f1 : 30.0
Floor value of f2 : -57.0

Hypotenuse : 13.0

Remainder : 1.0

Log value of 10 : 2.302585092994046
```
<hr>

### `atan(), ceil(), copySign() `

```
    // Use of atan() method
    double Atani = Math.atan(0);
        System.out.println("atan value of Atani : "+Atani);
    double x = Math.PI/2;
 
    // Use of toRadian() method
    x = Math.toRadians(x);
    double Atanj = Math.atan(x);
        System.out.println("atan value of Atanj : "+Atanj);
        System.out.println("");
 
 
    // Use of ceil() method
    double val = 15.34 ,ceilval;
    ceilval = Math.ceil(val);
        System.out.println("ceil value of val : "+ceilval);
        System.out.println("");
 
    double dblMag = val;
    double dblSign1 = 3;
    double dblSign2 = -3;
 
 
    // Use of copySign() method
    double result1 = Math.copySign(dblMag,dblSign1);
        System.out.println("copySign1 : "+result1);
 
    double result2 = Math.copySign(dblMag,dblSign2);
        System.out.println("copySign2 : "+result2);
```

**Output:**
```
atan value of Atani : 0.0
atan value of Atanj : 0.0274087022410345

ceil value of val : 16.0

copySign1 : 15.34
copySign2 : -15.34
```