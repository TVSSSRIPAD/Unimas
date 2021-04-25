let Bar;
(function () {
    getAndFillData('http://localhost:8081/facall');
})();
// let  data = [
//     [
//         "INTRO TO ML",
//         "DISCRETE MATHS",
//         "PDS"
//     ],
//     {
//         "INTRO TO ML": [
//             [
//                 "18CS01001",
//                 "SRIPAD",
//                 2018,
//                 4,
//                 10,
//                 16
//             ],
//             [
//                 "18CS01002",
//                 "DUSHYANTH",
//                 2018,
//                 4,
//                 10,
//                 16
//             ],
//             [
//                 "18CS01003",
//                 "STUDENT3",
//                 2018,
//                 4,
//                 10,
//                 16
//             ],
//             [
//                 "18CS01004",
//                 "STUDENT4",
//                 2018,
//                 4,
//                 10,
//                 16
//             ]
//         ],
//         "DISCRETE MATHS": [
//             [
//                 "18CS01001",
//                 "SRIPAD",
//                 2018,
//                 3,
//                 9,
//                 10
//             ],
//             [
//                 "18CS01002",
//                 "DUSHYANTH",
//                 2018,
//                 3,
//                 10,
//                 10
//             ],
//             [
//                 "18CS01003",
//                 "STUDENT3",
//                 2018,
//                 3,
//                 10,
//                 10
//             ],
//             [
//                 "18CS01004",
//                 "STUDENT4",
//                 2018,
//                 3,
//                 10,
//                 10
//             ]
//         ],
//         "PDS": [
//             [
//                 "18CS01001",
//                 "SRIPAD",
//                 2018,
//                 1,
//                 10,
//                 1
//             ],
//             [
//                 "18CS01002",
//                 "DUSHYANTH",
//                 2018,
//                 1,
//                 10,
//                 1
//             ],
//             [
//                 "18CS01003",
//                 "STUDENT3",
//                 2018,
//                 1,
//                 10,
//                 1
//             ],
//             [
//                 "18CS01004",
//                 "STUDENT4",
//                 2018,
//                 1,
//                 10,
//                 1
//             ]
//         ]
//     },
//     3
// ];
// fillData(data);

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
                ${data[i][4]}
                </td>
                </tr>
            `
    }
    x += `
        </table>
        `;
    k.innerHTML= x;
    let ithGrade=[];
    for(let i=0;i<=10;i++){
        ithGrade.push(0);
    }
    for(let i=0;i<data.length;i++){
        ithGrade[data[i][4]]++;
    }
    drawBar(document.getElementById("bar"),ithGrade,[0,1,2,3,4,5,6,7,8,9,10])
    console.log(data);


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
        <span class="badge badge-dark badge-pill" data-toggle="tooltip" data-placement="left" title="#students">${num_students[i]}</span>
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
function drawBar(cxt,grades,labels){
    if(Bar){
        Bar.destroy();
    }
    let _data = {
        labels:labels,
        datasets:[
            {
                label:'Grades',
                fill:false,
                data:grades,
                borderColor:'rgb(0,0,0)',
                backgroundColor:'rgb(0,0,0)'
            }
        ]
    }
    let _options = {
        
            scales: {
                y: {
                    title:{
                        display:true,
                        text:"Count(Students)",
                        font: {
                            size: 15
                        }
                    }
                },
                x:{
                    title:{
                        display:true,
                        text:"Grade",
                        font: {
                            size: 15
                        }
                    }
                }
            }
        
    }
    Bar = new Chart(cxt,
        {
            type:'bar',
            data:_data,
            options:_options
        });
        
}
