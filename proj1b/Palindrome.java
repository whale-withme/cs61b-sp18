// import java.util.ArrayDeque;
// import java.util.Deque;

public class Palindrome {
    
    public Deque<Character> wordToDeque(String word){
        Deque<Character> worDeque = new ArrayDeque<Character>();        /* Interface could't be instantiation */
        for(int i = word.length()-1; i >= 0; i--){
            worDeque.addFirst(word.charAt(i));
        }
        assert(worDeque != null);       /* Case null */
        return worDeque;
    }

    /* Use string  */
    // public boolean isPalindromechar(String word){
    //     boolean ispalind = true;
    //     for(int i = 0, j = word.length()-1; i != j; i++, j--){
    //         if(word.charAt(i) != word.charAt(j)){
    //             ispalind = false;
    //             break;
    //         }
    //     }
    //     return ispalind;
    // }

    /* Character equals */
    public boolean isPalindrome(String word){
        if(word == null)    return false;
        Deque<Character> senten = wordToDeque(word);        /* Use method name */
        boolean ispalind = true;
        // int i = senten.front()+1, j = senten.end()-1;
        // for(; i != j; i++, j--){
        //     if(!senten.Equal(i, j)){ ispalind = false; break;}
        // }
        while (senten.front() +2 != senten.end()) {
            char j = senten.removeLast();
            char i = senten.removeFirst();
            if(i != j )                    {ispalind = false; break;}
        }
        return ispalind;
    }

    /* Offbyone equals */
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word == null)        return false;
        Deque<Character> senten = wordToDeque(word);
        boolean ispalind = true;
        // for(int i = senten.front()+1, j = senten.end()-1; i != j; i++, j--){
        //     if(!cc.equalChars(senten.getIndex(i), senten.getIndex(j))){ ispalind = false; break;}
        // }
        while(senten.front() +2 != senten.end()){       /* One character exception */
            char i = senten.removeFirst(), j = senten.removeLast();
            if(!cc.equalChars(i, j))    { ispalind = false; break;}
        }
        return ispalind;
    }
}
