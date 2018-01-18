package deushtchebank;


public class DbJavaQuestion {

	public static void main(String[] args) {
		A a = new DbJavaQuestion().new B();
		a.printMe();
	}

	class A {
		String a = "A";

		A() {
			printMe();
		}

		void printMe() {
			System.out.println("hello");
			System.out.println(a);
		}
	}

	// dynamic binding happens before the constructor call.
	class B extends A {
		String b = "B";

		B() {
			printMe();
		}

		void printMe() {
			System.out.println(b);
		}
	}
}
