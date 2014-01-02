package tourDeHanoi;

public class JeuHanoi {

    public static void main(String args[]) {
        JeuHanoi j = new JeuHanoi();
        j.lancementJeu(5);
    }
    
    private Tour t1;
    private Tour t2;
    private Tour t3;
    private int nbr;
    
    public JeuHanoi(){
        t1 = new Tour();
        t2 = new Tour();
        t3 = new Tour();
        nbr = 0;
    }
    
    public void lancementJeu(int n){
        nbr = n;
        for(int i=n; i>0;i--)
           t1.push(new Disque(i));
        
        //hanoi(n,t1,t3,t2);
        
        System.out.println("############################## ITERATIF ####################");
        drawScene();
        hanoiIteratif2(n,t1,t3,t2);
    }
    
    public void hanoi(int n, Tour depart, Tour arrivee, Tour intermediaire){
        if(n!=0){
            hanoi(n-1,depart,intermediaire,arrivee);
            this.deplacer(depart,arrivee);
            hanoi(n-1,intermediaire,arrivee,depart);
        }         
    }
    
    private void deplacer(Tour depart,Tour arrivee) {
        if(depart.getTour().size()!=0){
            depart.move(arrivee);
            this.drawScene();
        }
    }

    
    
    public void hanoiIteratif2(int n, Tour depart,Tour arrivee, Tour intermediaire){
        int i = 0;
        int hauteur = depart.getHauteur();
        if(n%2==0)
            while(arrivee.getHauteur()!= hauteur){
                deplacementPetit(i,depart,arrivee,intermediaire);
                deplacementAutre(i,depart,arrivee,intermediaire);
                i++;
            }
        else{
            while(arrivee.getHauteur()!= hauteur){
                deplacementPetit(i,depart,intermediaire,arrivee);
                deplacementAutre(i,depart,intermediaire,arrivee);
                i++;
            }
        }
    }
    

    
    
    private void deplacementPetit(int i,Tour depart, Tour arrivee, Tour intermediaire) {
        // TODO Auto-generated method stub
        switch(i%3){
            case 0 :
                deplacer(depart,intermediaire);
                break;
            case 1 :
                deplacer(intermediaire,arrivee);
                break;
            case 2 :
                deplacer(arrivee,depart);
                break;
        }
    }

    private void deplacementAutre(int n,Tour depart, Tour arrivee, Tour intermediaire) {
        // TODO Auto-generated method stub
        boolean b= false;
        System.out.println(n);
        switch(n%6){
            case 0 :
                deplacer(depart,arrivee);
                break;
            case 1 :
                deplacer(depart,intermediaire);
                break;
            case 2 :
                deplacer(arrivee,intermediaire);
                break;
            case 3 :
                deplacer(depart,arrivee);
                break;
            case 4 :
                deplacer(intermediaire,depart);
                break;
            case 5 :
                if(b=true){
                    deplacer(intermediaire,arrivee);
                    //b=false;
                }
                else{
                    deplacer(arrivee,intermediaire);
                    b=true;
                }
                break;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public void hanoiIteratif(int n, Tour depart, Tour arrivee, Tour intermediaire){
        int [] pairTab = { 3 , 2 , 1};
        int [] impairTab = { 2 ,3 , 1};
        //int stop = (int)Math.pow(2, n)-1;
        int index = 0;
        int hauteur = t1.getHauteur();
    while(t3.getHauteur() == hauteur) {
        boolean petit = true;
        if(petit){
            if(n%2==0){ // pair
                switch(pairTab[index%3]) {
                    case 1:
                        getTourDuPetit().move(t1);
                        break;
                    case 2:
                        getTourDuPetit().move(t2);
                        break;
                    case 3:
                        getTourDuPetit().move(t3);
                        break;
                }
            }
            else { // impair
                switch(impairTab[index%3]) {
                    case 1:
                        getTourDuPetit().move(t1);
                        break;
                    case 2:
                        getTourDuPetit().move(t2);
                        break;
                    case 3:
                        getTourDuPetit().move(t3);
                        break;
                }
            }
            index++;
            petit=false;
        }
        else{
            getTourDuMoyen().move(getTourduGrand());
            petit=true;
        }
    }
    }
    
    private Tour getTourDuPetit() {
        Tour petit = t1;
        int tailleT1,tailleT2,tailleT3;
        if(t1.getHauteur()>0)
            tailleT1 = t1.getTour().get(t1.getTour().size()-1).getTaille();
        else tailleT1 = nbr+1;
        if(t1.getHauteur()>0)
            tailleT2 = t2.getTour().get(t2.getTour().size()-1).getTaille();
        else tailleT2 = nbr+1;
        if(t3.getHauteur()>0)
            tailleT3 = t3.getTour().get(t3.getTour().size()-1).getTaille();
        else tailleT3 = nbr+1;
        if(tailleT2 < petit.getTour().get(petit.getTour().size()-1).getTaille()) {
            petit=t2;
        }
        if(tailleT3 < petit.getTour().get(petit.getTour().size()-1).getTaille()) {
            petit=t3;
        }
        return petit;
    }
    
    private Tour getTourduGrand() {
        Tour grand = t1;
        int tailleT1,tailleT2,tailleT3;
        if(t1.getHauteur()>0)
            tailleT1 = t1.getTour().get(t1.getTour().size()-1).getTaille();
        else tailleT1 = nbr+1;
        if(t1.getHauteur()>0)
            tailleT2 = t2.getTour().get(t2.getTour().size()-1).getTaille();
        else tailleT2 = nbr+1;
        if(t3.getHauteur()>0)
            tailleT3 = t3.getTour().get(t3.getTour().size()-1).getTaille();
        else tailleT3 = nbr+1;
        if(t2.getTour().get(t2.getTour().size()-1).getTaille() > grand.getTour().get(grand.getTour().size()-1).getTaille()) {
            grand=t2;
        }
        if(t3.getTour().get(t3.getTour().size()-1).getTaille() > grand.getTour().get(grand.getTour().size()-1).getTaille()) {
            grand=t3;
        }
        return grand;
    }
    
    private Tour getTourDuMoyen() {
        Tour moyen = null;
        int tailleT1,tailleT2,tailleT3;
        if(t1.getHauteur()>0)
            tailleT1 = t1.getTour().get(t1.getTour().size()-1).getTaille();
        else tailleT1 = nbr+1;
        if(t1.getHauteur()>0)
            tailleT2 = t2.getTour().get(t2.getTour().size()-1).getTaille();
        else tailleT2 = nbr+1;
        if(t3.getHauteur()>0)
            tailleT3 = t3.getTour().get(t3.getTour().size()-1).getTaille();
        else tailleT3 = nbr+1;
        if(tailleT1 > tailleT2 && tailleT1 < tailleT3) moyen = t1;
        if(tailleT1 < tailleT2 && tailleT1 > tailleT3) moyen = t1;
        if(tailleT2 > tailleT1 && tailleT2 < tailleT3) moyen = t2;
        if(tailleT2 < tailleT1 && tailleT2 > tailleT3) moyen = t2;
        if(tailleT3 > tailleT1 && tailleT3 < tailleT2) moyen = t3;
        if(tailleT3 < tailleT1 && tailleT3 > tailleT2) moyen = t3;
        return moyen;
    }
    
    
    private void drawScene() {
        int hauteurMax = this.hauteurMax();
        int largeurMax = this.largeurMax();
        for(int i = nbr-1 ; i >= 0; i--) {
            System.out.print(" ");
            System.out.print(t1.getStringLine(i,largeurMax));
            System.out.print(" ");
            System.out.print(t2.getStringLine(i,largeurMax));
            System.out.print(" ");
            System.out.print(t3.getStringLine(i,largeurMax));
            System.out.print(" ");
            System.out.println("");
        }
        for(int i = 0; i < 3*largeurMax+4; i++) {
            System.out.print("#");
        }
        System.out.println("");
    }
    
    private int hauteurMax() {
        int toRet = 0;
        if(t1.getHauteur()> toRet) toRet = t1.getHauteur();
        if(t2.getHauteur()> toRet) toRet = t2.getHauteur();
        if(t3.getHauteur()> toRet) toRet = t3.getHauteur();
        return toRet;
    }
    
    private int largeurMax() {
        int toRet = 0;
        if(t1.getLargeur()> toRet) toRet = t1.getLargeur();
        if(t2.getLargeur()> toRet) toRet = t2.getLargeur();
        if(t3.getLargeur()> toRet) toRet = t3.getLargeur();
        return toRet;
    }
}
