public class Aufgabe_1 {

    public static void main(String[] args) {

        System.out.println("Start Aufgabe 1");
        System.out.println();
        System.out.println("Aufgabe a");
        div21(21, 420);
        System.out.println();


        System.out.println("Aufgabe b");
        fiveNotNine(45, 135);
        System.out.println();


        System.out.println("Aufgabe c");
        toASCII(50, 71);
        System.out.println();


        System.out.println("Aufgabe d");
        countThemZs("Zehn zahme Ziegen zogen ziemlich zügig zehn Zentner Zucker zum Zoo!");
    }


    //a)
    public static void div21(int beginInt, int endInt){
        int sum = 0;
        for(int i = beginInt; i < endInt; i++){
            if(i%21==0){
                sum+=i;
            }
        }
        System.out.println(sum);
    }


    //b
    public static void fiveNotNine(int beginInt, int endInt){
        String end = ":";
        for (int i = beginInt; i < endInt; i++) {
            if(i%5==0 && i%9!=0){
                end += i +":";
            }
        }
        System.out.println(end);
    }


    //c
    public static void toASCII(int beginInt, int endInt){
        String end = "";
        for (int i = endInt-1; i > beginInt-1; i--) {
            if(i==beginInt-2){
                char ch = (char) i;
                end += ch;
            }else{
                char ch = (char) i;
                end += ch + ",";
            }
        }
        System.out.println(end);
    }


    //d
    public static void countThemZs(String sentence){
        int count = 0;
        String toLower = sentence.toLowerCase();
        for (int i = 0; i < toLower.length(); i++) {
            if(toLower.charAt(i) == 'z'){
                count++;
            }
        }
        System.out.println(count);
    }
}
