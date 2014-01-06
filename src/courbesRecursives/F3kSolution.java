package courbesRecursives;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class F3kSolution extends AbstractSolution{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        F3kSolution n = new F3kSolution(3);
    }

    F3kSolution(int n){
        super(n);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        int frameHeight = getSize().height; // taille du frame, cette fois avec les bordures
        int frameWidth = getSize().width;   
        g2d.setColor(Color.black);  // La couleur avec laquelle on va dessiner
        g2d.translate(frameWidth/4,frameHeight/4); //pour déplacer l'origine si besoin

        // mettre ici un appel de drawSolutionk avec une liste d'arguments adaptés, par exemple : 
        //drawSolutionk(g2d, frameWidth/20, frameHeight/20, frameWidth/4,profondeur);
        drawSolutionk(g2d,0,0,frameHeight/8,0,0);
    }

    @Override
    public void drawSolutionk(Graphics drawingArea, int... arg) {
        // TODO Auto-generated method stub
        int x= arg[0];
        int y = arg[1];
        int cote = arg[2];
        int depth = arg[3];
        int cas = arg[4];

        if(depth!=profondeur){         
            drawingArea.drawRect(arg[0], arg[1], arg[2], arg[2]);
            switch(cas){
                case 0 : // cas initial
                    drawSolutionk(drawingArea,x+cote/2,y+ cote,cote/2,depth+1,1); //vers le bas
                    drawSolutionk(drawingArea,x+cote, y, cote/2,depth+1,2); // vers la droite
                    drawSolutionk(drawingArea,x-cote/2, y+cote/2, cote/2,depth+1,3); // vers la gauche
                    drawSolutionk(drawingArea,x, y-cote/2, cote/2, depth+1,4); // vers le haut
                    break;
                case 1 : //cas dans le deplacement vers le bas
                    drawSolutionk(drawingArea,x+cote/2,y+ cote,cote/2,depth+1,1); //vers le bas
                    drawSolutionk(drawingArea,x+cote, y, cote/2,depth+1,2); // vers la droite
                    drawSolutionk(drawingArea,x-cote/2, y+cote/2, cote/2,depth+1,3); // vers la gauche
                    break;
                case 2 : //cas dans le deplacement vers la droite
                    drawSolutionk(drawingArea,x+cote/2,y+ cote,cote/2,depth+1,1); //vers le bas
                    drawSolutionk(drawingArea,x+cote, y, cote/2,depth+1,2); // vers la droite
                    drawSolutionk(drawingArea,x, y-cote/2, cote/2, depth+1,4); // vers le haut
                    break;
                case 3 : //cas dans le deplacement vers la gauche
                    drawSolutionk(drawingArea,x+cote/2,y+ cote,cote/2,depth+1,1); //vers le bas
                    drawSolutionk(drawingArea,x-cote/2, y+cote/2, cote/2,depth+1,3); // vers la gauche
                    drawSolutionk(drawingArea,x, y-cote/2, cote/2, depth+1,4); // vers le haut
                    break;
                case 4 : //cas dans le deplacement vers le haut
                    drawSolutionk(drawingArea,x+cote, y, cote/2,depth+1,2); // vers la droite
                    drawSolutionk(drawingArea,x-cote/2, y+cote/2, cote/2,depth+1,3); // vers la gauche
                    drawSolutionk(drawingArea,x, y-cote/2, cote/2, depth+1,4); // vers le haut
                    break;
            }
        }
        
    }
}
