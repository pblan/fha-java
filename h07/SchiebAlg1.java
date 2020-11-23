/**
 * Lösungsalgorithmus der das Schiebepuzzle löst, indem er zufällig Plättchen verschiebt
 */
public class SchiebAlg1 implements Loesungsalgorithmus {
    /**
     * Schiebt solange zufällig bis das Plättchen mit der Nummer 1 auf der richtigen Position ist
     */
    public int loese(Schiebepuzzle sp){
        int nrSteps=0;
        while(2!=sp.getFeld()[0].x+sp.getFeld()[0].y){    
            nrSteps++;
            sp.schiebe((int)sp.getLegalMoves().get((int)Math.floor(sp.getLegalMoves().size()*Math.random())));
        }
        return nrSteps;
    }
}
