public class Greeter {

    public String greet(String name) {
        String greetingText = name != null ? name : "my friend";

        String response = "Hello, " + greetingText + ".";
        if (name != null && name.equals(name.toUpperCase())) {
            response = response.toUpperCase();
        }

        return response;
    }

    public String greet(String[] names) {
        String[] allNames = getNamesArrayIncludingCommaSeparationOnes(names);

        String[] noUpperCaseNames = ArrayUtils.getElementsThatMeetCondition(
                allNames, string -> !string.equals(string.toUpperCase()));
        String[] upperCaseNames = ArrayUtils.getElementsThatMeetCondition(
                allNames, string -> string.equals(string.toUpperCase()));

        return getResponse(noUpperCaseNames) + getShoutResponse(upperCaseNames);
    }

    private String getResponse(String[] names) {
        StringBuilder response = new StringBuilder("Hello");
        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1) {
                if (names.length > 1) {
                    response.append(" and ").append(names[i]);
                } else {
                    response.append(", ").append(names[i]);
                }
            } else {
                response.append(", ").append(names[i]);
            }
        }
        response.append(".");

        return response.toString();
    }

    private String getShoutResponse(String[] names) {
        StringBuilder response = new StringBuilder();
        for (String upperCaseName : names) {
            response.append(" AND HELLO ").append(upperCaseName).append("!");
        }

        return response.toString();
    }

    private String[] getNamesArrayIncludingCommaSeparationOnes(String[] names) {
        int totalNamesCount = getNamesIncludingCommaSeparationOnesCount(names);
        String[] allNames = new String[totalNamesCount];

        int namesIncrement = 0;
        int allNamesIncrement = 0;
        while (allNamesIncrement < allNames.length) {
            if (hasTwoNamesSeparatedBySeparator(names[namesIncrement])) {
                String[] split = names[namesIncrement].split(",");
                allNames[allNamesIncrement] = split[0].trim().replace("\"", "");
                allNames[allNamesIncrement + 1] = split[1].trim().replace("\"", "");
                allNamesIncrement++;
            } else {
                allNames[allNamesIncrement] = names[namesIncrement].replace("\"", "");
            }
            allNamesIncrement++;
            namesIncrement++;
        }

        return allNames;
    }

    private int getNamesIncludingCommaSeparationOnesCount(String[] names) {
        int containingCommaStringsCount = 0;
        for (String name : names) {
            if (hasTwoNamesSeparatedBySeparator(name)) {
                containingCommaStringsCount++;
            }
        }

        return names.length + containingCommaStringsCount;
    }

    private boolean hasTwoNamesSeparatedBySeparator(String name) {
        return name.contains(",") && !isLiteralEscaped(name);
    }

    private boolean isLiteralEscaped(String name) {
        return name.charAt(0) == '"' && name.charAt(name.length() - 1) == '"';
    }
}
