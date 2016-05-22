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
    final private String PATH_TANK="Imagenes/Tanques/tank";
    final private String EXT=".png";
    private final BufferedImage[][] img_tanques;
    
    //Constructor
    public Recursos() throws IOException
    {
        img_tanques = new BufferedImage[4][4];
        setImg_tanques();
    }
    
    //Metodos
    
    //Getters y setters

    public BufferedImage[][] getImg_tanques() {
        return img_tanques;
    }

    public void setImg_tanques() throws IOException {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                img_tanques[i][j]=ImageIO.read(new File(PATH_TANK+i+j+EXT));
            }
        }
    }
    
    
}
