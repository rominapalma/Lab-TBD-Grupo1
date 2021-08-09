<template>
	<div id="container">
		<div id="map" @click="handleLocation"></div>
	</div>
</template>
<script>
import axios from "axios";
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import leaflet from "leaflet";

var icon = require('leaflet/dist/images/marker-icon.png');
var LeafIcon = L.Icon.extend({
	options: {iconSize: [25, 41], iconAnchor: [12, 41], popupAnchor: [-3, -41]}
});
var myIcon = new LeafIcon({iconUrl: icon});
export default {
	data() {
		return {
			firstPoint: null,
			mymap: null,
			location: {
				latlng: "",
			},
			points: [],
		}
	},
	methods: {
		async getPoints(map) {
			try {
				//se llama el servicio
				let response = await axios.get('http://localhost:8082/allVolunteer');
				let dataPoints = response.data;
				dataPoints.forEach(point => {
					let p = [point.latitude, point.longitude]
					let marker = L.marker(p, {icon: myIcon})
						.bindPopup(point.name)
					this.points.push(marker);
				});
				console.log(this.points)
				this.points.forEach(p => {
					p.addTo(map)
				})

			} catch (error) {
				console.log('error', error);
			}
		},
		handleLocation() {
			this.$emit('handleLocation', this.location)
		}
	},
	mounted: function () {
		var mymap = leaflet.map("map").setView([-33.456, -70.648], 12);

		/*Este marcador lo puse para probar. Así se pueden mostrar los voluntarios
		var marker = L.marker([-33.456, -70.648], {icon: myIcon}).addTo(mymap);
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

		mymap.on("click", function (e) {
			point.location.latlng = e.latlng;
			if (point.marker) {
				mymap.removeLayer(point.marker);
			}
			point.marker = leaflet.marker([e.latlng.lat, e.latlng.lng]).addTo(mymap);
		});
		this.mymap = mymap;
		this.getPoints(this.mymap);
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