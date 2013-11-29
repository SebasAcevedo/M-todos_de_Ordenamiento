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
    /*
     Este metodo de ordenamiento se basa en los valores de los dígitos reales en las 
     representaciones de posiciones de los números que se ordenan.
     Por ejemplo el número 235 se escribe 2 en la posición de centenas, un 3 en 
     la posición de decenas y un 5 en la posición de unidades.
     */

    public void radix(int vec[]) {

        if (vec.length == 0) {
            return;
        }
        int[][] np = new int[vec.length][2];
        int[] q = new int[0x100]; //256
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
                j = ((0xFF << (k << 3)) & vec[i]) >> (k << 3);//255
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
    /*
     En este metodo de ordenamiento se elige un elemento de la lista de elementos a ordenar, al que se le llama pivote.
     Se vuelven a colocar los demás elementos de la lista a cada lado del pivote, 
     de manera que a un lado queden todos los menores que él, y al otro los mayores. 
     Los elementos iguales al pivote pueden ser colocados tanto a su derecha como
     a su izquierda. En este momento, el pivote ocupa exactamente el lugar que le
     corresponderá en la lista ordenada.
     La lista queda separada en dos sublistas, una formada por los elementos a la 
     izquierda del pivote, y otra por los elementos a su derecha.
     Repetir este proceso de forma recursiva para cada sublista mientras éstas 
     contengan más de un elemento. Una vez terminado este proceso todos los elementos estarán ordenados.
     */

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

    /*
     El ordenamiento por casilleros (bucket sort en inglés) distribuye todos los
     elementos a ordenar entre un número finito de casilleros. Cada casillero 
     sólo puede contener los elementos que cumplan unas determinadas condiciones.
     Las condiciones deben ser excluyentes entre sí, para evitar que un elemento pueda ser 
     clasificado en dos casilleros distintos. Después cada uno de esos casilleros
     se ordena individualmente con otro algoritmo de ordenación (que podría ser 
     distinto según el casillero), o se aplica recursivamente este algoritmo para
     obtener casilleros con menos elementos.
    
     El algoritmo contiene los siguientes pasos:

     Crear una colección de casilleros vacíos
     Colocar cada elemento a ordenar en un único casillero
     Ordenar individualmente cada casillero
     devolver los elementos de cada casillero concatenados por orden
     */
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

    /*
     El ordenamiento por mezcla funciona de la siguiente manera:
     Si la longitud de la lista es 0 ó 1, entonces ya está ordenada. En otro caso:
     Dividir la lista desordenada en dos sublistas de aproximadamente la mitad del tamaño.
     Ordenar cada sublista recursivamente aplicando el ordenamiento por mezcla.
     Mezclar las dos sublistas en una sola lista ordenada.
     El ordenamiento por mezcla incorpora dos ideas principales para mejorar su 
     tiempo de ejecución:
     Una lista pequeña necesitará menos pasos para ordenarse que una lista grande.
     Se necesitan menos pasos para construir una lista ordenada a partir de dos 
     listas también ordenadas, que a partir de dos listas desordenadas. 
     Por ejemplo, sólo será necesario entrelazar cada lista una vez que están ordenadas.
     */
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

    /*
    El algoritmo de ordenación por montículos o Heap Sort recorre el conjunto de
    elementos desde la posición de la mitad hasta la primera organizando el 
    montículo correspondiente a dicho elemento.  Una vez terminado este proceso,
    se inicia el proceso de ordenación intercambiando el primer elemento por el 
    último del arreglo y reorganizando el montículo a partir de la primera posición.
    */
    public void heapSort(int a[], int n) {
        buildheap(a, n);
        while (n > 1) {
            n--;
            exchange(0, n, a);
            downheap(0, a, n);
        }
    }

    private void buildheap(int a[], int n) {
        for (int v = n / 2 - 1; v >= 0; v--) {
            downheap(v, a, n);
        }
    }

    private void downheap(int v, int a[], int n) {
        int w = 2 * v + 1;    // Primer descendiente de v
        while (w < n) {
            if (w + 1 < n) // es esto un segundo descendiente?
            {
                if (a[w + 1] > a[w]) {
                    w++;
                }
            }
            // w es el descendiente de v con el maximo numero de etiquetas

            if (a[v] >= a[w]) {
                return;  // v tiane una propiedad heap
            }            // por otro lado
            exchange(v, w, a);  // intercambia etiquetas de v y w
            v = w;        // continua
            w = 2 * v + 1;
        }
    }

    private void exchange(int i, int j, int a[]) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
