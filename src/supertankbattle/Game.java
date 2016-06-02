/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Game extends JFrame implements Runnable {

    //Atributos
    private Tank jugador;
    private Tank aguila;
    private ArrayList<Tank> enemigos;
    private ArrayList<Tank> agui;
    private Recursos rec;
    private Image dbImage;
    private Graphics dbg;
    private Map mapa;
    private int puntaje;
    private int numEnemigos;
    private int nivelSel;
    private final int anchoVentana = 800;
    private final int altoVentana = 630;
    private final int upperOffset = 24;
    private final int rightOffset = 200;
    private final int downBound = altoVentana - 4;
    private final int rightBound = anchoVentana - rightOffset + 1;
    private final int leftBound = -1;
    private final int upBound = upperOffset;
    private final int FPS = 120;
    private boolean gameStarted;
    private boolean gamePaused;
    private boolean gameInstructions;
    private boolean gameMenu;
    private boolean gameLevel;
    private boolean gameMusic;
    private boolean actions[];
    private final int A_UP = 0;
    private final int A_DOWN = 1;
    private final int A_LEFT = 2;
    private final int A_RIGHT = 3;
    private final int A_SPACE = 4;
    private final int A_P = 5;

    public static Thread player;
    public static Thread traveling;
    public static Thread enemyAI;
    public static Clip musica;

    //Constructor
    public Game() {
        initComponents();

        gameMusic = true;
        gameStarted = false;
        gamePaused = false;
        gameInstructions = false;
        gameLevel = false;
        gameMenu = true;
        enemigos = new ArrayList<Tank>();
        agui = new ArrayList<Tank>();
        numEnemigos = 3;
        nivelSel = 1;
        puntaje = 0;
        try {
            actions = new boolean[6];
            rec = new Recursos();
            mapa = new Map();
            jugador = new Tank(0, 175, 575, 0, rec.getImg_tanques()[0][0]);
            aguila = new Tank(0, 275, 575, 0, rec.getImg_misc()[0]);
            agui.add(aguila);
            enemigos.add(new Tank(1, 0, 25, 1, rec.getImg_tanques()[1][1]));
            enemigos.add(new Tank(1, 250, 25, 1, rec.getImg_tanques()[1][1]));
            enemigos.add(new Tank(1, 550, 25, 1, rec.getImg_tanques()[1][1]));
            player = movePlayer();
            traveling = travelBullets();
            musica = rec.getAmbiente();
            enemyAI = movingEnemies();
            addListeners();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getCause());
        }

    }

    //Metodos
    private int randomPosx() {
        double i = Math.random() * 10;
        if (i < 3) {
            return 0;
        } else if (i >= 3 && i < 6) {
            return 250;
        } else {
            return 550;
        }
    }

    private void resetAll() throws IOException {
        gameStarted = false;
        gamePaused = false;
        gameInstructions = false;
        gameLevel = false;
        gameMenu = true;
        enemigos = new ArrayList<Tank>();
        agui = new ArrayList<Tank>();
        numEnemigos = 3;
        nivelSel = 1;
        puntaje = 0;
        actions = new boolean[6];
        mapa = new Map();
        jugador = new Tank(0, 175, 575, 0, rec.getImg_tanques()[0][0]);
        aguila = new Tank(0, 275, 575, 0, rec.getImg_misc()[0]);
        agui.add(aguila);
        enemigos.add(new Tank(1, 0, 25, 1, rec.getImg_tanques()[1][1]));
        enemigos.add(new Tank(1, 250, 25, 1, rec.getImg_tanques()[1][1]));
        enemigos.add(new Tank(1, 550, 25, 1, rec.getImg_tanques()[1][1]));

    }

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

                } else if (gameMenu) {

                    //Seleccionar nivel
                    if (e.getX() >= 250 && e.getX() <= 550 && e.getY() >= 200 && e.getY() <= 275) {
                        gameMenu = false;
                        gameLevel = true;
                        //Ver instrucciones
                    } else if (e.getX() >= 250 && e.getX() <= 550 && e.getY() >= 300 && e.getY() <= 375) {
                        gameMenu = false;
                        gameInstructions = true;
                    }
                } else if (gameLevel) {
                    //nivel
                    //f-izquierda
                    if (e.getX() >= 190 && e.getX() <= 310 && e.getY() >= 120 && e.getY() <= 220) {
                        if (nivelSel != 1) {
                            nivelSel -= 1;

                        }
                    } else if (e.getX() >= 430 && e.getX() <= 550 && e.getY() >= 120 && e.getY() <= 220) { //f-derecha
                        if (nivelSel != 1) {
                            nivelSel += 1;

                        }
                    } else if (e.getX() >= 190 && e.getX() <= 310 && e.getY() >= 320 && e.getY() <= 420) {
                        if (numEnemigos != 3) {
                            numEnemigos -= 1;
                        }
                    } else if (e.getX() >= 430 && e.getX() <= 550 && e.getY() >= 320 && e.getY() <= 420) {
                        if (numEnemigos != 20) {
                            numEnemigos += 1;
                        }
                    } else if (e.getX() >= 300 && e.getX() <= 500 && e.getY() >= 420 && e.getY() <= 570) {
                        mapa.setMapa(nivelSel, rec.getImg_bloques());

                        gameLevel = false;
                        gameStarted = true;

                    }

                } else if (gameInstructions) {
                    if (e.getX() >= 660 && e.getX() <= 760 && e.getY() >= 500 && e.getY() <= 580) {
                        gameInstructions = false;
                        gameMenu = true;
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

        rec.getAmbiente().addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {

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
                    aguila.draw(dbg);
                    for (Iterator<Tank> it = enemigos.iterator(); it.hasNext();) {
                        Tank t = it.next();
                        t.draw(dbg);
                    }
                    if (jugador.balas[0].traveling) {
                        jugador.balas[0].draw(dbg);
                    }
                    dbg.drawImage(rec.getImg_fondos()[1], 600, upBound, null);
                    mapa.draw(dbg);
                    dbg.setColor(Color.PINK);
                    dbg.setFont(new Font("TimesRoman", Font.PLAIN, 40));
                    dbg.drawImage(rec.getImg_misc()[6], 605, 120, null);
                    dbg.drawString("" + numEnemigos, 760, 190);
                    dbg.drawImage(rec.getImg_misc()[7], 605, 270, null);
                    dbg.drawString("" + puntaje, 690, 340);
                    dbg.drawImage(rec.getImg_misc()[8], 605, 420, null);
                    dbg.drawString("1", 760, 490);

                    g.drawImage(dbImage, 0, 0, this);

                } else //Menu principal
                 if (gameMenu) {
                        Graphics g = this.getGraphics();
                        dbImage = this.createImage(anchoVentana, altoVentana);
                        dbg = dbImage.getGraphics();
                        paintComponent(dbg);
                        dbg.drawImage(rec.getImg_fondos()[0], 0, upBound, null);
                        dbg.drawImage(rec.getImg_menus()[0], 250, 200, null);
                        dbg.drawImage(rec.getImg_menus()[1], 250, 300, null);

                        g.drawImage(dbImage, 0, 0, this);
                    } else if (gameInstructions) {
                        //Instrucciones
                        Graphics g = this.getGraphics();
                        dbImage = this.createImage(anchoVentana, altoVentana);
                        dbg = dbImage.getGraphics();
                        dbg.drawImage(rec.getImg_fondos()[2], 0, 0, null);
                        g.drawImage(dbImage, 0, 0, this);
                    } else if (gameLevel) {
                        Graphics g = this.getGraphics();
                        dbImage = this.createImage(anchoVentana, altoVentana);
                        dbg = dbImage.getGraphics();
                        paintComponent(dbg);
                        dbg.setColor(Color.WHITE);
                        //nivel
                        dbg.drawImage(rec.getImg_misc()[3], 240, 40, null);
                        dbg.drawImage(rec.getImg_misc()[1], 190, 120, null);
                        dbg.drawImage(rec.getImg_nums()[nivelSel - 1], 320, 120, null);
                        dbg.drawImage(rec.getImg_misc()[2], 430, 120, null);
                        //# de enemigos:
                        dbg.drawImage(rec.getImg_misc()[4], 240, 240, null);
                        dbg.drawImage(rec.getImg_misc()[1], 190, 320, null);
                        dbg.drawImage(rec.getImg_nums()[numEnemigos - 1], 320, 320, null);
                        dbg.drawImage(rec.getImg_misc()[2], 430, 320, null);
                        //continuar
                        dbg.drawImage(rec.getImg_misc()[5], 300, 420, null);

                        g.drawImage(dbImage, 0, 0, this);
                    }

                Thread.sleep(1000 / FPS);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getCause());
        }
    }

    public synchronized Thread movePlayer() {

        Thread action = new Thread(new Runnable() {
            @Override
            public void run() {
                int pos;
                while (true) {
                    try {
                        if (gameStarted) {
                            if (actions[A_UP]) {
                                pos = mapa.willCollide(jugador, A_UP);
                                if (pos == -2) {
                                    if (!jugador.willColide(enemigos, A_UP)) {
                                        jugador.move_up(upBound);
                                    }
                                } else if (pos >= 0) {
                                    if (!jugador.willColide(enemigos, A_UP)) {
                                        jugador.setPosx(pos);
                                        jugador.move_up(upBound);
                                    }
                                }
                            } else if (actions[A_DOWN]) {
                                pos = mapa.willCollide(jugador, A_DOWN);
                                if (pos == -2) {
                                    if (!jugador.willColide(enemigos, A_DOWN) && !jugador.willColide(aguila, A_DOWN)) {
                                        jugador.move_down(downBound);
                                    }
                                } else if (pos >= 0) {
                                    if (!jugador.willColide(enemigos, A_DOWN) && !jugador.willColide(aguila, A_DOWN)) {
                                        jugador.setPosx(pos);
                                        jugador.move_down(downBound);
                                    }
                                }
                            } else if (actions[A_LEFT]) {
                                pos = mapa.willCollide(jugador, A_LEFT);
                                if (pos == -2) {
                                    if (!jugador.willColide(enemigos, A_LEFT) && !jugador.willColide(aguila, A_LEFT)) {
                                        jugador.move_left(leftBound);
                                    }
                                } else if (pos >= 0) {
                                    if (!jugador.willColide(enemigos, A_LEFT) && !jugador.willColide(aguila, A_LEFT)) {
                                        jugador.setPosy(pos);
                                        jugador.move_left(leftBound);
                                    }
                                }
                            } else if (actions[A_RIGHT]) {
                                pos = mapa.willCollide(jugador, A_RIGHT);
                                if (pos == -2) {
                                    if (!jugador.willColide(enemigos, A_RIGHT) && !jugador.willColide(aguila, A_RIGHT)) {
                                        jugador.move_right(rightBound);
                                    }
                                } else if (pos >= 0) {
                                    if (!jugador.willColide(enemigos, A_RIGHT) && !jugador.willColide(aguila, A_RIGHT)) {
                                        jugador.setPosy(pos);
                                        jugador.move_right(rightBound);
                                    }
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

                        }
                        Thread.sleep(1000 / (FPS));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getCause());
                    }
                }
            }
        }
        );
        return action;
    }

    public synchronized Thread travelBullets() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (gameStarted) {

                            if (jugador.balas[0].traveling) {
                                switch (jugador.balas[0].direction) {
                                    case 0:
                                        if (mapa.willColide(jugador.balas[0], 0) == 0) {
                                            if (!jugador.willBulletCollide(enemigos, 0)) {
                                                if (!jugador.willBulletCollide(agui, 0)) {
                                                    jugador.balas[0].travel();
                                                } else {
                                                    jugador.balas[0].traveling = false;
                                                    jugador.balas[0].reset();
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nBASE DESTRUIDA: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;

                                                }
                                            } else {
                                                jugador.balas[0].traveling = false;
                                                jugador.balas[0].reset();
                                                puntaje += 100;
                                                numEnemigos -= 1;
                                                if (numEnemigos > 3) {
                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (enemigos.isEmpty() && numEnemigos > 0) {

                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (numEnemigos == 0) {
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nTODOS LOS ENEMIGOS HAN SIDO DESTRUIDOS: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;
                                                }
                                            }
                                        } else {
                                            jugador.balas[0].traveling = false;
                                            jugador.balas[0].reset();

                                        }
                                        break;
                                    case 1:
                                        if (mapa.willColide(jugador.balas[0], 1) == 0) {
                                            if (!jugador.willBulletCollide(enemigos, 1)) {
                                                if (!jugador.willBulletCollide(agui, 1)) {
                                                    jugador.balas[0].travel();
                                                } else {
                                                    jugador.balas[0].traveling = false;
                                                    jugador.balas[0].reset();
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nBASE DESTRUIDA: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;
                                                }
                                            } else {
                                                jugador.balas[0].traveling = false;
                                                jugador.balas[0].reset();
                                                puntaje += 100;
                                                numEnemigos -= 1;
                                                if (numEnemigos > 3) {
                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (enemigos.isEmpty() && numEnemigos > 0) {

                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (numEnemigos == 0) {
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nTODOS LOS ENEMIGOS HAN SIDO DESTRUIDOS: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;
                                                }
                                            }
                                        } else {
                                            jugador.balas[0].traveling = false;
                                            jugador.balas[0].reset();

                                        }
                                        break;
                                    case 2:
                                        if (mapa.willColide(jugador.balas[0], 2) == 0) {
                                            if (!jugador.willBulletCollide(enemigos, 2)) {
                                                if (!jugador.willBulletCollide(agui, 2)) {
                                                    jugador.balas[0].travel();
                                                } else {
                                                    jugador.balas[0].traveling = false;
                                                    jugador.balas[0].reset();
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nBASE DESTRUIDA: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;
                                                }
                                            } else {
                                                jugador.balas[0].traveling = false;
                                                jugador.balas[0].reset();
                                                puntaje += 100;
                                                numEnemigos -= 1;

                                                if (numEnemigos > 3) {
                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (enemigos.isEmpty() && numEnemigos > 0) {

                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (numEnemigos == 0) {
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nTODOS LOS ENEMIGOS HAN SIDO DESTRUIDOS: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;
                                                }
                                            }
                                        } else {
                                            jugador.balas[0].traveling = false;
                                            jugador.balas[0].reset();

                                        }
                                        break;
                                    case 3:
                                        if (mapa.willColide(jugador.balas[0], 3) == 0) {
                                            if (!jugador.willBulletCollide(enemigos, 3)) {
                                                if (!jugador.willBulletCollide(agui, 3)) {
                                                    jugador.balas[0].travel();
                                                } else {
                                                    jugador.balas[0].traveling = false;
                                                    jugador.balas[0].reset();
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nBASE DESTRUIDA: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;
                                                }
                                            } else {
                                                jugador.balas[0].traveling = false;
                                                jugador.balas[0].reset();
                                                puntaje += 100;
                                                numEnemigos -= 1;
                                                if (numEnemigos > 3) {
                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (enemigos.isEmpty() && numEnemigos > 0) {

                                                    enemigos.add(new Tank(1, randomPosx(), 25, 1, rec.getImg_tanques()[1][1]));
                                                }
                                                if (numEnemigos == 0) {
                                                    JOptionPane.showMessageDialog(rootPane, "PUNTAJE: " + puntaje + "\nTODOS LOS ENEMIGOS HAN SIDO DESTRUIDOS: JUEGO TERMINADO!");
                                                    resetAll();
                                                    gameStarted = false;
                                                }
                                            }
                                        } else {
                                            jugador.balas[0].traveling = false;
                                            jugador.balas[0].reset();

                                        }
                                        break;
                                }
                            }
                        }
                        Thread.sleep(500 / (FPS));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                }
            }
        });
        return t;
    }

    public synchronized Thread movingEnemies() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (gameStarted) {
                            for (Iterator<Tank> it = enemigos.iterator(); it.hasNext();) {
                                Tank t = it.next();
                                t.AI(upBound, downBound, leftBound, rightBound, jugador);
                            }
                        }
                        Thread.sleep(1000 / 5);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                }
            }
        });
        return t;
    }

//Getters & Setters
//Principal
    public static void main(String[] args) {

        Game game = new Game();
        //Threads

        try {
            Thread drawing = new Thread(game);
            drawing.start();
            player.start();
            traveling.start();
            enemyAI.start();
            musica.setMicrosecondPosition(35_000_000);
            musica.start();
            musica.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(game, ex.getMessage());
        }
    }
}
