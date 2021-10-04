package main.Gerenciamento;

public class acesscontrol {

    private static acesscontrol controle = null;
    private final acesscontrol dados = new classcontrol();

    private acesscontrol(){}

    public static acesscontrol obterControle(){

        if (controle == null){
            controle = new acesscontrol();
        }

        return controle;
    }

    public interfacecontrol crud(){
        return dados;
    }
}
