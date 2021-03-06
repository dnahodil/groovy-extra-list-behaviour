# Groovy Extra List Behaviour
[![Build Status](https://travis-ci.org/dnahodil/groovy-extra-list-behaviour.png)](https://travis-ci.org/dnahodil/groovy-extra-list-behaviour)

[About](#about) »  
[Using this library](#using-this-library) »  
[New methods available](#new-methods-available) »  
[Releases](#releases) »  
[Thanks](#thanks) »

## About
Adds extra methods to Groovy lists. Requires Groovy version > 2.0.5 as it utilises the Groovy extensions mechanism.  
Released under the [MIT license](https://github.com/dnahodil/groovy-extra-list-behaviour/raw/master/LICENSE).

## Using this library
You can include this library in your project in a number of ways, detailed below.
### Via [Grape](http://www.groovy-lang.org/Grape)
e.g. for use in Groovy scripts (including in the GroovyConsole)  
```groovy
@Grab('com.dnahodil.groovy.extensions:groovy-extra-list-behaviour')
```

### In Grails
Grails version > 2.4.4 is required for this to work automatically.
```groovy
compile('com.dnahodil.groovy.extensions:groovy-extra-list-behaviour:x.y.z')
```
For earlier versions of Grails I wrote a blog post describing [Adding Groovy extension modules to a Grails application](http://dnahodil.wordpress.com/2014/01/05/adding-groovy-extension-modules-to-a-grails-application/). You will either need to download the jar to include in your Grails app, or build it yourself using this repository.

### Via Gradle
```groovy
compile 'com.dnahodil.groovy.extensions:groovy-extra-list-behaviour:x.y.z'
```

### Via Maven
```xml
<dependency>
	<groupId>com.dnahodil.groovy.extensions</groupId>
	<artifactId>groovy-extra-list-behaviour</artifactId>
	<version>x.y.z</version>
</dependency>
```

## New methods available
### `only()`
In a similar vein to `first()` and `last()` this method will return the only element of a list. This method allows you to write clearer code by making it expressly clear when we are expecting a list with a single element. An example usage might be if we are calling an SQL utilty which always returns a list of rows as the result, but the SQL being executed will return a scalar value, e.g. `select count(*) from users;`. Calling `first()` or `last()` when we *know* there's only going to be one element weakens the expressiveness of the code, whereas calling `only()` enhances it.

As with similar methods on the List class this will throw a `NoSuchElementException` if the list is empty. If there is more than the expected one element a `MoreThanOneElementException` will be thrown.

``` groovy
['a', 'b'].only() // Throws MoreThanOneElementException
assert ['a'].only() == 'a'
[].only() // Throws NoSuchElementException
```

This is described in more detail in my blog post "[An extension for Groovy Lists – getting the only element of a List](http://dnahodil.wordpress.com/2014/01/05/an-extension-for-groovy-lists-getting-the-only-element-of-a-list/)".

### `firstIfAny()`, `lastIfAny()`, `headIfAny()`, `tailIfAny()`, and `onlyIfAny()`
These methods extend the `first()`, `last()`, `head()`, `tail()`, and `only()` methods. These methods will behave the same as their counterparts on a non-empty list. The difference is that they will return `null` if the list is empty. This is useful if you are using Groovy truthiness or null-safe navigation to make the subsequent code null-safe. Using these methods will allow you to eliminate an `if` condition, or a usage of the ternary operator, to stop the corresponding call of `first()`, `last()`, etc. on an empty list (which would otherwise throw an exception). 

``` groovy
assert ['a', 'b'].firstIfAny() == 'a'
assert ['a'].firstIfAny() == 'a'
assert [].firstIfAny() == null

assert ['a', 'b'].lastIfAny() == 'b'
assert ['a'].lastIfAny() == 'a'
assert [].lastIfAny() == null

assert ['a', 'b'].headIfAny() == 'a'
assert ['a'].headIfAny() == 'a'
assert [].headIfAny() == null

assert ['a', 'b'].tailIfAny() == ['b']
assert ['a'].tailIfAny() == []
assert [].tailIfAny() == null

assert ['a'].onlyIfAny() == 'a'
assert [].onlyIfAny() == null
```

I wrote a blog post about these, "[An extension for Groovy Lists – a less strict alternative for first(), last(), etc.](http://dnahodil.wordpress.com/2014/01/05/an-extension-for-groovy-lists-a-less-strict-alternative-for-first-last-etc/)".

### `removeNulls()`
This method will remove all occurences of `null` within a list. Elements in the returned list will be in the same order as they were in the original list. This is the same behaviour as calling `findAll{ it != null }` on a list but the intent is more clear.

``` groovy
assert [1, false, null, '', 2].removeNulls() == [1, false, '', 2]
```

## Releases
**2.0.2** (current version)  
Fixed issue [#20](https://github.com/dnahodil/groovy-extra-list-behaviour/issues/20)

**2.0.1**  
Fixed bug where `removeNulls()` removed items which weren't null but which were *falsey*

**2.0.0**  
Updated return types of `tailIfAny()` and `removeNulls()` from Object to List  
Changed package names (in preparation of publishing to maven central repo)

**1.2.0**  
Added new method: `removeNulls()`

**1.1.0**  
Switched to [semantic versioning](http://www.semver.org) (no functional changes)

**1.1**  
Improved some tests (no functional changes)

**1.0**  
Initial release  
New methods available: `only()`, `firstIfAny()`, `lastIfAny()`, `headIfAny()`, `tailIfAny()`, and `onlyIfAny()`

## Thanks
Learning about the Groovy extension mechanism and inspiration to try writing an extension myself come from [Tim Yates](https://twitter.com/tim_yates)' [Groovy Common Extensions](https://github.com/timyates/groovy-common-extensions) project. The Gradle build file here is based heavily on his from that project, too.
