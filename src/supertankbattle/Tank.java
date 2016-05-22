/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;

public class Tank {

    //Atributos
    private BufferedImage image;
    private String path;
    public int tipo;
    public int direction; //0: arriba, 1: abajo, 2: izquierda, 3: derecha
    public int posx;
    public int posy;
    public Bullet[] balas;
    final private int dist = 3;
    private final int MAX_BULLETS = 5;
    private int previous_direction;
    //private Graphics2D g2d;

    //Constructor
    public Tank(int tipo, int posx, int posy, int direction, BufferedImage image) throws IOException {
        this.tipo = tipo;
        this.posx = posx;
        this.posy = posy;
        this.direction = direction;
        this.image = image;
        this.previous_direction = 0;
        setBalas(MAX_BULLETS);
    }

    //Metodos
    public boolean canShoot() {
        for (int i = 0; i < MAX_BULLETS; i++) {
            if (!balas[i].traveling) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g) {

        g.drawImage(image, posx, posy, null);
        for (int i = 0; i < MAX_BULLETS; i++) {
            if (balas[i].traveling) {
                balas[i].travel(g);
            }
        }

    }

    public void move_up(int ubound) throws IOException {
        previous_direction = direction;
        direction = 0;
        if (posy - dist > ubound) {
            posy = posy - dist;
        }
    }

    public void move_down(int dbound) throws IOException {
        previous_direction = direction;
        direction = 1;
        if (posy + image.getHeight() + dist < dbound) {
            posy = posy + dist;
        }

    }

    public void move_left(int lfbound) throws IOException {
        previous_direction = direction;
        direction = 2;
        if (posx - dist > lfbound) {
            posx = posx - dist;
        }

    }

    public void move_right(int rbound) throws IOException {
        previous_direction = direction;
        direction = 3;
        if (posx + image.getWidth() + dist < rbound) {
            posx = posx + dist;
        }
    }

    public void shoot(int bound) {
        for (int i = 0; i < MAX_BULLETS; i++) {
            if (!balas[i].traveling) {
                balas[i].setDirection(direction);
                balas[i].setBound(bound);
                
                switch (direction) {
                    case 0:
                        balas[i].setPosx(posx + image.getWidth() / 2);
                        balas[i].setPosy(posy);
                        break;
                    case 1:
                        balas[i].setPosx(posx + image.getWidth() / 2);
                        balas[i].setPosy(posy + image.getHeight());
                        break;
                    case 2:
                        balas[i].setPosx(posx);
                        balas[i].setPosy(posy + image.getHeight() / 2);
                        break;
                    case 3:
                        balas[i].setPosx(posx + image.getWidth());
                        balas[i].setPosy(posy + image.getHeight() / 2);
                        break;
                }
                balas[i].traveling = true;
                break;
            }
        }

    }

    public boolean directionChanged() {
        return (direction != previous_direction);
    }

    //Getters y setters
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Bullet[] getBalas() {
        return balas;
    }

    public void setBalas(int cantidad) {
        this.balas = new Bullet[cantidad];
        for (int i = 0; i < cantidad; i++) {
            this.balas[i] = new Bullet(posx + image.getWidth() / 2, posy, -1);
        }
    }

    public int getPrevious_direction() {
        return previous_direction;
    }

}
