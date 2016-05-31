/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

    //Atributos
    public int posx;
    public int posy;
    public int direction;
    private final int RADIUS = 10;
    private int distx;
    private int disty;
    public boolean traveling;
    private final Color color = Color.YELLOW;
    private final int dist = 3;
    private int bound;

    //Constructor
    public Bullet(int posx, int posy, int bound) {
        this.posx = posx;
        this.posy = posy;
        this.distx = 0;
        this.disty = 0;
        this.direction = -1;
        this.traveling = false;
        this.bound = bound;
    }

    //Metodos
    public void draw(Graphics g) {
        g.setColor(color);
        if (direction == 0 || direction == 1) {
            g.fillOval(posx, posy, RADIUS - 5, RADIUS);
        } else if (direction == 2 || direction == 3) {
            g.fillOval(posx, posy, RADIUS, RADIUS - 5);
        }
    }

    public void reset() {
        setPosx(0);
        setPosy(0);
        direction = -1;
        bound = -1;
    }

    public void travel(Graphics g) {
        switch (direction) {
            case 0:
                distx = 0;
                disty = -dist;
                break;
            case 1:
                distx = 0;
                disty = dist;
                break;
            case 2:
                distx = -dist;
                disty = 0;
                break;
            case 3:
                distx = dist;
                disty = 0;
                break;
        }
        posx = posx + distx;
        posy = posy + disty;
        switch (direction) {
            case 0:
                if (posy < bound) {
                    traveling = false;
                    reset();
                }
                break;
            case 1:
                if (posy > bound) {
                    traveling = false;
                    reset();
                }
                break;
            case 2:
                if (posx < bound) {
                    traveling = false;
                    reset();
                }
                break;
            case 3:
                if (posx > bound) {
                    traveling = false;
                    reset();
                }
                break;
        }
        draw(g);

    }
    //getters y setters

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

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

}
