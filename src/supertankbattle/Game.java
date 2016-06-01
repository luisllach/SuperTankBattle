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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    private Map mapa;
    private final int anchoVentana = 800;
    private final int altoVentana = 630;
    private final int upperOffset = 25;
    private final int rightOffset = 200;
    private final int downBound = altoVentana - 4;
    private final int rightBound = anchoVentana - rightOffset + 1;
    private final int leftBound = -1;
    private final int upBound = upperOffset;
    private final int FPS = 120;
    private boolean gameStarted;
    private boolean gamePaused;
    private boolean gameInstructions;
    private boolean actions[];
    private final int A_UP = 0;
    private final int A_DOWN = 1;
    private final int A_LEFT = 2;
    private final int A_RIGHT = 3;
    private final int A_SPACE = 4;
    private final int A_P = 5;

    public static Thread key;

    //Constructor
    public Game() {
        initComponents();
        addListeners();
        gameStarted = false;
        try {
            actions = new boolean[6];
            rec = new Recursos();
            mapa = new Map();
            mapa.setMapa(1, rec.getImg_bloques());
            jugador = new Tank(0, 175, 575, 0, rec.getImg_tanques()[0][0]);
            key = Actions();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getCause());
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
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        actions[A_UP] = true;
                        jugador.setDirection(A_UP);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        actions[A_DOWN] = true;
                        jugador.setDirection(A_DOWN);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        actions[A_LEFT] = true;
                        jugador.setDirection(A_LEFT);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        actions[A_RIGHT] = true;
                        jugador.setDirection(A_RIGHT);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_P) {
                        actions[A_P] = true;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        actions[A_SPACE] = true;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getCause());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    actions[A_UP] = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    actions[A_DOWN] = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    actions[A_LEFT] = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    actions[A_RIGHT] = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    actions[A_P] = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    actions[A_SPACE] = false;
                }
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (gameStarted) {

                } else if (!gameInstructions) {
                    //Iniciar el juego
                    if (e.getX() >= 250 && e.getX() <= 550 && e.getY() >= 200 && e.getY() <= 275) {
                        gameStarted = true;
                        //Ver instrucciones
                    } else if (e.getX() >= 250 && e.getX() <= 550 && e.getY() >= 300 && e.getY() <= 375) {
                        gameInstructions = true;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
                if (gameStarted) {
                    //Inicia el juego
                    Graphics g = this.getGraphics();
                    dbImage = this.createImage(anchoVentana, altoVentana);
                    dbg = dbImage.getGraphics();

                    paintComponent(dbg);
                    jugador.draw(dbg);
                    if (jugador.balas[0].traveling) {
                        jugador.balas[0].draw(dbg);
                    }
                    dbg.drawImage(rec.getImg_fondos()[1], 600, upBound, null);
                    mapa.draw(dbg);
                    dbg.setColor(Color.WHITE);
                    dbg.drawString("X: " + jugador.getPosx() + " | Y: " + jugador.getPosy(), 1, 35);

                    g.drawImage(dbImage, 0, 0, this);

                } else //Menu principal
                 if (!gameInstructions) {
                        Graphics g = this.getGraphics();
                        dbImage = this.createImage(anchoVentana, altoVentana);
                        dbg = dbImage.getGraphics();
                        //paintComponent(dbg);
                        dbg.drawImage(rec.getImg_fondos()[0], 0, upBound, null);
                        dbg.drawImage(rec.getImg_menus()[0], 250, 200, null);
                        dbg.drawImage(rec.getImg_menus()[1], 250, 300, null);

                        g.drawImage(dbImage, 0, 0, this);
                    } else {
                        //Instrucciones
                        Graphics g = this.getGraphics();
                        dbImage = this.createImage(anchoVentana, altoVentana);
                        dbg = dbImage.getGraphics();

                        g.drawImage(dbImage, 0, 0, this);
                    }

                Thread.sleep(1000 / FPS);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getCause());
        }
    }

    public Thread Actions() {
        Thread action = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (gameStarted) {
                            if (actions[A_UP]) {
                                if (!mapa.willCollide(jugador, A_UP)) {
                                    jugador.move_up(upBound);
                                }
                            } else if (actions[A_DOWN]) {
                                if (!mapa.willCollide(jugador, A_DOWN)) {
                                    jugador.move_down(downBound);
                                }
                            } else if (actions[A_LEFT]) {
                                if (!mapa.willCollide(jugador, A_LEFT)) {
                                    jugador.move_left(leftBound);
                                }
                            } else if (actions[A_RIGHT]) {
                                if (!mapa.willCollide(jugador, A_RIGHT)) {
                                    jugador.move_right(rightBound);
                                }
                            }
                            if (actions[A_P]) {
                                gamePaused = !gamePaused;
                            }
                            if (actions[A_SPACE]) {
                                if (jugador.canShoot()) {
                                    switch (jugador.direction) {
                                        case 0:
                                            jugador.shoot(upBound);
                                            break;
                                        case 1:
                                            jugador.shoot(downBound);
                                            break;
                                        case 2:
                                            jugador.shoot(leftBound);
                                            break;
                                        case 3:
                                            jugador.shoot(rightBound);
                                            break;
                                    }
                                }
                            }
                            jugador.setImage(rec.getImg_tanques()[jugador.getTipo()][jugador.getDirection()]);
                            if(jugador.balas[0].traveling){
                                switch(jugador.balas[0].direction){
                                    case 0:
                                        if(!mapa.willColide(jugador.balas[0], 0)){
                                            jugador.balas[0].travel();
                                        }
                                        else{
                                            jugador.balas[0].traveling=false;
                                            jugador.balas[0].reset();
                                        }
                                        break;
                                    case 1:
                                        if(!mapa.willColide(jugador.balas[0], 1)){
                                            jugador.balas[0].travel();
                                        }
                                        else{
                                            jugador.balas[0].traveling=false;
                                            jugador.balas[0].reset();
                                        }
                                        break;
                                    case 2:
                                        if(!mapa.willColide(jugador.balas[0], 2)){
                                            jugador.balas[0].travel();
                                        }
                                        else{
                                            jugador.balas[0].traveling=false;
                                            jugador.balas[0].reset();
                                        }
                                        break;
                                    case 3:
                                        if(!mapa.willColide(jugador.balas[0], 3)){
                                            jugador.balas[0].travel();
                                        }
                                        else{
                                            jugador.balas[0].traveling=false;
                                            jugador.balas[0].reset();
                                        }
                                        break;
                                }
                            }
                        }
                        Thread.sleep(1500 / (FPS));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getCause());
                    }
                }
            }
        }
        );
        return action;
    }

//Getters & Setters
//Principal
    public static void main(String[] args) {

        Game game = new Game();
        //Threads
        Thread t1 = new Thread(game);
        t1.start();
        key.start();
    }
}
