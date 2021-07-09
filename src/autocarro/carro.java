package autocarro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class carro extends JPanel implements Runnable {
    
    
    Thread thread;
    int movimentX = 0;
    int insideObjectMovement = 0;
    float angulo = 0;
    boolean flagInsideObjectMovement = true;
    AffineTransform at;
    

    public carro() 
    {
       thread = new Thread(this);
       thread.start();
        
    }
    

    public void paint (Graphics g ) 
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
            at = new AffineTransform();

        at.translate(movimentX, 0);
        g2d.setTransform(at);
        g2d.setColor(Color.GRAY);
        
        //Desenhar o carro
        g2d.fillRect(100, 45, 150, 75);
        g2d.fillRect(100, 120, 200, 75);
        
        // desenhar a janela
        g2d.setColor(Color.WHITE);
        g2d.fillRect(120, 60, 45, 45);
        
        //desenhar porta
        g2d.fillRect(175, 60, 45, 120);
        
        //janela que vai se movimentar
        g2d.setColor(Color.BLUE);
        g2d.fillRect(130 + insideObjectMovement, 60, 22, 45);
        
       // desenhar as rodas
        
        g2d.setColor(Color.BLACK);
        float dash1[] = {10.0f};
        BasicStroke dashed = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        g2d.setStroke(dashed); // faz os tracejados
    
        
        at = new AffineTransform();
        at.translate(movimentX, 0);
        at.rotate(Math.toRadians(angulo), 145, 220);
        g2d.setTransform(at);
        g2d.drawOval(120, 195, 50, 50); // 1 roda
        
        
        
        at = new AffineTransform();
        at.translate(movimentX, 0);
        at.rotate(Math.toRadians(angulo), 225, 220);
        g2d.setTransform(at);
        g2d.drawOval(200, 195, 50, 50); // 2 roda
        
       
        
        
    }
    public void run() {
        try {
            while (true) {
                this.movimentX += 1;
                
                if (this.movimentX > getSize().width) {
                    this.movimentX = -300;//tamanho do carro
                }
                
                
                //movimento da janela
                if (flagInsideObjectMovement) {
                    this.insideObjectMovement = this.insideObjectMovement + 1;
                    if (this.insideObjectMovement > 10) {
                        this.flagInsideObjectMovement = false;
                    }
                } else {
                    this.insideObjectMovement = this.insideObjectMovement - 1;
                    if (this.insideObjectMovement < 0) {
                        this.flagInsideObjectMovement = true;
                    }
                }
                
                
                angulo += 1;
                super.repaint();
                thread.sleep(20);
            }
        } catch (Exception e) {
            System.err.println("S");
        }
    }    
}
