/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosordenamiento;

import java.util.Arrays;

/**
 *
 * @author Hogar
 */
public class Ordenamientos {

    public void radix(int vec[]) {

        if (vec.length == 0) {
            return;
        }
        int[][] np = new int[vec.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            for (f = i = 0; i < vec.length; i++) {
                j = ((0xFF << (k << 3)) & vec[i]) >> (k << 3);
                if (q[j] == -1) {
                    l = q[j] = f;
                } else {
                    l = q[j];
                    while (np[l][1] != -1) {
                        l = np[l][1];
                    }
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = vec[i];
                np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++) {
                for (l = q[i]; l != -1; l = np[l][1]) {
                    vec[j++] = np[l][0];
                }
            }
        }
    }

    public void Quick(int vec[], int Prim, int Ult) {
        int i = Prim, j = Ult;
        int pivote = vec[(Prim + Ult) / 2];
        int auxiliar;

        do {
            while (vec[i] < pivote) {
                i++;
            }
            while (vec[j] > pivote) {
                j--;
            }

            if (i <= j) {
                auxiliar = vec[j];
                vec[j] = vec[i];
                vec[i] = auxiliar;
                i++;
                j--;
            }
        } while (i <= j);
        if (Prim < j) {
            Quick(vec, Prim, j);
        }

        if (Ult > i) {
            Quick(vec, i, Ult);
        }
    }

    public void bucketSort(int arr[]) {
        int i, j;
        int count[] = new int[arr.length];
        Arrays.fill(count, 0);
        for (i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (i = 0, j = 0; i < count.length; i++) {
            for (; count[i] > 0; (count[i])--) {
                arr[j++] = i;
            }
        }

    }

    public int[] OrdenaMerge(int[] L) {
        int n = L.length;

        if (n > 1) {
            int m = (int) (Math.ceil(n / 2.0));
            int[] L1 = new int[m];
            int[] L2 = new int[n - m];

            for (int i = 0; i < m; i++) {
                L1[i] = L[i];
            }
            for (int i = m; i < n; i++) {
                L2[i - m] = L[i];
            }
            L = merge(OrdenaMerge(L1), OrdenaMerge(L2));
        }
        return L;
    }

    public int[] merge(int[] L1, int[] L2) {
        int[] L = new int[L1.length + L2.length];
        int i = 0;
        while ((L1.length != 0) && (L2.length != 0)) {
            if (L1[0] < L2[0]) {
                L[i++] = L1[0];
                L1 = eliminar(L1);
                if (L1.length == 0) {
                    while (L2.length != 0) {
                        L[i++] = L2[0];
                        L2 = eliminar(L2);
                    }
                }
            } else {
                L[i++] = L2[0];
                L2 = eliminar(L2);
                if (L2.length == 0) {
                    while (L1.length != 0) {
                        L[i++] = L1[0];
                        L1 = eliminar(L1);
                    }
                }
            }
        }
        return L;
    }

    public int[] eliminar(int[] l) {
        int[] L = new int[l.length - 1];
        for (int i = 1; i < l.length; i++) {
            L[i - 1] = l[i];
        }
        return L;
    }

    public void heapSort(int[] data, int n) {
        int unsorted; // Size of the unsorted part of the array
        int temp;     // Used during the swapping of two array locations

        makeHeap(data, n);

        unsorted = n;

        while (unsorted > 1) {
            unsorted--;

            // Swap the largest element (data[0]) with the final element of unsorted part  
            temp = data[0];
            data[0] = data[unsorted];
            data[unsorted] = temp;

            reheapifyDown(data, unsorted);
        }
    }

    private static void makeHeap(int[] data, int n) // Precondition: data is an array with at least n elements.
    // Postcondition: The elements of data have been rearranged so that the
    // complete binary tree represented by this array is a heap.
    {
        System.err.println("The student needs to implement the makeHeap and");
        System.err.println("reheapifyDown methods before the heapsort can be used.");
        System.exit(0);
    }

    private static void reheapifyDown(int[] data, int n) // Precondition: n > 0, and data is an array with at least n elements. These
    // elements form a heap, except that data[0] may be in an incorrect
    // location.
    // Postcondition: The data values have been rearranged so that the first
    // n elements of data now form a heap.
    {
        System.err.println("The student needs to implement the makeHeap and");
        System.err.println("reheapifyDown methods before the heapsort can be used.");
        System.exit(0);
    }
}
