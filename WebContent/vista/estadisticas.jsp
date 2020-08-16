<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Más vendidos</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
    		google.charts.load("current", {packages:['corechart']});
    		google.charts.setOnLoadCallback(drawChart);
    		var producto1;
    		element = document.getElementsByClassName("Producto");
    		if (element != null) {
    			producto1 = element.value;
    		}
    		else {
    		    producto1 = null;
    		}
    		
    		function drawChart() {
    		  var data = google.visualization.arrayToDataTable([
	        ["Producto", "Cantidad", { role: "style" } ],
    	    ["Cocacola", 8, "#b87333"],
        	["ESFERO ROJO", 10, "silver"],
	        ["ESFERO NEGRO", 0, "gold"],
    	    ["SOBRE MANILA", 0, "color: #a5f4f2"],
    	    ["Detergente", 0, "color: #a5f4f2"]
	      ]);

    	  var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

	      var options = {
    	    title: "Cantidad de productos vendidos",
	        width: 600,
    	    height: 400,
        	bar: {groupWidth: "95%"},
	        legend: { position: "none" },
    	  };
	      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
    	  chart.draw(view, options);
    	}
    	function drawChart1(){
    	  var data1 = google.visualization.arrayToDataTable([
  	        ["Producto", "Cantidad", { role: "style" } ],
      	    ["Producto1", 10, "color: #a5f4f2"],
          	["Producto2", 20, "color: #a5f4f2"],
  	        ["Producto3", 30, "gold"],
      	    ["Producto4", 40, "silver"],
      	    ["Producto4", 50, "#b87333"]
  	      ]);

      	  var view1 = new google.visualization.DataView(data1);
  	      view.setColumns([0, 1,
                         { calc: "stringify",
                           sourceColumn: 1,
                           type: "string",
                           role: "annotation" },
                         2]);

  	      var options1 = {
      	    title: "Cantidad de productos",
  	        width: 600,
      	    height: 400,
          	bar: {groupWidth: "95%"},
  	        legend: { position: "none" },
      	  };
  	      var chart1 = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      	  chart1.draw(view1, options1);
  		}
	</script>
	</head>
	<body>
		<div class="container pt-5">
			<div class="text-center">
				<h1>Más vendidos</h1>
			</div>

			<div class="row d-flex justify-content-center pt-5">
				<div id="columnchart_values" class="chart p-3 my-3" style="width: 900px; height: 300px;"></div>
			</div>
		</div>
	</body>
	
</html>