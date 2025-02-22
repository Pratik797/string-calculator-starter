package calculator;

class StringCalculator {

    public int add(String input) {
        if (input.equals("")) {
            return 0;
        } else

        {
            String numList[] = splitNumbers(input, ",|\n");
            String delimiter = ",";
            if (input.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(input.charAt(2));
                input = input.substring(4);
            }

            String numList1[] = splitNumbers(input, delimiter + "|\n");
            return sum(numList1);
        }
    }

    private static String[] splitNumbers(String numbers, String divider) {
        return numbers.split(divider);
    }

    private static int sum(String[] numbers) {
        int total = 0;
        String negString = "";
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                if (negString.equals(""))
                    negString = number;
                else
                    negString += ("," + number);
            }
            if (Integer.parseInt(number) < 1000)
                total += Integer.parseInt(number);
        }
        if (!negString.equals("")) {
            throw new IllegalArgumentException("Negatives not allowed: " + negString);
        }
        return total;
    }
}