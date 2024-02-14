Setup Instructions:
1.Clone the Repository:

2.Open the Project in IDE:

3.Install Dependencies

4.Configure Application Properties:
  # I am using MySQL database,so you have to create a database with name "ecommerce".
  # We have to add database username and password in application.properties file.
  
  spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?createTableIfNotExists=true
  spring.datasource.username=root
  spring.datasource.password=xxxxxxxx
  spring.jpa.hibernate.ddl-auto=update

5.Run the Application:

6.Access the Application:
 #If the application has a web interface, specify the URL where the user can access it (e.g.,http://localhost:8080).



API Details:

## Sign-Up API:

HTTP Method: POST
Endpoint: /api/signup
Description: Allows users to create a new account by providing their username, email, password, and other relevant information.
Request Body: JSON object containing user registration details (e.g., username, email, password).
Response: A message indicating the success or failure of the sign-up process.

## Login API:
HTTP Method: POST
Endpoint: /api/login
Description: Allows registered users to log in to their account by providing their username/email and password.
Request Body: JSON object containing user credentials (e.g., username/email, password).
Response: Upon successful authentication, "User login successfully!..."



## Get User Wishlist Methods:

HTTP Method: GET
Endpoint: /api/wishlists/get
Description: Retrieves the wishlist items of the authenticated user.
Request Body: None
Response: A list of wishlist items belonging to the authenticated user.
Authentication: Requires authentication .

## Add Item to Wishlist:

HTTP Method: POST
Endpoint: /api/wishlists/add
Description: Adds an item to the wishlist of the authenticated user.
Request Body: JSON object representing the wishlist item to be added.
Response: A message indicating the success or failure of the operation.
Authentication: Requires authentication .

## Remove Item from Wishlist:

HTTP Method: DELETE
Endpoint: /api/wishlists/delete/{productId}
Description: Removes an item from the wishlist of the authenticated user.
Request Parameters: productId (Path variable) - ID of the product to be removed from the wishlist.
Response: A message indicating the success or failure of the operation.
Authentication: Requires authentication .
