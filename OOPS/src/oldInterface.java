public interface oldInterface {
    public void existingMethod();
        default public void newDefaultMethod() {
        System.out.println("New default method is added in interface");
    }
        default public void newDefaultMethod2() {
            System.out.println("New default method is added in interface");
        }
}