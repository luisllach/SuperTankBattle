/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.image.BufferedImage;


public class Block {
    
    //Atributos
    private int posx;
    private int posy;
    private BufferedImage image;
    
    //Constructor
    public Block(int posx, int posy, BufferedImage image){
        this.posx = posx;
        this.posy = posy;
        this.image = image;
        
    }
    
    //Metodos
    
    //Getters and Setters

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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
}
