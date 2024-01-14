<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // Fetch all products on page load
            fetchProducts();

            // Event listener for Create button
            $("#createBtn").click(function () {
                createProduct();
            });

            // Event listener for Update button
            $("#updateBtn").click(function () {
                updateProduct();
            });

            // Event listener for Delete button
            $("#deleteBtn").click(function () {
                deleteProduct();
            });

            // Event listener for keyup in the search input field
            $("#searchInput").keyup(function () {
                searchProducts();
            });
        });

        // Function to fetch all products
        function fetchProducts() {
            $.get("/products", function (data) {
                console.log("Fetched products:", data);
                // Update UI with the fetched data
                displayProductData(data);
            });
        }

        // Function to display product data
        function displayProductData(products) {
            var productDisplay = $("#productDisplay");
            productDisplay.empty(); // Clear existing content

            if (products.length === 0) {
                productDisplay.html("No products available.");
            } else {
                // Create an HTML table to display product data
                var table = $("<table>").addClass("table");
                var headerRow = $("<tr>").append(
                    $("<th>").text("ID"),
                    $("<th>").text("Name"),
                    $("<th>").text("Description"),
                    $("<th>").text("Price"),
                    $("<th>").text("Quantity"),
                    $("<th>").text("Actions")
                );
                table.append(headerRow);

                // Add rows for each product
                $.each(products, function (index, product) {
                    var row = $("<tr>").append(
                        $("<td>").text(product.id),
                        $("<td>").text(product.name),
                        $("<td>").text(product.description),
                        $("<td>").text(product.price),
                        $("<td>").text(product.quantity),
                        $("<td>").html(
                            "<button class='btn btn-warning btn-sm' onclick='editProduct(" + product.id + ")'>Edit</button> " +
                            "<button class='btn btn-danger btn-sm' onclick='deleteProduct(" + product.id + ")'>Delete</button>"
                        )
                    );
                    table.append(row);
                });

                productDisplay.append(table);
            }
        }

        // Function to create a new product
        function createProduct() {
            var newProduct = {
                "name": $("#nameInput").val(),
                "description": $("#descriptionInput").val(),
                "price": $("#priceInput").val(),
                "quantity": $("#quantityInput").val()
            };

            $.ajax({
                url: "/products",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(newProduct),
                success: function (data) {
                    console.log("Product created:", data);
                    // Update UI or perform other actions after creation
                    fetchProducts(); // Fetch updated product list
                    displayMessage("Product created successfully!");
                    // Clear input fields after creation
                    clearInputFields();
                }
            });
        }

        // Function to update a product
        function updateProduct() {
            var updatedProduct = {
                "name": $("#nameInput").val(),
                "description": $("#descriptionInput").val(),
                "price": $("#priceInput").val(),
                "quantity": $("#quantityInput").val()
            };

            var productId = $("#idInput").val(); // Use the input field for ID

            $.ajax({
                url: "/products/" + productId,
                type: "PUT",
                contentType: "application/json",
                data: JSON.stringify(updatedProduct),
                success: function (data) {
                    console.log("Product updated:", data);
                    // Update UI or perform other actions after update
                    fetchProducts(); // Fetch updated product list
                    displayMessage("Product updated successfully!");
                    // Clear input fields after update
                    clearInputFields();
                }
            });
        }

        // Function to delete a product
        function deleteProduct() {
            var productId = $("#idInput").val(); // Use the input field for ID

            $.ajax({
                url: "/products/" + productId,
                type: "DELETE",
                success: function () {
                    console.log("Product deleted");
                    // Update UI or perform other actions after deletion
                    fetchProducts(); // Fetch updated product list
                    displayMessage("Product deleted successfully!");
                    // Clear input fields after deletion
                    clearInputFields();
                }
            });
        }

        // Function to edit a product
        function editProduct(productId) {
            // Fetch the product details by ID and populate the input fields for editing
            $.get("/products/" + productId, function (data) {
                $("#idInput").val(data.id);
                $("#nameInput").val(data.name);
                $("#descriptionInput").val(data.description);
                $("#priceInput").val(data.price);
                $("#quantityInput").val(data.quantity);
            });
        }

        // Function to clear input fields
        function clearInputFields() {
            $("#idInput").val("");
            $("#nameInput").val("");
            $("#descriptionInput").val("");
            $("#priceInput").val("");
            $("#quantityInput").val("");
        }

        // Function to search products by name containing a specified string
        function searchProducts() {
            var searchKeyword = $("#searchInput").val();
            if (searchKeyword.trim() !== "") {
                $.get("/products/search?name=" + searchKeyword, function (data) {
                    console.log("Search results:", data);
                    displayProductData(data);
                });
            } else {
                // If the search input is empty, fetch all products
                fetchProducts();
            }
        }

        // Function to display a message
        function displayMessage(message) {
            $("#messageDisplay").html(message);
        }
    </script>
</head>
<body>
    <h2>Product Management</h2>
    <div>
        <label>ID:</label>
        <input type="text" id="idInput" readonly>
    </div>
    <div>
        <label>Name:</label>
        <input type="text" id="nameInput">
    </div>
    <div>
        <label>Description:</label>
        <input type="text" id="descriptionInput">
    </div>
    <div>
        <label>Price:</label>
        <input type="text" id="priceInput">
    </div>
    <div>
        <label>Quantity:</label>
        <input type="text" id="quantityInput">
    </div>
    <button id="createBtn">Create</button>
    <button id="updateBtn">Update</button>
    <button id="deleteBtn">Delete</button>

    <!-- Search input without a button -->
    <div>
        <label>Search by Name:</label>
        <input type="text" id="searchInput">
    </div>

    <div id="productDisplay"></div>
</body>
</html>
