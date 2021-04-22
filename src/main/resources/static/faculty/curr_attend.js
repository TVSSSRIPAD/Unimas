(function(){
   let data = {
       cid:"DBMS",
       credits:5,
       name:"Database management system",
       type:"core",
       date:"13/04/2021",
       students:[{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},
       {sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},
       {sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"},{sroll:"18CS01009",sname:"Dushyanth"}]
   }
document.getElementById("cid").innerHTML = data.cid;
document.getElementById("cname").innerHTML = data.name;
document.getElementById("ccredits").innerHTML = data.credits;
document.getElementById("cdate").innerHTML = data.date;
document.getElementById("ctype").innerHTML = data.type;
for(let i=0;i<data.students.length;i++){
    document.getElementById("cattend").innerHTML+=
        "<tr><td class='border border-dark p-2'>"+data.students[i].sname+"</td><td class='border border-dark p-2'>"+data.students[i].sroll+"</td><td class='border border-dark p-2'><select name='ap' ><option value='A'>Absent</option><option value='P' selected='selected'>Present</option></select></td></tr>";
}

})();