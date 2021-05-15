(function(){
        /*"sroll": "18CS01001",
         "sname": "SRIPAD",
        "batch": 2018,
         "dept_id": 1,
         "email": "sri@s.com",
        "phone": "9876543210",
         "gender": "M",
         "program": "B.Tech",
         "address": "Kurnool, AP",
         "dob": "2000-05-07 00:00:00"

         */
    let k = document.getElementById("adds");
    k.addEventListener("click",async(e)=>{
        // e.target.disabled = true;
        e.target.innerHTML = "Submiting..."
        let data={
            sname:"",
            dept_id:"",
            sroll:"",
            batch:"",
            program:"",
            gender:"",
            email:"",
            phone:"",
            dob:"",
            address:""
        };

        data['sname'] = document.getElementById("sname").value;
        data["sroll"]=-1;
        data['dept_id'] = document.getElementById("dept_id").value;
        data['batch'] = document.getElementById("batch").value;
        data['program'] = document.getElementById("program").value;
        data['gender'] = document.getElementById("gender").value;
        data['email'] = document.getElementById("email").value;
        data['phone'] = document.getElementById("phone").value;
        data['dob'] = document.getElementById("dob").value;
        data['address'] = document.getElementById("address").value;
        console.log(data);
        let response = await axios.post('http://localhost:8081/student',data);
        e.target.disabled=false;
        e.target.innerHTML = "Submit";
    });

})();