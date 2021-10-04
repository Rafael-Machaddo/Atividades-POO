package main;
import main.Gerenciamento.acesscontrol;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       Main.executar();

    }

    public static void executar(){

        double addGasto;
        double addGanho ;
        Scanner leitor=new Scanner(System.in);


        while (true){

            System.out.println("-------------------");
            System.out.println("1-GASTO");
            System.out.println("2-GANHO");
            System.out.println("3-SOMAR");
            System.out.println("4-SAIR");
            System.out.println("-------------------");
            System.out.print("Digite sua opção:");
            int index = leitor.nextInt();

            if ( index == 1){

                System.out.print("Saída:");
                addGasto = leitor.nextDouble();
                acesscontrol.obterControle().crud().adicionarGasto(addGasto);

            }

            if ( index == 2){

                System.out.print("Entrada:");
                addGanho = leitor.nextDouble();
                acesscontrol.obterControle().crud().adicionarGanho(addGanho);
            }

            if ( index == 3){

                acesscontrol.obterControle().crud().somar();

            }
            if ( index == 4){
                System.out.println("Saindo...");
                break;
            }
        }
    }
}
