let Line;
(function(){
    console.log("i am loaded");
    getData('http://localhost:8081/srollgrades')
})();
async function getData(url){
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
function fillData(data){
    let programme = "b.tech"

    let sgpa = data.sgpa;
    let grades = data.sgrades;
    let k = document.getElementById("gtables");
    let globalTable =``;
    let sem_wise = [];
    for(let i=0;i<8;i++){
        sem_wise.push([]);
    }
    for(let i=0;i<grades.length;i++){
        sem_wise[grades[i].semno-1].push(grades[i]);
    }
    let sem_wise_grades = [];
    for(let i=0;i<8;i++){
        sem_wise_grades.push([]);
    }
    for(let i=0;i<sgpa.length;i++){
        sem_wise_grades[sgpa[i].semno-1].push(sgpa[i].gpa);
    }
    let CGPA=0;
    let counter=0;
    let gradesForP =[];
    for(let i=0;i<8;i++){
        gradesForP.push(sem_wise_grades[i].length==0?0:sem_wise_grades[i][0]);
        if(sem_wise_grades[i].length!=0){
            CGPA+= sem_wise_grades[i][0];
            //counter++;
        }
    } 
    
    console.log(sem_wise_grades);
    for(let i=0;i<8;i++){
        if(sem_wise[i].length!=0){
            let x = `
            <p>
               
            </p>
            <p>
               
            </p>
            <table class="w-100 mx-auto">
                <tr>
                <th class="xyz1">
                Semester: ${i+1}
                </th>
                <th class="xyz1">
                </th>
                <th class="xyz1">
                </th>
                <th class="xyz1 xyz2">
                SGPA: ${sem_wise_grades[i][0]}
                </th>
                </tr>
                <tr>
                    <th>
                        ${"Course Name"}
                    </th>
                    <th>
                        ${"Course Type"}
                    </th>
                    <th>
                        ${"Credits"}
                    </th>
                    <th>
                        ${"Grade"}
                    </th>
                </tr>
            `
            for(let j=0;j<sem_wise[i].length;j++){
                x+=`
                <tr>
                <td>
                    ${sem_wise[i][j].cname}
                </td>
                <td>
                    ${sem_wise[i][j].ctype}
                </td>
                <td>
                    ${sem_wise[i][j].credits}
                </td>
                <td>
                    ${sem_wise[i][j].grade}
                </td>
                </tr>
                `
            }
            x+=`
            </table>
            `
           globalTable+=x;
        }
        
    }
    while(gradesForP.length && gradesForP[gradesForP.length-1]==0){
        //console.log(gradesForP.length)
        gradesForP.pop();
    }
    counter = gradesForP.length; 
    CGPA = (counter==0)? 0:CGPA/counter;
    globalTable+=`
    <div>
       <strong>CGPA</strong>: ${CGPA}
    </div>
    `
    k.innerHTML = globalTable;

    let cxt = document.getElementById("progress");
    if(programme=="b.tech")drawLine(cxt,gradesForP,[1,2,3,4,5,6,7,8]);
    if(programme=="m.tech")drawLine(cxt,gradesForP,[1,2,3,4]);
}
function drawLine(cxt,grades,labels){
    if(Line){
        Line.destroy();
    }
    let _data = {
        labels:labels,
        datasets:[
            {
                label:'SGPA',
                fill:false,
                data:grades,
                borderColor:'rgb(0,0,0)'
            }
        ]
    }
    let _options = {

        scales: {
            y: {
                title:{
                    display:true,
                    text:"SGPA",
                    font: {
                        size: 15
                    }
                }
            },
            x:{
                title:{
                    display:true,
                    text:"Semester",
                    font: {
                        size: 15
                    }
                }
            }
        }

    }
    Line = new Chart(cxt,
        {
            type:'line',
            data:_data,
            options:_options
        });
        
}