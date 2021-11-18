package com.stefanmocoat.showoffice.stuff;

import java.util.HashSet;
import java.util.Set;

public class MyEnum {

	public static final MyEnum H = new MyEnum("H");
	public static final MyEnum W = new MyEnum("W");

	private static Set<MyEnum> values = new HashSet<>();

	private final String code;

	private MyEnum(String code) {
		this.code = code;
		values.add(this);
	}

	public String getCode() {
		return code;
	}

	public static MyEnum[] values() {
		return values.toArray(new MyEnum[values.size()]);
	}

}
