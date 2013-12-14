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
}
