import java.util.Arrays;
import java.util.Scanner;

public class IBANDemo {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Eingabe von IBAN:");

        String ibanEntry = myObj.nextLine();  // Read user input

        IBAN_Validation ibanValidationService = new IBAN_Validation(ibanEntry);
        //IBAN_Validation ibanValidationService = new IBAN_Validation("AT611904300234573201");


        System.out.println("\nLändercode: " + ibanValidationService.getCountryCode() + " (" + ibanValidationService.getCountryCodeNumber() + ")");
        System.out.println("Prüfsumme: " + ibanValidationService.getCheckSum());
        System.out.println("Kontonummer: " + ibanValidationService.getAccountNumber());
        System.out.println("Prüfzahl: " + ibanValidationService.getFullCode());

        int[] checkNumberAsInt = ibanValidationService.buildArray();
        System.out.println("arr = " + Arrays.toString(checkNumberAsInt));

        System.out.println("Ist dieser IBAN korrekt? " + ibanValidationService.isIbanCorrect());


    }
}
