package courbesRecursives;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class F4kSolution extends AbstractSolution {

    //    float[] hsbvals = { 0,0,0};
    //    hsbvals = Color.RGBtoHSB(0, 255, 0, hsbvals);
    //    for(int i=0 ; i<3 ;i++){
    //        System.out.println(hsbvals[i]);
    //    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        F4kSolution n = new F4kSolution(8);
    }

    F4kSolution(int n){
        super(n);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        int frameHeight = getSize().height; // taille du frame, cette fois avec les bordures
        int frameWidth = getSize().width;   
        g2d.setColor(Color.black);  // La couleur avec laquelle on va dessiner
        g2d.translate(frameWidth/2,3*frameHeight/4); //pour déplacer l'origine si besoin

        // mettre ici un appel de drawSolutionk avec une liste d'arguments adaptés, par exemple : 
        //drawSolutionk(g2d, frameWidth/20, frameHeight/20, frameWidth/4,profondeur);
        drawSolutionk(g2d,0,0,frameHeight/8,0);
    }

    @Override
    public void drawSolutionk(Graphics drawingArea, int... arg) {

        Graphics2D g2d = (Graphics2D) drawingArea;
        int x = arg[0];
        int y = arg[1];
        int longueur = arg[2];
        int depth = arg[3];


        if(depth != profondeur){

            if(depth <6){
                g2d.setColor(Color.BLACK);
            }
            else{
                g2d.setColor(Color.GREEN);
            }

            int echelle = 3*longueur/5;
            
            //Dessin de depart
            g2d.drawLine(x,y, x ,-longueur);
            g2d.drawLine(x, -longueur/2, -longueur/8, -3*longueur/4); // s1
            g2d.drawLine(x, -3*longueur/4, longueur/4, -longueur); // s2   

            //Permet la croissance vers le haut
            g2d.translate(x, -longueur);
            drawSolutionk(g2d,x,y,echelle,depth+1);

             //Permet la croissance vers le cote gauche
            g2d.translate(x,longueur);
            g2d.translate(-longueur/8, -3*longueur/4);
            g2d.rotate(Math.toRadians(-30));
            drawSolutionk(g2d,x,y,echelle,depth+1);

            //Permet la croissance vers le cote droit
            g2d.rotate(Math.toRadians(30));
            g2d.translate(longueur/8, 3*longueur/4);
            g2d.translate(longueur/4, -longueur);
            g2d.rotate(Math.toRadians(45));          
            drawSolutionk(g2d,x,y,echelle,depth+1);

            g2d.rotate(Math.toRadians(-45));
            g2d.translate(-longueur/4, longueur);       

        }


    }
}


