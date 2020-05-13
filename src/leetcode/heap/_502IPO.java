package leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author onion
 * @date 2020/4/28 -8:25 上午
 *
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
 * 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 *
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。
 * 当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 *
 */
public class _502IPO {
    private PriorityQueue<int[]> project;
    private PriorityQueue<Integer> available;
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        project = new PriorityQueue<>((a,b)->a[0]-b[0]);
        available = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i < Capital.length; i++)
            project.offer(new int[]{Capital[i],Profits[i]});
        while(k > 0){
            while(!project.isEmpty()){
                int[] pair = project.peek();
                if(W >= pair[0]){
                    available.offer(pair[1]);
                    project.poll();
                }
                else
                    break;
            }
            if(!available.isEmpty()){
                W += available.poll();
                k--;
            }else{
                break;
            }
        }
        return W;
    }
}
