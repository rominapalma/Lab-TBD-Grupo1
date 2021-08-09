<template>
	<div id="container">
		<div id="map" @click="handleLocation"></div>
	</div>

</template>
<script>
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import leaflet from "leaflet";

export default {
	data: () => ({
		mymap: null,
		location:{
			latlng: "",
		}
	}),
	mounted: function() {
		console.log(process.env.VUE_APP_ACCESS_TOKEN)
		var mymap = leaflet.map("map").setView([-33.556023, -70.734428], 12);

		/*Este marcador lo puse para probar. Así se pueden mostrar los voluntarios
		var marker = L.marker([-33.456023, -70.634427]).addTo(mymap);
		marker.bindPopup("<b>Hello world!</b><br>I am a popup.").openPopup();*/

		L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
			attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
			maxZoom: 18,
			id: 'mapbox/streets-v11',
			tileSize: 512,
			zoomOffset: -1,
			accessToken: process.env.VUE_APP_ACCESS_TOKEN
		}).addTo(mymap);


		var point = this;

		mymap.on("click", function(e) {
			point.location.latlng = e.latlng;
			if (point.marker) {
				mymap.removeLayer(point.marker);
			}
			point.marker = leaflet.marker([e.latlng.lat, e.latlng.lng]).addTo(mymap);

		});
		this.mymap = mymap;
	},
	methods: {
		handleLocation(){
			this.$emit('handleLocation', this.location)
		}
	},
};
</script>

<style scoped>
@import "https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.5.1/leaflet.css";
#map {
	z-index: 0;
	width: 30vw;
	height: 50vh;
}
</style>