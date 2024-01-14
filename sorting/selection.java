// Selection Sort Code
// Time Complexity: Best Average and Worst: o(n^2)
// Space Complexity: O(1)
// Explanation: https://takeuforward.org/sorting/selection-sort-algorithm/

package sorting;

import java.util.Scanner;

public class selection {
    static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini])
                    mini = j;
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr, n);
        for (int i = 0; i < n - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
