const getDataAndFill = async function(url){
    try {
        let response = await axios.get(url);
        if(response.status==200 ){
           console.log(response.data); 
           let data = response.data;

           if(data.registered==false)fillFormData(data.offeredCourses);
           fillCourseList(data.coursesList);
        }
    } catch (error) {
        console.log(error);
    }
}
function fillCourseList(coursesList){
    
    let sem_wise=[];
    for(let i=0;i<8;i++){
        sem_wise.push([]);
    }
    for(let i=0;i<coursesList.length;i++){
        sem_wise[coursesList[i].semno-1].push(coursesList[i]);
    }
  
   for(let i=0;i<8;i++){
       
       if(sem_wise[i].length!=0){
            fillCourseTable(sem_wise[i],i+1);
       }
   }
   
   
}
function fillCourseTable(courseData,semno){
    let lc = document.getElementById("lcourses");
   
    let x =`
    <table class="w-100 mb-3">
        <tr>
        <th class="xyz">Semester: ${semno}</th>
        </tr>
        <tr>
        <th>Course Name</th>
        <th>Course Type</th>
        <th>Credits</th>
        </tr>
    `;
    for(let j=0;j<courseData.length;j++){
        x+=`
        <tr>
           <td>
            ${courseData[j].cname}
           </td> 
           <td>
            ${courseData[j].ctype}
           </td> 
           <td>
            ${courseData[j].credits}
           </td> 
        </tr>
        `
    }
    x+=`
    </table>
    `;
    lc.innerHTML+= x;
}
function fillFormData(offeredCourses){
  
       /* {
            "course_id": 21,
            "cname": "DATABASE SYSTEMS",
            "ctype": "CORE",
            "dept_id": 0,
            "semno": 6,
            "credits": 4
        }*/
        let semno = offeredCourses[0].semno;
        let k = document.getElementById("reg");
        let x=`
                <h6 class="text-center bg-dark text-white border border-dark p-2">Register</h6>
                </hr>

                <table class="w-75 mx-auto">
                    <tr>
                        <th>Course Name</th>
                        <th>Course Type</th>
                        <th>Credits</th>
                        <th>Register</th>
                    </tr>`
        for(let i=0;i<offeredCourses.length;i++)
        {
                x+=`
                <tr>
                    <td>
                        ${offeredCourses[i].cname}
                    </td>
                    <td>
                        ${offeredCourses[i].ctype}
                    </td>
                    <td>
                        ${offeredCourses[i].credits}
                    </td>
                    <td><input type="checkbox" name="${offeredCourses[i].course_id}" id=${offeredCourses[i].course_id}></td>
                </tr>
                `
        }
        x+=`
        </table>`;
        x+=`
           <div class="mt-2 d-flex justify-content-center"> <button type="submit" class="btn btn-dark" id="register">Register</button></div>
        `;
        k.innerHTML = x;
        let p = document.getElementById("register");
        //console.log(p);
        if(p){
            //console.log(p);
            p.addEventListener("click",async (e)=>{
                    e.preventDefault();
                    // p.disabled=true;
                    //console.log("clicked");
                    let regDiv = document.getElementById("reg");
                    let chkbx = regDiv.getElementsByTagName("input");
                    let regData = [];
                    for(let i=0;i<chkbx.length;i++){
                        if(chkbx[i].checked){
                            regData.push(chkbx[i].name);
                        }
                    }
                    console.log(regData);

                    p.innerHTML = `<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                    Registering...`;
                    try{
                        let response = await axios({
                            url:"http://localhost:8081/register",
                            method:"post",
                            data:regData
                        })
                        if(response.status==200){
                            document.getElementById("info").innerHTML=
                                `
                        <div class="alert alert-success" role="alert">
                            Registration Successful!
                        </div>
                        `;

                        }
                    }
                    catch(e){
                        console.log(e.response.data);
                        console.log(e.response);
                        console.log(e.response.headers);
                        p.innerHTML = `<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                    Refresh page and try again...`;
                        document.getElementById("info").innerHTML=
                            `
                            <div class="alert alert-danger" role="alert">
                                ${e.response.data}
                            </div>
                            `
                    }

                    // if(response.status==200){
                    //     document.getElementById("info").innerHTML=
                    //     `
                    //     <div class="alert alert-success" role="alert">
                    //         Registration Successful!
                    //     </div>
                    //     `;
                    //     //fillCourseTable(response.data,semno);
                    // }else{
                    //     if(response.status==400){
                    //         document.getElementById("info").innerHTML=
                    //         `
                    //         <div class="alert alert-danger" role="alert">
                    //             ${response.data}
                    //         </div>
                    //         `
                    //     }
                    // }

                    // console.log(response);
                    
                    // console.log(semno);
            });
        }
    

}
(function(){
    
   getDataAndFill('http://localhost:8081/srollreg');
   //getDataAndFill('https://jsonplaceholder.typicode.com/todos/1');
})();
