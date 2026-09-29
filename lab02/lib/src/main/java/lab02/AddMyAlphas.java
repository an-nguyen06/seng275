package lab02;

public class AddMyAlphas {
    public int add(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, 3);
            numbers = numbers.substring(4);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String part : parts) {
            int value = Integer.parseInt(part);
            if (value < 0) {
                if (negatives.length() > 0) negatives.append(",");
                negatives.append(value);
            } else {
                if (value <= 1000 && value >= 0) {
                    sum += value;
                }
            }
        }
        if (negatives.length() >0){
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
        return sum;
    }
}
