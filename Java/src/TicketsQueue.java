import java.util.LinkedList;
import java.util.Queue;

public class TicketsQueue {
	public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i <tickets.length; i++) {
            queue.add(i);
        }
        int count=0;
        while(!queue.isEmpty()) {
            count++;
            int index = queue.poll();
            if(tickets[index] >= 1) {
                tickets[index] -= 1;
            }
            //now I will check he can go back to last of queue or not
            if(index != k && tickets[index] == 0) { 
                //he is the normal guy, which means he can leave the queue
                continue;
            }
            //he is the Kth guy, he cannot leave the Queue instead he can BREAK the Queue :)
            if(index == k && tickets[index] == 0) {
                break;
            }
            //in all other case we need to add the guy back to Queue
            queue.offer(index);
        }
        return count;
    }
}
