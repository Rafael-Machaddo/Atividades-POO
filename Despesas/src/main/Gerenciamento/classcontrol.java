package main.Gerenciamento;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class classcontrol implements interfacecontrol {

    @Override
    public void adicionarGasto(double addGasto) {

        if(Files.exists(Path.of("gastos.dat"))) {

            try {
                List<String> linhas = new ArrayList<>();
                String str = Double.toString(addGasto);
                linhas.add(str);
                Files.write(Paths.get("gastos.dat")
                        , linhas
                        , StandardCharsets.UTF_8
                        , StandardOpenOption.APPEND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {

            try{
                Files.createFile(Path.of("gastos.dat"));

                try {
                    List<String> linhas = new ArrayList<>();
                    String str = Double.toString(addGasto);
                    linhas.add(str);
                    Files.write(Paths.get("gastos.dat")
                            , linhas
                            , StandardCharsets.UTF_8
                            , StandardOpenOption.APPEND);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void adicionarGanho(double addGanho) {

        if(Files.exists(Path.of("ganhos.dat"))) {

            try {
                List<String> linhas = new ArrayList<>();
                String str = Double.toString(addGanho);
                linhas.add(str);
                Files.write(Paths.get("ganhos.dat")
                        , linhas
                        , StandardCharsets.UTF_8
                        , StandardOpenOption.APPEND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {

            try{
                Files.createFile(Path.of("ganhos.dat"));

                try {
                    List<String> linhas = new ArrayList<>();
                    String str = Double.toString(addGanho);
                    linhas.add(str);
                    Files.write(Paths.get("ganhos.dat")
                            , linhas
                            , StandardCharsets.UTF_8
                            , StandardOpenOption.APPEND);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void somar() {

        double somaTotal;
        double somaGanhos = 0;
        double somaGastos = 0;

        try{
            List<String> linhas = Files.readAllLines(Path.of("ganhos.dat"));
            for(String s : linhas){
                double numero = 0;
                boolean testeb = false;

                if (testeb != linhas.isEmpty()){
                    break;
                }
                else{
                    numero = numero + Double.parseDouble(s);
                    somaGanhos = somaGanhos + numero;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            List<String> linhas = Files.readAllLines(Path.of("gastos.dat"));
            for(String s : linhas){
                double numero = 0;
                boolean testea = false;

                if (testea != linhas.isEmpty()){
                    break;
                }
                else{
                    numero = numero + Double.parseDouble(s);
                    somaGastos = somaGastos + numero;
                }


            }
        }catch(Exception e){
            e.printStackTrace();
        }

        somaTotal = somaGanhos - somaGastos;
        System.out.println("A soma ficou:" +somaTotal);
    }

}
