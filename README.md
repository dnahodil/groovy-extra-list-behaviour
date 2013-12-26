# Groovy Extra List Behaviour
Current version: 1.0

## Description
Adds extra methods to the Groovy Lists. Requires Groovy version > 2.0 as it utilises the Groovy extensions mechanism.

## New methods available
### `only()`
In a similar vein to `first()` and `last()` this method will return the only element of a List. This method allows you to write clearer code by making it expressly clear when we are expecting a List with a single element. An example usage might be is we are calling an SQL utilty which always returns a List of rows as the result, but the SQL has specified `SELECT TOP 1 ...` so we know there will only be one element during normal operation. Calling `first()` or `last()` when we *know* there's only going to be one element weakens the expressiveness of the code, whereas calling `only()` reinforces it.

As with similar methods on the List class this will throw a `NoSuchElementException` if the List is empty. If there is more than the expected one element a `MoreThanOneElementException` will be thrown.

### `firstIfAny()`, `lastIfAny()`, `headIfAny()`, `tailIfAny()`, `onlyIfAny()`
These methods extend the `first()`, `last()`, `head()`, `tail()`, and `only()` methods. These methods will behave the same as their counterparts on a non-empty List. The difference is that they will return `null` if the List is empty. This is useful if you are using Groovy truthiness or null-safe navigation to make following code null-safe. Using these methods will allow you to eliminate an `if` condition, or a usage of the ternary operator, to stop the corresponding call of `first()`, `last()`, etc. on an empty List (which would otherwise throw an Exception). 
