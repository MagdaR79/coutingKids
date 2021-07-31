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

//    public class BackgroundPanel extends JPanel {
//        // The Image to store the background image in.
//       public Image img;
//
//        public BackgroundPanel() {
//            // Loads the background image and stores in img object.
//            img = Toolkit.getDefaultToolkit().getImage("elo.png");
//        }
//
//        public void paint(Graphics g) {
//            // Draws the img to the BackgroundPanel.
//            g.drawImage(img, 10, 10, null);
//        }
//    }
    public Main () throws IOException {
        this.initComponents();
this.pack();
    }

    public void initComponents() throws IOException {

// frameMain
        frameMain = new JFrame();
       frameMain.setTitle("Kids count!");
        frameMain.setPreferredSize(new Dimension(200,200));
       frameMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameMain.setVisible(true);


//        panelMain
        panelMain = new JPanel();
        panelMain.setPreferredSize(new Dimension(180, 220));
        panelMain.setBackground(Color.DARK_GRAY);
        frameMain.getContentPane().add(panelMain, BorderLayout.NORTH);

//        panel text
        panelText = new JPanel();
        panelText.setBackground(Color.blue);
        panelText.setPreferredSize(new Dimension( 180, 100));
        frameMain.getContentPane().add(panelText, BorderLayout.SOUTH);

//        panel Center
        panelCenter = new JPanel();
        frameMain.getContentPane().add(panelCenter, BorderLayout.CENTER);
        BufferedImage img1 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        File file = new File("C:\\Users\\resma\\OneDrive\\Desktop\\elo.png.jpg");
        img1 = ImageIO.read(file);
        label = new JLabel();
        label.setBounds(0, 10, 100, 100);
        label.setIcon(new ImageIcon(img1));
        panelCenter.add(label);


//        BackgroundPanel bcg = new BackgroundPanel();
//               panelCenter.add(bcg);



//        textFieldMain
        txtFieldMain = new JFormattedTextField();
        txtFieldMain.setText("Enter your name:");
        txtFieldMain.setEditable(false);
        txtFieldMain.setBounds(20, 20, 100, 40);
        panelText.add(txtFieldMain, BorderLayout.WEST);

//        textFieldName
       txtFieldName= new JFormattedTextField();
       txtFieldName.setLocation(60, 20);
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
        txtFieldAddResponse.setLocation(60, 20);
        txtFieldAddResponse.setPreferredSize(new Dimension(100, 40));
        txtFieldAddResponse.setEditable(true);
        panelMain.add(txtFieldAddResponse, BorderLayout.CENTER);

//        btnStart
        btnStart = new JButton("START");
        panelText.add(btnStart, BorderLayout.EAST);

//        buttonCheck
          btnCheck = new JButton("Check");
        panelMain.add(btnCheck, BorderLayout.WEST);


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