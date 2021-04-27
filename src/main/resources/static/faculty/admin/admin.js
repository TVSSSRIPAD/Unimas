document.getElementById("t").addEventListener('click',async ()=>{
    let data="";
    let response = await axios.get('http://localhost:8081/gettoppers');
    
    if(response.status==200){
        data = response.data;
    }
   // data =  [
   //  [
   //      "18CS01003",
   //      "STUDENT3",
   //      2018,
   //      "B.Tech",
   //      10
   //  ],
   //  [
   //      "18CS01002",
   //      "DUSHYANTH",
   //      2018,
   //      "B.Tech",
   //      10
   //  ],
   //  [
   //      "18CS01004",
   //      "STUDENT4",
   //      2018,
   //      "B.Tech",
   //      10
   //  ]
   //  ]
   //
    let k=document.getElementById("info");
    let  x= ``;
    x+=`
    <table class="mx-auto">
        <tr>
        <th>Student Name
        </th>
        <th>Roll No
        </th>
        <th>Batch
        </th>
        <th>Program
        </th>
        <th>CGPA
        </th>
        </tr>
    `
    for(let i=0;i<data.length;i++){
            x+=`
            <tr>
            <td>
            ${data[i][1]}
            </td>
            <td>${data[i][0]}
            </td>
            <td>${data[i][2]}
            </td>
            <td>
           ${data[i][3]}
            </td>
            <td>${data[i][4]}
            </td>
            </tr>
            `
    }
    x+=
    `
    </table>`;
    k.innerHTML = x;
})

document.getElementById("s").addEventListener('click',async ()=>{
    let data="";
    let response = await axios.get('http://localhost:8081/getstu');
    
    if(response.status==200){
        data = response.data;
    }
//    data = [
//     {
//         "sroll": "18CS01027",
//         "sname": "SRIPAD",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "sri@s3.com",
//         "phone": "9876543210",
//         "gender": "M",
//         "program": "B.Tech",
//         "address": "Kurnool, AP",
//         "dob": "2000-05-07 00:00:00"
//     },
//     {
//         "sroll": "18CS01001",
//         "sname": "SRIPAD",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "sri@s.com",
//         "phone": "9876543210",
//         "gender": "M",
//         "program": "B.Tech",
//         "address": "Kurnool, AP",
//         "dob": "2000-05-07 00:00:00"
//     },
//     {
//         "sroll": "18CS01002",
//         "sname": "DUSHYANTH",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "kd@s.com",
//         "phone": "9876543211",
//         "gender": "M",
//         "program": "B.Tech",
//         "address": "Guntur, AP",
//         "dob": "2000-12-05 00:00:00"
//     },
//     {
//         "sroll": "18CS01007",
//         "sname": "STUDENT7",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "s7@s.com",
//         "phone": "9876543217",
//         "gender": "M",
//         "program": "B.Tech",
//         "address": "Mumbai, MH",
//         "dob": "1999-12-11 00:00:00"
//     },
//     {
//         "sroll": "18CS01004",
//         "sname": "STUDENT4",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "s4@s.com",
//         "phone": "9876543214",
//         "gender": "M",
//         "program": "B.Tech",
//         "address": "Bhubaneswar, OD",
//         "dob": "1999-12-06 00:00:00"
//     },
//     {
//         "sroll": "18CS01005",
//         "sname": "STUDENT5",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "s5@s.com",
//         "phone": "9876543215",
//         "gender": "F",
//         "program": "B.Tech",
//         "address": "Hyderabad, AP",
//         "dob": "1999-12-16 00:00:00"
//     },
//     {
//         "sroll": "18CS01006",
//         "sname": "STUDENT6",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "s6@s.com",
//         "phone": "9876543216",
//         "gender": "M",
//         "program": "B.Tech",
//         "address": "Hyderabad, AP",
//         "dob": "1999-11-11 00:00:00"
//     },
//     {
//         "sroll": "18CS01003",
//         "sname": "STUDENT3",
//         "batch": 2018,
//         "dept_id": 1,
//         "email": "s3@s.com",
//         "phone": "9876543213",
//         "gender": "M",
//         "program": "B.Tech",
//         "address": "Hyderabad, AP",
//         "dob": "1999-12-06 00:00:00"
//     }
// ]
 
    let k=document.getElementById("info");
    let  x= ``;
    x+=`
    <table class="mx-auto">
        <tr>
        <th>Student Name
        </th>
        <th>Roll No
        </th>
        <th>DOB
        </th>
        <th>Email
        </th>
        <th>Phone
        </th>
        <th>Gender
        </th>
        <th>Program
        </th>
        <th>Batch
        </th>
        <th>Address
        </th>
        </tr>
    `
    for(let i=0;i<data.length;i++){
            x+=`
            <tr>
            <td>
            ${data[i].sname}
            </td>
            <td>${data[i].sroll}
            </td>
            <td>${data[i].dob.substr(0,10)}
            </td>
            <td>
           ${data[i].email}
            </td>
            <td>${data[i].phone}
            </td>
            <td>
            ${data[i].gender}
            </td>
            <td>${data[i].program}
            </td>
            <td>${data[i].batch}
            </td>
            <td>${data[i].address}
            </td>
            </tr>
            `
    }
    x+=
    `
    </table>`;
    k.innerHTML = x;
})

document.getElementById("f").addEventListener('click',async ()=>{
    let data="";
    let response = await axios.get('htpp://localhost:8081/getfac');
    
    if(response.status==200){
        data = response.data;
    }
    // data= [
    //     {
    //         "faculty_id": 1,
    //         "fname": "PADMALOCHAN BERA",
    //         "joining_date": "2011-10-10 00:00:00",
    //         "dept_id": 1,
    //         "email": "f1@s.com",
    //         "phone": "8765432109",
    //         "gender": "M",
    //         "salary": 1000000,
    //         "job_id": 1
    //     },
    //     {
    //         "faculty_id": 2,
    //         "fname": "SUDIPATA SAHA",
    //         "joining_date": "2011-11-10 00:00:00",
    //         "dept_id": 1,
    //         "email": "f2@s.com",
    //         "phone": "8765432110",
    //         "gender": "M",
    //         "salary": 1000000,
    //         "job_id": 1
    //     },
    //     {
    //         "faculty_id": 3,
    //         "fname": "JOY",
    //         "joining_date": "2011-10-10 00:00:00",
    //         "dept_id": 1,
    //         "email": "f3@s.com",
    //         "phone": "8765432119",
    //         "gender": "M",
    //         "salary": 1000000,
    //         "job_id": 1
    //     },
    //     {
    //         "faculty_id": 4,
    //         "fname": "DEBI PRASAD DOGRA",
    //         "joining_date": "2014-10-10 00:00:00",
    //         "dept_id": 1,
    //         "email": "f4@s.com",
    //         "phone": "8765432129",
    //         "gender": "M",
    //         "salary": 1000000,
    //         "job_id": 1
    //     },
    //     {
    //         "faculty_id": 5,
    //         "fname": "SRINIVAS PINISETTY",
    //         "joining_date": "2015-10-10 00:00:00",
    //         "dept_id": 1,
    //         "email": "f5@s.com",
    //         "phone": "8765432139",
    //         "gender": "M",
    //         "salary": 1000000,
    //         "job_id": 1
    //     }
    // ]

    let k=document.getElementById("info");
    let  x= ``;
    x+=`
    <table class="mx-auto">
        <tr>
        <th>Faculty Name
        </th>
        <th>Email
        </th>
        <th>Phone
        </th>
        <th>Gender
        </th>
        <th>Joining Date
        </th>
        <th>Salary
        </th>
        </tr>
    `
    for(let i=0;i<data.length;i++){
            x+=`
            <tr>
            <td>
            ${data[i].fname}
            </td>
            <td>
           ${data[i].email}
            </td>
            <td>${data[i].phone}
            </td>
            <td>
            ${data[i].gender}
            </td>
            <td>${data[i].joining_date}
            </td>
            <td>${data[i].salary}
            </td>
            </tr>
            `
    }
    x+=
    `
    </table>`;
    k.innerHTML = x;
})

