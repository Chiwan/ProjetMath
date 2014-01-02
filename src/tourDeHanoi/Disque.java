package tourDeHanoi;


public class Disque {

    private int taille;
    
    public Disque(int n){
        this.taille=n;
    }
    
    public String getStringDisque() {
        String toRet = "";
        for(int i = 0 ; i < 2*taille-1;i++) {
            toRet +="_";
        }
        return toRet;
    }
    
    public String toString(){
        String s = "";
        for(int i = 0; i<=taille; i++)
            s+="-";
        return s;
        
    }

    public int getTaille() {
        return taille;
    }
    
}
