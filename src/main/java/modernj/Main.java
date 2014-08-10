package modernj;

import org.checkerframework.checker.tainting.qual.*;

public class Main {
    
    public static void main(String[] args) {
        process(parse(sanitize(read())));
    }
    
    static @Tainted String read() {
        return "12345";
    }
    
    @SuppressWarnings("tainting")
    static @Untainted String sanitize(@Tainted String s) {
        if(s.length() > 10)
            throw new IllegalArgumentException("I don't wanna do that!");
        return (@Untainted String)s;
    }
    
    @SuppressWarnings("tainting")
    static @PolyTainted int parse(@PolyTainted String s) {
        return (@PolyTainted int)Integer.parseInt(s);
    }
    
    static void process(@Untainted int data) {
        System.out.println("-->" + data);
    }
}
