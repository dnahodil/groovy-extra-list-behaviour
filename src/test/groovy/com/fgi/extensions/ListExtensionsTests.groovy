package com.fgi.extensions

import com.fgi.extensions.exceptions.MoreThanOneElementException
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
}
