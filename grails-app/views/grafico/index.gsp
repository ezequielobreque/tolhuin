<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />

        <title>Graficos estadísticos</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>

    </head>

    <body>




    <div class="row">
        <div class="col-xl-5 col-lg-5">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">bar char</h6>
                </div>
                <div class="card-body">
                    <div class="chart-container" style=" height:100%; width: 100%">
                        <canvas id="myBarChart" responsive=true></canvas>
                    </div>
                </div>
            </div>
        </div>



        <div class="col-xl-7 col-lg-7">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Emprendimientos por sector</h6>
            </div>
            <div class="card-body">
                <div class="chart-container" style=" height:100%; width: 100%">
                    <canvas id="myChart" responsive=true></canvas>
                </div>
            </div>
        </div>
    </div>
        </div>

        <script>



            var ctx = document.getElementById("myChart").getContext('2d');
            data = ${raw(data)};
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

            var ctx2 = document.getElementById("myBarChart").getContext('2d');

            var myBarChart = new Chart(ctx, {
                type: 'bar',
                data: data2,
                options: options
            });
            </script>

    </body>

</html> 
