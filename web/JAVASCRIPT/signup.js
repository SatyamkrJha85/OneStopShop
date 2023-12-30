// Get references to HTML elements
const termsLink = document.getElementById("terms_condition");
const termsModal = document.getElementById("terms-modal");
const closeButton = document.getElementById("close-btn");

// Function to open the modal when the terms link is clicked
termsLink.addEventListener("click", function () {
    termsModal.style.display = "block";
    document.body.style.overflow = "hidden"; // Prevent scrolling on the body
});

// Function to close the modal when the close button is clicked
closeButton.addEventListener("click", function () {
    termsModal.style.display = "none";
    document.body.style.overflow = "auto"; // Restore scrolling on the body
});

// Function to close the modal when clicking outside the modal
window.addEventListener("click", function (event) {
    if (event.target === termsModal) {
        termsModal.style.display = "none";
        document.body.style.overflow = "auto"; // Restore scrolling on the body
    }
});

// Prevent the modal from automatically showing on page load
document.addEventListener("DOMContentLoaded", function () {
    termsModal.style.display = "none";
});