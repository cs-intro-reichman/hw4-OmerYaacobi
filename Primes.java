public class Primes {
    public static void main(String[] args) {
        // Replace this statement with your code
        System.out.println( "Prime numbers up to " + (args [0] + ":"));
        int bound = Integer.parseInt(args [0]);
        int count = 0;
        int i = 2;
        while (i <= bound) {
           
            if (i == 2) {
                System.out.println(i);
                count ++;
            } else { 
                int div = i -1;
            while (i % div != 0) {
                div --;
               
                if (div == 1) {
                    count ++;
                    System.out.println(i);
                    break;
                    }
                }
            } i++;
        }
        System.out.println("There are " + count + " primes between 2 and " + bound + " (" + ((count * 100) / bound) + "% are primes)");

    }
}