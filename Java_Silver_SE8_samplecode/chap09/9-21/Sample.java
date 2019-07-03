import java.time.*;
import java.time.format.*;
class Sample {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = LocalDate.of(2016, 05, 23);
        LocalDate d3 = LocalDate.parse("2016-05-23",
                              DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.print(d1 + " : ");
        System.out.print(d2 + " : ");
        System.out.print(d3);
    }
}
