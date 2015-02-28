package com.dnahodil.groovy.extensions

import spock.lang.Specification

class ListExtensionsTests extends Specification {

	def "only() fails on empty list"() {
		when:
		[].only()

		then:
		thrown(NoSuchElementException)
	}

	def "only() returns only element"() {
		expect:
		['a'].only() == 'a'
	}

	def "only() fails on list with many elements"() {
		when:
		['a', 'b'].only()

		then:
		thrown(MoreThanOneElementException)
	}

	def "onlyIfAny() returns null on empty list"() {
		expect:
		[].onlyIfAny() == null
	}

	def "onlyIfAny() calls only()"() {
		setup:
		def list = GroovySpy(ArrayList)

		when:
		list << 'a'
		list.onlyIfAny()

		then:
		1 * list.only()
	}

	def "firstIfAny() returns null on empty list"() {
		expect:
		[].firstIfAny() == null
	}

	def "firstIfAny() calls first()"() {
		setup:
		def list = GroovySpy(ArrayList)

		when:
		list << 'a'
		list.firstIfAny()

		then:
		1 * list.first()
	}

	def "lastIfAny() returns null on empty list"() {
		expect:
		[].lastIfAny() == null
	}

	def "lastIfAny() calls last()"() {
		setup:
		def list = GroovySpy(ArrayList)

		when:
		list << 'a'
		list.lastIfAny()

		then:
		1 * list.last()
	}

	def "headIfAny() returns null on empty list"() {
		expect:
		[].headIfAny() == null
	}

	def "headIfAny() calls head()"() {
		setup:
		def list = GroovySpy(ArrayList)

		when:
		list << 'a'
		list.headIfAny()

		then:
		1 * list.head()
	}

	def "tailIfAny() returns null on empty list"() {
		expect:
		[].tailIfAny() == null
	}

	def "tailIfAny() calls tail()"() {
		setup:
		def list = GroovySpy(ArrayList)

		when:
		list << 'a'
		list.tailIfAny()

		then:
		1 * list.tail()
	}

	def "removeNulls() works on an empty list"() {
		expect:
		[].removeNulls() == []
	}

	def "removeNulls() removes one null from a list"() {
		expect:
		['a', null, 'c'].removeNulls() == ['a', 'c']
	}

	def "removeNulls() removes all nulls from a list"() {
		expect:
		[3, null, 2, null,  1].removeNulls() == [3, 2, 1]
	}

	def "removeNulls() returns an empty list when all elements are null"() {
		expect:
		[null, null].removeNulls() == []
	}
}
