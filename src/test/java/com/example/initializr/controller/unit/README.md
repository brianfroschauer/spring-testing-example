# Unit or Integration Test?

## Introduction
In a unit test, we would test the controller in isolation. That means we would instantiate a controller object, mocking away the business logic, and then call the controller’s methods and verify the response.
Would that work in our case? Let’s check which of the 6 responsibilities we have identified above we can cover in an isolated unit test.

## Responsibilities

| Responsibility | Covered in a Unit Test |
| -------------- | ---------------------- |
| Listen to HTTP Requests | No, because the unit test would not evaluate the @PostMapping annotation and similar annotations specifying the properties of a HTTP request. |
| Deserialize Input | No, because annotations like @RequestParam and @PathVariable would not be evaluated. Instead we would provide the input as Java objects, effectively skipping deserialization from an HTTP request |
| Validate Input | Not when depending on bean validation, because the @Valid annotation would not be evaluated |
| Call the Business Logic | Yes, because we can verify if the mocked business logic has been called with the expected arguments |
| Serialize the Output | No, because we can only verify the Java version of the output, and not the HTTP response that would be generated |
| Translate Exceptions | No. We could check if a certain exception was raised, but not that it was translated to a certain JSON response or HTTP status code |

In summary, a simple unit test will not cover the HTTP layer.
