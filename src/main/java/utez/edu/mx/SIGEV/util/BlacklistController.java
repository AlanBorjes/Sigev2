package utez.edu.mx.SIGEV.util;

public class BlacklistController {

    private static String[] blacklist = { "<SCRIPT", "SELECT", "FROM", "DELETE", "INSERT", "UPDATE", "WHERE", "=", "&",
            "+", "-", " AND ", " OR ", "/SCRIPT>", "HREF", "SRC", "TH:", "%", "*", "DISTINCT", "CONST", "DROP",
            "EXECUTE", "`", "'" ,"\""};

    public static boolean checkBlacklistedWords(String word) {
        if (!word.equals(null)) {
            for (int i = 0; i < blacklist.length; i++) {
                if (word.toUpperCase().contains(blacklist[i])) {
                    return true;
                }
            }
        }
        return false;
    }

}
