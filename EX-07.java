import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    System.out.println("Informe o valor X:");
    double x = leitor.nextDouble();

    System.out.println("Informe o valor Y:");
    double y = leitor.nextDouble();
    double a = 100* Math.sqrt(Math.abs(y-0.01*(x*x)));
    double b = 0.01* Math.abs(x+10.0);
    double resultado = a+b;
    System.out.println("f(x,y) = "+resultado);
  }
}