

function showToast(content) {
    let toastElement = document.getElementById("toast");

    // Display the toast
    toastElement.innerHTML = content;
    toastElement.classList.add("display");

    setTimeout(() => {
        toastElement.classList.remove("display");
    }, 1000);
}

function redirect() {
    event.preventDefault();
    window.location.href = "http://localhost:8080/OneStopShop/login.jsp";
}

function redirectServlet(id, uid, qty, cid) {
    event.preventDefault();
    window.location.href = "CartServlet?id="+id+"&uid="+uid+"&qty="+qty+"&cid="+cid;
}

    