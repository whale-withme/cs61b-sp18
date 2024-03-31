public class OffByN implements CharacterComparator{
    int step;
    
    public OffByN(int N)    { step = N;}

    @Override
    public boolean equalChars(char x, char y){
        
        if((x - y == step) || (y - x == step))  return true;
        else                                    return false;
    }
}
