<!doctype html>
<html lang="en">
<head>

    <meta name="layout" content="main" />
    <link rel="stylesheet" href="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.3.0/css/ol.css" type="text/css">

    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
    <link rel="stylesheet" href="https://openlayers.org/en/v5.3.0/css/ol.css" type="text/css">
    <g:javascript src="lea"></g:javascript>
    <style>
    .ol-popup {
        position: absolute;
        background-color: white;
        -webkit-filter: drop-shadow(0 1px 4px rgba(0,0,0,0.2));
        filter: drop-shadow(0 1px 4px rgba(0,0,0,0.2));
        padding: 15px;
        border-radius: 10px;
        border: 1px solid #cccccc;
        bottom: 12px;
        left: -50px;
        min-width: 280px;
    }
    .ol-popup:after, .ol-popup:before {
        top: 100%;
        border: solid transparent;
        content: " ";
        height: 0;
        width: 0;
        position: absolute;
        pointer-events: none;
    }
    .ol-popup:after {
        border-top-color: white;
        border-width: 10px;
        left: 48px;
        margin-left: -10px;
    }
    .ol-popup:before {
        border-top-color: #cccccc;
        border-width: 11px;
        left: 48px;
        margin-left: -11px;
    }
    .ol-popup-closer {
        text-decoration: none;
        position: absolute;
        top: 2px;
        right: 8px;
    }
    .ol-popup-closer:after {
        content: "✖";
    }

    #map {
        height: 100%;
        width: 100%;
    }
    #marker {
        width: 20px;
        height: 20px;
        border: 1px solid #088;
        border-radius: 10px;
        background-color: #0FF;
        opacity: 0.5;
    }
    #vienna {
        text-decoration: none;
        color: white;
        font-size: 11pt;
        font-weight: bold;
        text-shadow: black 0.1em 0.1em 0.2em;
    }

    .boxcode {
        -webkit-box-sizing: content-box;
        -moz-box-sizing: content-box;
        box-sizing: content-box;
        width: 160px;
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



    <script src="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.3.0/build/ol.js"></script>
    <title>OpenLayers example</title>
</head>
<body>
<div id="map"></div>

%{--<div id="marker" title="Marker"></div>--}%
<div id="popup" class="ol-popup">
    <a class="overlay" id="vienna" target="_blank">emprendimiento</a>
    <a href="#" id="popup-closer" class="ol-popup-closer"></a>
    <div id="popup-content"></div>
</div>
<script type="text/javascript">

    var map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([-67.1955032,-54.5108299]),

            zoom: 16
        })
    });





    var layer = new ol.layer.Vector({
        source: new ol.source.Vector({
            features: [
                new ol.Feature({
                    geometry: new ol.geom.Point(ol.proj.fromLonLat([-67.1955032, -54.5108299]))
                })
            ]
        })
    });
    map.addLayer(layer);


    var container = document.getElementById('popup');
    var content = document.getElementById('popup-content');
    var closer = document.getElementById('popup-closer');

    var overlay = new ol.Overlay({
        element: container,
        autoPan: true,
        positioning: 'center-center',
        autoPanAnimation: {
            duration: 250
        }
    });
    map.addOverlay(overlay);

    closer.onclick = function() {
        overlay.setPosition(undefined);
        closer.blur();
        return false;
    }

    map.on('singleclick', function (event) {
        if (map.hasFeatureAtPixel(event.pixel) === true) {
            var coordinate = event.coordinate;

            content.innerHTML = '<div class="boxcode"><b>Hello world!</b><br />I am a popup.</div>';
            overlay.setPosition(coordinate);
        } else {
            overlay.setPosition(undefined);
            closer.blur();
        }
    });


    var pos = ol.proj.fromLonLat([-67.1955032, -54.5108299]);

    var marker = new ol.Overlay({
        position: pos,
        positioning: 'center-center',
        element: document.getElementById('marker'),
        stopEvent: false
    });
    map.addOverlay(marker);

    // Vienna label
    var vienna = new ol.Overlay({
        position: pos,
        element: document.getElementById('vienna')
    });
    map.addOverlay(vienna);


/*
    map.on('click', function(evt){
        console.info(evt.pixel);
        console.info(map.getPixelFromCoordinate(evt.coordinate));
        console.info(ol.proj.toLonLat(evt.coordinate));
        var coords = ol.proj.toLonLat(evt.coordinate);
        var lat = coords[1];
        var lon = coords[0];
        var locTxt = "Latitude: " + lat + " Longitude: " + lon;
        // coords is a div in HTML below the map to display
        document.getElementById('coords').innerHTML = locTxt;
    }); */


</script>

<asset:javascript src="ol-popup.js"/>
</body>
</html>