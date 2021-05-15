let global_data={
         "sroll": "18CS01001",
         "sname": "SRIPAD",
        "batch": 2018,
         "dept_id": 1,
         "email": "sri@s.com",
        "phone": "9876543210",
         "gender": "M",
         "program": "B.Tech",
         "address": "Kurnool, AP",
         "dob": "2000-05-07 00:00:00"
     };
(function(){
    let k = document.getElementById('getInfo');
    k.addEventListener('click',(e)=>{
        e.preventDefault();
        // e.target.disabled = true;
        console.log(document.getElementById("roll").value);
        getAndFill(`http://localhost:8081/myprofile2/${document.getElementById("roll").value}`);
        e.target.disabled = false;
    })
    let k1 = document.getElementById("edit");
    k1.addEventListener('click',async(e)=>{
        e.preventDefault();
        // e.target.disabled = true;
        //console.log(document.getElementById("phone").innerHTML);
        global_data.sname = document.getElementById("iname").value;
        global_data.phone = document.getElementById("iphone").value;
        global_data.address = document.getElementById("iaddress").value;
        console.log(global_data);
        let response = await axios.put("http://localhost:8081/student",global_data);
        if(response.status==200){
           fill(global_data);
        }
    })
})();

function fill(data){
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
async function getAndFill(url){
    try{
        let response = await axios.get(url);
        if(response.status==200){
           global_data = response.data; 
           let  data = response.data;
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
            fill(data);
        }
     
    }catch(err){
        console.log(err);
    }
}

