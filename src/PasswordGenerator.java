import java.util.Random;


// back-end codes
// this class works as the back-end and will generate the passwords

public class PasswordGenerator{
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "45898910";
    public static final String SPECIAL_SYMBOLS = "!@#$%#%^&*()_+-=?><.;:,";

    private final Random random;

    public PasswordGenerator(){random = new Random();}

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
                                    
        
        StringBuilder passwordBuilder = new StringBuilder();

        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        // biuld password
        for (int i = 0 ; i < length ; i++){

            // generate a random index 
            // gerando um index aleatorio
            int randomIndex = random.nextInt(validCharacters.length());

            // get the char based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            // store char into password builder
            passwordBuilder.append(randomChar);

            

        }

        return passwordBuilder.toString();
    }
}
