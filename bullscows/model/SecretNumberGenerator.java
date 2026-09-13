package bullscows.model;

public class SecretNumberGenerator {

    public String generate(int length) {
        StringBuilder secretCode = new StringBuilder();
        while (secretCode.length() < length) {
            StringBuilder pseudoRandomNum = new StringBuilder(String.valueOf(System.nanoTime())).reverse();
            for (int i = 0; i < pseudoRandomNum.length(); i++) {
                if(secretCode.length() == length){break;}
                if(!(secretCode.indexOf(String.valueOf(pseudoRandomNum.charAt(i))) >= 0)) {
                    secretCode.append(pseudoRandomNum.charAt(i));
                }
            }
        }
        return secretCode.reverse().toString();
    }
}
