package main.java.split_wise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class algo {
    List<Integer> creditList;
    List<int[]> transfers;

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> creditMap = new HashMap<>();
        for (int[] t : transactions) {
            creditMap.put(t[0], creditMap.getOrDefault(t[0], 0) + t[2]);
            creditMap.put(t[1], creditMap.getOrDefault(t[1], 0) - t[2]);
        }

        creditList = new ArrayList<>();
        for (int amount : creditMap.values()) {
            creditList.add(amount);
        }

        transfers = new ArrayList<>();
        int n = creditList.size();
        dfs(0, n, new ArrayList<>());

        for (int[] transfer : transfers) {
            System.out.println(transfer[0] + " pays " + transfer[1] + " : " + transfer[2]);
        }
        return transfers.size();
    }

    private int dfs(int cur, int n, List<int[]> currentTransfers) {
        while (cur < n && creditList.get(cur) == 0) {
            cur++;
        }

        if (cur == n) {
            if (transfers.isEmpty() || currentTransfers.size() < transfers.size()) {
                transfers = new ArrayList<>(currentTransfers);
            }
            return 0;
        }

        int cost = Integer.MAX_VALUE;
        for (int nxt = cur + 1; nxt < n; nxt++) {
            if (creditList.get(nxt) * creditList.get(cur) < 0) {
                int transferAmount = Math.min(Math.abs(creditList.get(cur)), Math.abs(creditList.get(nxt)));

                // Adjust credits
                creditList.set(nxt, creditList.get(nxt) + creditList.get(cur));

                // Store the transfer with positive amounts
                currentTransfers.add(new int[]{creditList.get(cur) > 0 ? cur : nxt,  // from
                        creditList.get(cur) > 0 ? nxt : cur,  // to
                        transferAmount                         // amount
                });

                cost = Math.min(cost, 1 + dfs(cur + 1, n, currentTransfers));

                // Backtrack
                currentTransfers.remove(currentTransfers.size() - 1);
                creditList.set(nxt, creditList.get(nxt) - creditList.get(cur));
            }
        }

        return cost;
    }
}
