package SecondHMW.Polynomial;

public class PolyIterator {
    PolyNode current;
    PolyIterator(PolyNode current){
        this.current = current;
    }

    public boolean isEnd(){
        return current == null;
    }

    public String retrieve(){
        return isEnd()? null : current.item;
    }

    public void advance(){
        if(!isEnd()) current = current.next;
    }
}
