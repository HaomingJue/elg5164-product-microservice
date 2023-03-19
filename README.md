# elg5164-product-microservice
This is a microservice for managing products in a SOA microservice architecture e-commerce platform. The microservice provides APIs for performing CRUD operations on products.
## API Endpoints
Get all products: 
```
[Get] <Base URL>/products
```
Get product by ID:
```
[Get] <Base URL>/products/<id>
```
Create a product:
```
[Post] <Base URL>/products
```
```
request body
{
    "productName": "testname",
    "userId": "1",
    "description": "test description number 1",
    "price": "232"
}
```
Creates a new product. The request body should be a JSON object containing the following fields:

- `productName` (string, required): The name of the product.
- `userId` (number, required): The ID of the user who created the product.
- `description` (string, optional): A description of the product.
- `price` (number, required): The price of the product.

Delete product by ID:
```
[Delete] <Base URL>/products/<id>
```
Delete all products:
```
[Delete] <Base URL>/products
```
## Getting Started

To get a local copy up and running follow these simple steps:

1. Clone the repository.
2. Build the project with Maven: `mvn clean install`.
3. Run the application: `java -jar target/elg5164-product-microservice-1.0.0.jar`.
4. Test the API endpoints using a tool like [Postman](https://www.postman.com/) or `curl`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
