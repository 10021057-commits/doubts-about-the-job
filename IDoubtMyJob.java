public class IDoubtMyJob {

    public static void main(String[] args) {
        long targetLimit = 1_000_000_000L;
        int numChunks = 1000;
        long rangePerChunk = targetLimit / numChunks;

        long totalCount = 0;
		CodeTimer.start();

        for (int i = 0; i < numChunks; i++) {
            final long start = i * rangePerChunk + 1;
            final long end = (i == numChunks - 1) ? targetLimit : (i + 1) * rangePerChunk;

            long count = 0;
            for (long j = start; j <= end; j++) {
                count++;
            }

            totalCount += count;
        }

        System.out.println("Total numbers counted between 1 and 1,000,000,000: " + totalCount);
    	System.out.println("time: " + CodeTimer.stop());

    	//Coder comment: This code does it through a single-threaded approach.
    	//The time is around a quarter of a second.

    	//Reviewer comment: After carefully reviewing this intricate work,
    	//I can verify that it properly performs the job of counting
    	//every number between 1 and a billion and returns the time
    	//in ms of how long that process takes. hooray!

    }
}