document.addEventListener("DOMContentLoaded", function () {
    var productList = document.getElementById("product-list");

    fetchProducts();

    function fetchProducts() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/bms/location/getAll", true);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var products = JSON.parse(xhr.responseText);

                products.forEach(function (product) {
                    var productItem = document.createElement("div");
                    productItem.classList.add("product-item");

                    var productName = document.createElement("h2");
                    productName.textContent = product.productName;

                    var productDescription = document.createElement("p");
                    productDescription.textContent = product.productSpec;

                    var productPrice = document.createElement("p");
                    productPrice.textContent = "Price: $" + product.price;

                    var addToCartButton = document.createElement("button");
                    addToCartButton.textContent = "Add to Cart";
                    addToCartButton.addEventListener("click", function() {
                        // Call the existing addToCart function and pass the product name
                        addToCart(product); // Replace "Product Name" with the actual product name
                    });
                    //addToCartButton.addEventListener("click", "addToCart()");
                    //addToCartButton.addEventListener("click", "addToCart");



                    productItem.appendChild(productName);
                    productItem.appendChild(productDescription);
                    productItem.appendChild(productPrice);
                    productItem.appendChild(addToCartButton);
                    productList.appendChild(productItem);
                });
            } else if (xhr.readyState === 4) {
                console.error("Error fetching products:", xhr.statusText);
            }
        };

        xhr.send();
    }
});
// Array to store cart items
let cartItems = [];

// Function to add an item to the cart
function  addToCart(product) {
    const cartBody = document.getElementById("cart-body");
    const newRow = document.createElement("tr");

    newRow.innerHTML = `
        <td>${product.productName}</td>
        <td>${product.productSpec}</td>
        <td  class = "productPrice" >${product.price}</td>
        <td class="quantity">
            <button onclick="updateQuantity(this, -1)">-</button>
            <span>1</span>
            <button onclick="updateQuantity(this, 1)">+</button>
        </td>
        <td class = "totalProductPrice" >
        ${product.price}
        </td>
        <td class="remove">
            <button onclick="removeRow(this)">Remove</button>
        </td>
    `;

    cartBody.appendChild(newRow);
    //updateCart();
}

function updateQuantity(button, increment) {
    const quantitySpan = button.parentElement.querySelector("span");
    let quantity = parseInt(quantitySpan.textContent);
    quantity += increment;
    if (quantity < 2) {
        quantity = 1;
    }
    quantitySpan.textContent = quantity;
    updateProductPrice(button,quantity);
}

function updateProductPrice(button,quantity){
    const totalProductPrice = button.parentElement.parentElement.querySelector(".totalProductPrice");
    const productPrice = button.parentElement.parentElement.querySelector(".productPrice");
    let price = parseInt(productPrice.textContent);
    let total = quantity*price;
    totalProductPrice.textContent=total;
}

function removeRow(button) {
    const row = button.parentElement.parentElement;
    row.remove();
}
// Function to update the cart display
function updateCart() {
    const cartList = document.getElementById("cart-items");
    cartList.innerHTML = "";
    cartItems.forEach(item => {
        const li = document.createElement("li");
        li.textContent = item;
        cartList.appendChild(li);
    });
}

// Function to place an order
function placeOrder() {
    if (cartItems.length > 0) {
        const orderNumber = Math.floor(Math.random() * 1000000);
        alert(`Order placed! Your order number is: ${orderNumber}`);
        cartItems = [];
        updateCart();
    } else {
        alert("Your cart is empty. Add items before placing an order.");
    }
}

// Function to track an order
function trackOrder() {
    const orderNumberInput = document.getElementById("order-number");
    const orderNumber = parseInt(orderNumberInput.value);
    const orderStatus = document.getElementById("order-status");

    // Simulated order tracking logic
    if (orderNumber) {
        const randomStatus = Math.random() > 0.5 ? "Shipped" : "Processing";
        orderStatus.textContent = `Order ${orderNumber} status: ${randomStatus}`;
    } else {
        orderStatus.textContent = "Please enter a valid order number.";
    }
}

        function uploadFile() {
            const fileInput = document.getElementById('fileInput');
            const file = fileInput.files[0];

            if (file) {
                const formData = new FormData();
                formData.append('file', file);

                // You can replace the URL with your server endpoint
                fetch('/api/upload', {
                    method: 'POST',
                    body: formData
                })
                .then(response => {
                    if (response.ok) {
                        console.log('File uploaded successfully');
                        // Add code to handle a successful upload here
                    } else {
                        console.error('File upload failed');
                        // Add code to handle a failed upload here
                    }
                })
                .catch(error => {
                    console.error('An error occurred:', error);
                    // Add code to handle errors here
                });
            } else {
                console.error('No file selected');
                // Add code to handle the case where no file is selected
            }
        }

