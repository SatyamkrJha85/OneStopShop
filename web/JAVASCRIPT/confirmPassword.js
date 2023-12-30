const newPassword = document.getElementById("pass");
const confirmPassword = document.getElementById("confirm-pass");
const errorMessage = document.getElementById("error-msg");
const resetBtn = document.querySelector(".reset-btn");
const togglePassword1 = document.getElementById("toggle-pass1");
const togglePassword2 = document.getElementById("toggle-pass2");

resetBtn.addEventListener("click", (e) => {
  

  const newPasswordValue = newPassword.value;
  const confirmPasswordValue = confirmPassword.value;

  if (
    newPasswordValue.length >= 6 &&
    newPasswordValue.length <= 15 &&
    confirmPasswordValue.length >= 6 &&
    confirmPasswordValue.length <= 15
  ) {
    if (newPasswordValue === confirmPasswordValue) {
      errorMessage.innerHTML = "Password matched";
      errorMessage.style.color = "green";

    } else {
      errorMessage.innerHTML = "Passwords do not match";
      errorMessage.style.color = "red";
    }
  } else {
    errorMessage.innerHTML = "Password must be between 6 - 15 characters";
    errorMessage.style.fontSize = ".8rem";
    errorMessage.style.color = "red";
  }
  
});

togglePassword1.addEventListener("click", () => {
  inputVisibility(newPassword);
});

togglePassword2.addEventListener("click", () => {
  inputVisibility(confirmPassword);
});

function inputVisibility(inputField) {
  if (inputField.type === "password") {
    inputField.type = "text";
  } else {
    inputField.type = "password";
  }
};