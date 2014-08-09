package modernj;

import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.strands.Strand;

public class Main {

    /**
     *
     * @param args
     */
    public static void main (String[] args) throws Exception{
        final Channel<Integer> ch = Channels.newChannel(0);
        
        new Fiber<Void>(() -> {
            for (int i = 0; i < 10; i++){
                Strand.sleep(100);
                ch.send(i);
            }
            ch.close();
        }).start();
        
        new Fiber<Void>(() -> {
            Integer x;
            while((x = ch.receive()) != null)
                System.out.println("-->" + x);
        }).start().join();
    }
    
}
