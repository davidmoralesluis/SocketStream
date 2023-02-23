package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Calc extends JFrame implements ActionListener {

    private JFrame ventana;
    private JLabel saludo;
    private JTextField campoTexto;
    private JLabel respuesta1,respuesta2,respuesta3;
    private JButton boton1,boton2,boton3,boton4;

    Double num;
    Timer sec;

    private static Calc instance = null;
    public static Calc getInstance() throws IOException {

        if (instance == null) {
            // como no está creada, la creo
            // desde aqui si que puedo acceder al constructor
            // porque estoy en la misma clase
            instance = new Calc();
        }
        // devuelvo la instancia
        return instance;
    }

    private Calc() throws IOException{
        ventana = new JFrame("Calculadora Especial");
        ventana.setBounds(250, 400, 400, 500);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(Color.white);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setResizable(true);

        sec = new Timer(10,this);
        sec.start();


        saludo = new JLabel("Calculadora");
        saludo.setBounds(100, 30, 200, 30);
        saludo.setFont(new Font("Courier 10 Pitch", Font.BOLD+Font.CENTER_BASELINE, 25));
        ventana.add(saludo);

        respuesta1 = new JLabel("---");
        respuesta1.setBounds(50, 250, 300, 50);
        ventana.add(respuesta1);

        respuesta2 = new JLabel("---");
        respuesta2.setBounds(50, 300, 200, 50);
        ventana.add(respuesta2);

        respuesta3 = new JLabel("---");
        respuesta3.setBounds(50, 350, 300, 50);
        ventana.add(respuesta3);

        campoTexto = new JTextField();
        campoTexto.setBounds(100, 100, 200, 30); // Establecer la posición y tamaño del campo de texto
        campoTexto.setVisible(true);
        ventana.add(campoTexto);

        boton1 = new JButton("CJ");
        boton1.setBounds(100, 150, 50, 30); // Establecer la posición y tamaño del botón
        boton1.setBackground(Color.BLUE);
        boton1.setVisible(true);
        boton1.addActionListener(this);
        ventana.add(boton1);

        boton2 = new JButton("X");
        boton2.setBounds(250, 150, 50, 30); // Establecer la posición y tamaño del botón
        boton2.setBackground(Color.BLUE);
        boton2.setVisible(true);
        boton2.addActionListener(this);
        ventana.add(boton2);

        boton3 = new JButton("PR");
        boton3.setBounds(100, 200, 50, 30);
        boton3.setVisible(true);
        boton3.addActionListener(this);
        ventana.add(boton3);

        boton4 = new JButton("S");
        boton4.setBounds(250, 200, 50, 30);
        boton4.setVisible(true);
        boton4.addActionListener(this);
        ventana.add(boton4);

        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==sec){
            ventana.getContentPane().setBackground(Color.gray);
            System.out.println("start");
            sec.stop();
        }

        if (e.getSource()==boton1){
            System.out.println("boton1");
            try {
                String ans=new Cliente("1#"+campoTexto.getText()).clienteResponde();
                num=Math.floor((Double.parseDouble(ans)) * 100) / 100;
                respuesta1.setText("El numero es equivalente a");
                respuesta2.setText(num+"");
                respuesta3.setText("Campos de Futbol");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource()==boton2){
            System.out.println("boton2");
            try {
                String ans=new Cliente("2#"+campoTexto.getText()).clienteResponde();
                respuesta1.setText("Te quedan");
                respuesta2.setText(ans);
                respuesta3.setText("meses para la jubilacion completa");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource()==boton3){
            System.out.println("boton3");
            try {
                String ans=new Cliente("3#"+campoTexto.getText()).clienteResponde();
                respuesta1.setText("El numero es equivalente a");
                respuesta2.setText(ans);
                respuesta3.setText("veces a los libros");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource()==boton4){
            System.out.println("boton4");
            try {
                String ans=new Cliente("4#"+campoTexto.getText()).clienteResponde();
                num=Math.floor((Double.parseDouble(ans)) * 100) / 100;

                respuesta1.setText("El precio es");
                if (num>=0){
                    respuesta2.setText(num+" €");
                    respuesta3.setText("mas caro de el precio mas barato de Vigo");
                }else {
                    respuesta2.setText(""+(Double.parseDouble(ans)*-1));
                    respuesta3.setText("mas barata de el precio mas barato de Vigo");
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }





    }
}
