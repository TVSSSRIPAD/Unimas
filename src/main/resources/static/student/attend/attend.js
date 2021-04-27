

(function(){
    let daily = [
            [
                "CN LAB",
                "CN",
                "DATABASE SYSTEMS",
                "DATABASE SYSTEMS LAB"
            ],
            [
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-09T18:30:00.000+00:00",
                    "A"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-10T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-11T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-12T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-13T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-14T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-15T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-19T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-20T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS",
                    21,
                    "2021-02-21T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-09T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-10T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-11T18:30:00.000+00:00",
                    "A"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-12T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-13T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-14T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-15T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-19T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-20T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "DATABASE SYSTEMS LAB",
                    22,
                    "2021-02-21T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-09T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-10T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-11T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-12T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-13T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-14T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-15T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-19T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-20T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN",
                    23,
                    "2021-02-21T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-09T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-10T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-11T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-12T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-13T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-15T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-19T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-20T18:30:00.000+00:00",
                    "P"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-21T18:30:00.000+00:00",
                    "A"
                ],
                [
                    "CN LAB",
                    24,
                    "2021-02-22T18:30:00.000+00:00",
                    "P"
                ]
            ],
            4
        ];
   let formattedData = {};
   for(let i=0;i<daily[2];i++){
        formattedData[daily[0][i]] = [];
   }
   for(let i=0;i<daily[1].length;i++){
        formattedData[daily[1][i][0]].push([new Date(daily[1][i][2].substr(0,10)),(daily[1][i][3]=="P"?1:-1)]);
   }
    console.log(formattedData);
    let upperEle = document.getElementById('calendar_basic');
    let S = ``;
    for(let i=0;i<daily[2];i++){
        S+=`
        <div id = ${i}>
        </div>
        `
    }
    upperEle.innerHTML=S;
    google.charts.load("current", {packages:["calendar"]});
    google.charts.setOnLoadCallback(()=>{
        for(let i=0;i<daily[2];i++){
            drawChart(formattedData[daily[0][i]],daily[0][i],i)
        }
    });
    if(daily[2]>0){
        let k1 = document.getElementById("info");
        k1.innerHTML+=`
        <p>
           <strong> Note: </strong> <span style="width:12px;height:12px;background-color:#eb8841;display: inline-block"></span> Absent & <span style="width:12px;height:12px;background-color:#4f7ce1;display: inline-block"></span> Present.
        </p>
        `
    }
})();
(function(){
    let data = [
        [
            "CN LAB",
            24,
            9,
            10
        ],
        [
            "CN",
            23,
            10,
            10
        ],
        [
            "DATABASE SYSTEMS LAB",
            22,
            9,
            10
        ],
        [
            "DATABASE SYSTEMS",
            21,
            10,
            10
        ],
        [
            "COA LAB",
            20,
            10,
            10
        ],
        [
            "OPERATING SYSTEMS LAB",
            19,
            10,
            10
        ],
        [
            "COA",
            18,
            10,
            10
        ],
        [
            "OPERATING SYSTEMS",
            17,
            10,
            10
        ],
        [
            "INTRO TO ML",
            16,
            10,
            10
        ],
        [
            "ALGORITHMS LAB",
            15,
            10,
            10
        ],
        [
            "ALGORITHMS",
            14,
            10,
            10
        ],
        [
            "COMBINATORICS",
            13,
            10,
            10
        ],
        [
            "MATHS3",
            12,
            10,
            10
        ],
        [
            "DATA STRUCTURES LAB",
            11,
            10,
            10
        ],
        [
            "DISCRETE MATHS",
            10,
            10,
            10
        ],
        [
            "DATA STRUCTURES",
            9,
            10,
            10
        ],
        [
            "CHEMISTRY LAB",
            8,
            10,
            10
        ],
        [
            "ENGLISH2",
            7,
            10,
            10
        ],
        [
            "CHEMISTRY",
            6,
            10,
            10
        ],
        [
            "MATHS2",
            5,
            9,
            10
        ],
        [
            "MATHS",
            4,
            10,
            10
        ],
        [
            "PHYSICS",
            3,
            10,
            10
        ],
        [
            "ENGLISH",
            2,
            10,
            10
        ],
        [
            "PDS",
            1,
            9,
            10
        ]
    ];
    
    let k = document.getElementById("attend_table");
    let x = ``;
    x+=`
    <table class="mx-auto">
        <tr>
        <th>
            S.no
        </th>
        <th>
            Course Name
        </th>
        <th>
            Classes Attended
        </th>
        <th>
            Classes Conducted
        </th>
        <th>
            Percentage
        </th>
        </tr>
    `
    for(let i=0;i<data.length;i++){
        x+=`
        <tr>
        <td>
            ${i+1}
        </td>
        <td>
            ${data[i][0]}
        </td>
        <td>
            ${data[i][2]}
        </td>
        <td>
            ${data[i][3]}
        </td>
        <td>
            ${data[i][3]==0?(0):(Math.round(((data[i][2]/data[i][3]) + Number.EPSILON) * 100))}%
        </td>
        </tr>
        `
    }
    x+=`</table>`;
    k.innerHTML = x;
    //console.log(x);
})();



function drawChart(Data,course,id) {
 
 var dataTable = new google.visualization.DataTable();
 dataTable.addColumn({ type: 'date', id: 'Date' });
 dataTable.addColumn({ type: 'number', id: 'Present/Absent' });
 dataTable.addRows(Data);

 var chart = new google.visualization.Calendar(document.getElementById(id));

 var options = {
   title: course,
   //height:2000,
   calendar:{
    yearLabel: {
        fontName: 'Times-Roman',
        fontSize: 32,
        color:'#000000',
        bold: true,
      }
   }
 };

 chart.draw(dataTable, options);
}

