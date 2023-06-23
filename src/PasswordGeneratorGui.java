// front-end codes

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PasswordGeneratorGui extends JFrame{

    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGui(){
        super("Password Generator");


        // Colocar o tamanho do Gui //set the size of gui
        setSize(540, 570);


        setResizable(true);


        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);


        //init password generator
        passwordGenerator = new PasswordGenerator();

        addGuiComponents();
    }

    private void addGuiComponents(){
        JLabel titleLabel = new JLabel("Password Generator");

        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        titleLabel.setBounds(0, 10, 540, 39);
        
        add(titleLabel);

        JTextArea passwordOutput = new JTextArea();

        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));


        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);


        // create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(318, 215, 192, 39);
        add(passwordLengthInputArea);



        JLabel passwordLengthLabel = new JLabel("Password length: ");
        passwordLengthLabel.setFont(new Font("Dialog" , Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        // create toggle buttons
        // criando butões
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25, 302, 225, 56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);


        // create generate button 
        // butão de gerar as senhas
        JButton generateButton= new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() { // declaring events in generate button
        @Override
        public void actionPerformed(ActionEvent e){
            if(passwordLengthInputArea.getText().length() <= 0)return;
            boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                uppercaseToggle.isSelected() ||
                numbersToggle.isSelected() ||
                symbolsToggle.isSelected();

            int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
            if(anyToggleSelected){
                String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                       uppercaseToggle.isSelected(),
                       lowercaseToggle.isSelected(),
                       numbersToggle.isSelected(),
                       symbolsToggle.isSelected());

                passwordOutput.setText(generatedPassword);
            }
        }

        });
        add(generateButton);
    }
}