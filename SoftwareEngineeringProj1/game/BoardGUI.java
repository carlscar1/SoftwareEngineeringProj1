package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoardGUI {
    public static void main(String[] args) throws IOException {

        File file = new File("src/BoardImage.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new FlowLayout());
        
        jFrame.setSize(835, 845);
        JLabel jLabel = new JLabel();

        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}