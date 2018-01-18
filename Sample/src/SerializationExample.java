import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person2 implements Serializable
{
   private final String lastName;
   private final String firstName;
   private final NonSerializable nonSerializable;

   public NonSerializable getNonSerializable() {
	return nonSerializable;
}

public Person2(
      final String newLastName, final String newFirstName,
      final NonSerializable nonSerializable)
   {
      this.lastName = newLastName;
      this.firstName = newFirstName;
      this.nonSerializable = nonSerializable;
   }

   public String getFirstName()
   {
      return this.firstName;
   }

   public String getLastName()
   {
      return this.lastName;
   }
   
   

   @Override
   public String toString()
   {
      return this.firstName + " " + this.lastName + " of " + this.nonSerializable;
   }
}


public class SerializationExample {
	public static void main(String[] args) {
		try {
			FileOutputStream file = new FileOutputStream("/Users/g09562357/Documents/My_Documents/MY_DATA/SeriaizedContent/sample.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			NonSerializable nonSerializable = new NonSerializable();
			nonSerializable.setAge(27);
			Person2 person2 = new Person2("lalwani", "girish", nonSerializable);
			
			// Method for serialization of object
			out.writeObject(person2);
			 
			out.close();
			
			 FileInputStream file1 = new FileInputStream("/Users/g09562357/Documents/My_Documents/MY_DATA/SeriaizedContent/sample.ser");
	            ObjectInputStream in = new ObjectInputStream(file1);
	             
	            // Method for deserialization of object
	            Person2 person3 = (Person2)in.readObject();
	             
	            in.close();
	            file1.close();
	             
	            System.out.println("Object has been deserialized ");
	            System.out.println("b = " + person3.getNonSerializable().getAge());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
