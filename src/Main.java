import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
//V6 Написать регулярное выражение, определяющее является ли данная строчка датой в формате dd/mm/yyyy. Начиная с 1600 года до 9999 года.– пример правильных выражений: 29/02/2000, 30/04/2003, 01/01/2003.– пример неправильных выражений: 29/02/2001, 30-04-2003, 1/1/1899.
    public static void main(String[] args) {
        String[] testDates = {
                "29/02/2000",  // valid leap year
                "30/04/2003",  // valid
                "01/01/2003",  // valid
                "29/02/2001",  // invalid (not a leap year)
                "30-04-2003",  // invalid format
                "1/1/1899"     // invalid format
        };


        for (String date : testDates) {
            if (isValidDate(date)) {
                System.out.println(date + " is valid");
            } else {
                System.out.println(date + " is NOT valid");
            }
        }
    }

    public static boolean isValidDate(String date) {
        // Regex to match date format dd/mm/yyyy
        String dateRegex = "^((0[1-9]|[12][0-9]|3[01])/(0[13578]|1[02])/(16[0-9]{2}|[17-9][0-9]{2}|[2-9][0-9]{3}))" + // 31 days in months 01, 03, 05, 07, 08, 10, 12
                "|((0[1-9]|[12][0-9]|30)/(0[469]|11)/(16[0-9]{2}|[17-9][0-9]{2}|[2-9][0-9]{3}))" +         // 30 days in months 04, 06, 09, 11
                "|((0[1-9]|1[0-9]|2[0-8])/02/(16[0-9]{2}|[17-9][0-9]{2}|[2-9][0-9]{3}))" +                // 28 days in February
                "|(29/02/((16|[2468][048]|[3579][26])00|((16|[2468][048]|[3579][26])|[2468][048]|[3579][26])00))$"; // 29 days in leap years

        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}