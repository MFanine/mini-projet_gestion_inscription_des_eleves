package mini_projet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Formul extends JFrame implements ActionListener {
    
    Container container;
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenuItem menuItemSave = new JMenuItem("Save");
    JMenuItem menuItemExit = new JMenuItem("Exit");
//    JLabel save = new JLabel("Save");
//    JLabel exit = new JLabel("Exit");
    JButton envoyer = new JButton("Envoyer");
    JButton annuler = new JButton("Annuler");
    GridLayout grid = new GridLayout();
    JTextField nom = new JTextField();
    JTextField prenom = new JTextField();
    JTextField adress = new JTextField();
    JTextField tel = new JTextField();
    JTextField email = new JTextField();
    JRadioButton homme = new JRadioButton("Homme");
    JRadioButton femme = new JRadioButton("Femme");
    JComboBox<String > villes = new JComboBox<>();
    JComboBox<String > diplomes = new JComboBox<>();
    JPanel left = new JPanel();
    JPanel right = new JPanel();
    JPanel nomPanel = new JPanel();
    JPanel anotherPrenomPanel = new JPanel();
    JPanel adressPanel = new JPanel();
    JPanel telPanel = new JPanel();
    JPanel sexePanel = new JPanel();
    JPanel radioPanel = new JPanel();
    JPanel emailPanel = new JPanel();
    JPanel villePanel = new JPanel();
    JPanel diplomePanel = new JPanel();
    JPanel anotherNotePanel = new JPanel();
    JTextField anotherNote = new JTextField();
    JLabel nomLabel = new JLabel("Nom : ");
    JLabel adressLabel = new JLabel("Adress : ");
    JLabel telLabel = new JLabel("TEL : ");
    JLabel sexeLabel = new JLabel("Sexe : ");
    JLabel emailLabel = new JLabel("Email : ");
    JLabel villeLabel = new JLabel("Ville : ");
    JLabel diplomeLabel = new JLabel("Dernier Diplome :");
    JLabel noteLabel = new JLabel("Note");
    ButtonGroup radios = new ButtonGroup();
    
    public Formul(){
        
        container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        
        //Menu
        menu.add(menuItemExit);
//        menuItemExit.add(exit);
//        menuItemSave.add(save);
        menuItemExit.addActionListener(this);
        menu.add(menuItemSave);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
      
        //leftPanel
            //nomPanel
            nomPanel.setLayout(grid);
            nomPanel.add(nomLabel);
            nomPanel.setMaximumSize(new Dimension(500, 25));
            nomPanel.add(nom);
            
            //prenomPanel
            anotherPrenomPanel.setLayout(grid);
            anotherPrenomPanel.setMaximumSize(new Dimension(500, 25));
            anotherPrenomPanel.add(new JLabel("Prenom: "));
            anotherPrenomPanel.add(prenom);
            
            //adressPanel
            adressPanel.setLayout(grid);
            adressPanel.setMaximumSize(new Dimension(500, 25));
            adressPanel.add(adressLabel);
            adressPanel.add(adress);
          
            telPanel.setLayout(grid);
            telPanel.setMaximumSize(new Dimension(500, 25));
            telPanel.add(telLabel);
            telPanel.add(tel);
            
            //sex panel
            radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
            radios.add(homme);
            radios.add(femme);
            radioPanel.add(homme);
            radioPanel.add(femme);
            sexePanel.setLayout(grid);
            sexePanel.setMaximumSize(new Dimension(500, 50));
            sexePanel.add(sexeLabel);
            sexePanel.add(radioPanel);
        
        //right 
            //email
            emailPanel.setLayout(grid);
            emailPanel.add(emailLabel);
            emailPanel.setMaximumSize(new Dimension(500, 25));
            emailPanel.add(email);
        
            villePanel.setLayout(grid);
            villePanel.setMaximumSize(new Dimension(500, 25));
            villePanel.add(villeLabel);
            villePanel.add(villes);
            villes.addItem("Taounate");
            villes.addItem("Fes");
            villes.addItem("CasaBlanca");
            
          
            diplomePanel.setLayout(grid);
            diplomePanel.setMaximumSize(new Dimension(500, 25));
            diplomePanel.add(diplomeLabel);
            diplomePanel.add(diplomes);
            diplomes.addItem("BTS");
            diplomes.addItem("Bachlore");
           
            //notes
            anotherNotePanel.setLayout(grid);
            anotherNotePanel.setMaximumSize(new Dimension(500, 25));
            anotherNotePanel.add(noteLabel);
            anotherNotePanel.add(anotherNote);
            
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.add(nomPanel);
        left.add(anotherPrenomPanel);
        left.add(adressPanel);
        left.add(telPanel);
        left.add(sexePanel);
        left.add(envoyer);
        envoyer.addActionListener(this);
        left.setSize(400, 300);
        left.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.add(emailPanel);
        right.add(villePanel);
        right.add(diplomePanel);
        right.add(anotherNotePanel);
        right.add(annuler);
        annuler.addActionListener(this);
        right.setSize(400, 300);
        right.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        container.add(left);
        container.add(right);
        
//        save.addMouseListener(this);
//        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Utilisateur person = new Utilisateur();
        if(e.getSource().equals(envoyer)){
            AbstractButton adresse;
			person = new Utilisateur(this.nom.getText(), this.prenom.getText(), this.adresse.getText(), tel.getText(), (femme.isSelected()) ? "Femme": "Homme", email.getText(), villes.getSelectedItem().toString(), diplomes.getSelectedItem().toString(),   Double.parseDouble(anotherNote.getText()));
           
            try {
                     	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabd", "root", "");

            	PreparedStatement stmt = conn.prepareStatement("INSERT INTO Etidiant (nom, prenom, adresse, tel, email, villes, diplomes ,note ) VALUES (?, ?, ?, ?, ?, ? ,?, ?)");

            	
            	stmt.setString(1, nom.getText());
            	stmt.setString(2, prenom.getText());
            	stmt.setString(3, adresse.getText());
            	stmt.setString(4, tel.getText());
            	stmt.setString(5, email.getText());
            	stmt.setString(6, villes.getSelectedItem().toString());
            	stmt.setString(7, diplomes.getSelectedItem().toString());
            	stmt.setString(8, note.getText());
            	
            	ResultSet rs = stmt.executeQuery();
            	
                     conn.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource().equals(menuItemSave)){
            try {
//                envoyer.doClick();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File("Person.txt")));
                dataOutputStream.writeUTF(person.toString());
                dataOutputStream.flush();

                DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Person.txt"));
                System.out.println(dataInputStream.readUTF());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource().equals(menuItemExit)){
            setVisible(false); 
            dispose();        
        }
        
    }
}
