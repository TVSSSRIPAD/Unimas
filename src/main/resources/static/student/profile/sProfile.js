(function(){
    getAndFill('http://localhost:8081/myprofile');
})();

async function getAndFill(url){
    try{
        let response = await axios.get(url);
        if(response.status==200){
            let data = response.data;
            //console.log(response);
            console.log(data);
            // data = {
            //     "sroll": "18CS01001",
            //     "sname": "SRIPAD",
            //     "batch": 2018,
            //     "dept_id": 1,
            //     "email": "sri@s.com",
            //     "phone": "9876543210",
            //     "gender": "M",
            //     "program": "B.Tech",
            //     "address": "Kurnool, AP",
            //     "dob": "2000-05-07 00:00:00"
            // };
        document.getElementById("sroll").innerHTML = data.sroll;
        document.getElementById("sname").innerHTML = data.sname;
        document.getElementById("batch").innerHTML = data.batch;
        document.getElementById("email").innerHTML = data.email;
        document.getElementById("phone").innerHTML = data.phone;
        document.getElementById("gender").innerHTML = data.gender;
        document.getElementById("program").innerHTML = data.program;
        document.getElementById("address").innerHTML = data.address;
        document.getElementById("dob").innerHTML = data.dob.substr(0,10);
        }
     
    }catch(err){
        console.log(err);
    }
}



