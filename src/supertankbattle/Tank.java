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
    private final int dist = 1;
    private final int MAX_BULLETS = 1;
    private int previous_direction;
    private int bullet_offsetX;
    private int bullet_offsetY;
    //private Graphics2D g2d;

    //Constructor
    public Tank(int tipo, int posx, int posy, int direction, BufferedImage image) throws IOException {
        this.tipo = tipo;
        this.posx = posx;
        this.posy = posy;
        this.direction = direction;
        this.image = image;
        this.previous_direction = 0;
        setBullet_offsetX(direction);
        setBullet_offsetY(direction);
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
                        balas[i].setPosx(posx + (image.getWidth() / 2) - bullet_offsetX);
                        balas[i].setPosy(posy);
                        break;
                    case 1:
                        balas[i].setPosx(posx + (image.getWidth() / 2) - bullet_offsetX);
                        balas[i].setPosy(posy + image.getHeight()-balas[i].getRADIUS());
                        break;
                    case 2:
                        balas[i].setPosx(posx);
                        balas[i].setPosy(posy + (image.getHeight() / 2) - bullet_offsetY);
                        break;
                    case 3:
                        balas[i].setPosx(posx + image.getWidth()-balas[i].getRADIUS());
                        balas[i].setPosy(posy + (image.getHeight() / 2) - bullet_offsetY);
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
    
    public void AI(){
        
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
            this.balas[i] = new Bullet(posx + (image.getWidth() / 2)-bullet_offsetX, posy, -1);
        }
    }

    public int getPrevious_direction() {
        return previous_direction;
    }

    public int getBullet_offsetX() {
        return bullet_offsetX;
    }

    public void setBullet_offsetX(int tanque_tipo) {
        switch (tanque_tipo) {
            case 0:
                this.bullet_offsetX=2;
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;

        }
    }

    public int getBullet_offsetY() {
        return bullet_offsetY;
    }

    public void setBullet_offsetY(int tanque_tipo) {
        switch (tanque_tipo) {
            case 0:
                this.bullet_offsetY=3;
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;

        }
    }

    public int getDist() {
        return dist;
    }

    public int getMAX_BULLETS() {
        return MAX_BULLETS;
    }
    
    
    
    

}
