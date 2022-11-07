public class Vijener {
    public String key;
    public String message;
    public boolean ciphOrDeciph;

    public Vijener(String key, String message, boolean ciphOrDeciph) {
        this.key = key;
        this.message = message;
        this.ciphOrDeciph = ciphOrDeciph;
    }

    public String cipherOrDecipher() {
        String oldMessage = this.message;
        String keyMessage = this.key;
        int smallA = 'а';
        int bigA = 'А';
        int smallYa = 'я';
        int bigYa = 'Я';
        String newMessage = "";
        int j = 0;
        for (int i = 0; i < oldMessage.length(); i++) {
            char newChar = oldMessage.charAt(i);
            if (j == keyMessage.length()) {
                j = 0;
            }
            int keyChar = keyMessage.charAt(j);
            j++;
            keyChar = keyChar - (keyChar > bigYa ? smallA : bigA);
            if (!this.ciphOrDeciph) {
                keyChar = -keyChar;
            }
            switch (check(newChar)) {
                case "big" -> {
                    newMessage += (char) redo(bigA, bigYa, newChar, keyChar);
                }
                case "small" -> {
                    newMessage += (char) redo(smallA, smallYa, newChar, keyChar);
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

    public int redo(int codeOfA, int codeOfYa, int charTOChange, int keyChar) {
        int sum = charTOChange + keyChar;
        if (sum > codeOfYa) {
            return codeOfA + (sum - codeOfYa - 1);
        } else if (sum < codeOfA) {
            return codeOfYa - (codeOfA - sum - 1);
        } else {
            return sum;
        }

    }
}