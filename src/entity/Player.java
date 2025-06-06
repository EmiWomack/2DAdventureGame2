/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import pkg2dadventuregame.GamePanel;
import pkg2dadventuregame.KeyHandler;

/**
 *
 */
public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH){
        
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        
        x = 100;
        y = 100;
        speed = 4; 
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/rightWalking1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/rightWalking2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/downWalking1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/downWalking2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/leftWalking1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/leftWalking2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/upWalking1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/upWalking2.png"));
                        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        //in java the upper left corner is X=0 Y=0
        //x values increase to the right
        //y values increase as they go down
        
        if (keyH. upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true){
            
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }
        else if (keyH.downPressed == true){
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }
        else if (keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
        
        //every 12 frames the image changes
        spriteCounter++;
        if(spriteCounter > 12){
             if(spriteNum == 1){
                spriteNum = 2;
            }
             else if(spriteNum ==2){
                 spriteNum = 1;
             }
             spriteCounter = 0;
        }
       
            
       }

    }
    public void draw(Graphics2D g2){
        
    //    g2.setColor(Color.white);
    //    g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    
    BufferedImage image = null;
    
    switch(direction){
        case "up": 
            if(spriteNum == 1){
                image = up1;
            }
            if (spriteNum  == 2){
                image = up2;
            }
            break;
        case "down":
            if(spriteNum == 1){
                image = down1;
            }
            if (spriteNum  == 2){
                image = down2;
            }
            break;
        case "left":
            if(spriteNum == 1){
                image = left1;
            }
            if (spriteNum  == 2){
                image = left2;
            }
            break;
        case "right":
            if(spriteNum == 1){
                image = right1;
            }
            if (spriteNum  == 2){
                image = right2;
            }
            break;   
    }
    
    g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    
    
    }
}
