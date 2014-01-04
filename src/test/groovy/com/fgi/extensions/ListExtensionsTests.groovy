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

	def "firstIfAny() returns null on empty list"() {
		expect:
		[].firstIfAny() == null
	}

	def "lastIfAny() returns null on empty list"() {
		expect:
		[].lastIfAny() == null
	}

	def "headIfAny() returns null on empty list"() {
		expect:
		[].headIfAny() == null
	}

	def "tailIfAny() returns null on empty list"() {
		expect:
		[].tailIfAny() == null
	}
}
