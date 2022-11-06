import java.util.Scanner;

public class IBAN_Validation {

    private String iBan;
    private int calculatedCheckSum;


    public IBAN_Validation(String iBan) {
        this.iBan = iBan;
        this.calculatedCheckSum = -1;
    }

    public String getCountryCode() {
        return iBan.substring(0, 2);
    }

    public int getCheckSum() {
        String part = iBan.substring(2, 4);
        this.calculatedCheckSum = Integer.valueOf(part);
        return calculatedCheckSum;

    }

    public String getAccountNumber() {
        return iBan.substring(4, iBan.length());

    }

    public String getCountryCodeNumber() {
        char checkA = '7';
        int intA = iBan.charAt(0) - checkA;
        int intB = iBan.charAt(1) - checkA;
        String countryCodeNumber = "" + intA + intB * 100;
        return countryCodeNumber;

    }

    public String getFullCode() {
        return getAccountNumber() + getCountryCodeNumber();

    }

    public int[] buildArray() {

        int[] fullCode = new int[getFullCode().length()];
        for (int i = 0; i < getFullCode().length(); i++) {
            fullCode[i] = getFullCode().charAt(i) - '0';
        }
        return fullCode;


    }

    public int calcCheckSum() {
        int checkNumber = 0;
        for (int i = 0; i < getFullCode().length(); i++) {
            checkNumber = ((checkNumber * 10) + buildArray()[i]) % 97;

        }
        checkNumber = 98 - (checkNumber % 97);
        return checkNumber;
    }

    public boolean isIbanCorrect() {
        return calcCheckSum() == calculatedCheckSum;
    }


    @Override
    public String toString() {
        return "IBAN_Validation{" +
                "iBan='" + iBan + '\'' +
                ", calculatedCheckSum=" + calculatedCheckSum +
                '}';
    }
}
