public class IDoubtMyJob {

    public static void main(String[] args) {
        long targetLimit = 1_000_000_000L;
        int numChunks = 1000;
        long rangePerChunk = targetLimit / numChunks;

        long totalCount = 0; // 1. Declared outside the loop so it keeps the grand total
		CodeTimer.start();

        for (int i = 0; i < numChunks; i++) {
            final long start = i * rangePerChunk + 1;
            final long end = (i == numChunks - 1) ? targetLimit : (i + 1) * rangePerChunk;

            long count = 0;
            for (long j = start; j <= end; j++) {
                count++;
            }

            totalCount += count; // 2. Add this chunk's count to the grand total before count resets
        }

        System.out.println("Total numbers counted between 1 and 1,000,000,000: " + totalCount);
    	System.out.println("time: " + CodeTimer.stop());

    }
}