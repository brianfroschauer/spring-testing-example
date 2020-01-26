# Responsibility	Description

In summary, for each request, a controller usually does the following steps:

| Responsibility | Description |
| -------------- | ----------- |
| Listen to HTTP Requests |	The controller should respond to certain URLs, HTTP methods and content types |
| Deserialize Input	| The controller should parse the incoming HTTP request and create Java objects from variables in the URL, HTTP request parameters and the request body so that we can work with them in the code |
| Validate Input | The controller is the first line of defense against bad input, so it’s a place where we can validate the input |
| Call the Business Logic | Having parsed the input, the controller must transform the input into the model expected by the business logic and pass it on to the business logic |
| Serialize the Output | The controller takes the output of the business logic and serializes it into an HTTP response |
| Translate Exceptions | If an exception occurs somewhere on the way, the controller should translate it into a meaningful error message and HTTP status for the user |

Source: https://reflectoring.io/spring-boot-web-controller-test/
