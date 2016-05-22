/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Luis Llach
 */
public class Game extends JFrame implements Runnable {

    //Atributos
    private Tank jugador;
    private Recursos rec;
    private Image dbImage;
    private Graphics dbg;
    private final int anchoVentana = 800;
    private final int altoVentana = 600;
    private final int FPS = 120;

    //Constructor
    public Game() {
        initComponents();
        addListeners();
        try {
            rec = new Recursos();
            jugador = new Tank(0, anchoVentana / 2, altoVentana / 2, 0, rec.getImg_tanques()[0][0]);

        } catch (Exception ex) {

        }

    }

    //Metodos
    private void initComponents() {
        //Jframe
        this.setTitle("SUPER TANKS BATTLE");
        this.setSize(new Dimension(anchoVentana, altoVentana));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setFocusable(true);

    }

    private void addListeners() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            jugador.move_up(0);
                            break;
                        case KeyEvent.VK_DOWN:
                            jugador.move_down(altoVentana);
                            break;
                        case KeyEvent.VK_LEFT:
                            jugador.move_left(0);
                            break;
                        case KeyEvent.VK_RIGHT:
                            jugador.move_right(anchoVentana);
                            break;
                    }
                    if(jugador.directionChanged())
                    {
                        jugador.setImage(rec.getImg_tanques()[jugador.getTipo()][jugador.getDirection()]);
                    }
                } catch (Exception ex) {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void paint(Graphics g) {
        dbImage = this.createImage(anchoVentana, altoVentana);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, anchoVentana, altoVentana);

    }

    public void run() {
        try {
            while (true) {
                Graphics g = this.getGraphics();
                dbImage = this.createImage(anchoVentana, altoVentana);
                dbg = dbImage.getGraphics();
                paintComponent(dbg);
                jugador.draw(dbg);
                
                g.drawImage(dbImage, 0, 0, this);
                Thread.sleep(1000 / FPS);
            }
        } catch (Exception ex) {

        }
    }

    //Getters & Setters
    //Principal
    public static void main(String[] args) {

        Game game = new Game();
        //Threads
        Thread t1 = new Thread(game);
        t1.start();
    }
}
