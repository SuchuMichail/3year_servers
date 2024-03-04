package validators.primitive;

import java.util.List;

public class DateValidator {
    public boolean validateDate(String date, List<String> error, String fieldName){
        String[] mas=date.split("\\.");
        if(mas.length != 3) {
            error.add(fieldName + ": uncorrected format");
            return false;
        }

        int day = Integer.parseInt(mas[0]);
        int month = Integer.parseInt(mas[1]);
        int year = Integer.parseInt(mas[2]);

        if(day<1 || month<1){
            error.add(fieldName + ":  day<1 || month<1");
            return false;
        }
        if((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && day>31){
            error.add(fieldName +
                    ": error in count of days in January or March or May or July or August or October or December");
            return false;
        }
        if((month==4 || month==6 || month==9 || month==11) && day>30) {
            error.add(fieldName +
                    ": error in count of days in April or June or September or November");
            return false;
        }

        if(month == 2) {
            if (year % 4 != 0) {
                if (day > 28) {
                    error.add(fieldName + ": error in count of days in February");
                    return false;
                }
            }

            if (year % 4 == 0 && year % 100 != 0) {
                if (day > 29) {
                    error.add(fieldName + ": error in count of days in February");
                    return false;
                }
            }

            if (year % 100 == 0 && year % 400 != 0) {
                if (day > 28) {
                    error.add(fieldName + ": error in count of days in February");
                    return false;
                }
            }
            if (year % 100 == 0 && year % 400 == 0) {
                if (day > 29) {
                    error.add(fieldName + ": error in count of days in February");
                    return false;
                }
            }
        }

        return true;
    }
}
