import java.util.function.Consumer;

class Mailer {
    public static void print(String msg) { System.out.println(msg);}
    
    // public void from(String addr) { print("from");}
    // public void to(String addr) { print("to"); }
    // public void subject(String addr) { print("subject"); }
    // public void body(String msg) { print("body"); }
    // public void send() { System.out.println("Sending...."); }
    
    public Mailer() {};
    public Mailer from(String addr) { print("from"); return this;}
    public Mailer to(String addr) { print("to"); return this;}
    public Mailer subject(String addr) { print("subject"); return this;}
    public Mailer body(String msg) { print("body"); return this;}
    
    public static void send(Consumer<Mailer> block) { 
        Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("Sending...."); 
    }
}

public class FluentFun {

    public static void main(String[] args) {
        // Mailer mailer = new Mailer();
        // mailer.from("baby@yoda.com");
        // mailer.to("skye@rsi.com");
        // mailer.subject("soup");
        // mailer.body("more soup");
        // mailer.send();
        // noisy
        // ok to re-use mailer?

        Mailer.send(mailer -> 
            mailer
            .from("baby@yoda.com")
            .to("skye@rsi.com")
            .subject("soup")
            .body("more soup"));
    }
}
