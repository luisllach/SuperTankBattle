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
    private final int downBound = altoVentana;
    private final int rightBound = anchoVentana - rightOffset;
    private final int leftBound = 0;
    private final int upBound = upperOffset;
    private final int FPS = 120;
    private boolean gameStarted;
    private boolean gamePaused;
    private boolean gameInstructions;

    //Constructor
    public Game() {
        initComponents();
        addListeners();
        gameStarted = false;
        try {
            rec = new Recursos();
            mapa = new Map();
            mapa.setMapa(1, rec.getImg_bloques());
            jugador = new Tank(0, 175, 575, 0, rec.getImg_tanques()[0][0]);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
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
                    if (e.getKeyCode() == KeyEvent.VK_UP && gameStarted) {
                        jugador.move_up(upBound);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN && gameStarted) {
                        jugador.move_down(downBound);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT && gameStarted) {
                        jugador.move_left(leftBound);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT && gameStarted) {
                        jugador.move_right(rightBound);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_P && gameStarted) {
                        if (gamePaused) {
                            gamePaused = false;
                        } else {
                            gamePaused = true;
                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_SPACE && gameStarted) {
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
                    if (jugador.directionChanged()) {
                        jugador.setImage(rec.getImg_tanques()[jugador.getTipo()][jugador.getDirection()]);
                    }
                } catch (Exception ex) {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

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
                    dbg.drawImage(rec.getImg_fondos()[1], 600, upBound, null);
                    mapa.draw(dbg);

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
