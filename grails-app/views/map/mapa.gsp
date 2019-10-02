<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
          integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
          crossorigin=""/>

    <!-- Make sure you put this AFTER Leaflet's CSS -->
    <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
            integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
            crossorigin=""></script>
    <asset:javascript src="leaflet-providers.js"/>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
    #mapid { height: 100%;
        width:100%;


                }

    .leaflet-popup-content-wrapper, .leaflet-popup-tip {
        background: transparent;

    }
    .boxcode {
        -webkit-box-sizing: content-box;
        -moz-box-sizing: content-box;
        box-sizing: content-box;
        max-width: 250px;
        max-height: 250px;
        padding: 20px;
        overflow: hidden;
        border: 1px solid;
        -webkit-border-radius: 7px;
        border-radius: 7px;
        font: normal 16px/1 Tahoma, Geneva, sans-serif;
        color: rgba(0,0,0,1);
        text-align: center;
        -o-text-overflow: ellipsis;
        text-overflow: ellipsis;
        background: -webkit-repeating-linear-gradient(23.96248897457818deg, rgba(109,221,249,1) 0, rgba(108,152,247,1) 100%);
        background: -moz-repeating-linear-gradient(66.03751102542182deg, rgba(109,221,249,1) 0, rgba(108,152,247,1) 100%);
        background: repeating-linear-gradient(66.03751102542182deg, rgba(109,221,249,1) 0, rgba(108,152,247,1) 100%);
        background-position: 50% 50%;
        -webkit-background-origin: padding-box;
        background-origin: padding-box;
        -webkit-background-clip: border-box;
        background-clip: border-box;
        -webkit-background-size: auto auto;
        background-size: auto auto;
        -webkit-box-shadow: 1px 1px 1px 0 rgba(22,3,3,0.3) ;
        box-shadow: 1px 1px 1px 0 rgba(22,3,3,0.3) ;
        text-shadow: 1px 1px 1px rgba(0,0,0,0.2) ;
        text-shadow: 1px 1px 1px rgba(0,0,0,0.2) ;
    }
    </style>
</head>
<body>

<div id="mapid"></div>








<script>

    var mymap = L.map('mapid').setView([-54.5108299, -67.1955032], 13);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'pk.eyJ1IjoidGh4YXhlIiwiYSI6ImNqejNmaXk4dzAyeWYzcG9ldjZoN2s2Z2oifQ.odq5qehRuqIb2nU8HALFqg'
    }).addTo(mymap);
    /*L.tileLayer.provider('OpenTopoMap').addTo(mymap);*/




   /* var marker = L.marker([-54.5108, -67.19550]).addTo(mymap);*/
    /*var marker2 = L.marker([-54.50, -67.190]).addTo(mymap);*/
    /*var circle = L.circle([-54.510829, -67.19550], {
        color: 'red',
        fillColor: '#f03',
        fillOpacity: 0.5,
        radius: 500
    }).addTo(mymap);*/

    /*var polygon = L.polygon([
        [51.509, -0.08],
        [51.503, -0.06],
        [51.51, -0.047]
    ]).addTo(mymap);*/
    list = ${raw(list)};
    emp = ${raw(emp)};
    if(emp==null){

        if(list!=null) {

            list.forEach(myFunction);

            function myFunction(item) {
                if (item.longitud!=null && item.latitud!=null){

                var marker = L.marker([item.latitud,item.longitud]).addTo(mymap);

                marker.bindPopup("<div class='boxcode'>" +
                    '<div class="col-sm-12">'+
                    '<div class="card text-white bg-success mb-3" style="max-width: 250px;max-height: 250px">'+
                        "<h3>"+item.nombre+"<h3>" +
                    "<br>" +


                    "<a>Ambito:"+item.ambito+"</a>"+
                        "<br>"+
                    "<a>Rubro:"+item.rubro+"</a>"+
                        "<br>"+

                    "<a> Direccion:"+item.direccion+"</a>" +
                    "</div>"   );




                }



                /*sum += item;
                document.getElementById("demo").innerHTML = sum;*/
            }

            /*marker.bindPopup("<div class='boxcode'><a>Hello world!<br><a>I am a popup.</a></div>");
            marker2.bindPopup("<div class='boxcode'><a>Hello world!<br><a>I am a popup.</a></div>");*/

        }

        }else{
        var marker = L.marker([emp.latitud, emp.longitud]).addTo(mymap);
    marker.bindPopup("<div class='boxcode'><a>" + emp.nombre + "</a><br><a>I am a popup.</a></div>");
    }
    /*circle.bindPopup("I am a circle.");
    polygon.bindPopup("I am a polygon.");

    var popup = L.popup()
        .setLatLng([51.5, -0.09])
        .setContent("I am a standalone popup.")
        .openOn(mymap);*/




    var MacizosUrbanosGeneral = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
        layers: "catastro:Macizos Urbanos general",
        format: 'image/png',
        INFO_FORMAT:'application',
        transparent: true,
        version: '1.3',
        height:'286',
        width: '286'
    });
    var baseMaps = {
    };
    var ejido = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "tierras:gis_tolh_ejido",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;
    var ParcelasRural = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "catastro:gis_tolh_parcelas_rur",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;
    var Calles = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "catastro:gis_tolhuin_ncalles",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;

    var Barrios = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "catastro:gis_tolh_barrios",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;
    var lagos = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "ambiental:gis_tolh_lagos",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;
    var AreasProtegidas = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "ambiental:gis_tolh_areas_protegidas",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;
    var MacizosProvisorios =L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "tierras:Macizos Provisorios general lineas",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;


    var MacizosUrbanos = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "catastro:Macizos Urbanos general lineas",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;
    var turisitico = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
            layers: "turismo:gis_tolh_int_turistico",
            format: 'image/png',
            INFO_FORMAT:'application',
            transparent: true,
            version: '1.3',
            height:'286',
            width: '286'
        })
    ;
    var Zonficacion = L.tileLayer.wms('http://catastro.tolhuin.gob.ar/geoserver/ows?', {
        layers: "tierras:gis_tolh_zonificacion",
        format: 'image/png',
        INFO_FORMAT:'application',
        transparent: true,
        version: '1.3',
        height:'286',
        width: '286'
    });



    var overlays={
        "Macizos Urbanos general":   MacizosUrbanosGeneral,
        "Zonficacion":  Zonficacion,
        "Parcelas Rural": ParcelasRural,
        "Calles": Calles,
        "Barrios": Barrios,
        "Lagos": lagos,
        "Areas Protegidas": AreasProtegidas,
        "Macizos Provisorios":  MacizosProvisorios,
        "Macizos Urbanos general Lineas" : MacizosUrbanos,
        "turistico": turisitico,
        "Ejido":ejido
    };
    L.control.layers(baseMaps,overlays).addTo(mymap);

    basemaps.Countries.addTo(mymap);



    var popup = L.popup();

    function onMapClick(e) {
        popup
            .setLatLng(e.latlng)
            .setContent("You clicked the map at " + e.latlng.toString())
            .openOn(mymap);
    }

    mymap.on('click', onMapClick);

</script>



</body>

</html>