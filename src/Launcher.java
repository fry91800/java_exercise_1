class Launcher {
   public static void main (String[] args){
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
}