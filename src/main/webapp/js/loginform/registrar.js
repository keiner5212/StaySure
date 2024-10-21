import { signUp } from "../api/SingUp";

const form = document.querySelector("form");
const email = document.querySelector("input[type='email']");
const password = document.querySelector("input[type='password']");
const repassword = document.querySelector("input[type='repassword']");
const singbtn = document.querySelector(".form-btn");

form.addEventListener("submit", function (e) {
    e.preventDefault();

    if (!email.value || !password.value || !repassword.value) {
        singbtn.disabled = true;
        singbtn.classList.add("disabled");
    }
    if(password.value !== repassword.value){
        alert("Las contraseñas no coinciden");
    }

    const data = signUp(email.value, password.value)

    if(data){   
        window.location.href = "/";
    }
    else{
        alert("Error al registrar usuario");
    }
});