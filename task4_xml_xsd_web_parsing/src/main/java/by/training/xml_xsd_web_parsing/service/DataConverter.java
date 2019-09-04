package by.training.xml_xsd_web_parsing.service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataConverter {

    public static XMLGregorianCalendar stringToYearXMLGregorianCalendar(String s)
            throws ParseException,
            DatatypeConfigurationException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date date = simpleDateFormat.parse(s);
        GregorianCalendar gregorianCalendar =
                (GregorianCalendar) GregorianCalendar.getInstance();
        gregorianCalendar.setTime(date);

        return DatatypeFactory.newInstance()
                .newXMLGregorianCalendarDate(gregorianCalendar
                                .get(Calendar.YEAR),
                        DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED);
    }

    public static XMLGregorianCalendar stringToDataXMLGregorianCalendar(String s)
            throws ParseException,
            DatatypeConfigurationException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        GregorianCalendar gregorianCalendar =
                (GregorianCalendar) GregorianCalendar.getInstance();
        gregorianCalendar.setTime(date);

        return DatatypeFactory.newInstance()
                .newXMLGregorianCalendarDate(
                        gregorianCalendar.get(Calendar.YEAR),
                        gregorianCalendar.get(Calendar.MONTH),
                        gregorianCalendar.get(Calendar.DATE),
                        DatatypeConstants.FIELD_UNDEFINED);
    }
}
