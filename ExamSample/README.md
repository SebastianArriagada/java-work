# Ankaa Birds

## Test 

```
javac -cp .;junit-4.13.jar tests/AdventureTest.java
java -cp .;junit-4.13.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.AdventureTest
```


# Exam Description

You should follow Sinbad the sailor on his adventures to Diamond Island. His plan is to collect some diamonds, then calls a helpful Ankaa bird that carries him away. Then he stores his collected diamonds, and returns to the island the following day.

## Task #1 (12 points)

(1 point) Create the interface `exam.sinbad.sky.Bird` with the method `isAtHeightRange()` that takes `height` of type 'int' and returns a `boolean` value, and a `getName` that returns a `String` value. 

(1 point) Create the `exam.sinbad.Adventure` class which has the following fields:
 - `collectedDiamonds` (initially `0`), `birds` (a list of `Bird`s; with `getBirdCount` that returns the number of birds in the list), and `day`(initially `1`).
 - It also has a static field: `storedDiamonds`(initially `0`).

(1 point) Create `collectDiamonds` and `storeDiamonds`. They take a `diamondCount` parameter, and add it to `collectedDiamonds` and `storedDiamonds` respectively. 

(1 point) Create `clearStoredDiamonds` that sets `storedDiamonds` to `0`. 

(2 point) Make `storeDiamonds` method and all fields of the `Adventure` class only accessible to the descendants of `Adventure`, and create getters for all of the fields. 

`Adventure` has two constructors:
(1 point) 1. A constructor that takes an arbitrary amount of birds as parameters, and add them to the `birds` List. If the constructor gets more than three birds, it throws an `IllegalArgumentException`.

(1 point) 2. A constructor that takes no arguments. It calls the previous constructor with a single `Ankaa` with the name `BigBird` and a `height` of `700`. For more on the `Ankaa` class, see below.

(1 point) TEST: Create `tests.AdventureTest` class that uses JUnit. It checks the following:

(1 point) An adventure (constructor #2) has `0` collected and stored diamonds initially.

(1 point) An adventure (constructor #1) has `0` collected and stored diamonds initially.

(1 point) It also has the appropriate `getBirdCount`: test for 0 and 2 birds.\

- You have to add all test cases described below into this class.\

## Task #2 (16 points)

(1 point) Create an enum `exam.sinbad.sky.HeightRange` with four values: `LOW`, `MEDIUM`, `HIGH`, and `BEYOND`.

(1 point) It has `min` and `max` fields, and 2 constructors: the first one takes `min` and `max` fields and set their values, while the second one takes no parameters and set 0 for both fields.

(1 point) The first three enum values take two parameters, and they are stored in the field. The enum value `BEYOND` does not take any parameters, and stores `0` in the fields. The first three values take the ranges `0..300`, `301..600`, `601..900`.

(1 point) It has a `getHeightRange` method, which takes an `int`. The method loops through the `HeightRange` enum values; if the parameter number is between `min..max` for the enum value, the method returns the enum value. If it is the last value (with `0` in its fields), the method returns it.

(1 point) TEST: Test `getHeightRange` for the following values: `0`, `299`, `300`, `301`, `600`, `601`, `900`, `901`.

(1 point) Create the class `exam.sinbad.sky.Ankaa` with two fields: `name` and `height`.

(1 point) Create a setter for `height` and getters for both.

(1 point) `toString()` returns text that looks like this: `ThisIsMyName[flying HIGH at 765 meters]` or `OneDoesNotSimplyFlyOutOfDiamondIsland[flying BEYOND at 100000 meters]` Use the `HeightRange` enum to produce this output.

(1 point) Let `Ankaa` implement the `Bird` interface.

(1 point) When `isAtHeightRange` is called, the method returns as a boolean whether the Ankaa bird is flying in the `HeightRange` for the method's parameter.

(2 point) Override `equals()`: two Ankaas are considered equal if they are flying in the same height range and their names are the same. Don't forget to override `hashCode()`, too.

(1 point) TEST: test `toString` with the two examples given above.

(1 point) TEST: two birds with the same data are equal.

(1 point) TEST: two birds with the same name, different heights (but at the same height level) are equal.

(1 point) TEST: two birds with different names but at the same height are *not* equal.


## Task #3 (12 points)

(2 point) In `Adventure`, create the method `callBird`. It takes `height` of `int` value, and checks whether any of the Ankaa birds is at this height range. If so, Sinbad escapes with the bird: he calls `doEscape`. Otherwise, Sinbad could not escape. The method returns whether the escape was successful or not.

(1 point)`doEscape` is a method accessible to the descendants of the class. It takes a `Bird` as a parameter. It adds the value of `collectedDiamonds` to `storedDiamonds` using the `storeDiamonds` method, then set `collectedDiamonds` to `0`, and increases the `day`.

(1 point) TEST: if you call a bird but the call is too low or too high, the bird will not come. Also, you're still on day 1.

(1 point) TEST: write a test case that lasts a day. Call the birds, collect the diamonds, and use `getCollectedDiamonds`, `getStoredDiamonds`, and `getDay` to check that everything is as expected.

(2 point) TEST: write a test case that lasts 3 days. Call the birds, collect the diamonds, and use `getCollectedDiamonds`, `getStoredDiamonds`, and `getDay` to check that everything is as expected. Hint: you have to call `clearStoredDiamonds` in the appropriate place.

(1 point) Create `exam.sinbad.ValuableAdventure`, a child class of `Adventure`. Its single constructor takes a `diamondFilename` and a list of `Bird`s. The `Bird`s are passed on to the constructor of the base class.

(2 point) Open the file (you can assume it exists) and process it line by line. Each line looks like this: `BirdName 1234` where the number is a diamond count.

(1 point) Store the diamond counts associated with the birds in the field `birdDiamonds` which is a `Map` data structure.

(1 point) Override `doEscape` so that in addition to its previous actions, it also checks whether the bird that the method takes as a parameter has an associated diamond count in `birdDiamonds`. If so, those diamonds are also stored (using `storeDiamonds`) and the bird and its diamonds are removed from `birdDiamonds`.
