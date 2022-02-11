import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Launcher {
   public static void main (String[] args) throws IOException {
       System.out.println("Binvenue dans le compilateur");

       java.util.Scanner scan = new java.util.Scanner(System.in);
       String command = scan.nextLine();
       while (!(command.equals("quit"))) {
           if (command.equals("fibo")) {
               System.out.println("Entrez le rang de la suite de fibonacci pour obtenir son image");
               int nb = Integer.parseInt(scan.nextLine());
               int res = fibo(nb);
               System.out.println(res);

           }
           if (command.equals("freq")){
               System.out.println("Entrez un chemin de fichier, renvois les 3 mots les plus frequents de celui ci");
               String strPath = scan.nextLine();
                   Path path = Paths.get(strPath);
               String text = java.nio.file.Files.readString(path);
               text.toLowerCase();
               List<String> mostFrequent = threeMostFrequentWords(text);
               mostFrequent.forEach(System.out::println);
           }
           else {
               System.out.println("unknown Command");
           }
           command = scan.nextLine();
       }
   }
   private static int fibo(int n){
       if (n<0) {
           throw new IllegalArgumentException("Should be positive");
       }

       if(n == 0 || n == 1) {
           return n;
       }
       return fibo(n-1) + fibo(n - 2);
   }
   private static List<String> threeMostFrequentWords(String text){
       //creer un hashmap
       Map<String, Integer> wordsCounter = new HashMap<String, Integer>();
       //split le text en tableau de mots
       String[] words = splitTextToWords(text);
       //pour chaque mots ajouter le couple mot -> nb d'occurence
       for (String word: words) {
           if (keyExistsInHashMap(word, wordsCounter)){
               wordsCounter.put(word,countWords(word, words));
           }
       }
       //Tant que most frequent n'est pas de taille 3 il se nourrit du plus grand elt de la hashmap
       List<String> mostFrequent = new ArrayList<String>();
       while ((mostFrequent.size() < 3) || wordsCounter.size() < 0){
           String currentMostFrequent = mapMostFrequent(wordsCounter);
           mostFrequent.add(currentMostFrequent);
           wordsCounter.remove(currentMostFrequent);
       }
       return mostFrequent;

   }
   private static String[] splitTextToWords(String text) {
       return text.split(" ");
   }
   private static int countWords(String str, String[] wordList){
       int res = 0;
       for (String word: wordList) {
           if (str.equals(word)){
               res += 1;
           }
       }
       return res;
   }
   private static boolean keyExistsInHashMap(String key, Map<String, Integer> hashMap) {
    return true;
   }
   private static String mapMostFrequent(Map<String, Integer> hashMap){
       int highest  = 0;
       String res = "null";
       for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
           if (highest < entry.getValue()){
               highest = entry.getValue();
               res = entry.getKey();
           }
       }
       return res;
   }
}