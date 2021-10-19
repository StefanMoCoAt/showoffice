package com.stefanmocoat.showoffice.stuff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorStuff {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Foo");
		list.add("Bar");

		// Iterator weg
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String val = iter.next();
			System.out.println(val);
		}

		// Iterable weg
		for (String val : list) {
			System.out.println(val);
		}

		// for with count
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
