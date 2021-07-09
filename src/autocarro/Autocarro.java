package autocarro;

import javax.swing.JFrame;

public class Autocarro {

    public static void main(String[] args) throws InterruptedException {
       JFrame frame = new JFrame();
        carro x = new carro();
        
        
        frame.setSize(500, 500);
        x.setSize(500, 500);
        
       
       // x.setBackground(Color.BLACK);
        
        frame.setVisible(true);
        x.setVisible(true);
        
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(x);
        
        
    }
    
}
