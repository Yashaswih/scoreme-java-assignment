import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    // Used AtomicInteger to ensure thread-safe counter updates
    private AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<StatementRecord> records) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {

            executor.submit(() -> {

                processRecord(record);

                // Atomic increment prevents race condition
                processedCount.incrementAndGet();

            });

        }

        executor.shutdown();

        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {

        // Return the current atomic value
        return processedCount.get();

    }

    private void processRecord(StatementRecord record) {
        // Existing processRecord(...) implementation is assumed to exist.
        // Only the counter mechanism has been modified as per assignment instructions.
    }
}