# Radix Sort

This program generates 1,000,000 random integers using generateRandomIntegers() method, sorts them using radix sort with radixSort() method, and prints the unsorted and sorted arrays using printArray() method.
The countingSort() method is used as a helper method for radix sort to perform counting sort for each digit.

## Example Output

This image will display as your example output. Name the image README.jpg in your project folder.

![Sample Output](README.jpg)

## Analysis Steps

The assignment requires the development of a Java program that randomly generates 1,000,000 integers and sorts them using radix sort.

The requirements were carefully analyzed to understand the concept of radix sort and its implementation in Java.

The solution was designed using a modular approach. 
The generateRandomIntegers() method was created to generate 1,000,000 random integers. 
The radixSort() method was implemented to perform radix sort by calling the countingSort() method for each digit. 
The getMaxDigits() method was added to calculate the maximum number of digits in the array. 
The countingSort() method was designed to perform counting sort for a specific digit. 
Finally, the printArray() method was created to print the unsorted and sorted arrays.

### Design

The program design followed a modular approach, where different methods were defined to handle specific tasks, but all the methods were kept within a single class. 
The main class, RadixSort, was used to define the overall structure and flow of the program, while additional helper methods were defined within the same class to perform specific functionalities.

### Testing

Generate an array of 1,000,000 random integers and sort them using radix sort.

Generate an array of 10 random integers and sort them using radix sort.

Generate an array of 1 random integer and sort it using radix sort.

Generate an array of 1,000,000 random integers, print the unsorted array, and then sort and print the sorted array.

Generate an array of 0 random integers and try to sort it using radix sort

## Notes

For very large arrays with millions of elements, the sorting process may take considerable time.

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
