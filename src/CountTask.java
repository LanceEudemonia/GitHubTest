import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author: liyi
 * @date: 2019/9/22 上午9:40
 */
public class CountTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000000000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i < end; i++) {
                sum = sum + i;
            }
        } else {
            // 分割成100个小任务，这里应该可以计算出分割的任务的值而不是直接写死
            long step = (end + start) / 100;
            ArrayList<CountTask> countTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = step + pos;
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask task = new CountTask(pos, lastOne);
                pos = pos + 1;
                countTasks.add(task);
                task.fork();
            }
            for (CountTask count :
                    countTasks) {
                sum += count.join();

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinTask = new ForkJoinPool();
        CountTask countTask = new CountTask(0, 200000L);
        ForkJoinTask<Long> result = forkJoinTask.submit(countTask);
        Long aLong = null;
        try {
            aLong = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(aLong);

    }
}
