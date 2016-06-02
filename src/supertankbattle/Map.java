/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class Map {

    //Atributos
    private final int alto = 625;
    private final int ancho = 600;
    private ArrayList<Block> bloques;

    //Constructor
    public Map() {
        bloques = new ArrayList<>();
    }

    //Metodos
    public void setMapa(int nivel, BufferedImage img_bloques[]) {
        int y;
        switch (nivel) {
            case 1:
                //y=25
                //y=50
                //y=75
                y = 75;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=100
                y = 100;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=125
                y = 125;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=150
                y = 150;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=175
                y = 175;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=200
                y = 200;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=225
                y = 225;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=250
                y = 250;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 1, img_bloques[1]));
                bloques.add(new Block(300, y, 1, img_bloques[1]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=275
                y = 275;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 1, img_bloques[1]));
                bloques.add(new Block(300, y, 1, img_bloques[1]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=275
                y = 300;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(75, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(175, y, 0, img_bloques[0]));
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                bloques.add(new Block(400, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(500, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=325
                //y=350
                y = 350;
                bloques.add(new Block(0, y, 0, img_bloques[0]));
                bloques.add(new Block(25, y, 0, img_bloques[0]));
                bloques.add(new Block(100, y, 0, img_bloques[0]));
                bloques.add(new Block(125, y, 0, img_bloques[0]));
                bloques.add(new Block(450, y, 0, img_bloques[0]));
                bloques.add(new Block(475, y, 0, img_bloques[0]));
                bloques.add(new Block(550, y, 0, img_bloques[0]));
                bloques.add(new Block(575, y, 0, img_bloques[0]));
                //y=375
                y = 375;
                bloques.add(new Block(0, y, 1, img_bloques[1]));
                bloques.add(new Block(25, y, 1, img_bloques[1]));
                bloques.add(new Block(100, y, 0, img_bloques[0]));
                bloques.add(new Block(125, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(450, y, 0, img_bloques[0]));
                bloques.add(new Block(475, y, 0, img_bloques[0]));
                bloques.add(new Block(550, y, 1, img_bloques[1]));
                bloques.add(new Block(575, y, 1, img_bloques[1]));
                //400
                y = 400;
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                //425
                y = 425;
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                //450
                y = 450;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(125, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(450, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=475
                y = 475;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(125, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(450, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=500
                y = 500;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(125, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(450, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=525
                y = 525;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(125, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(450, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=550
                y = 550;
                bloques.add(new Block(50, y, 0, img_bloques[0]));
                bloques.add(new Block(125, y, 0, img_bloques[0]));
                bloques.add(new Block(150, y, 0, img_bloques[0]));
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(275, y, 0, img_bloques[0]));
                bloques.add(new Block(300, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                bloques.add(new Block(425, y, 0, img_bloques[0]));
                bloques.add(new Block(450, y, 0, img_bloques[0]));
                bloques.add(new Block(525, y, 0, img_bloques[0]));
                //y=575
                y = 575;
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                //y=600
                y = 600;
                bloques.add(new Block(225, y, 0, img_bloques[0]));
                bloques.add(new Block(250, y, 0, img_bloques[0]));
                bloques.add(new Block(325, y, 0, img_bloques[0]));
                bloques.add(new Block(350, y, 0, img_bloques[0]));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public synchronized void draw(Graphics g) {
        for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
            Block b = it.next();
            g.drawImage(b.getImage(), b.getPosx(), b.getPosy(), null);
        }
    }

    public synchronized int willCollide(Tank tanque, int direction) {
        int pos = -1;
        Block b1 = null;
        Block b3 = null;
        Block b5 = null;
        switch (direction) {
            case 0:
                if (tanque.getPosx() % 25 == 0) {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if (tanque.getPosx() == b.getPosx()) {
                            if (isInBlockY(b, tanque.getPosy() - tanque.getDist())) {
                                b1 = b;

                            }
                        }
                        if (tanque.getPosx() + 25 == b.getPosx()) {
                            if (isInBlockY(b, tanque.getPosy() - tanque.getDist())) {
                                b3 = b;
                            }
                        }
                    }
                } else {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if ((tanque.getPosx() > b.getPosx() && tanque.getPosx() < b.getPosx() + 25)) {
                            if (isInBlockY(b, tanque.getPosy() - tanque.getDist())) {
                                b1 = b;
                            }
                        }
                        if (tanque.getPosx() + 25 > b.getPosx() && tanque.getPosx() + 25 < b.getPosx() + 25) {
                            if (isInBlockY(b, tanque.getPosy() - tanque.getDist())) {
                                b3 = b;
                            }
                        }
                        if (tanque.getPosx() + 50 > b.getPosx() && tanque.getPosx() + 50 < b.getPosx() + 25) {
                            if (isInBlockY(b, tanque.getPosy() - tanque.getDist())) {
                                b5 = b;
                            }
                        }
                    }
                    if (b1 != null && b3 == null && b5 == null) {
                        if (tanque.getPosx() - b1.getPosx() >= 15) {
                            pos = b1.getPosx() + 25;
                        }
                    } else if (b1 == null && b3 == null && b5 != null) {
                        if (tanque.getPosx() + 50 - b5.getPosx() <= 10) {
                            pos = b5.getPosx() - 50;
                        }
                    }
                }
                break;
            case 1:
                if (tanque.getPosx() % 25 == 0) {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if (tanque.getPosx() == b.getPosx()) {
                            if (isInBlockY(b, tanque.getPosy() + 50 + tanque.getDist())) {
                                b1 = b;
                            }
                        }
                        if (tanque.getPosx() + 25 == b.getPosx()) {
                            if (isInBlockY(b, tanque.getPosy() + 50 + tanque.getDist())) {
                                b3 = b;
                            }
                        }
                    }
                } else {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if ((tanque.getPosx() > b.getPosx() && tanque.getPosx() < b.getPosx() + 25)) {
                            if (isInBlockY(b, tanque.getPosy() + 50 + tanque.getDist())) {
                                b1 = b;
                            }
                        }
                        if (tanque.getPosx() + 25 > b.getPosx() && tanque.getPosx() + 25 < b.getPosx() + 25) {
                            if (isInBlockY(b, tanque.getPosy() + 50 + tanque.getDist())) {
                                b3 = b;
                            }
                        }
                        if (tanque.getPosx() + 50 > b.getPosx() && tanque.getPosx() + 50 < b.getPosx() + 25) {
                            if (isInBlockY(b, tanque.getPosy() + 50 + tanque.getDist())) {
                                b5 = b;
                            }
                        }
                    }
                }
                if (b1 != null && b3 == null && b5 == null) {
                    if (tanque.getPosx() - b1.getPosx() >= 15) {
                        pos = b1.getPosx() + 25;
                    }
                } else if (b1 == null && b3 == null && b5 != null) {
                    if (tanque.getPosx() + 50 - b5.getPosx() <= 10) {
                        pos = b5.getPosx() - 50;
                    }
                }
                break;
            case 2:
                if (tanque.getPosy() % 25 == 0) {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if (tanque.getPosy() == b.getPosy() || tanque.getPosy() + 25 == b.getPosy()) {
                            if (isInBlockX(b, tanque.getPosx() - tanque.getDist())) {
                                b1 = b;
                            }
                        }
                        if (tanque.getPosy() + 25 == b.getPosy()) {
                            if (isInBlockX(b, tanque.getPosx() - tanque.getDist())) {
                                b3 = b;
                            }
                        }
                    }
                } else {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if ((tanque.getPosy() > b.getPosy() && tanque.getPosy() < b.getPosy() + 25)) {
                            if (isInBlockX(b, tanque.getPosx() - tanque.getDist())) {
                                b1 = b;
                            }
                        }
                        if (tanque.getPosy() + 25 > b.getPosy() && tanque.getPosy() + 25 < b.getPosy() + 25) {
                            if (isInBlockX(b, tanque.getPosx() - tanque.getDist())) {
                                b3 = b;
                            }
                        }
                        if (tanque.getPosy() + 50 > b.getPosy() && tanque.getPosy() + 50 < b.getPosy() + 25) {
                            if (isInBlockX(b, tanque.getPosx() - tanque.getDist())) {
                                b5 = b;
                            }
                        }
                    }
                    if (b1 != null && b3 == null && b5 == null) {
                        if (tanque.getPosy() - b1.getPosy() >= 15) {
                            pos = b1.getPosy() + 25;
                        }
                    } else if (b1 == null && b3 == null && b5 != null) {
                        if (tanque.getPosy()+50 - b5.getPosy() <= 10) {
                            pos = b5.getPosy() - 50;
                        }
                    }
                }
                break;
            case 3:
                if (tanque.getPosy() % 25 == 0) {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if (tanque.getPosy() == b.getPosy() || tanque.getPosy() + 25 == b.getPosy()) {
                            if (isInBlockX(b, tanque.getPosx() + 50 + tanque.getDist())) {
                                b1 = b;
                            }
                        }
                        if (tanque.getPosy() + 25 == b.getPosy()) {
                            if (isInBlockX(b, tanque.getPosx() + 50 + tanque.getDist())) {
                                b3 = b;
                            }
                        }
                    }
                } else {
                    for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                        Block b = it.next();
                        if ((tanque.getPosy() > b.getPosy() && tanque.getPosy() < b.getPosy() + 25)) {
                            if (isInBlockX(b, tanque.getPosx() + 50 + tanque.getDist())) {
                                b1 = b;
                            }
                        }
                        if (tanque.getPosy() + 25 > b.getPosy() && tanque.getPosy() + 25 < b.getPosy() + 25) {
                            if (isInBlockX(b, tanque.getPosx() + 50 + tanque.getDist())) {
                                b3 = b;
                            }
                        }
                        if (tanque.getPosy() + 50 > b.getPosy() && tanque.getPosy() + 50 < b.getPosy() + 25) {
                            if (isInBlockX(b, tanque.getPosx() + 50 + tanque.getDist())) {
                                b5 = b;
                            }
                        }
                    }
                    if (b1 != null && b3 == null && b5 == null) {
                        if (tanque.getPosy() - b1.getPosy() >= 15) {
                            pos = b1.getPosy() + 25;
                        }
                    } else if (b1 == null && b3 == null && b5 != null) {
                        if (tanque.getPosy()+50 - b5.getPosy() <= 10) {
                            pos = b5.getPosy() - 50;
                        }
                    }
                }
                break;
            default:
                break;
        }
        if (pos == -1 && b1 == null && b3 == null && b5 == null) {
            pos = -2;
        }
        return pos;
    }

    public synchronized int willColide(Bullet bala, int direction) {
        int cont = 0;
        switch (direction) {
            case 0:
                for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                    Block b = it.next();
                    if ((bala.getPosx() >= b.getPosx() && bala.getPosx() <= b.getPosx() + 25) || (bala.getPosx() + bala.getRADIUS() - 5 >= b.getPosx() && bala.getPosx() + bala.getRADIUS() - 5 <= b.getPosx() + 25)) {
                        if (isInBlockYB(b, bala.getPosy() - bala.getDist())) {
                            if (b.getTipo() == 0) {
                                it.remove();

                            }
                            cont += 1;
                        }
                    }
                }

                break;
            case 1:
                for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                    Block b = it.next();
                    if ((bala.getPosx() >= b.getPosx() && bala.getPosx() <= b.getPosx() + 25) || (bala.getPosx() + bala.getRADIUS() - 5 >= b.getPosx() && bala.getPosx() + bala.getRADIUS() - 5 <= b.getPosx() + 25)) {
                        if (isInBlockYB(b, bala.getPosy() + bala.getRADIUS() + bala.getDist())) {
                            if (b.getTipo() == 0) {
                                it.remove();

                            }
                            cont += 1;
                        }
                    }
                }
                break;
            case 2:
                for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                    Block b = it.next();
                    if ((bala.getPosy() >= b.getPosy() && bala.getPosy() <= b.getPosy() + 25) || (bala.getPosy() + bala.getRADIUS() - 5 >= b.getPosy() && bala.getPosy() + bala.getRADIUS() - 5 <= b.getPosy() + 25)) {
                        if (isInBlockXB(b, bala.getPosx() - bala.getDist())) {
                            if (b.getTipo() == 0) {
                                it.remove();

                            }
                            cont += 1;
                        }
                    }
                }
                break;
            case 3:
                for (Iterator<Block> it = bloques.iterator(); it.hasNext();) {
                    Block b = it.next();
                    if ((bala.getPosy() >= b.getPosy() && bala.getPosy() <= b.getPosy() + 25) || (bala.getPosy() + bala.getRADIUS() - 5 >= b.getPosy() && bala.getPosy() + bala.getRADIUS() - 5 <= b.getPosy() + 25)) {
                        if (isInBlockXB(b, bala.getPosx() + bala.getRADIUS() - 5 + bala.getDist())) {
                            if (b.getTipo() == 0) {
                                it.remove();

                            }
                            cont += 1;
                        }
                    }
                }
                break;
            default:
                break;
        }
        return cont;
    }

    private boolean isInBlockX(Block b, int posx) {
        return posx > b.getPosx() && posx < b.getPosx() + 25;

    }

    private boolean isInBlockY(Block b, int posy) {
        return posy > b.getPosy() && posy < b.getPosy() + 25;

    }

    private boolean isInBlockXB(Block b, int posx) {
        return posx >= b.getPosx() && posx <= b.getPosx() + 25;

    }

    private boolean isInBlockYB(Block b, int posy) {
        return posy >= b.getPosy() && posy <= b.getPosy() + 25;

    }

    //Getters and Setters
}
