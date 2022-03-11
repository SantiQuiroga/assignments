import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {
        final String[] c = Utility.Repeated("This is a repeated word test this is a A");
        System.out.println(Arrays.toString(c));

        final String[] c1 = Utility.Repeated("This is a repeated word test this this this this this this");
        System.out.println(Arrays.toString(c1));

        final String[] c2 = Utility.Repeated("This is a repeated word test this word word word");
        System.out.println(Arrays.toString(c2));
    }
}
