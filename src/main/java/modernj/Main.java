package modernj;

import org.checkerframework.checker.units.qual.*;

public class Main {
    @SuppressWarnings("unsafe") private static final @m int m = (@m int)1;
    @SuppressWarnings("unsafe") private static final @s int s = (@s int)1;

    public static void main(String[] args) {
        @m double meters = 5.0 * m;
        @s double seconds = 2.0 * s;
        // @kmPERh double speed = meters / seconds; // this won't compile
        @mPERs double speed = meters / seconds;
        
        System.out.println("Speed: " + speed);
        
    }
}
