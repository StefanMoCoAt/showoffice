package com.stefanmocoat.showoffice.stuff;

public class ClassStuff {

	String foo = "Foo";
	public void foo() {
		
	}
	
	public class Inner{
		public void doFoo() {
			System.out.println(foo);
		}
	}
	
	public static class InnerStatic {
		public void doFoo() {
//			System.out.println(foo);
		}
	}
}
