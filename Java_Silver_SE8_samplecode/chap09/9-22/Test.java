import java.time.*;
import java.time.format.*;
class Test {
    public static void main(String[] args) {
        String str = LocalDate.parse("2016-05-23").
                         format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(str);
    }
}