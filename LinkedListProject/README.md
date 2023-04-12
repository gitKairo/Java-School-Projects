# Animated Linked List

The Java program is designed to animate search, insertion, and deletion operations in a linked list using JavaFX. 
It provides a graphical user interface (GUI) with rectangles representing the nodes in the linked list, and buttons for searching, inserting, and deleting values from the list.

## Example Output

This image will display as your example output. Name the image README.JPG in your project folder.

![Sample Output](README.JPG)

## Analysis Steps

The assignment requires the development of a Java program using JavaFX that animates search, insertion, and deletion operations in a linked list. 
The program should have a GUI with rectangles representing the nodes in the linked list, and buttons for performing these operations.

The program needs to have a graphical user interface (GUI) using JavaFX, with rectangles to represent the nodes in the linked list, labels inside them to display the values, and buttons for user interactions.

The program should animate the search, insertion, and deletion operations using fill transitions and translate transitions to create smooth animations, visually showing the changes in the linked list.

The program needs to implement a linked list data structure to store the values and perform search, insertion, and deletion operations based on user input.

The program should allow users to specify a value to search, insert, or delete in the linked list.

A custom class (LinkedListRectangle) needs to be created to represent the rectangles used in the animation, encapsulating the logic for animating the nodes and handling their visual changes.

### Design

LinkedListRectangle: This custom class extends StackPane and represents the rectangles used in the animation.

LinkedList: This class represents the linked list data structure and manages the nodes in the list.

AnimationUtils: This utility class provides static methods for creating fill transitions and translate transitions, which are used for animating the nodes in the linked list.

### Testing

Open the program and visualize the initial linked list state

Insertion operation:

Click the "Insert" button without specifying an index.
Observe that a new rectangle is appended to the end of the
_______________________________________________________________ 

Search operation:

Enter a value in the "Value to Search" text field.
Click the "Search" button.
Observe that the rectangle representing the node with the searched value is highlighted with a different color to indicate the search operation.
_________________________________________________________________________________________________________________________________________________
Deletion operation:

Enter a value in the "Value to Delete" text field.
Click the "Delete" button.
Observe that the rectangle representing the node with the specified value is smoothly animated, fading out and disappearing from the linked list, indicating the deletion operation.
______________________________________________________________________________________________________________________________________________________________________________________

## Notes

Getting the program to insert and delete at different positions was tough

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
