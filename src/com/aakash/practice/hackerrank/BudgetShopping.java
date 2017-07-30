package com.aakash.practice.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/25/17.
 */
public class BudgetShopping {

    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {

        int[] temp = new int[n+1];

        int len = bundleCosts.length;
        for (int i=0; i<=n; i++)
            for (int j=0; j<len; j++)
                if (bundleCosts[j] <= i)
                    temp[i] = Math.max(temp[i], temp[i-bundleCosts[j]]+bundleQuantities[j]);

        return temp[n];
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = "t1.out";//System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());


        int _bundleQuantities_size = 0;
        _bundleQuantities_size = Integer.parseInt(in.nextLine().trim());
        int[] _bundleQuantities = new int[_bundleQuantities_size];
        int _bundleQuantities_item;
        for(int _bundleQuantities_i = 0; _bundleQuantities_i < _bundleQuantities_size; _bundleQuantities_i++) {
            _bundleQuantities_item = Integer.parseInt(in.nextLine().trim());
            _bundleQuantities[_bundleQuantities_i] = _bundleQuantities_item;
        }


        int _bundleCosts_size = 0;
        _bundleCosts_size = Integer.parseInt(in.nextLine().trim());
        int[] _bundleCosts = new int[_bundleCosts_size];
        int _bundleCosts_item;
        for(int _bundleCosts_i = 0; _bundleCosts_i < _bundleCosts_size; _bundleCosts_i++) {
            _bundleCosts_item = Integer.parseInt(in.nextLine().trim());
            _bundleCosts[_bundleCosts_i] = _bundleCosts_item;
        }

        res = budgetShopping(_n, _bundleQuantities, _bundleCosts);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
