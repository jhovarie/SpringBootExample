<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // Fetch all products on page load
            fetchProducts();

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
                    $("<th>").text("Quantity")
                );
                table.append(headerRow);

                // Add rows for each product
                $.each(products, function (index, product) {
                    var row = $("<tr>").append(
                        $("<td>").text(product.id),
                        $("<td>").text(product.name),
                        $("<td>").text(product.description),
                        $("<td>").text(product.price),
                        $("<td>").text(product.quantity)
                    );
                    table.append(row);
                });

                productDisplay.append(table);
            }
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
    </script>
</head>
<body>
    <h2>Search Product</h2>
    <!-- Search input without a button -->
    <div>
        <label>Search by Name:</label>
        <input type="text" id="searchInput">
    </div>

    <div id="productDisplay"></div>
</body>
</html>
