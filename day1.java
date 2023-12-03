import java.util.Scanner;
import java.util.ArrayList;

public class day1 {

    public int getSum(ArrayList<String> x) {
        int sum = 0;

        for (String currStr : x) {
            String firstDigit = "";
            String lastDigit = "";
            boolean foundFirst = false;

            // Find the first digit or spelled-out number
            for (int j = 0; j < currStr.length(); j++) {
                if (Character.isDigit(currStr.charAt(j)) && !foundFirst) {
                    firstDigit = Character.toString(currStr.charAt(j));
                    foundFirst = true;
                    break; // Break after finding the first digit
                }

                String word = findWordAtPosition(currStr, j);
                if (!word.isEmpty() && !foundFirst) {
                    firstDigit = word;
                    foundFirst = true;
                    j += word.length() - 1; // Skip the length of the word
                }
            }

            // Find the last digit or spelled-out number
            for (int j = currStr.length() - 1; j >= 0; j--) {
                if (Character.isDigit(currStr.charAt(j))) {
                    lastDigit = Character.toString(currStr.charAt(j));
                    break;
                }

                String word = findWordAtPosition(currStr, j);
                if (!word.isEmpty()) {
                    lastDigit = word;
                    break;
                }
            }

            // Convert spelled-out numbers to digits
            firstDigit = convertWordToDigit(firstDigit);
            lastDigit = convertWordToDigit(lastDigit);

            // Add to sum
            sum += Integer.parseInt(firstDigit + lastDigit);
        }
        return sum;
    }


    private String findWordAtPosition(String str, int position) {
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (String word : words) {
            int wordIndex = str.indexOf(word, position);
            if (wordIndex == position) {
                return word;
            }
        }
        return "";
    }

    private String convertWordToDigit(String word) {
        switch (word) {
            case "one": return "1";
            case "two": return "2";
            case "three": return "3";
            case "four": return "4";
            case "five": return "5";
            case "six": return "6";
            case "seven": return "7";
            case "eight": return "8";
            case "nine": return "9";
            default: return word;
        }
    }


    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        Scanner scnr = new Scanner(System.in);

        while (true)
        {
            String inputLine = scnr.nextLine();
            if (inputLine.isEmpty()) {
                break;
            }
            data.add(inputLine);
        }

        day1 m = new day1();
        int sum = m.getSum(data);
        System.out.println("The sum is: " + sum);
    }
}
