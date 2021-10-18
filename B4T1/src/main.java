import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
	
    //public static void uniao(String[] args){
	public List<Integer> uniao(){
		
		List<Integer> listaA = new ArrayList<>();
		listaA.add(1);
		listaA.add(2);
		listaA.add(3);
		
		List<Integer> listaB = new ArrayList<>();
		listaB.add(4);
		listaB.add(5);
		listaB.add(6);
		
		List<Integer> listauniao = Stream.concat(listaA.stream(), listaB.stream())
                .collect(Collectors.toList());
		
        System.out.println("União: " + listauniao);

		return listauniao;
	}
	
	public List<Integer> interseccao(){
		
		List<Integer> listaA = new ArrayList<>();
		listaA.add(1);
		listaA.add(2);
		listaA.add(3);
		
		List<Integer> listaB = new ArrayList<>();
		listaB.add(1);
		listaB.add(5);
		listaB.add(3);
		
		List<Integer> listainterseccao = listaA.stream()
			    .filter(listaB::contains)
			    .collect(Collectors.toList());
		
        System.out.println("Intersecção: " + listainterseccao);

		return listainterseccao;
	}
	
    //public static void main(String[] args){
	public List<Integer> diferenca(){
		
		List<Integer> listaA = new ArrayList<>();
		listaA.add(1);
		listaA.add(2);
		listaA.add(3);
		
		List<Integer> listaB = new ArrayList<>();
		listaB.add(1);
		listaB.add(5);
		listaB.add(3);

        Collection<Integer> diferente = new HashSet<Integer>();

        diferente.addAll(listaA);
        diferente.addAll(listaB);

        diferente.removeAll(listaB);

        List<Integer> listadiferenca = new ArrayList<Integer>(diferente);

        System.out.println("Comparação" + listadiferenca);

		return listadiferenca;
	}
	
	public int complemento() {
		return 0;	
	}
	
}