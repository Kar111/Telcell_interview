import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncReplacement {


    public String[] asyncArrayCopyWithReplacement(String[] source) {
        String[] destination = new String[source.length];

        int treadNumber = 11;

        ExecutorService executorService = Executors.newFixedThreadPool(treadNumber);

        for(int i = 0; i < source.length; i++) {
            final int index = i;
            executorService.execute( () -> {
                destination[index] = source[index].replace("a", "%");
                    }
            );
        }

        executorService.shutdown();

        while(!executorService.isTerminated()) {
        }

        return destination;
    }
}
