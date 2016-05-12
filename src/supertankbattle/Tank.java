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
    final private int dist=3;
    private final int MAX_BULLETS=5;
    private int shots_fired;
    //private Graphics2D g2d;

    
    //Constructor
    public Tank(int tipo, int posx, int posy,int direction,BufferedImage image) throws IOException
    {
        this.tipo=tipo;
        this.posx=posx;
        this.posy=posy;
        this.direction=direction;
        this.image=image;
        this.shots_fired=0;
        setBalas(MAX_BULLETS);
    }
    
    //Metodos
    
    public void draw(Graphics g)
    {
        g.drawImage(image, posx, posy,null);  
    }
    
    public void move_up(int ubound) throws IOException
    {
        direction=0;
        if(posy-dist>ubound)
        {
            posy=posy-dist;
        }
    }
    public void move_down(int dbound) throws IOException
    {
        direction=1;
        if(posy+image.getHeight()+dist<dbound)
        {
            posy=posy+dist;
        }
        
    }
    public void move_left(int lfbound) throws IOException
    {
        direction=2;
        if(posx-dist>lfbound)
        {
            posx=posx-dist;
        }
        
    }
    public void move_right(int rbound) throws IOException
    {
        direction=3;
        if(posx+image.getWidth()+dist<rbound)
        {
            posx=posx+dist;
        }
    }
    
    public void shoot(int bound, Graphics g)
    {
        if(shots_fired<=MAX_BULLETS){
            shots_fired=shots_fired+1;
            balas[shots_fired-1].travel(direction, bound,g);
        }
    }
    
    //Getters y setters

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image){   
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
        this.balas= new Bullet[cantidad];
        for (int i = 0; i < cantidad; i++) {
            this.balas[i]= new Bullet();
            this.balas[i].setPosx(posx+image.getWidth()/2);
            this.balas[i].setPosy(posy);
        }
    }

    public int getShots_fired() {
        return shots_fired;
    }

    public void setShots_fired(int shots_fired) {
        this.shots_fired = shots_fired;
    }
    
    
    
    
}
