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
        do {
            System.out.println("Desea realizar un metodo de ordenamiento y llenar el vector?(S/N)");
            Resp1 = sc.next();
            Resp1 = Resp1.toUpperCase();

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
                }
                System.out.println("Desea comparar el mismo vector con otro metodo de ordenamiento?(S/N)");
                Resp = sc.next();
                Resp = Resp.toUpperCase();
            } while (Resp.equals("S"));
        } while (Resp1.equals("S"));

    }

}

public class Bucketsort {

    public static int[] bucketSort(int[] arr) {
        int i, j;
        int[] count = new int[arr.length];
        Arrays.fill(count, 0);

        for (i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (i = 0, j = 0; i < count.length; i++) {
            for (; count[i] > 0; (count[i])--) {
                arr[j++] = i;
            }
        }
        return arr;
        
    }

    public static void main(String[] args) {

        System.out.println(" Input an integer ");
        Scanner sc = new Scanner(System.in);

        Random r = new Random();

        int[] arr = new int[]{2, 3, 2, 1, 4, 5, 2, 3, 1};

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");

        }

        System.out.println();

        arr = bucketSort(arr);

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");

        }

        System.out.println();

    }

}