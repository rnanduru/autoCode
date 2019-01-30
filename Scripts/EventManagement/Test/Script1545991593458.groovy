import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.DayOfWeek as DayOfWeek
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import javax.swing.text.DateFormatter as DateFormatter

DateTimeFormatter df = DateTimeFormatter.ofPattern('EEE MMM/dd/yyyy')
LocalDate today = LocalDate.now()
// Go forward to get saturday
LocalDate saturday = today
while (saturday.getDayOfWeek() != DayOfWeek.SATURDAY) {
    saturday = saturday.plusDays(1)
}
System.out.println('Sunday of the Week: ' + df.format(saturday))