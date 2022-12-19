package numbers;

public class PropertyFactory {
    public static NumberProperty factory(String name) {
        switch (name.toLowerCase()) {
            case "buzz" -> {
                return new BuzzNumber("");
            }
            case "duck" -> {
                return new DuckNumber("");
            }
            case "even" -> {
                return new EvenNumber("");
            }
            case "gapful" -> {
                return new GapfulNumber("");
            }
            case "happy" -> {
                return new HappyNumber("");
            }
            case "jumping" -> {
                return new JumpingNumber("");
            }
            case "odd" -> {
                return new OddNumber("");
            }
            case "palindromic" -> {
                return new PalindromicNumber("");
            }
            case "sad" -> {
                return new SadNumber("");
            }
            case "spy" -> {
                return new SpyNumber("");
            }
            case "square" -> {
                return new SquareNumber("");
            }
            case "sunny" -> {
                return new SunnyNumber("");
            }
            default -> {
                return null;
            }
        }
    }
}
