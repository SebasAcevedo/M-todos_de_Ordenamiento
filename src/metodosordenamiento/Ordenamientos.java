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
}
