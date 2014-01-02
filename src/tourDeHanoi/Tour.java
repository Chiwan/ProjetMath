package tourDeHanoi;
import java.util.Stack;

public class Tour {
    
    private Stack<Disque> tour;
    
    public Stack<Disque> getTour() {
        return tour;
    }
    
    public Tour(){
        tour= new Stack<Disque>();
    }
    
    public void move(Tour t){
        t.push(this.tour.pop());
    }
    
    public void push(Disque d){
        this.tour.push(d);
    }
    public int getHauteur() {
        return tour.size();
    }

    public boolean isEmpty(){
        return tour.isEmpty();
    }
    
    public int getLargeur() {
        if(tour.isEmpty()) return 1;
        return 2*tour.get(0).getTaille()-1;
    }
    
    public String getStringLine(int n,int largeur) {
        String toRet = "";
        if(n>getHauteur()-1) {
            for(int i = 0; i < (largeur-1)/2 ; i++) {
                toRet+=" ";
            }
            toRet+="|";
            for(int i = 0; i < (largeur-1)/2 ; i++) {
                toRet+=" ";
            }
        }
        else {
            for(int i = 0; i < (largeur-(2*this.tour.get(n).getTaille()-1))/2 ; i++) {
                toRet+=" ";
            }
            toRet+=this.tour.get(n).getStringDisque();
            for(int i = 0; i < (largeur-(2*this.tour.get(n).getTaille()-1))/2 ; i++) {
                toRet+=" ";
            }
        }
        return toRet;
    }

    

}
