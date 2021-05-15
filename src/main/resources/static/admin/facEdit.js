let global_data={
    fname:"",
    jdate:"",
    email:"",
    phone:"",
    gender:"",
    salary:"",
    fid:-1
};
(function(){
let k = document.getElementById('getInfo');
k.addEventListener('click',(e)=>{
   e.preventDefault();
   // e.target.disabled = true;
   console.log(document.getElementById("roll").value);
   getAndFill('http://localhost:8081/facprofile2');
   e.target.disabled = false;
})
let k1 = document.getElementById("edit");
k1.addEventListener('click',async(e)=>{
   e.preventDefault();
   e.target.disabled = true;
   //console.log(document.getElementById("phone").innerHTML);
   global_data.fname = document.getElementById("iname").value;
   global_data.phone = document.getElementById("iphone").value;
   global_data.address = document.getElementById("iaddress").value;
   console.log(global_data);
   let response = await axios.put("http://localhost:8081/faculty",global_data);
   if(response.status==200){
      fill(global_data);
   }
})
})();

function fill(data){

   document.getElementById("fname").innerHTML = data.fname;
   document.getElementById("salary").innerHTML = data.salary;
   document.getElementById("email").innerHTML = data.email;
   document.getElementById("phone").innerHTML = data.phone;
   document.getElementById("gender").innerHTML = data.gender;
   document.getElementById("jdate").innerHTML = data.jdate.substr(0,10);
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
       //    /* 
    //fname:"",
    //jdate:"",
    //email:"",
    //phone:"",
    //gender:"",
    //salary
       // };
       fill(data);
   }

}catch(err){
   console.log(err);
}
}


