import { signIn } from "./api/SingIn.js";
import { Cookies } from "./constant/globals.js";
import { getCookie, saveCookie } from "./utils/cookies.js";



const form = document.querySelector("form");
const email = document.querySelector("input[type='email']");
const password = document.querySelector("input[type='password']");
const loginBtn = document.querySelector(".form-btn");

const validatefields = () => {
    if (!email.value || !password.value) {
        loginBtn.disabled = true;
        loginBtn.classList.add("disabled");
    } else {
        loginBtn.disabled = false;
        loginBtn.classList.remove("disabled");
        return { email, password }
    }
}

form.addEventListener("submit", function (e) {
    e.preventDefault();
    const data = validatefields();
    if (!data) {
        return;
    }
    signIn(data.email, data.password)
        .then((res) => {
            saveCookie(Cookies.JWT_TOKEN, res.token);
            window.location.href = "/";
        })
        .catch((err) => {
            console.log(err);
        });
});
