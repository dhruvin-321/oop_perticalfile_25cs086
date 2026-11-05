class PasswordChecker
{
    public static boolean hasLength(String pw)
    {
        return pw.length()>=8;
    }
    public static boolean hasUppercase(String pw)
    {
        return (pw.matches(".*[A-Z].*"));
    }
    public static boolean hasDigits(String pw)
    {
        return (pw.matches(".*[0-9].*"));
    }
    public static boolean hasSpecialChar(String pw)
    {
        return (pw.matches(".*[#@$&!].*"));
    }
    public static String getStrength(String pw)
    {
        int count =0;
        if(hasLength(pw))
            count++;
        if( hasUppercase(pw))
            count++;
        if(hasDigits(pw))
            count++;
        if(hasSpecialChar(pw))
            count++;
        String strength = switch(count)
        {
            case 0,1 -> "weak";
            case 2,3 -> "medium";
            case 4 -> "Strong";
            default -> "invalid";
        };
        return strength;
    }
}