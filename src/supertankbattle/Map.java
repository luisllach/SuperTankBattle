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
    private final int alto=625;
    private final int ancho=600;
    private ArrayList<Block> bloques;
    
    //Constructor
    public Map(){
        bloques = new ArrayList<>();
    }
    
    //Metodos
    public void setMapa(int nivel, BufferedImage img_bloques[]){
        int y;
        switch (nivel){
            case 1:
                //y=25
                //y=50
                //y=75
                y=75;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(250,y,img_bloques[0]));
                bloques.add(new Block(275,y,img_bloques[0]));
                bloques.add(new Block(300,y,img_bloques[0]));
                bloques.add(new Block(325,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=100
                y=100;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(250,y,img_bloques[0]));
                bloques.add(new Block(275,y,img_bloques[0]));
                bloques.add(new Block(300,y,img_bloques[0]));
                bloques.add(new Block(325,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=125
                y=125;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=150
                y=150;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=175
                y=175;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(250,y,img_bloques[0]));
                bloques.add(new Block(275,y,img_bloques[0]));
                bloques.add(new Block(300,y,img_bloques[0]));
                bloques.add(new Block(325,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=200
                y=200;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(250,y,img_bloques[0]));
                bloques.add(new Block(275,y,img_bloques[0]));
                bloques.add(new Block(300,y,img_bloques[0]));
                bloques.add(new Block(325,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=225
                y=225;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=250
                y=250;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(275,y,img_bloques[1]));
                bloques.add(new Block(300,y,img_bloques[1]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=275
                y=275;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(225,y,img_bloques[0]));
                bloques.add(new Block(250,y,img_bloques[0]));
                bloques.add(new Block(275,y,img_bloques[1]));
                bloques.add(new Block(300,y,img_bloques[1]));
                bloques.add(new Block(325,y,img_bloques[0]));
                bloques.add(new Block(350,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                //y=275
                y=300;
                bloques.add(new Block(50,y,img_bloques[0]));
                bloques.add(new Block(75,y,img_bloques[0]));
                bloques.add(new Block(150,y,img_bloques[0]));
                bloques.add(new Block(175,y,img_bloques[0]));
                bloques.add(new Block(225,y,img_bloques[0]));
                bloques.add(new Block(250,y,img_bloques[0]));
                bloques.add(new Block(325,y,img_bloques[0]));
                bloques.add(new Block(350,y,img_bloques[0]));
                bloques.add(new Block(400,y,img_bloques[0]));
                bloques.add(new Block(425,y,img_bloques[0]));
                bloques.add(new Block(500,y,img_bloques[0]));
                bloques.add(new Block(525,y,img_bloques[0]));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
    
    public void draw(Graphics g){
        for (Block b : bloques) {
            g.drawImage(b.getImage(), b.getPosx(), b.getPosy(), null);
        }
    }
    
    //Getters and Setters
    
}
