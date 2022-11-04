public class Ceasar {
    public int numberOfSymbols;
    public String message;

    public Ceasar(int numberOfSymbols, String message) {
        this.numberOfSymbols = numberOfSymbols;
        this.message = message;
    }

    public String cipherOrDecipher() {
        String oldMessage = this.message;
        int smallA = 'а';
        int bigA = 'А';
        int smallYa = 'я';
        int bigYa = 'Я';
        String newMessage = "";
        for (int i = 0; i < oldMessage.length(); i++) {
            char newChar = oldMessage.charAt(i);
            switch (check(newChar)) {
                case "big" -> {
                    newMessage += (char) redo(bigA, bigYa, newChar);
                }
                case "small" -> {
                    newMessage += (char) redo(smallA, smallYa, newChar);
                }
                default -> {
                    newMessage += newChar;
                }
            }
        }
        return newMessage;
    }

    public String check(int charToCheck) {
        return charToCheck >= 1040 && charToCheck <= 1071 ? "big" : charToCheck >= 1072 && charToCheck <= 1103 ? "small" : "another";
    }

    public int redo(int codeOfA, int codeOfYa, int charTOChange) {
        int sum = charTOChange + this.numberOfSymbols;
        if (sum > codeOfYa) {
            return codeOfA + (sum - codeOfYa - 1);
        } else if (sum < codeOfA) {
            return codeOfYa - (codeOfA - sum - 1);
        } else {
            return sum;
        }

    }
}
