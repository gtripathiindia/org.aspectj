
public class Foo3 {
	int i=3;
	
	// Need local variable table for this code to be OK and not lose the fact that this/etc are setup from
	// instruction 0 to the end of the method
	void foo(Bar bar) {
		i = 33;
        try {
System.out.println("x");
        } catch (Exception e) {
          e.printStackTrace();
        }
	}
	public static void main(String[] args) {
		new Foo3().foo(null);
	}
}

class Bar {}

aspect FooAspect {
	before(): execution(* *(..)) {}
	before(): execution(* *(..)) {}
}
