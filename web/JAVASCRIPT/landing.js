var MenuItems = document.getElementById('MenuItems');
MenuItems.style.maxHeight = '0px';

function menutoggle() {
  if (MenuItems.style.maxHeight == '0px') {
    MenuItems.style.maxHeight = '200px';
  } else {
    MenuItems.style.maxHeight = '0px';
  }
}

function toggleDropdown() {
    var dropdownContent = document.getElementById("userDropdownContent");
    dropdownContent.style.display = (dropdownContent.style.display === "block") ? "none" : "block";
  }
  
  
//// Get the add-to-cart button
//const addToCartButtons = document.querySelectorAll(".add-to-cart-button");
//
//// Add a click event listener to all add-to-cart buttons
//addToCartButtons.forEach(button => {
//  button.addEventListener("click", () => {
//    const id = button.getAttribute("data-id");
//    const name = button.getAttribute("data-name");
//    const price = parseFloat(button.getAttribute("data-price"));
//
//    let itemsInCart = JSON.parse(localStorage.getItem("userCartKey")) || [];
//
//    // Check if the item already exists in the cart
//    const existingItem = itemsInCart.find(item => item.id === id);
//
//    if (existingItem) {
//      // If the item exists, update the quantity
//      existingItem.quantity += 1;
//    } else {
//      // If the item is not in the cart, add it
//      itemsInCart.push({ id, name, price, quantity: 1 });
//    }
//
//    // Update the cart items in localStorage
//    localStorage.setItem("userCartKey", JSON.stringify(itemsInCart));
//  });
//});


