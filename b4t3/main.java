package b4t3;
 
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
 
public class main extends JFrame{
  public main(){
    super("Tela de login");
 
   
    setLayout(new GridBagLayout());
     
    ((JComponent)getContentPane()).setBorder(
       new EmptyBorder(5, 8, 8, 8));
 
    
    GridBagConstraints gbc = new GridBagConstraints();
 
    
    gbc.insets = new Insets(3, 3, 3, 3);
 
    gbc.gridy = 0; // linha
    gbc.gridx = 0; // coluna
    gbc.gridwidth = 2; // duas células na linha
    
    gbc.anchor = GridBagConstraints.WEST;
    JLabel infoLabel = new JLabel("Dados do Usuário:");
    
    infoLabel.setFont(new Font("SansSerif", 
      Font.BOLD, 14));
    
    infoLabel.setBorder(
      new EmptyBorder(0, 0, 5, 0));
     
    add(infoLabel, gbc);
 
    gbc.gridy = 1; // linha
    gbc.gridx = 0; // coluna
    gbc.gridwidth = 1;
    
    JLabel usuarioLabel = new JLabel("Usuário:");
    add(usuarioLabel, gbc);
 
    gbc.gridy = 1; // linha
    gbc.gridx = 1; // coluna
    
    JTextField usuarioTxt = new JTextField(13);
    add(usuarioTxt, gbc);
 
    gbc.gridy = 2; // linha
    gbc.gridx = 0; // coluna
    
    JLabel usuarioSenha = new JLabel("Senha:");
    add(usuarioSenha, gbc);    
     
    gbc.gridy = 2; // linha
    gbc.gridx = 1; // coluna
    
    JPasswordField senhaTxt = new JPasswordField(13);
    add(senhaTxt, gbc);
 
    gbc.gridy = 3; // linha
    gbc.gridx = 1; // coluna
    gbc.gridwidth = 2; // duas células na linha
    
    gbc.anchor = GridBagConstraints.EAST;
    JPanel botoesPanel = new JPanel();
    botoesPanel.add(new JButton("Cancelar"));
    botoesPanel.add(new JButton("OK"));
    add(botoesPanel, gbc);
 
    pack(); 
    setVisible(true);    
  }
 
  public static void main(String args[]){
    Estudos app = new main();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}