import java.util.Random;

public class Utiles {
   public static char generateRandomChar(char lastLetter){
        Random generator = new Random();
        int firstLetter = (int)'a';
        int newLetter = (char) generator.nextInt(lastLetter-'a'+1);

       return (char)(firstLetter+newLetter);
    }

    public static int generateRandomInt(int cap){
       Random generator = new Random();
       return generator.nextInt(cap);
    }

}
