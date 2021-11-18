package com.stefanmocoat.showoffice.stuff;

public class ClassStuff2 {

	public void foo() {
		ClassStuff.InnerStatic innerS = new ClassStuff.InnerStatic();
//		ClassStuff.Inner inner = new ClassStuff.Inner();
		
		ClassStuff cs = new ClassStuff();
		ClassStuff.Inner inner = cs.new Inner();
	}
	
}
