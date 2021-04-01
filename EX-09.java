import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    System.out.println("Informe o valor X:");
    double x = leitor.nextDouble();

    System.out.println("Informe o valor Y:");
    double y = leitor.nextDouble();

    double a = -200* (Math.pow(Math.E,(-0.2* Math.sqrt((x*x)+(y*y)))));
    double resultado = a;
    
    System.out.println("f(x,y,) = "+resultado);
  }
}