(function () {
    getAndFillData('http://localhost:8081/faccurr');

})();
function fillViewData(current_course, data) {
    let current_sem = data[0][3];
    let current_batch = data[0][2];
    let course_id = data[0][4];

    //console.log(course_id,"xy");
    let k = document.getElementById("cdata-view");

    let x = "";
    x =
        `<h6>Course: <span id="ccourse">${current_course}</span></h6>
        <table class="mb-3"> 
        <tr >
        <th class="xyz">
        Batch: ${current_batch}
        </th>
        <th class="xyz">
        </th>
        <th class="xyz">
        </th>
        <th class="xyz">
        Semester: ${current_sem}
        </th>
        </tr>

        <tr> <th>S.no</th><th>Student Name </th>
         <th>Roll No </th>
         <th>Grade </th>
        </tr>
        `
    let j = 0;
    for (let i = 0; i < data.length; i++) {
        j++;
        x += `

                <tr>
                <td>
                ${j}
                </td>
                <td>
                ${data[i][1]}
                </td>
                <td>
                ${data[i][0]}
                </td>
                <td>
                <input type="number" step="1" min="1" max="10" name="${data[i][0]}" required />
                </td>
                </tr>
            `
    }
    x += `
        </table>
        <div class="d-flex flex-row justify-content-center">
        <button type="submit" id="gradeSub" class="btn btn-dark text-white">Submit</button>
        </div>
        `;
    k.innerHTML = x;
    let l = document.getElementById("gradeSub");
    l.addEventListener("click",async (e)=>{
        e.preventDefault();
        e.target.disabled=true;
        console.log("clicked");
        let gradeData=[];
        let w = document.getElementById("cdata-view");
        let gradeIP = w.getElementsByTagName("input");
        for(let i=0;i<gradeIP.length;i++){
            
                console.log(gradeIP[i].value);
                gradeData.push({sroll:gradeIP[i].name,course_id:course_id,grade:(gradeIP[i].value).length==0? "0":(gradeIP[i].value)});
        }
        console.log(gradeData);
        let response = await axios({
            url:"http://localhost:8081/gradestudents",
            method:"post",
            data:gradeData
        });

        //console.log(response.data);
        e.target.innerHTML = `
        <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
        Grading...`;
       
    })

}
function fillData(data){

    let tot_courses = data[2];
    let list_courses = data[0];

    let stud_data = data[1];
    let num_students = [];
    for (let i = 0; i < tot_courses; i++) {
        num_students.push(stud_data[list_courses[i]].length);
    }
    console.log(num_students)
    let k = document.getElementById("ccl");
    let x = "";
    for (let i = 0; i < tot_courses; i++) {
        x += `
        <button type="button" id="${list_courses[i]}"  class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
        ${list_courses[i]}
        <span class="badge badge-primary badge-pill" data-toggle="tooltip" data-placement="left" title="#students">${num_students[i]}</span>
        </button>
        `
    }

    let current_course = list_courses[0];
    k.innerHTML = x;

    let buttons = document.getElementsByTagName("button");
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', (e) => {
            //e.target.id = "DATABASE SYSTEMS"
            console.log(e.target)
            fillViewData(e.target.id, stud_data[e.target.id]);
        })
    }
    fillViewData(current_course, stud_data[current_course]);
    console.log(data);
}

async function getAndFillData(url){
    try {
        let response = await axios.get(url);
        if(response.status==200){
            console.log(response.data);
            fillData(response.data);
        }
    } catch (error) {
        console.log(error);
    }
}
