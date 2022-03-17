package puntodeventa;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LogIn extends JFrame{
    private boolean removerUsuario=true;
    private boolean removerContraseña=true;
    private JPanel fondoSesion;
    
    public LogIn(){   
      setExtendedState(MAXIMIZED_BOTH);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Grupo BG");
      this.setMinimumSize(new Dimension(500,500));
      setResizable(true);
      iniciarSesion();
      crearFondo();
    }
    private void iniciarSesion(){
       fondoSesion = new JPanel();
       fondoSesion.setLayout(null);
       getContentPane().add(fondoSesion);
 
       JLabel letrero = new JLabel();
       letrero.setText("Iniciar sesion");
       letrero.setForeground(Color.white);
       letrero.setFont(new Font("Rockwell",0,40));
       letrero.setHorizontalAlignment(SwingConstants.CENTER);
       letrero.setBounds(450,100,500,70);
       letrero.setOpaque(true);
       letrero.setBackground(new Color(255,61,101));
       fondoSesion.add(letrero);
        
        
        JTextField usuario = new JTextField("Usuario");
        usuario.setBounds(550, 220, 380, 70);
        usuario.setFont(new Font("Rockwell",0,40));
        //usuario.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBorder(BorderFactory.createLineBorder(Color.white));
       
        JLabel iconoUsuario = new JLabel(new ImageIcon("iconoUsuario.png"));
        //JLabel iconoUsuario = new JLabel("iconoUsuario.png");
        iconoUsuario.setBounds(480,220,70,70);
        fondoSesion.add(iconoUsuario);
        usuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt){
                if(removerUsuario){
                   usuario.setText("");
                   removerUsuario=false;
                }
               
            }
        });
        usuario.addFocusListener(new  FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e) {
                if(usuario.getText().equals("")){
                    usuario.setText("Usuario");
                    usuario.setFont(new Font("Rockwell",0,40));
                    removerUsuario = true;
                }
            }
        });
        fondoSesion.add(usuario);
        
        JPasswordField contraseña = new JPasswordField("Contraseña");
        contraseña.setLayout(new BorderLayout(0, 0));
        
        char tituloContraseña=contraseña.getEchoChar();
        JCheckBox box = new JCheckBox();
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(box.isSelected()){
            	   ImageIcon mostrar = new ImageIcon("ocultar.png");
                   box.setIcon(new ImageIcon(mostrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
                   contraseña.setEchoChar((char)0);
               }else{
                   ImageIcon mostrar = new ImageIcon("ojo.png");
                   box.setIcon(new ImageIcon(mostrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
                   contraseña.setEchoChar(tituloContraseña);
               }
            }
        });
        
        box.setOpaque(false);
        Image icon = new ImageIcon("ojo.png").getImage();
        Icon icono = new ImageIcon(icon.getScaledInstance(50,50,Image.SCALE_SMOOTH));
        box.setIcon(icono);
        
        contraseña.add(box, BorderLayout.EAST);
        
        contraseña.setBounds(550, 350, 380, 70);
        contraseña.setFont(new Font("Rockwell",0,40));
        //contraseña.setHorizontalAlignment(SwingConstants.CENTER);
        contraseña.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contraseña.setEditable(true);
        contraseña.setEchoChar((char)0);
        contraseña.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt){
                if(removerContraseña){
                    contraseña.setText("");
                    removerContraseña=false;
                    contraseña.setEchoChar(tituloContraseña);
                }
            }
        });
        contraseña.addFocusListener(new  FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e) {
                if(contraseña.getText().equals("")){
                    contraseña.setText("Contraseña");
                    contraseña.setFont(new Font("Rockwell",0,40));
                    removerContraseña= true;
                    contraseña.setEchoChar((char)0);
                } 
            }
        });
        JLabel iconoContraseña = new JLabel(new ImageIcon("iconoContraseña.png"));
        //JLabel iconoContraseña = new JLabel("iconoContraseña.png");
        iconoContraseña.setBounds(480,350,70,70);
        fondoSesion.add(iconoContraseña);
        fondoSesion.add(contraseña);
        
        JPanel inicioSesion = new JPanel();
        inicioSesion.setLayout(null);
        inicioSesion.setBounds(450,100,500,500);
        inicioSesion.setBackground(new Color(0,0,0,200));
        
        JButton acceder = new JButton("Acceder");
        acceder.setBounds(600, 500, 200, 50);
        acceder.setForeground(Color.white);
        acceder.setFont(new Font("Rockwell",0,40));
        acceder.setBackground(new Color(255,61,101));
        acceder.setBorder(BorderFactory.createLineBorder(new Color(255,61,101)));
        fondoSesion.add(acceder);
        fondoSesion.add(inicioSesion);
        
        JButton continuar = new JButton("Aceptar");
        continuar.setBounds(600, 500, 200, 50);
        continuar.setForeground(Color.white);
        continuar.setFont(new Font("Rockwell",0,40));
        continuar.setBackground(new Color(255,61,101));
        continuar.setBorder(BorderFactory.createLineBorder(new Color(255,61,101), 1));
        continuar.setVisible(false);
        fondoSesion.add(continuar);
        
        acceder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fondoSesion.remove(acceder);
                fondoSesion.remove(usuario);
                fondoSesion.remove(letrero);
                fondoSesion.remove(contraseña);
                fondoSesion.remove(box);
                fondoSesion.remove(iconoContraseña);
                fondoSesion.remove(iconoUsuario);
               
                JLabel mensajeBienvenida = new JLabel();
                mensajeBienvenida.setText("Bienvenido:  "+usuario.getText());
                mensajeBienvenida.setBounds(0,0,800,100);
                mensajeBienvenida.setForeground(Color.white);
                mensajeBienvenida.setFont(new Font("Rockwell",0,40));
                mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
                inicioSesion.add(mensajeBienvenida);
                inicioSesion.setBounds(350,100,800,100);
                
                continuar.setVisible(true);
                 
                
            }
        });
        
        
    }

    private void crearFondo() {
    	JLabel fondo = new JLabel(new ImageIcon("fondo.png"));
        fondo.setBounds(0, 0, 1370, 705);
        fondoSesion.add(fondo);
    }
}
