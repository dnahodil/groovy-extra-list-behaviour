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
		given:
		def el = ['a'].only()

		expect:
		el == 'a'
	}

	def "only() fails on list with many elements"() {
		when:
		['a', 'b'].only()

		then:
		thrown(MoreThanOneElementException)
	}

	def "onlyIfAny() returns null on empty list"() {
		given:
		def el = [].onlyIfAny()

		expect:
		el == null
	}

	def "firstIfAny() returns null on empty list"() {
		given:
		def el = [].firstIfAny()

		expect:
		el == null
	}

	def "lastIfAny() returns null on empty list"() {
		given:
		def el = [].lastIfAny()

		expect:
		el == null
	}

	def "headIfAny() returns null on empty list"() {
		given:
		def el = [].headIfAny()

		expect:
		el == null
	}

	def "tailIfAny() returns null on empty list"() {
		given:
		def el = [].tailIfAny()

		expect:
		el == null
	}
}
