package metodosordenamiento;

import java.util.Scanner;

/**
 *
 * @author Hogar
 */
public class MetodosOrdenamiento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Llenado obj = new Llenado();
        Ordenamientos obj2 = new Ordenamientos();
        int i, n, vec1[], vec2[], opc;
        String Resp, Resp1;
        System.out.println("Desea realizar un metodo de ordenamiento y llenar el vector?(S/N)");
        Resp1 = sc.next();
        Resp1 = Resp1.toUpperCase();
        if (Resp1.equals("S")) {
            do {

                System.out.println("Ingrese tamaño del vector a crear: ");
                n = sc.nextInt();
                vec1 = new int[n];
                vec2 = new int[n];
                obj.set(vec1);
                vec2 = vec1;
                do {
                    vec1 = vec2;
                    System.out.println("Menú");
                    System.out.println("1.Radix");
                    System.out.println("2.Quick");
                    System.out.println("3.Bucket");
                    System.out.println("4.Merge");
                    System.out.println("5.Heap");
                    do {
                        System.out.println("Metodo de ordenamiento que quiere realizar: ");
                        opc = sc.nextInt();
                    } while (opc < 1 || opc > 5);

                    switch (opc) {
                        case 1:
                            long tiempoI = System.currentTimeMillis();
                            obj2.radix(vec1);
                            for (i = 0; i < vec1.length; i++) {
                                System.out.println("Vector ordenado: " + vec1[i]);
                            }
                            long tiempoF = System.currentTimeMillis();
                            long milisegundos = tiempoF - tiempoI;
                            long hora = milisegundos / 3600000;
                            long restohora = milisegundos % 3600000;
                            long minuto = restohora / 60000;
                            long restominuto = restohora % 60000;
                            long segundo = restominuto / 1000;
                            long restosegundo = restominuto % 1000;
                            System.out.println("El tiempo gastado en ordenar el vector fue de: Hora: " + hora + " Minutos: " + minuto + " Segundos: " + segundo + " Milisegundos: " + restosegundo);
                            break;
                        case 2:
                            long TiempoI = System.currentTimeMillis();
                            obj2.Quick(vec1, 0, vec1.length - 1);
                            for (i = 0; i < vec1.length; i++) {
                                System.out.println("Vector ordenado: " + vec1[i]);
                            }
                            long TiempoF = System.currentTimeMillis();
                            long Milisegundos = TiempoF - TiempoI;
                            long Hora = Milisegundos / 3600000;
                            long Restohora = Milisegundos % 3600000;
                            long Minuto = Restohora / 60000;
                            long Restominuto = Restohora % 60000;
                            long Segundo = Restominuto / 1000;
                            long Restosegundo = Restominuto % 1000;
                            System.out.println("El tiempo gastado en ordenar el vector fue de: Hora: " + Hora + " Minutos: " + Minuto + " Segundos: " + Segundo + " Milisegundos: " + Restosegundo);
                            break;
                        case 3:
                            long TiempI = System.currentTimeMillis();
                            obj2.Quick(vec1, 0, vec1.length - 1);
                            for (i = 0; i < vec1.length; i++) {
                                System.out.println("Vector ordenado: " + vec1[i]);
                            }
                            long TiempF = System.currentTimeMillis();
                            long Milisegundo = TiempF - TiempI;
                            long Hor = Milisegundo / 3600000;
                            long Restohor = Milisegundo % 3600000;
                            long Minut = Restohor / 60000;
                            long Restominut = Restohor % 60000;
                            long Segund = Restominut / 1000;
                            long Restosegund = Restominut % 1000;
                            System.out.println("El tiempo gastado en ordenar el vector fue de: Hora: " + Hor + " Minutos: " + Minut + " Segundos: " + Segund + " Milisegundos: " + Restosegund);
                            break;
                        case 4:
                            int v[] = new int[vec1.length];
                            long TiemI = System.currentTimeMillis();
                            v = obj2.OrdenaMerge(vec1);
                            for (i = 0; i < v.length; i++) {
                                System.out.println("Vector ordenado: " + v[i]);
                            }
                            long TiemF = System.currentTimeMillis();
                            long Milisegund = TiemF - TiemI;
                            long Ho = Milisegund / 3600000;
                            long Restoho = Milisegund % 3600000;
                            long Minu = Restoho / 60000;
                            long Restominu = Restoho % 60000;
                            long Segun = Restominu / 1000;
                            long Restosegun = Restominu % 1000;
                            System.out.println("El tiempo gastado en ordenar el vector fue de: Hora: " + Ho + " Minutos: " + Minu + " Segundos: " + Segun + " Milisegundos: " + Restosegun);
                            break;
                        case 5:
                            obj2.heapSort(vec1, vec1.length);
                            long TiemI = System.currentTimeMillis();
                            v = obj2.OrdenaMerge(vec1);
                            for (i = 0; i < v.length; i++) {
                                System.out.println("Vector ordenado: " + v[i]);
                            }
                            long TiemF = System.currentTimeMillis();
                            long Milisegund = TiemF - TiemI;
                            long Ho = Milisegund / 3600000;
                            long Restoho = Milisegund % 3600000;
                            long Minu = Restoho / 60000;
                            long Restominu = Restoho % 60000;
                            long Segun = Restominu / 1000;
                            long Restosegun = Restominu % 1000;
                            System.out.println("El tiempo gastado en ordenar el vector fue de: Hora: " + Ho + " Minutos: " + Minu + " Segundos: " + Segun + " Milisegundos: " + Restosegun);
                            break;
                    }
                    System.out.println("Desea comparar el mismo vector con otro metodo de ordenamiento?(S/N)");
                    Resp = sc.next();
                    Resp = Resp.toUpperCase();
                } while (Resp.equals("S"));
                System.out.println("Desea realizar un metodo de ordenamiento y llenar el vector?(S/N)");
                Resp1 = sc.next();
                Resp1 = Resp1.toUpperCase();
            } while (Resp1.equals("S"));
        }
    }

}

public class Heapsort {

    /**
     * The main method illustrates the use of a heapsort to sort a small array.
     * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used in
     * this implementation.
     *
     */
    public static void main(String[] args) {
        final String BLANKS = "  "; // A String of two blanks
        int i;                      // Array index

        int[] data = {80, 10, 50, 70, 60, 90, 20, 30, 40, 0};

        // Print the array before sorting:
        System.out.println("Here is the entire original array:");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + BLANKS);
        }
        System.out.println();

        // Sort the numbers, and print the result with two blanks after each number.
        heapsort(data, data.length);
        System.out.println("After sorting, the numbers are:");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + BLANKS);
        }
        System.out.println();
    }

    /**
     * This method cannot be used until the student implements
     * <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>. Sort an array of
     * integers from smallest to largest, using a heapsort algorithm.
     *
     * @param <CODE>data</CODE> the array to be sorted
     * @param <CODE>n</CODE> the number of elements to sort, (from
     * <CODE>data[0]</CODE> through <CODE>data[n-1]</CODE>)
     * <dt><b>Precondition:</b><dd>
     * <CODE>data</CODE> has at least <CODE>n</CODE> elements.
     * <dt><b>Postcondition:</b><dd>
     * If <CODE>n</CODE> is zero or negative then no work is done. Otherwise,
     * the elements of </CODE>data</CODE> have been rearranged so that
     * <CODE>data[0] &lt= data[1] &lt= ... &lt= data[n-1]</CODE>.
     * @exception ArrayIndexOutOfBoundsException Indicates that
     * <CODE>data</CODE> has fewer than </CODE>n</CODE> elements.
     *
     */
}
