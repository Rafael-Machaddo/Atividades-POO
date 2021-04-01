import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    System.out.println("Informe o valor X:");
    double x = leitor.nextDouble();

    System.out.println("Informe o valor Y:");
    double y = leitor.nextDouble();

    System.out.println("Informe o valor Z:");
    double z = leitor.nextDouble();

    double a = 4/3*(Math.pow((x*x)+(y*y)-(x*y),0.75)+z);
    double resultado = a;

    System.out.println("f(x,y,z) = "+resultado);
  }
}