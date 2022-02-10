class Launcher {
   public static void main (String[] args){
       System.out.println("Binvenue dans le compilateur");

       java.util.Scanner scan = new java.util.Scanner(System.in);
       String command = scan.nextLine();
       while (!(command.equals("quit"))) {
           System.out.println("unknown Command");
           command = scan.nextLine();
       }
   }
}