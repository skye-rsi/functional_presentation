import java.util.function.Consumer;

class Resource {
    // public Resource() { System.out.println("created..."); }
    // public void op1() { System.out.println("op1"); }
    // public void op2() { System.out.println("op2"); }
    // public void close() { System.out.println("cleanup..."); }

    private Resource() { System.out.println("created..."); }
    public Resource op1() { System.out.println("op1"); return this;}
    public Resource op2() { System.out.println("op2"); return this;}
    private void close() { System.out.println("cleanup..."); }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}

public class ExecuteAroundFun {


    public static void main(String[] args) {
        // Resource resource = new Resource();
        // try {
        //     resource.op1();
        //     resource.op2();
        // } finally {
        //     resource.close(); 
        // }
        // easy to forget
        // verbose

     Resource.use(resource ->resource.op1().op2());   
    }
}
