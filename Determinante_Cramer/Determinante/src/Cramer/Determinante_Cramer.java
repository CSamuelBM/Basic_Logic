package M_N;

import java.util.Scanner;

public class Determinante_Cramer {
    
    private static Scanner cs = new Scanner(System.in);
    private static int n = cs.nextInt();
    
    public static void main(String[] args) {

        llenar(n);
        
    }
    
    private static void llenar(int n){
        int matM[][] = new int[n][n];
        int arrR[] = new int[n];
        
        for(int i= 0; i< matM.length; i++)
            for(int j= 0; j< matM.length; j++)
                matM[i][j] = cs.nextInt();
        
        for(int i= 0; i< arrR.length; i++)
            arrR[i] = cs.nextInt();
        
        det(matM, "");
        det(matRem(matM, arrR, 0), "x");
        det(matRem(matM, arrR, 1), "y");
        det(matRem(matM, arrR, 2), "z");
    }
    
    private static int[][] matRem(int matM[][], int arrR[], int f){
        int matRem[][] = new int[n][n];
        int matAux[][] = new int[n][n];
        
        for(int i= 0; i< matRem.length; i++)
            for(int j= 0; j< matRem.length; j++)
                matAux[i][j] = matM[i][j];
        
        for(int i= 0; i< matRem.length; i++){
            for(int j= 0; j< matRem.length; j++){
                if(j== f)
                    matRem[i][j] = arrR[i];
                else
                    matRem[i][j] = matAux[i][j];
            }
        }
        
        return matRem;
    }
    
    private static void det(int matM[][], String var){
        int det, det1, det2;
        int mat2[][] = new int[2][n];
        int matJu[][] = new int[n+2][n];
        int a = 0, b = 0;
        int c1 = 1, c2 = 1, c3 = 1;
        
        for(int i= 0; i< matM.length; i++){
            for(int j= 0; j< matM.length; j++){
                if(i == 0 || i == 1)
                    mat2[i][j] = matM[i][j];
            }
        }
        
        for(int i= 0; i< matJu.length; i++){
            for(int j= 0; j< n; j++){
                if(i < n)
                    matJu[i][j] = matM[i][j];
                else{
                    if(b >= n){
                        a++;
                        b = 0;
                    }
                    matJu[i][j] = mat2[a][b];
                    b++;
                }
            }
        }
        
        for(int i= 0; i< matJu.length; i++){
            for(int j= 0; j< n; j++){
                if(i == j)
                    c1 *= matJu[i][j];
                else if(j+1 == i)
                    c2 *= matJu[i][j];
                else if(j+2 == i)
                    c3 *= matJu[i][j];
            }
        }
        det1 = c1 + c2 + c3;
        c1 = 1; 
        c2 = 1; 
        c3 = 1;
        
        for(int i= 0; i< matJu.length; i++){
            for(int j= 0; j< n; j++){
               if(i+j == n-1)
                    c1 *= matJu[i][j]* -1;
                else if(i+j == n)
                    c2 *= matJu[i][j]* -1;
                else if(i+j == n+1)
                    c3 *= matJu[i][j]* -1;
            }
        }
        det2 = c1 + c2 + c3;
        det = det1 + det2;
        System.out.printf("Δ%s = %d%n", var, det);
        
    }
    
}
