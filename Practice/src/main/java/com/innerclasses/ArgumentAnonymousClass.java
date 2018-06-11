package com.innerclasses;

interface Foo {
	void foof();
}

class Bar {
	void doStuff(Foo f) {

	}
}

public class ArgumentAnonymousClass {
	int x = 4;
	void go() {
		Bar b = new Bar();
		b.doStuff(new Foo() {
			public void foof() {
				System.out.println("foof");
				System.out.println(x);
			}
		});

	}

}
