# Exercise 13_04 Display Calendars

Used listing 6.12 to create and display a calendar for a user inputted month and year and outputted the number of days in that year
using the subclass GregorianCalendar.

## Example Output

This image will display as your example output. Name the image README.jpg in your project folder.

![Sample Output](README.jpg)

## Analysis Steps

I realized I needed to import the Java Scanner class if I was going to be able to get user input as well as import the Java Calendar class and the 
GregorianCalendar subclass. I used multiple methods to create variables that would be used later in my program. 

### Design

I had to use multiple classes and methods to build my calendar one object at a time as well as many variables created in my class and the imported classes.

```
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

```

### Testing

A step by step series of examples that you developed to properly test the program. 

Created multiple methods

```
public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";
        }
        return monthName;
    }
```

public static void printMonthBody(int year, int month) {
        //get start day of week for the first date in month
        int startDay = getStartDay(year, month);
        
        //get number of days in month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
        
        //pad space before first day of month
        int i =0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");
        
        for(i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);
            
            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
        
        System.out.println();
    }

```
public static int getStartDay(int year, int month) {
        final int START_OF_DAY_FOR_JAN_1_1800 = 3;
        //get total num of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        
        //return the start day for month/1/year
        return (totalNumberOfDays + START_OF_DAY_FOR_JAN_1_1800) % 7;
    }
```

End with an example of getting some data out of the system or using it for a little demo

## Notes

Explain any issues or testing instructions.

## Do not change content below this line
## Adapted from a README Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
