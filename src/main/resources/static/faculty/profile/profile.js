(function () {
    //getAndFill('http://localhost:8081/myprofile');
    console.log("I am here!")
    getAndFill('http://localhost:8081/facprofile');
})();
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

async function getAndFill(url) {
    try {
        let response = await axios.get(url);
        if (response.status == 200) {
            let data = response.data[0];
            //console.log(response);
            console.log(data[0]);
            console.log(getCookie("dept_id"));
            if(getCookie("dept_id") != null && getCookie("dept_id") != "-1"){
                document.getElementById("admin-link").style.display = 'block';
            }else{
                document.getElementById("admin-link").style.display = 'none';
            }
            document.getElementById("fname").innerHTML = data.fname;
            document.getElementById("jdate").innerHTML = data.joining_date.substr(0, 10);
            document.getElementById("email").innerHTML = data.email;
            document.getElementById("phone").innerHTML = data.phone;
            document.getElementById("gender").innerHTML = data.gender;
            document.getElementById("salary").innerHTML += data.salary;
        }

    } catch (err) {
        console.log(err);
    }
}



