import java.io.Serializable;
import java.lang.instrument.Instrumentation;

class Parent implements Serializable{
	private int pA;

	public int getpA() {
		return pA;
	}

	public void setpA(int pA) {
		this.pA = pA;
	}
	
}

class Child extends Parent{
	
}


public class PrivateInheritance {
	
	public static void main(String[] args) {
		Child parent = new Child();
		parent.setpA(10);
		//System.out.println(ObjectSizeCalculator.getObjectSizeInBytes(parent.getpA()));
	System.out.println(parent.getpA());
	
	}
	

}
