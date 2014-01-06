package courbesRecursives;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class FkSolution extends AbstractSolution{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FkSolution n = new FkSolution(6);
    }
    
    FkSolution(int n){
        super(n);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        int frameHeight = getSize().height; // taille du frame, cette fois avec les bordures
        int frameWidth = getSize().width;   
        g2d.setColor(Color.black);  // La couleur avec laquelle on va dessiner
        //g2d.translate(frameWidth/2,frameHeight/2); //pour déplacer l'origine si besoin

        // mettre ici un appel de drawSolutionk avec une liste d'arguments adaptés, par exemple : 
        //drawSolutionk(g2d, frameWidth/20, frameHeight/20, frameWidth/4,profondeur);
        drawSolutionk(g2d,frameHeight/4,frameHeight/4,frameHeight/4,0);
    }
    @Override
    public void drawSolutionk(Graphics drawingArea, int... arg) {
        // TODO Auto-generated method stub
        int x= arg[0];
        int y = arg[1];
        int rayon = arg[2];
        int depth = arg[3];
        if(depth!=profondeur){
            //drawingArea.drawOval(x, y, rayon, rayon);
            drawingArea.setColor(Color.PINK);
            drawingArea.fillOval(x, y, rayon, rayon);
            
            drawSolutionk(drawingArea,x+rayon/4,y+ rayon,rayon/2,depth+1);
            drawSolutionk(drawingArea,x+rayon, y+rayon/4, rayon/2,depth+1);
            
       }
    }

}
