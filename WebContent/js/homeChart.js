const prepareChart = (resultData)=>{
    // Bind data
    let myData = {
        labels: [
            'Janvier', "Février", 'Mars', 'Avril','Mai','Juin' ,'Juillet','Août','September','November','Décember'
        ],

        datasets: [
            {
                label: 'diagramme',
                backgroundColor: [
                    'rgb(255, 154, 53,0.8)', 'rgb(62, 158, 255,0.8)', 'rgb(0, 196, 0,0.8)', 'rgb(255, 30, 30,0.8)','rgb(255, 144, 53,0.8)', 'rgb(652, 158, 255,0.8)', 'rgb(60, 196, 0,0.8)', 'rgb(655, 30, 30,0.8)', 'rgb(275, 30, 30,0.8)', 'rgb(0, 176, 0,0.8)', 'rgb(255, 303, 30,0.8)', 'rgb(255, 30, 30,3.8)'
                ],
                borderColor: 'rgb(255, 154, 53,0.3)',
                data: [ resultData.jan,resultData.feb,resultData.mar,resultData.apr,resultData.may,resultData.jun,resultData.jul,resultData.aug,resultData.sep,resultData.oct,resultData.nov,resultData.dec
                ],
                borderWidth: 1,
                borderColor: '#777',
                hoverBorderWidth: 3,
                hoverBorderColor: '#000'

            }
        ]

    };
    let myOptions = {
        title: {
            display: true,
            text: "Diagramme",
            fontSize: 16,
            fontColor: '#111'
        },
        legend: {
            display: false
        },
        scales: {
            xAxes: [
                {
                    ticks: {
                        maxRotation: 90
                    }
                }
            ],
            yAxes: [
                {
                    ticks: {
                        beginAtZero: true
                    }
                }
            ]
        }
    };

    //Diagramme
    let ctx = document.getElementById('canvas').getContext('2d');
    Chart.defaults.global.defaultFontFamily = 'Lato';
    Chart.defaults.global.defaultFontSize = 18;
    Chart.defaults.global.defaultFontColor = '#777';
    let Barchart = new Chart(ctx, {
        type: 'bar',
        data: myData,
        options: myOptions
    });
}
const creatChart = ()=>{
    //make ajax requesr to DataServlet
    $.ajax({
        url: "DataServlet",
        success: (result)=>{
            // desplay the result to the console to test can be omited
            for (const key in result.monthData) {
                console.log(`${key}: ${result.monthData[key]}`);
            }
            // draw the chart
            prepareChart(result.monthData);
            },
        error : (err)=>{
            console.log(err+"custom error by me");
        }
    });
}

$(document).ready(function(){
    creatChart();
});
//
// var homeChart ={
//
//     loadStudentData : function(){
//
//         let formattedstudentListArray =[];
//         const aStudent = {};
//         $.ajax({url: "DataServlet", success: function(result){
//                 console.log( " this is the result :" + result);
//                 // result.forEach(elt => {
//                 //     console.log(elt);
//                 //     // formattedstudentListArray.push([elt.mathematicsMark,aStudent.computerMark,aStudent.historyMark,aStudent.litratureMark,aStudent.geographyMark]);
//                 // });
//                 console.log(formattedstudentListArray);
//
//             },
//             error : function(err){console.log(err+"comstom error by me")}
//             });
//         // $.ajax({
//         //
//         //     url: "Home",
//         //
//         //     dataType:"json",
//         //
//         //     success: function(studentJsonData) {
//         //
//         //         console.log(studentJsonData);
//         //
//         //         $.each(studentJsonData,function(index,aStudent){
//         //
//         //             formattedstudentListArray.push([aStudent.mathematicsMark,aStudent.computerMark,aStudent.historyMark,aStudent.litratureMark,aStudent.geographyMark]);
//         //         });
//         //     },
//         //     error: function(xhr){
//         //         alert("An error occured: " + xhr.status + " " + xhr.statusText);
//         //     }
//         //
//         //
//         // });
//         return formattedstudentListArray;
//     },
//     /*Crate the custom Object with the data*/
//     createChartData : function(jsonData){
//
//         console.log(jsonData);
//         return {
//
//             labels : ["Mathematics", "Computers", "History","Literature", "Geography"],
//
//             datasets : [
//                 {
//                     fillColor : "rgba(255,0,0,0.3)",
//
//                     strokeColor : "rgba(0,255,0,1)",
//
//                     pointColor : "rgba(0,0,255,1)",
//
//                     pointStrokeColor : "rgba(0,0,255,1)",
//
//                     /*As Ajax response data is a multidimensional array, we have 'student' data in 0th position*/
//                     data : jsonData[0]
//                 }
//             ]
//         };
//     },
//     /*Renders the Chart on a canvas and returns the reference to chart*/
//     // renderStudenrRadarChart:function(radarChartData){
//     //
//     //     var context2D = document.getElementById("canvas").getContext("2d"),
//     //
//     //         // myRadar = new Chart(context2D).Radar(radarChartData,{
//     //         //
//     //         //     scaleShowLabels : false,
//     //         //
//     //         //     pointLabelFontSize : 10
//     //         // });
//     //
//     //         myRadar = new Chart(ctx, {
//     //         type: 'radar',
//     //         data: data,
//     //         options: options
//     //     });
//     //
//     //
//     //     return myRadar;
//     // },
//     /*Initalization Student render chart*/
//     initRadarChart : function(){
//
//         var studentData = homeChart.loadStudentData();
//         console.log(studentData);
//         // chartData = homeChart.createChartData(studentData);
//         //
//         // radarChartObj = homeChart.renderStudenrRadarChart(chartData);
//
//     }
// };
//

