/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertankbattle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.*;


public class Recursos {
    
    //Atributos
    private final String PATH_TANK="Imagenes/Tanques/tank";
    private final String PATH_MENUS="Imagenes/MenuOpciones/menu";
    private final String PATH_FONDOS="Imagenes/Fondos/fondo";
    private final String PATH_BLOQUES="Imagenes/Bloques/bloque";
    private final String PATH_MISC="Imagenes/Misc/misc";
    private final String PATH_NUMEROS="Imagenes/Misc/Numbers/number";
    private final String PATH_MUSICA="Sonidos/zizibum.wav";
    private final String EXT=".png";
    private final BufferedImage[][] img_tanques;
    private final BufferedImage[] img_menus;
    private final BufferedImage[] img_fondos;
    private final BufferedImage[] img_bloques;
    private final BufferedImage[] img_misc;
    private final BufferedImage[] img_nums;
    private final Clip ambiente;
    private final int num_tanques=4;
    private final int dirs_tanque=4;
    private final int num_menus=2;
    private final int num_fondos=3;
    private final int num_bloques=3;
    private final int num_misc=9;
    private final int num_numeros=20;
    
    //Constructor
    public Recursos() throws IOException, UnsupportedAudioFileException, LineUnavailableException
    {
        img_tanques = new BufferedImage[num_tanques][dirs_tanque];
        img_menus = new BufferedImage[num_menus];
        img_fondos= new BufferedImage[num_fondos];
        img_bloques = new BufferedImage[num_bloques];
        img_misc= new BufferedImage[num_misc];
        img_nums = new BufferedImage[num_numeros];
        ambiente = AudioSystem.getClip();
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(PATH_MUSICA));
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        ambiente.open(audioStream);
        setImg_tanques();
        setImg_menus();
        setImg_fondos();
        setImg_bloques();
        setImg_misc();
        setImg_nums();
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
    
    public BufferedImage[] getImg_misc() {
        return img_misc;
    }

    public void setImg_misc() throws IOException {
        for (int i = 0; i < num_misc; i++) {
            img_misc[i]=ImageIO.read(new File(PATH_MISC+i+EXT));
        }
    }
    
    public BufferedImage[] getImg_nums() {
        return img_nums;
    }

    public void setImg_nums() throws IOException {
        for (int i = 0; i < num_numeros; i++) {
            img_nums[i]=ImageIO.read(new File(PATH_NUMEROS+(i+1)+EXT));
        }
    }

    public Clip getAmbiente() {
        return ambiente;
    }
    
    
    
}
