<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />

        <title>Graficos estadísticos</title>
    </head>

    <body>

    	<h1>Emprendimientos por sector</h1>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
        <div class="chart-container" height:50; width:30">
            <canvas id="myChart" responsive=true></canvas>
   	    </div>

        <script>

            var ctx = document.getElementById("myChart").getContext('2d');
            data =  ${raw(data)};
            var myPieChart = new Chart(ctx,{
                type: 'pie',
                data: data,
                options: {
                    layout: {
                        padding: {
                            left: 0,
                            right: 0,
                            top: 0,
                            bottom: 0
                        }
                    }
                }
            });

            </script>

    </body>

</html> 
