package com.fgi.extensions

import com.fgi.extensions.exceptions.MoreThanOneElementException

class ListExtensions {

	public static def only(List list) {

		if (list.size() == 0)
			throw new NoSuchElementException("Cannot access only() element from an empty List")

		if (list.size() > 1)
			throw new MoreThanOneElementException("Cannot access only() element from a List with many elements (List has ${list.size()} elements)")

		return list.first()
	}

	public static def onlyIfAny(List list) {

		list.size() ? list.only() : null
	}

	public static def firstIfAny(List list) {

		list.size() ? list.first() : null
	}

	public static def lastIfAny(List list) {

		list.size() ? list.last() : null
	}

	public static def headIfAny(List list) {

		list.size() ? list.head() : null
	}

	public static def tailIfAny(List list) {

		list.size() ? list.tail() : null
	}
}
