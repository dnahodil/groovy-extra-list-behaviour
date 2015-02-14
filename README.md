# Groovy Extra List Behaviour
[![Build Status](https://travis-ci.org/dnahodil/groovy-extra-list-behaviour.png)](https://travis-ci.org/dnahodil/groovy-extra-list-behaviour)

Current version: 1.2.0

## Description
Adds extra methods to Groovy lists. Requires Groovy version > 2.0.5 as it utilises the Groovy extensions mechanism.

## Using this library
I plan to publish this library to a central repository so it can be used with Maven or other dependancy resolution tools. For now you can download the [built jar](https://github.com/dnahodil/groovy-extra-list-behaviour/raw/master/build/libs/groovy-extra-list-behaviour-1.1.0.jar) and include it as a library in your project.

I wrote a blog post describing [Adding Groovy extension modules to a Grails application](http://dnahodil.wordpress.com/2014/01/05/adding-groovy-extension-modules-to-a-grails-application/).

## New methods available
### `only()`
In a similar vein to `first()` and `last()` this method will return the only element of a list. This method allows you to write clearer code by making it expressly clear when we are expecting a list with a single element. An example usage might be if we are calling an SQL utilty which always returns a list of rows as the result, but the SQL has specified `SELECT TOP 1 ...` so we know there will only be one element during normal operation. Calling `first()` or `last()` when we *know* there's only going to be one element weakens the expressiveness of the code, whereas calling `only()` enhances it.

As with similar methods on the List class this will throw a `NoSuchElementException` if the list is empty. If there is more than the expected one element a `MoreThanOneElementException` will be thrown.

This is described in more detail in my blog post "[An extension for Groovy Lists – getting the only element of a List](http://dnahodil.wordpress.com/2014/01/05/an-extension-for-groovy-lists-getting-the-only-element-of-a-list/)".

### `firstIfAny()`, `lastIfAny()`, `headIfAny()`, `tailIfAny()`, `onlyIfAny()`
These methods extend the `first()`, `last()`, `head()`, `tail()`, and `only()` methods. These methods will behave the same as their counterparts on a non-empty list. The difference is that they will return `null` if the list is empty. This is useful if you are using Groovy truthiness or null-safe navigation to make the subsequent code null-safe. Using these methods will allow you to eliminate an `if` condition, or a usage of the ternary operator, to stop the corresponding call of `first()`, `last()`, etc. on an empty list (which would otherwise throw an Exception). 

I wrote a blog post about these, "[An extension for Groovy Lists – a less strict alternative for first(), last(), etc.](http://dnahodil.wordpress.com/2014/01/05/an-extension-for-groovy-lists-a-less-strict-alternative-for-first-last-etc/)".
