
const getDataAndFill = async function(url){
    try {
        let response = await axios.get(url);
        if(response.status==200 ){
           //console.log(response.data); 
           //let data = response.data;
        //    let data = [
        //     [
        //         [
        //             "PDS",
        //             1,
        //             4,
        //             "CORE",
        //             1
        //         ],
        //         [
        //             "DATA STRUCTURES",
        //             9,
        //             4,
        //             "CORE",
        //             3
        //         ],
        //         [
        //             "DISCRETE MATHS",
        //             10,
        //             4,
        //             "CORE",
        //             3
        //         ],
        //         [
        //             "DATA STRUCTURES LAB",
        //             11,
        //             3,
        //             "LAB",
        //             3
        //         ],
        //         [
        //             "COMBINATORICS",
        //             13,
        //             4,
        //             "CORE",
        //             4
        //         ],
        //         [
        //             "ALGORITHMS",
        //             14,
        //             4,
        //             "CORE",
        //             4
        //         ],
        //         [
        //             "ALGORITHMS LAB",
        //             15,
        //             3,
        //             "LAB",
        //             4
        //         ],
        //         [
        //             "OPERATING SYSTEMS",
        //             17,
        //             4,
        //             "CORE",
        //             5
        //         ],
        //         [
        //             "COA",
        //             18,
        //             4,
        //             "CORE",
        //             5
        //         ],
        //         [
        //             "OPERATING SYSTEMS LAB",
        //             19,
        //             3,
        //             "LAB",
        //             5
        //         ],
        //         [
        //             "COA LAB",
        //             20,
        //             3,
        //             "LAB",
        //             5
        //         ],
        //         [
        //             "DATABASE SYSTEMS",
        //             21,
        //             4,
        //             "CORE",
        //             6
        //         ],
        //         [
        //             "DATABASE SYSTEMS LAB",
        //             22,
        //             3,
        //             "LAB",
        //             6
        //         ],
        //         [
        //             "CN",
        //             23,
        //             4,
        //             "CORE",
        //             6
        //         ],
        //         [
        //             "CN LAB",
        //             24,
        //             3,
        //             "LAB",
        //             6
        //         ],
        //         [
        //             "ELECTIVE-1",
        //             31,
        //             3,
        //             "ELECTIVE",
        //             4
        //         ],
        //         [
        //             "ELECTIVE-2",
        //             32,
        //             3,
        //             "ELECTIVE",
        //             4
        //         ],
        //         [
        //             "ELECTIVE-3",
        //             33,
        //             3,
        //             "ELECTIVE",
        //             6
        //         ],
        //         [
        //             "ELECTIVE-4",
        //             34,
        //             3,
        //             "ELECTIVE",
        //             6
        //         ],
        //         [
        //             "ELECTIVE-5",
        //             35,
        //             3,
        //             "ELECTIVE",
        //             8
        //         ],
        //         [
        //             "ELECTIVE-6",
        //             36,
        //             3,
        //             "ELECTIVE",
        //             8
        //         ],
        //         [
        //             "ADVANCED GRAPH THEORY",
        //             25,
        //             3,
        //             "MTECH-CORE",
        //             1
        //         ],
        //         [
        //             "NETWORK SECURITY",
        //             26,
        //             4,
        //             "MTECH-CORE",
        //             1
        //         ],
        //         [
        //             "MACHINE LEARNING",
        //             27,
        //             4,
        //             "MTECH-CORE",
        //             1
        //         ],
        //         [
        //             "MACHINE LEARNING-2",
        //             28,
        //             4,
        //             "MTECH-CORE",
        //             2
        //         ],
        //         [
        //             "PROJECT-1",
        //             29,
        //             3,
        //             "MTECH-CORE",
        //             2
        //         ],
        //         [
        //             "ADVANCED CN",
        //             30,
        //             3,
        //             "MTECH-CORE",
        //             2
        //         ]
        //     ],
        //     27
        // ]
           let data = response.data
            fillFormData(data[0]);
           //fillCourseList(data.coursesList);
        }
    } catch (error) {
        console.log(error);
    }
}

const getDataAndFill2 = async function(url){
    console.log(2);
    try {
        let response = await axios.get(url);
        if(response.status==200 ){
            console.log(response.data);
            //let data = response.data;
            //    let data = [
            //     [
            //         [
            //             "PDS",
            //             1,
            //             4,
            //             "CORE",
            //             1
            //         ],
            //         [
            //             "DATA STRUCTURES",
            //             9,
            //             4,
            //             "CORE",
            //             3
            //         ],
            //         [
            //             "DISCRETE MATHS",
            //             10,
            //             4,
            //             "CORE",
            //             3
            //         ],
            //         [
            //             "DATA STRUCTURES LAB",
            //             11,
            //             3,
            //             "LAB",
            //             3
            //         ],
            //         [
            //             "COMBINATORICS",
            //             13,
            //             4,
            //             "CORE",
            //             4
            //         ],
            //         [
            //             "ALGORITHMS",
            //             14,
            //             4,
            //             "CORE",
            //             4
            //         ],
            //         [
            //             "ALGORITHMS LAB",
            //             15,
            //             3,
            //             "LAB",
            //             4
            //         ],
            //         [
            //             "OPERATING SYSTEMS",
            //             17,
            //             4,
            //             "CORE",
            //             5
            //         ],
            //         [
            //             "COA",
            //             18,
            //             4,
            //             "CORE",
            //             5
            //         ],
            //         [
            //             "OPERATING SYSTEMS LAB",
            //             19,
            //             3,
            //             "LAB",
            //             5
            //         ],
            //         [
            //             "COA LAB",
            //             20,
            //             3,
            //             "LAB",
            //             5
            //         ],
            //         [
            //             "DATABASE SYSTEMS",
            //             21,
            //             4,
            //             "CORE",
            //             6
            //         ],
            //         [
            //             "DATABASE SYSTEMS LAB",
            //             22,
            //             3,
            //             "LAB",
            //             6
            //         ],
            //         [
            //             "CN",
            //             23,
            //             4,
            //             "CORE",
            //             6
            //         ],
            //         [
            //             "CN LAB",
            //             24,
            //             3,
            //             "LAB",
            //             6
            //         ],
            //         [
            //             "ELECTIVE-1",
            //             31,
            //             3,
            //             "ELECTIVE",
            //             4
            //         ],
            //         [
            //             "ELECTIVE-2",
            //             32,
            //             3,
            //             "ELECTIVE",
            //             4
            //         ],
            //         [
            //             "ELECTIVE-3",
            //             33,
            //             3,
            //             "ELECTIVE",
            //             6
            //         ],
            //         [
            //             "ELECTIVE-4",
            //             34,
            //             3,
            //             "ELECTIVE",
            //             6
            //         ],
            //         [
            //             "ELECTIVE-5",
            //             35,
            //             3,
            //             "ELECTIVE",
            //             8
            //         ],
            //         [
            //             "ELECTIVE-6",
            //             36,
            //             3,
            //             "ELECTIVE",
            //             8
            //         ],
            //         [
            //             "ADVANCED GRAPH THEORY",
            //             25,
            //             3,
            //             "MTECH-CORE",
            //             1
            //         ],
            //         [
            //             "NETWORK SECURITY",
            //             26,
            //             4,
            //             "MTECH-CORE",
            //             1
            //         ],
            //         [
            //             "MACHINE LEARNING",
            //             27,
            //             4,
            //             "MTECH-CORE",
            //             1
            //         ],
            //         [
            //             "MACHINE LEARNING-2",
            //             28,
            //             4,
            //             "MTECH-CORE",
            //             2
            //         ],
            //         [
            //             "PROJECT-1",
            //             29,
            //             3,
            //             "MTECH-CORE",
            //             2
            //         ],
            //         [
            //             "ADVANCED CN",
            //             30,
            //             3,
            //             "MTECH-CORE",
            //             2
            //         ]
            //     ],
            //     27
            // ]
            let data = response.data
            // fillFormData(data[0]);
            fillCourseList(data[0]);
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
        sem_wise[coursesList[i][4]-1].push(coursesList[i]);
    }
  
   for(let i=0;i<8;i++){
       if(sem_wise[i].length!=0){
            fillCourseTable(sem_wise[i],i+1);
       }
   }
   
   
}
function fillCourseTable(courseData,semno){
    let lc = document.getElementById("lcourses");
    // [cid, cname, credits, ctype, semno] = courseData
    let x =`
    <table class="w-100 mb-3">
        <tr>
        <th class="xyz">Semester: ${semno}</th>
        </tr>
        <tr>
        <th>S.no</th>
        <th>Course Name</th>
        <th>Course ID</th>
        <th>Course Type</th>
        <th>Credits</th>
        <th>Semester</th>
        </tr>
    `;
    for(let j=0;j<courseData.length;j++){
        x+=`
        <tr>
           <td>
            ${j+1}
           </td> 
           <td>
            ${courseData[j][0]}
           </td> 
            <td>
            ${courseData[j][1]}
           </td> 
           <td>
            ${courseData[j][3]}
           </td> 
           <td>
            ${courseData[j][2]}
           </td> 
           <td>
            ${courseData[j][4]}
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
  
       
        let k = document.getElementById("reg");
        let x=`
                <h6 class="text-center bg-dark text-white border border-dark p-2">Register</h6>
                </hr>

                <table class="w-100 mb-3">
                <tr>
                <th>S.no</th>
                <th>Course Name</th>
                <th>Course Type</th>
                <th>Credits</th>
                <th>Semester</th>
                <th>Register</th>
                </tr>`
        for(let i=0;i<offeredCourses.length;i++)
        {
                x+=`
                <tr>
                    <td>
                        ${i+1}
                    </td> 
                    <td>
                        ${offeredCourses[i][0]}
                    </td> 
                    <td>
                        ${offeredCourses[i][3]}
                    </td> 
                    <td>
                        ${offeredCourses[i][2]}
                    </td> 
                    <td>
                        ${offeredCourses[i][4]}
                    </td> 
                    <td>
                        <input type="checkbox" name="${offeredCourses[i][1]}" id=${offeredCourses[i][1]}></td>
                    </td>
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
                    p.disabled=true;
                    p.innerHTML = `<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                    Registering...`;
                    //console.log("clicked");
                    let regDiv = document.getElementById("reg");
                    let chkbx = regDiv.getElementsByTagName("input");
                    let regData = [];
                    for(let i=0;i<chkbx.length;i++){
                        if(chkbx[i].checked){
                            regData.push(chkbx[i].name);
                        }
                    }
                    let data = {
                        cids : regData
                    };
                    console.log("data is ",data);

                    
                    let response = await axios({
                        url:"http://localhost:8081/offercourses",
                        method:"post",
                        data:{
                            cids : regData
                        }
                    })
                    if(response.status==200){
                        document.getElementById("info").innerHTML=
                        `
                        <div class="alert alert-success" role="alert">
                            Registration Successful!
                        </div>
                        `;
                    }else{
                        if(response.status==400){
                            document.getElementById("info").innerHTML=
                            `
                            <div class="alert alert-danger" role="alert">
                                ${response.data}
                            </div>
                            `
                        }
                    }

                    console.log(response);
                    
            });
        }
    

}
(function(){
    
   getDataAndFill('http://localhost:8081/offercourses');
   getDataAndFill2('http://localhost:8081/mycourses');
})();
