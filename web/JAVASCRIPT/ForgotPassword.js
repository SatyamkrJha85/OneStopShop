const submitBtn = document.querySelector(".submit");
const wrongEmail = document.getElementById("wrong-email");

submitBtn.addEventListener("click", (e) => {
    e.preventDefault();

  wrongEmail.innerHTML = "Couldn't find your account";
  wrongEmail.style.color = "red";
  wrongEmail.style.letterSpacing = '.1rem';
  wrongEmail.style.paddingTop = '.5rem';
});

