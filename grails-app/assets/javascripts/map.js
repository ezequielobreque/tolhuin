var olview = new ol.View({
    center: [-9120944.666442728, 2653259.4403269454],
    resolution: 39135.75848201024,
    minZoom: 2,
    maxZoom: 20
});

var sourceFeatures = new ol.source.Vector(),
    layerFeatures = new ol.layer.Vector({source: sourceFeatures});

var map = new ol.Map({
    target: document.getElementById('map'),
    loadTilesWhileAnimating: true,
    loadTilesWhileInteracting: true,
    view: olview,
    renderer: 'canvas',
    layers: [
      new ol.layer.Tile({
        style: 'Aerial',
        source: new ol.source.MapQuest({layer: 'sat'})
      }),
      layerFeatures
    ]
});

var popup = new ol.Overlay.Popup;
popup.setOffset([0, -55]);
map.addOverlay(popup);

var long_string = 'a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text a long text ';


var style1 = [
    new ol.style.Style({
        image: new ol.style.Icon(({
            scale: 0.7,
            rotateWithView: false,
            anchor: [0.5, 1],
            anchorXUnits: 'fraction',
            anchorYUnits: 'fraction',
            opacity: 1,
            src: '//raw.githubusercontent.com/jonataswalker/map-utils/master/images/marker.png'
        })),
        zIndex: 5
    }),
    new ol.style.Style({
        image: new ol.style.Circle({
            radius: 5,
            fill: new ol.style.Fill({
                color: 'rgba(255,255,255,1)'
            }),
            stroke: new ol.style.Stroke({
                color: 'rgba(0,0,0,1)'
            })
        })
    })
];

var feature = new ol.Feature({
    type: 'click',
    desc: long_string,
    geometry: new ol.geom.Point([-9120944.666442728, 2653259.4403269454])
});
var feature2 = new ol.Feature({
    type: 'click',
    desc: long_string,
    geometry: new ol.geom.Point([-8347855.579795895, -679521.3556101936])
});
feature.setStyle(style1);
sourceFeatures.addFeature(feature);

feature2.setStyle(style1);
sourceFeatures.addFeature(feature2);

map.on('click', function(evt) {
    var f = map.forEachFeatureAtPixel(
        evt.pixel,
        function(ft, layer){return ft;}
    );
    if (f && f.get('type') == 'click') {
        var geometry = f.getGeometry();
        var coord = geometry.getCoordinates();
        
        var content = '<p>'+f.get('desc')+'</p>';
        
        popup.show(coord, content);
        
    } else { popup.hide(); }
    
});
map.on('pointermove', function(e) {
    if (e.dragging) { popup.hide(); return; }
    
    var pixel = map.getEventPixel(e.originalEvent);
    var hit = map.hasFeatureAtPixel(pixel);
    
    map.getTarget().style.cursor = hit ? 'pointer' : '';
});

