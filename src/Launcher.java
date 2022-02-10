class Launcher {
   public static void main (String[] args){
       System.out.println("Binvenue dans le compilateur");

       java.util.Scanner scan = new java.util.Scanner(System.in);

       System.out.println("Entrez votre commande");
       String command = scan.nextLine();
       if (!(command.equals("quit"))) {
           System.out.println("unknown Command");
       }
   }
}