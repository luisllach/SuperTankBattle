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
    private final int RADIUS=10;
    private int distx;
    private int disty;
    private final Color color = Color.YELLOW;
    
    
    //Constructor
    
    public Bullet(){
        this.distx=0;
        this.disty=0;
        
    }
    
    //Metodos
    public void draw(Graphics g){
        g.drawOval(posx, posy, RADIUS, RADIUS);
    }
    
    public void travel(int direction, int bound,Graphics g) {
        switch (direction){
            case 0:
                distx=0;
                disty=-1;
                break;
            case 1:
                distx=0;
                disty=1;
                break;
            case 2:
                distx=-1;
                disty=0;
                break;
            case 3:
                distx=1;
                disty=0;
                break;
        }
        Thread move = new Thread(){
            public void Run(){
                posx=posx+distx;
                posy=posy+disty;
                draw(g);
            }
        };
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
    
}
