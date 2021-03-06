package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main extends JFrame {

    JFrame frameMain;
    JPanel panelMain, panelText, panelCenter;
    JTextField txtFieldMain, txtFieldName, txtFieldAddQuest, txtFieldAddResponse;
    JButton btnStart, btnCheck;
    JLabel label;
    String name;
    int randomNum1, randomNum2, randSum,  randSub;


    public Main () throws IOException {
        this.initComponents();
pack();
    }

    public void initComponents() throws IOException {

//         frameMain
        frameMain = new JFrame();
       frameMain.setTitle("Kids count!");

        frameMain.setResizable(true);
            Toolkit kit = frameMain.getToolkit();
            GraphicsDevice[] gs = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
            Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
            Dimension d = kit.getScreenSize();

            int max_width = (d.width - in.left - in.right);
            int max_height = (d.height - in.top - in.bottom);
        frameMain.setMinimumSize(new Dimension(580, 520));
            frameMain.setLocation((int) (max_width - frameMain.getWidth()) *2 / 3, (int) (max_height - frameMain.getHeight() ) * 2 / 3);





//        panelMain
        panelMain = new JPanel();
        panelMain.setPreferredSize(new Dimension(180, 140));
        panelMain.setBackground(Color.DARK_GRAY);
        frameMain.getContentPane().add(panelMain, BorderLayout.NORTH);


//        panel text
        panelText = new JPanel();
        panelText.setBackground(Color.BLUE);
        panelText.setPreferredSize(new Dimension( 180, 80));
        frameMain.getContentPane().add(panelText, BorderLayout.SOUTH);

//        panel Center
        panelCenter = new JPanel();
        frameMain.getContentPane().add(panelCenter);
        BufferedImage img1;
        File file = new File("C:\\Users\\resma\\IdeaProjects\\coutingKids\\elo.jpg");
        img1 = ImageIO.read(file);
        label = new JLabel();
        label.setBounds(0, 0, 280, 100);
        label.setIcon(new ImageIcon(img1));
        panelCenter.add(label, BorderLayout.CENTER);


//        textFieldMain
        txtFieldMain = new JFormattedTextField();
        txtFieldMain.setText("Enter your name:");
        txtFieldMain.setEditable(false);
        txtFieldMain.setPreferredSize(new Dimension(100, 20));
        panelText.add(txtFieldMain, BorderLayout.CENTER);

//        textFieldName
       txtFieldName= new JFormattedTextField();
       txtFieldName.setPreferredSize(new Dimension(100, 40));
        txtFieldName.setEditable(true);
        panelText.add(txtFieldName, BorderLayout.CENTER);

//        text Field AddQuest
        txtFieldAddQuest = new JFormattedTextField();
        txtFieldAddQuest.setText("Let's count!");
        txtFieldAddQuest.setEditable(false);
        txtFieldAddQuest.setBounds(20, 20, 100, 40);
        panelMain.add(txtFieldAddQuest, BorderLayout.WEST);



//        text Field add response
        txtFieldAddResponse= new JFormattedTextField();
        txtFieldAddResponse.setPreferredSize(new Dimension(100, 40));
        txtFieldAddResponse.setEditable(true);
        panelMain.add(txtFieldAddResponse, BorderLayout.CENTER);

//        btnStart
        btnStart = new JButton("START");
        panelText.add(btnStart, BorderLayout.EAST);

//        buttonCheck
          btnCheck = new JButton("Check");
        panelMain.add(btnCheck, BorderLayout.WEST);

        frameMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameMain.setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }

            private void start() {
                name = txtFieldName.getText();
                String hello = "Hello " + name + "!";
                String[] options = new String[]{"Addition", "Subtraction", "Cancel"};
                int response = JOptionPane.showOptionDialog(null, "Choose what you want to do: ", hello,
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);
//
                if (response == 0) {

                    addition();


                } else if (response == 1) {
                    subtraction();
                } else {
                    System.exit(0);
                }
            }


            private void addition() {

                Random rand = new Random();
                for (int i = 1; i <= 20; i++) {
                    randomNum1 = rand.nextInt(20 - 1);
                    randomNum2 = rand.nextInt(19);
                    randSum = randomNum1 + randomNum2;

                    String operAdd = randomNum1 + " + " + randomNum2 + " = ";
                    txtFieldAddQuest.setText(operAdd);

//
                    btnCheck.addActionListener(e -> {
                                String brawo = "Brawo";
                                String[] options = new String[]{"One more time!", "Exit"};
                                String response = txtFieldAddResponse.getText();
                             int   resp = Integer.parseInt(response);
                                txtFieldAddResponse.setText(null);

                                if (randSum == resp) {

                                    int response1 = JOptionPane.showOptionDialog(null, "Correct!", brawo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                            null, options, options[0]);

                                    if (response1 == 0) {

                                        start();

                                    } else {
                                        System.exit(0);
                                    }
                                } else {
                                    String keepPractice = "Keep practice!";
                                    String[] options2 = new String[]{"Try again!", "Exit"};
                                    int resp2 = JOptionPane.showOptionDialog(null, "Incorrect!", keepPractice, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                            null, options2, options2[0]);
                                    if (resp2 == 0) {
                                        start();
                                    } else {
                                        System.exit(0);
                                    }


                                }

// "Correct"; try again, exit

                            }
                    );
                }
            }

            private void subtraction() {
                Random rand = new Random();
                for (int i = 1; i <= 20; i++) {
                    randomNum1 = rand.nextInt(20);
                    randomNum2 = rand.nextInt(20);
                    if (randomNum1 >= randomNum2) {
                        randSub = randomNum1 - randomNum2;

                        String operSub = randomNum1 + " - " + randomNum2 + " = ";
                        txtFieldAddQuest.setText(operSub);}

                    else {
                        randSub = randomNum2 - randomNum1;
                    }
                        btnCheck.addActionListener(e -> {
                                    String brawo = "Brawo";
                                    String[] options = new String[]{"One more time!", "Exit"};
                                   String  response = txtFieldAddResponse.getText();
                                    int resp = Integer.parseInt(response);
//                           txtFieldAddResponse.contains(null);

//for (int i = 0; i<)
                                    if (randSub == resp) {

                                        int response1 = JOptionPane.showOptionDialog(null, "Correct!", brawo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                null, options, options[0]);

                                        if (response1 == 0) {

                                            start();

                                        } else if (response1 == 1) {

//                                             back
                                            System.exit(0);
                                        }
                                    } else {
                                        String keepPractice = "Keep practice!";
                                        String[] options2 = new String[]{"Try again!", "Exit"};
                                        int resp2 = JOptionPane.showOptionDialog(null, "Incorrect!", keepPractice, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                null, options2, options2[0]);
                                        if (resp2 == 0) {
                                            start();
                                        } else {
                                            System.exit(0);
                                        }}


                                    });


                }}  }
                        );
                    }




            public static void main(String[] args) throws IOException {
                new Main();

            }

        }