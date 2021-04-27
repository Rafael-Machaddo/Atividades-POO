import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    System.out.println("____Matriz____");
    Scanner vetor = new Scanner(System.in);
         int i, j, l, m, QntLinha, QntColuna;
         int A  [][];
         int B  [][];
         int M180 [][];
         int M270 [][];
         int grau;
		 
          System.out.println("Digite a quantidade de linhas das matrizes: ");
          QntLinha = vetor.nextInt();
          System.out.println("Digite a quantidade de colunas das matrizes: ");
          QntColuna = vetor.nextInt();
		  
          A = new int[QntLinha][QntColuna];
          B = new int[QntLinha][QntColuna];
          M180 = new int[QntLinha][QntColuna];
          M270 = new int [QntLinha][QntColuna];
		  
    for (i=0; i<QntLinha; i++){
        for( j=0; j<QntColuna; j++){
            System.out.println("Qual é o valor da linha "+i+", coluna "+j);
            A[i][j]= vetor.nextInt();
        }
    }
    System.out.println("Informe o grau para rotacionar a matriz: ");
    grau = vetor.nextInt();
    if  (grau == 0) { 
        System.out.println("____Matriz rotacionada em 0°____");
         for( i=0; i<QntLinha; i++){
            for( j=0; j < QntColuna; j++){
                System.out.print("["+A[i][j]+"]");
                }
                 System.out.println();
            }
    } else if ( grau == 90){
        System.out.println("____Matriz rotacionada em 90°____");
        for (i =0; i< QntLinha; i++){
           for(j=0; j< QntColuna;j++){
           B[j][i]= A[QntLinha-1-i][j];
           }
        }
        for( i =0; i< QntLinha; i++){
            for( j =0; j < QntColuna; j++){
            System.out.print("["+B[i][j]+"]");
            }
            System.out.println();
        }
   }else if ( grau == 180){
       System.out.println("____Matriz rotacionada em 180°____");
        for (i =0; i< QntLinha; i++){
           for(j=0; j< QntColuna;j++){
           B[j][i]= A[QntLinha-1-i][j];
           }
        }
        for (l =0; l< QntLinha; l++){
           for(m=0; m< QntColuna;m++){
           M180[m][l]= B[QntLinha-1-l][m];
           }
        }
        for( i =0; i< QntLinha; i++){
          for( j =0; j < QntColuna; j++){
          System.out.print("["+M180[i][j]+"]");
          }
          System.out.println();
        }
    }else if (grau ==270){
      System.out.println("____Matriz rotacionada em 270°____");
        for (i =0; i< QntLinha; i++){
           for(j=0; j< QntColuna;j++){
           M270[j][i]= A[i][QntLinha - j - 1];
           }
        }
        for( i =0; i< QntLinha; i++){
          for( j =0; j < QntColuna; j++){
          System.out.print("["+M270[i][j]+"]");
          }
          System.out.println();
        }
    }else if (grau == 360){
      System.out.println("____Matriz rotacionada em 360°____");
        for (j=0; j<QntColuna; j++) {
          for (i=0; i<QntLinha; i++) {
            System.out.print("["+A[j][i]+"]");
          }
          System.out.println();
        }
    }else{
      System.out.println("Você digitou um grau inválido.");
    }
  }
}
