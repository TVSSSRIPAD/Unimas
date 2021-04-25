(function () {
    //getAndFill('http://localhost:8081/myprofile');
    console.log("I am here!")
    getAndFill('http://localhost:8081/facprofile');
})();

async function getAndFill(url) {
    try {
        let response = await axios.get(url);
        if (response.status == 200) {
            let data = response.data[0];
            //console.log(response);
            console.log(data[0]);

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



