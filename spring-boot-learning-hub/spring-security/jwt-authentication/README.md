# spring-boot-jwt-authentication

## The UserService in a Spring Boot application typically performs the following operations related to user management.

**User Registration**

+ This handles user registration by accepting user input (such as username, email, and password).
+ It encrypts the password using a password encoder (e.g., BCryptPasswordEncoder) to ensure security.
+ The user's creation timestamp (createdAt) is set, and the user is saved in the database using the UserRepository.
  **User Login**
+ This handle user login by verifying credentials provided during the login process (usually username/email and
  password).
+ It retrieves the user's information from the database based on the provided username/email.
+ It compares the provided password (after encryption) with the stored encrypted password to authenticate the user.
+ Upon successful authentication, the service may generate and return a JWT (JSON Web Token) for further authentication
  and authorization in subsequent requests.
  **JWT Token Generation**
+ This generates a JWT (JSON Web Token) after successful user authentication.
+ It includes relevant user information (e.g., username, user roles, expiration time) in the JWT payload.
+ The generated JWT can be used by the client for subsequent requests to authenticate and authorize the user without the
  need for repeated username/password validation.

**User Retrieval**

+ This retrieve user information based on various criteria (e.g., by username, email, ID).
+ This functionality allows other parts of the application to access user details for specific purposes, such as profile
  management or user-specific operations.

**User Deletion**

+ This handle user deletion if the application requires such functionality, ensuring proper cleanup and data integrity.

## To summarize:

Overall, the UserService encapsulates the business logic related to user management, including registration,
authentication, authorization, and user data operations. It plays a crucial role in ensuring a secure and efficient user
experience within the Spring Boot application.
