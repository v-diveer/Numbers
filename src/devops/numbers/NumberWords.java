package devops.numbers;

public class NumberWords {
    private static final String[] SPECIALNAMES = { "", " thousand", " million", " billion", " trillion", " quadrillion",
          " quintillion" };
  
    private static final String[] TENSNAMES = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
          " seventy", " eighty", " ninety" };
  
    private static final String[] NUMBERNAMES = { "", " one", " two", " three", " four", " five", " six", " seven",
          " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
          " seventeen", " eighteen", " nineteen" };
  
    private String convertLessThanOneThousand(int number) {
       String current;
  
       if (number % 100 < 20) {
          current = NUMBERNAMES[number % 100];
          number /= 100;
       } else {
          current = NUMBERNAMES[number % 10];
          number /= 10;
  
          current = TENSNAMES[number % 10] + current;
          number /= 10;
       }
       if (number == 0)
          return current;
       return NUMBERNAMES[number] + " hundred" + current;
    }
  
    public String convert(int number) {
       if (number == 0) {
          return "zero";
       }
  
       String prefix = "";
  
       if (number < 0) {
          number = -number;
          prefix = "-";
       }
  
       String current = "";
       int place = 0;
  
       do {
          int n = number % 1000;
          if (n != 0) {
             String s = convertLessThanOneThousand(n);
             current = s + SPECIALNAMES[place] + current;
          }
          place++;
          number /= 1000;
       } while (number > 0);
  
       return (prefix + current).trim();
    }
 }