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
                            long TieI = System.currentTimeMillis();
                            v = obj2.OrdenaMerge(vec1);
                            for (i = 0; i < v.length; i++) {
                                System.out.println("Vector ordenado: " + v[i]);
                            }
                            long TieF = System.currentTimeMillis();
                            long Milisegun = TieF - TieI;
                            long H = Milisegun / 3600000;
                            long Restoh = Milisegun % 3600000;
                            long Min = Restoh/ 60000;
                            long Restomin = Restoh % 60000;
                            long Segu = Restomin / 1000;
                            long Restosegu = Restomin % 1000;
                            System.out.println("El tiempo gastado en ordenar el vector fue de: Hora: " + H + " Minutos: " + Min + " Segundos: " + Segu + " Milisegundos: " + Restosegu);
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

