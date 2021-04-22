let l = document.getElementById("submit-btn");
console.log("I am here!")
l.addEventListener("click", async (e) => {
    e.preventDefault();
e.target.disabled = true;
console.log("clicked");

let email = document.getElementById("email");
let pass = document.getElementById("password");
let dd = document.getElementById("isfaculty");

console.log(email.value + " pass " + pass.value);
let url = "http://localhost:8081/auth";
var x = 0;
if(dd.checked){
    x = 1;
    url = "http://localhost:8081/facultyauth";
}
let response = await axios({
    url: url,
    method: "post",
    data: {
        email: email.value,
        password: pass.value
    }
});
console.log(response.data);
    if(response.status < 400){
        if(x === 1){
            window.location.href = "facultyprofile"
        }else window.location.href = "profile"
    }
});