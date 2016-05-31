/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Recursos {
    
    //Atributos
    private final String PATH_TANK="Imagenes/Tanques/tank";
    private final String PATH_MENUS="Imagenes/MenuOpciones/menu";
    private final String PATH_FONDOS="Imagenes/Fondos/fondo";
    private final String PATH_BLOQUES="Imagenes/Bloques/bloque";
    private final String EXT=".png";
    private final BufferedImage[][] img_tanques;
    private final BufferedImage[] img_menus;
    private final BufferedImage[] img_fondos;
    private final BufferedImage[] img_bloques;
    private final int num_tanques=4;
    private final int dirs_tanque=4;
    private final int num_menus=2;
    private final int num_fondos=2;
    private final int num_bloques=3;
    
    //Constructor
    public Recursos() throws IOException
    {
        img_tanques = new BufferedImage[num_tanques][dirs_tanque];
        img_menus = new BufferedImage[num_menus];
        img_fondos= new BufferedImage[num_fondos];
        img_bloques = new BufferedImage[num_bloques];
        setImg_tanques();
        setImg_menus();
        setImg_fondos();
        setImg_bloques();
    }
    
    //Metodos
    
    //Getters y setters

    public BufferedImage[][] getImg_tanques() {
        return img_tanques;
    }

    public void setImg_tanques() throws IOException {
        for (int i = 0; i < num_tanques; i++) {
            for (int j = 0; j < dirs_tanque; j++) {
                img_tanques[i][j]=ImageIO.read(new File(PATH_TANK+i+j+EXT));
            }
        }
    }

    public BufferedImage[] getImg_menus() {
        return img_menus;
    }

    public void setImg_menus() throws IOException {
        for (int i = 0; i < num_menus; i++) {
            img_menus[i]=ImageIO.read(new File(PATH_MENUS+i+EXT));
        }
    }

    public BufferedImage[] getImg_fondos() {
        return img_fondos;
    }

    public void setImg_fondos() throws IOException {
        for (int i = 0; i < num_fondos; i++) {
            img_fondos[i]=ImageIO.read(new File(PATH_FONDOS+i+EXT));
        }
    }

    public BufferedImage[] getImg_bloques() {
        return img_bloques;
    }

    public void setImg_bloques() throws IOException {
        for (int i = 0; i < num_bloques; i++) {
            img_bloques[i]=ImageIO.read(new File(PATH_BLOQUES+i+EXT));
        }
    }
    
    
}
