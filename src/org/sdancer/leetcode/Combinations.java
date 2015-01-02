package org.sdancer.leetcode;

import java.util.*;

public class Combinations {
	// Combine(n, n).
    private List<Integer> allContain(int n)
    {
        final List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i)
        {
            result.add(i);
        }

        return result;
    }

    public List<List<Integer>> combine(int n, int k)
    {
        List<List<List<Integer>>> previous = new ArrayList<>();

        for (int i = 0; i <= n; ++i)
        {
            previous.add(Collections.singletonList(Collections.<Integer>emptyList()));
        }

        for (int i = 1; i <= k; ++i)
        {
            final List<List<List<Integer>>> current = new ArrayList<>();
            current.add(Collections.singletonList(allContain(i)));

            // Combine(i, j).
            for (int j = i + 1; j <= n; ++j)
            {
                final List<List<Integer>> list = new ArrayList<>();

                // Combine(i, j - 1).
                list.addAll(current.get(current.size() - 1));

                // Comine(i - 1, j - 1).
                for (final List<Integer> item : previous.get(current.size()))
                {
                    final List<Integer> newItem = new ArrayList<>(item);
                    newItem.add(j);
                    list.add(newItem);
                }

                current.add(list);
            }

            previous = current;
        }

        return (previous.size() == 0) ? Collections.<List<Integer>>emptyList() : previous.get(previous.size() - 1);
    }
}
