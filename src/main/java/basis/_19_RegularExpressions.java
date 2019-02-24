package basis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _19_RegularExpressions {

    //note that some symbols like ? could be execute different functions.
    // (?i) in replaceAll is nonSensitivity
    // (*?) in patterns is turn quantifier in non-greedy
    // (?!v) in patterns is negation
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        //Matches any single character alphanumeric
        System.out.println(alphanumeric.replaceAll(".","Y"));
        //Matches the text at the beginning of the line
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
        //Starts by
        System.out.println(alphanumeric.matches("^hello"));
        //Matches has to match strictly
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12GhhabcDeeeiiiijkl99z"));
        //Replace at the end
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        //Replace a e or i
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        //Replace a e or i followed by F or j
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));
        //Replace followed by text
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));


        String newAlphanumeric = "abcDeeeF12Ghhijkl99z";
        //Replace except e and j
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        //(?i) Case sensitivity
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        //Matches digits (d) and no digits (D)
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));
        //Matches word characters (w) and no Word (W) characters
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\W", "X"));

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        //Matches space (s) and non space (S)
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        System.out.println(hasWhitespace.replaceAll("\\S", "Y"));
        //Matches tabulation
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        //Matches the word boundaries (XIX XhaveX XblanksX)
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));

        //Matches if {n times appear}, + 1 or more, * 0 or more
        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());

        }

        //Greedy quantifiers vs lazy quantifiers (? (0 or 1) turns * greedy into lazy). This means when find one occurrence stop
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        //Here note there is 3 groups and with + we find at least 1 ocurrence so between h2 tags have to be text
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPatten = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPatten.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        String tvTest = "tstvtkt";
        // ?! in patterns is like "t[^v]" in replaceAll and the opposite is t(?=v)
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phoneCheckerPattern = "^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4}$";
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches(phoneCheckerPattern));
        System.out.println("phone2 = " + phone2.matches(phoneCheckerPattern));
        System.out.println("phone3 = " + phone3.matches(phoneCheckerPattern));
        System.out.println("phone4 = " + phone4.matches(phoneCheckerPattern));

        String visaCheckerPattern = "^4[0-9]{12}([0-9]{3})?$";
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches(visaCheckerPattern));
        System.out.println("visa2 " + visa2.matches(visaCheckerPattern));
        System.out.println("visa3 " + visa3.matches(visaCheckerPattern));
        System.out.println("visa4 " + visa4.matches(visaCheckerPattern));
    }

}