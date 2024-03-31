import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TestLocalDateTime {
    // 1 LocalDate LocalTime LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();

        LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 19, 13, 55, 25);

        LocalDateTime ldt3 = ldt.plusYears(2);

        LocalDateTime ldt4 = ldt.minusHours(5);

        int year = ldt.getYear();
        int dayOfMonth = ldt.getDayOfMonth();

    }

    // 2 Instant 时间戳 Unix元年: 1970.1.1T00:00:00到某时间之间的毫秒数
    @Test
    public void test2() {
        Instant ins1 = Instant.now(); // 默认获取UTC时区
        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));

        long epochMilli = ins1.toEpochMilli();

    }
    /* 3
     * Duration 计算两个“时间”之间间隔
     * Period   计算两个“日期”之间的间隔
     */
    @Test
    public void test3(){
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        Instant now2 = Instant.now();
        Duration between = Duration.between(now, now2);
        System.out.println(between.toMillis());

        LocalDate now3 = LocalDate.now();
        LocalDate of = LocalDate.of(2024, 04, 01);
        Period between2 = Period.between(now3, of);
        System.out.println(between2.getDays());
    }

    // TemporalAdjuster：时间矫正器
    @Test
    public void test4(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        
        LocalDateTime withDayOfMonth = now.withDayOfMonth(10);
        System.out.println(withDayOfMonth);

        LocalDateTime ldt  = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(ldt);

        // 自定义
        LocalDateTime ldt4 = now.with((l) -> {
            LocalDateTime ldt3 = (LocalDateTime) l;
            DayOfWeek dow = ldt3.getDayOfWeek();
            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt3.plusDays(3);
            } else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt3.plusDays(2);
            } else {
                return ldt3.plusDays(1);
            }
        });
    }

    // DateTimeFormatter: 格式化时间/日期
    @Test
    public void test5(){
        DateTimeFormatter dtf  = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt  = LocalDateTime.now();

        String strDate  = ldt.format(dtf);
        System.out.println(strDate);

        DateTimeFormatter dtf2  = DateTimeFormatter.ofPattern("dd-MM-yyyy,ss:mm:HH");
        String strDate2  = dtf2.format(ldt);
        System.out.println(strDate2);

        LocalDateTime ldt3  = LocalDateTime.parse(strDate2,dtf2);
        System.out.println(ldt3);
    }

    // ZonedDate、ZonedTime、ZonedDateTime
    @Test
    public void test6(){
        Set<String> set  = ZoneId.getAvailableZoneIds();
        LocalDateTime ldt  = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt);
        LocalDateTime ldt1  = LocalDateTime.now();
        ZonedDateTime zdt  = ldt1.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }

}
