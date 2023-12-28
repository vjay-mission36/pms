package com.mission42.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PMSUtils {
    /*
     * Date to LocalDate
     */
    public static LocalDate getLocalDateInstance(Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /*
     * LocalDate to Date
     */
    public static Date getDateFromLocalDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
