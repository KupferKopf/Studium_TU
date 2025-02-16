import java.util.Random;

public class Aufgabe4 {

    public static void main(String[] args){


        passwordTest(10);
        passwordTest(20);
        passwordTest(30);



    }

    public static void passwordTest(int passwordL){

        String characterSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String password = "";
        Random myRand = new Random();


        for (int i = 0; i < passwordL; i++) {
            password += characterSet.charAt(myRand.nextInt(characterSet.length()));
        }

        double entropie = calculateEntropy(password);

        System.out.println("The generated password is: " + password);
        System.out.print("Entropy of the password: " + entropie + " -> The password is: ");
        
        if(entropie < 60){
            System.out.println("weak");
        } else if (60 < entropie && entropie < 120 ) {
            System.out.println("strong");
        } else {
            System.out.println("very strong");
        }
        System.out.println();
    }


    public static double calculateEntropy(String password){

        double entropy = 0;

        int L = password.length();
        int N = 0;

        int amountNum = 0; //ziffern
        int amountGrBs = 0; //groß buchstaben
        int amountKlBs = 0; //klein buchstaben

        for(int i = 0; i < password.length(); i++){

            char stelle = password.charAt(i);

            if(Character.isDigit(stelle)){
                amountNum ++;
            } else if (Character.isUpperCase(stelle)) {
                amountGrBs ++;
            } else {
                amountKlBs ++;
            }

        }

        if(amountNum == password.length()){
            N = 10;
        } else if (amountNum == 0) {
            if(amountGrBs != 0 && amountKlBs == 0 || amountGrBs == 0 && amountKlBs != 0){
                N = 26;
            } else {
                N = 52;
            }
        } else {
            if(amountGrBs != 0 && amountKlBs == 0 || amountGrBs == 0 && amountKlBs != 0){
                N = 36;
            } else {
               N = 62;
            }
        }

        entropy = L * (Math.log10(N)/Math.log10(2));

        return entropy;
    }


}
