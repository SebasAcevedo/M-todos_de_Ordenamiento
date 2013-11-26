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
    
    public void radix(int vec[]){
        
        if(vec.length == 0)
            return;
        int[][] np = new int[vec.length][2];
        int[] q = new int[0x100];
        int i,j,k,l,f = 0;
        for(k=0;k<4;k++){
            for(i=0;i<(np.length-1);i++)
                np[i][1] = i+1;
            np[i][1] = -1;
            for(i=0;i<q.length;i++)
                q[i] = -1;
            for(f=i=0;i<vec.length;i++){
                j = ((0xFF<<(k<<3))&vec[i])>>(k<<3);
                if(q[j] == -1)
                    l = q[j] = f;
                else{
                    l = q[j];
                    while(np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = vec[i];
                np[l][1] = -1;
            }
            for(l=q[i=j=0];i<0x100;i++)
                for(l=q[i];l!=-1;l=np[l][1])
                        vec[j++] = np[l][0];
        }
    }   
    
    public void Quick(int vec[], int Prim, int Ult){
        int i=Prim, j=Ult;
        int pivote=vec[(Prim + Ult) / 2];
            int auxiliar;
 
            do
            {
                while(vec[i]<pivote) i++;      
                while(vec[j]>pivote) j--;
 
          if (i<=j)
          {
               auxiliar=vec[j];
               vec[j]=vec[i];
               vec[i]=auxiliar;
               i++;
               j--;
          }
     }
     while (i<=j);
     if(Prim<j)
     {
          Quick(vec,Prim, j);
     }

     if(Ult>i)
     {
          Quick(vec,i, Ult);
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
    
    public void OrdenaMerge(int[] L) {
        int n = L.length;
 
        if (n > 1){
            int m = (int) (Math.ceil(n/2.0));
            int [] L1 = new int[m];
            int [] L2 = new int[n-m];
 
            for (int i = 0; i < m; i++){
                L1[i] = L[i];
            }
            for (int i = m; i < n; i++){
                L2[i-m] = L[i];
            }
            L = merge(OrdenaMerge(L1), OrdenaMerge(L2));
        }
    }
 
    public int[] merge(int[] L1, int[] L2) {
         int[] L = new int[L1.length+L2.length];
         int i = 0;
         while ((L1.length != 0) && (L2.length != 0)) {
             if (L1[0] < L2[0]){
                 L[i++] = L1[0];
                 L1 = eliminar(L1);
                 if (L1.length == 0){
                     while (L2.length != 0) {
                         L[i++] = L2[0];
                         L2 = eliminar(L2);
                     }
                 }
             }
             else{
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
 
        public int[] eliminar(int [] l){
        int [] L = new int[l.length-1];
        for(int i = 1; i < l.length; i++){
            L[i-1] = l[i];
        }
        return L;
    }
 
        public void imprimir(int [] A){
        for(int i = 0; i < A.length; i++){
            System.out.print(""+A[i]+" ");
        }
    }
}
