## Setup Instructions:
  1.Clone the Repository:
  
  2.Open the Project in IDE:
  
  3.Install Dependencies

  4.Configure Application Properties:
    * I am using MySQL database,so you have to create a database with name "ecommerce".
    * We have to add database username and password in application.properties file.
    
    spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?createTableIfNotExists=true
    spring.datasource.username=root
    spring.datasource.password=xxxxxxxx
    spring.jpa.hibernate.ddl-auto=update
  
  5.Run the Application:
  
  6.Access the Application:
   #If the application has a web interface, specify the URL where the user can access it (e.g.,http://localhost:8080).



## API Details:

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


## TEST CASES:

Test Case Documentation for Wishlist Controller
## shouldReturnInvalidUser_whenGetWishList
Description:
Verifies that the controller method throws a UserNotFoundException when an invalid user attempts to access their wishlist.
Test Steps:

Set up the mock authentication to return an invalid username.
Execute the controller method to get the wishlist for the authenticated user.
Verify that a UserNotFoundException is thrown.
## shouldReturnEmptyWishlist_whenGetWishList
Description:

Tests that the controller returns an empty wishlist when a valid user with no wishlist items requests their wishlist.
Test Steps:

Mock the UserRepository to return a user with no wishlist items.
Execute the controller method to get the wishlist for the authenticated user.
Verify that the response contains an empty wishlist.
## shouldReturnUserNotFound_whenAddWishList
Description:

Ensures that the controller method throws a UserNotFoundException when attempting to add a wishlist item for an invalid user.
Test Steps:

Execute the controller method to add a wishlist item for the authenticated user.
Verify that a UserNotFoundException is thrown.
## shouldReturnSuccess_whenAddWishList
Description:

Tests that the controller successfully adds a wishlist item for a valid user.
Test Steps:

Mock the UserRepository to return a valid user.
Execute the controller method to add a wishlist item for the authenticated user.
Verify that the response indicates the item was added successfully.
## shouldReturnUserNotFoundException_whenDeleteWishList
Description:

Verifies that the controller method throws a UserNotFoundException when attempting to delete a wishlist item for an invalid user.
Test Steps:

Execute the controller method to delete a wishlist item for the authenticated user.
Verify that a UserNotFoundException is thrown.
## shouldReturnWishListNotFound_whenDeleteWistList
Description:

Ensures that the controller method throws a WishlistItemNotFoundException when attempting to delete a non-existent wishlist item.
Test Steps:

Mock the UserRepository to return a valid user.
Execute the controller method to delete a wishlist item for the authenticated user.
Verify that a WishlistItemNotFoundException is thrown.
## shouldDeleteWistListSuccessfully
Description:

Tests that the controller successfully deletes an existing wishlist item for a valid user.
Test Steps:

Mock the UserRepository to return a valid user.
Mock the WishlistRepository to return an existing wishlist item.
Execute the controller method to delete the wishlist item for the authenticated user.
Verify that the response indicates the item was deleted successfully.
These test cases cover various scenarios related to accessing, adding, and deleting wishlist items for users in the system. They ensure that the WishlistController behaves as expected under different conditions.




