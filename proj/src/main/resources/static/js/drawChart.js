//function drawchart(yAxisData) {
  xAxisData = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
  var ctx = document.getElementById("myChart");

  var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: xAxisData,
      datasets: [{
        // data: [250, 320, 240, 255, 180, 10, 20],
        data: yAxisData,
        lineTension: 0,
        backgroundColor: '#007bff',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: {
          ticks: {
            beginAtZero: true
          }
        }
      },
      legend: {
        display: false,
      }
    }
  });
//}