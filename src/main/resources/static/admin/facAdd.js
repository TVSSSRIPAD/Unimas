(function(){
    /*
    fname:"",
    jdate:"",
    email:"",
    phone:"",
    gender:"",
    salary
     */
let k = document.getElementById("adds");
k.addEventListener("click",async(e)=>{
    e.target.disabled = true;
    e.target.innerHTML = "Submiting..."
    let data={
        fname:"",
        fid:"",
        jdate:"",
        email:"",
        phone:"",
        gender:"",
        salary
    };

    data['fname'] = document.getElementById("fname").value;
    data["fid"]=-1;
    data['jdate'] = (new Date()).toISOString().substr(0,10);
    data['salary'] = document.getElementById("salary").value;
    data['gender'] = document.getElementById("gender").value;
    data['email'] = document.getElementById("email").value;
    data['phone'] = document.getElementById("phone").value;
    console.log(data);
    let response = await axios.post('http://localhost:8081/faculty',data);
    // e.target.disabled=false;
    e.target.innerHTML = "Submit";
});

})();