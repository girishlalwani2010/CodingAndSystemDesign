package athena;
public class ABC {
    static String v = "abc";
    static int v1 = 25;

    static {
        v1 = 50;
        System.out.println(v);
        System.out.println(v1); 
    }

    public static void main(String args[]){
    }

}