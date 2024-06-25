class A{
    void display() //overridden method
    {
        System.out.println("hey I'am A");
    }
}
class B extends A{
    void display() //overridig method
    {
        System.out.println("hey I'am B");
    }
}
public class overriding  {
    public static void main(String[] args){
        B b = new B();
        b.display();

    }
    
}
