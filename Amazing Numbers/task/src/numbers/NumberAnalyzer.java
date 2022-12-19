package numbers;

import java.util.*;

public class NumberAnalyzer {
    public static String instructions = """
                        
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.
                """;
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println(instructions);

        while (true) {
            System.out.print("\nEnter a request: ");

            String number = scanner.nextLine();

            if (number.isEmpty() || number.isBlank()) {
                System.out.println(instructions);
                continue;
            }

            switch (number.split(" ").length) {
                case 1 -> analyzeSingleNumber(number);
                case 2 -> analyzeNumberRange(number);
                default -> searchNumbersWithProperty(number);
            }
        }
    }

    private static void searchNumbersWithProperty(String number) {
        String[] numberAndLength = number.split(" ");

        List<String> properties = List.of("BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD", "EVEN", "ODD");
        if (Long.parseLong(numberAndLength[0]) < 0) {
            System.out.println("\nThe first parameter should be a natural number or zero.\n");
            return;
        }

        long startingNumber = Long.parseLong(numberAndLength[0]);

        if (Long.parseLong(numberAndLength[1]) < 0) {
            System.out.println("\nThe second parameter should be a natural number.\n");
            return;
        }

        long count = Long.parseLong(numberAndLength[1]);

        List<String> unsupportedProperties = Arrays.stream(Arrays.copyOfRange(numberAndLength, 2, numberAndLength.length))
                .map(String::toUpperCase)
                .filter(property -> !properties.contains(property.replace("-", "")))
                .toList();

        if (!unsupportedProperties.isEmpty()) {
            System.out.printf("The propert%s [%s] %s wrong.%n",
                    unsupportedProperties.size() == 1 ? "y" : "ies",
                    String.join(", ", unsupportedProperties),
                    unsupportedProperties.size() == 1 ? "is" : "are");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return;
        }

        List<String> parametersToMatch = Arrays.stream(Arrays.copyOfRange(numberAndLength, 2, numberAndLength.length))
                .filter(property -> properties.contains(property.toUpperCase()))
                .toList();

        List<String> parametersToNotMatch = Arrays.stream(Arrays.copyOfRange(numberAndLength, 2, numberAndLength.length))
                .filter(property -> property.startsWith("-") && properties.contains(property.toUpperCase().replace("-", "")))
                .map(property -> property.replace("-", ""))
                .toList();

        for (String parameter: parametersToMatch) {
            List<String> mutuallyExclusiveProperties = parametersToMatch
                    .stream()
                    .filter(property -> Objects.requireNonNull(PropertyFactory.factory(parameter)).mutuallyExclusiveWith(property))
                    .toList();

            if (mutuallyExclusiveProperties.size() != 0) {
                System.out.printf("The request contains mutually exclusive properties: [%s, %s]%n", parameter, mutuallyExclusiveProperties.get(0));
                System.out.println("There are no numbers with these properties.");
                return;
            }
        }

        for (String parameter: parametersToNotMatch) {
            List<String> mutuallyExclusiveProperties = parametersToNotMatch
                    .stream()
                    .filter(property -> Objects.requireNonNull(PropertyFactory.factory(parameter)).mutuallyExclusiveWith(property))
                    .toList();

            if (mutuallyExclusiveProperties.size() != 0) {
                System.out.printf("The request contains mutually exclusive properties: [%s, %s]%n", parameter, mutuallyExclusiveProperties.get(0));
                System.out.println("There are no numbers with these properties.");
                return;
            }
        }

        HashSet<String> mutuallyExclusiveProperties = new HashSet<>(parametersToMatch);
        mutuallyExclusiveProperties.retainAll(new HashSet<>(parametersToNotMatch));

        if (mutuallyExclusiveProperties.size() != 0) {
            System.out.printf("The request contains mutually exclusive properties: [%s, %s]%n", mutuallyExclusiveProperties.stream().toList().get(0), "-" + mutuallyExclusiveProperties.stream().toList().get(0));
            System.out.println("There are no numbers with these properties.");
            return;
        }

        List<NumberWithProperties> numberList = new ArrayList<>();

        while (count > 0) {
            NumberWithProperties number1 = new NumberWithProperties(startingNumber);

            if (number1.matchesAll(parametersToMatch) && !number1.matchesAny(parametersToNotMatch)) {
                numberList.add(number1);
                count--;
            }

            startingNumber++;
        }

        numberList.forEach(n -> System.out.println(n.getProperties()));
    }

    private static void analyzeNumberRange(String number) {
        String[] numberAndLength = number.split(" ");

        if (Long.parseLong(numberAndLength[0]) < 0) {
            System.out.println("\nThe first parameter should be a natural number or zero.\n");
            return;
        } else if (Long.parseLong(numberAndLength[1]) < 0) {
            System.out.println("\nThe second parameter should be a natural number.\n");
            return;
        }
        for (long i = Long.parseLong(numberAndLength[0]); i < Long.parseLong(numberAndLength[0]) + Long.parseLong(numberAndLength[1]); i++) {
            System.out.println(new NumberWithProperties(String.valueOf(i)).getProperties());
        }
    }

    private static void analyzeSingleNumber(String number) {
        if (Long.parseLong(number) < 0) {
            System.out.println("\nThe first parameter should be a natural number or zero.\n");
            return;
        } else if (Long.parseLong(number) == 0) {
            exitProgram();
        }

        System.out.println("\n" + new NumberWithProperties(number).getAllProperties());
    }

    private static void exitProgram() {
        System.out.println("\nGoodbye!");
        System.exit(0);
    }


}
