/*
 Algorithms Task 2
 problem 2 Optimal Array Multiplication Sequence
 Student: Mariam Ahmed Amin 
 ID: 20170279
 
 */
package matrixmultiplication;
import java.util.Scanner;

/**
 *
 * @author Mariam
 */
class Matrix {

    int row, col;
    String code;

    Matrix(int r, int c,String co) {
        row = r;
        col = c;
        code= co;

    }

    public int multiply(Matrix mat) {
        return row * mat.col;
    }
}

public class MatrixMultiplication {

    static public int[] getAllMulti(Matrix[] matrices) {
        int[] multiplications = new int[matrices.length - 1];

        for (int i = 0; i < matrices.length - 1; i++) {
           
            multiplications[i] =  matrices[i].multiply(matrices[i + 1]);
        }

        return multiplications;
    }

    static public int getMin(int[] cal) {
        int minIndex = 0;
        int min = cal[0];
        for (int i = 1; i < cal.length; i++) {

            if (cal[i] < min) {
                minIndex = i;
                min = cal[i];
            }
        }
        return minIndex;
    }

    static public Matrix[] updateMatrices(Matrix[] matrices, int min ) {
        Matrix temp = new Matrix(matrices[min].row, matrices[min + 1].col,"("+matrices[min].code+" x "+matrices[min+1].code+")");
        Matrix [] mat = new Matrix [matrices.length-1];
        for (int i=0 ; i<min ; i++)
        {
            mat[i]=matrices[i];
        }
        mat[min] = temp;
        for (int i = min + 1; i < matrices.length-1; i++) {
            mat[i] = matrices[i + 1];
        }
        return mat;
    }

  

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int caseNum = 1;
        while (true){
            int num = sc.nextInt();
            if (num==0)
            {
                break;
            }
            else {
                Matrix [] matrices = new Matrix [num];
                for (int i=0 ; i<num ; i++)
                {
                    int row = sc.nextInt();
                    int col = sc.nextInt();
                    Matrix temp = new Matrix (row , col , "A"+(i+1));
                    matrices[i]=temp;
                }
                 
                int [] multiplications = getAllMulti( matrices);
                
            
                
                while (matrices.length>1)
                {
                    
                    int minimum =  getMin(multiplications) ;
                     matrices= updateMatrices( matrices,  minimum );
                     multiplications = getAllMulti( matrices); // can be optimized by using another function that updates only adjacent ones
                     
                    
                }
                System.out.println("Case "+caseNum++ +": "+matrices[0].code);
            }
        }
        
        
        
    }

}
