You will run the project from the BasicSpringApplication.java class. As you launch the main local host you will be presented with the home page. (http://localhost:8080)

I've implemented two buttons in order to navigate to either the Author List or Book List page. Bootstrap classes (MaxCDN Content Delivery Network) were utilized to style the buttons in the container. The buttons were assigned the classes btn and btn-info to achieve the desired visual appearance. The project also has two other classes, AuthorController and BookController, that handle web requests. They can create, read, update, and delete information in the database.

Once you navigate to the Author List page, you will see the few example data that I've included. In order to implement this when the project loads, I had to create an AuthorList.java class. On this page, you will be able to Add, Edit, and Delete new and existing authors. This was implemented using a combination of HTML, Thymeleaf, and Spring Boot. Essentially when the page loads, the server retrieves the author data from the database. Thymeleaf generates the HTML table with buttons linked to each author's ID. If the edit option is clicked, it will send a request to the server, allowing the user to modify the author's information. Clicking the delete button triggers a request to delete the author's record. The add button redirects to a form where users can enter details for a new author. The server handles the form submission, creates a new record in the database, and updates the Author List page. The same concept was implemented for the Book List page.

**Launching H2-Database:

1. Go to http://localhost:8080/h2-console
2. JDBC URL: jdbc:h2:mem:dcbapp
3. Username: sa
4. No password required
5. Click Connect

Once logged in, you can view current data by calling queries.#   1 0 4 - B a s i c S p r i n g  
 