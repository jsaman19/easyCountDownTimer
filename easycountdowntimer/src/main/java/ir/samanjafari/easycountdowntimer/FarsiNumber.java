package ir.samanjafari.easycountdowntimer;

public class FarsiNumber {
    private static String[] persianNumbers = new String[]{ "۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹" };
    public static String convertToFarsi(String s)
    {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder out = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out.append(persianNumbers[number]);
            }
            else if (c == '٫') {
                out.append('،');
            }
            else {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static String convertToDecimal(String s)
    {
        if (s.length() == 0) {
            return "";
        }
        int length = s.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch >= 0x0660 && ch <= 0x0669)
                ch -= 0x0660 - '0';
            else if (ch >= 0x06f0 && ch <= 0x06F9)
                ch -= 0x06f0 - '0';
            chars[i] = ch;
        }
        return new String(chars);
    }
}
