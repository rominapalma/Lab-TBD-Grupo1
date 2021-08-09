<template>
	<div id="container">
		<div>
			<div class="elegirVoluntarios">
				<v-card color="transparent" flat>
					<v-subheader>Seleccione la cantidad de voluntarios más cercanos a buscar</v-subheader>
					<v-card-text>
						<v-row>
							<v-col class="pr-4">
								<v-slider
									v-model="slider"
									:max="max"
									:min="min"
									class="align-center"
									hide-details
								>
									<template v-slot:append>
										<v-text-field
											id="perro"
											v-model="slider"
											class="mt-0 pt-0"
											hide-details
											single-line
											style="width: 60px"
											type="number"
										></v-text-field>
									</template>
								</v-slider>
							</v-col>
						</v-row>
					</v-card-text>
				</v-card>
			</div>
			<v-card-text class="pb-6">
				<v-btn color="primary" @click="handleStep(slider, $event)">
					Actualizar
				</v-btn>
			</v-card-text>
		</div>
		<div id="map" @click="handleLocation()"></div>
		<br>
		<br>


		<div class="elegirVoluntarios">
			<v-simple-table dense>
				<template v-slot:default>
					<thead>
					<tr>
						<th class="text-left">
							Voluntario/a
						</th>
						<th class="text-left">
							Distancia (metros)
						</th>
						<th class="text-left">
							Ubicación (grados)
						</th>
						<th class="text-left">

						</th>
					</tr>
					</thead>
					<tbody>
					<tr
						v-for="(item,index) in dataPoints" v-bind:key="item.id"
					>
						<td>{{ item.name }}</td>
						<td>{{ item.distance }}</td>
						<td>{{ item.latitude }}, {{ item.longitude }}</td>
						<td>
							<v-btn color="red darken-1" text @click="foundInMap(index, $event)">
								<v-icon>mdi-map-marker</v-icon>
							</v-btn>
						</td>
					</tr>
					</tbody>
				</template>
			</v-simple-table>
		</div>
		<br>
		<br>
	</div>

</template>
<script>
import axios from "axios";
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import leaflet from "leaflet";

var icon = require('leaflet/dist/images/marker-icon.png'); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
	options: {iconSize: [25, 41], iconAnchor: [12, 41], popupAnchor: [-3, -41]}
});
var myIcon = new LeafIcon({iconUrl: icon});
var redIcon = new L.Icon({
	iconUrl: 'https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-red.png',
	shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
	iconSize: [25, 41],
	iconAnchor: [12, 41],
	popupAnchor: [1, -34],
	shadowSize: [41, 41]
});
export default {
	data() {
		return {
			firstPoint: null,
			mymap: null,
			location: {
				latlng: "",
			},
			points: [], //colección de puntos cargados de la BD
			min: 0,
			max: 90,
			slider: 0,
			dataPoints: null
		}
	},
	methods: {
		foundInMap: function (n) {
			this.points[n].openPopup();
			this.mymap.setView([this.dataPoints[n].latitude, this.dataPoints[n].longitude]);
			window.scrollTo(0, 100);
		},
		handleStep: function (n) {
			this.clearMarkers(this.mymap);
			this.getPoints(this.mymap, n);
		},
		clearMarkers: function () { //eliminar marcadores

			this.points.forEach(p => {
				this.mymap.removeLayer(p);
			})
			this.points = [];
		},
		async getPoints(map, N) {
			try {
				//se llama el servicio
				this.idService = this.$route.params.id;
				let response2 = await axios.get('http://localhost:8082/urgency/' + this.idService);
				let point = response2.data[0]
				let marker = L.marker([point.latitude, point.longitude], {icon: redIcon}).addTo(map);
				this.mymap.setView([point.latitude, point.longitude]);
				marker.bindPopup("<b>Emergencia</b>").openPopup();
				let response = await axios.get('http://localhost:8082/volunteerDistance/' + point.latitude + '/' + point.longitude + '/' + N);
				this.dataPoints = response.data;

				//Se itera por los puntos
				this.dataPoints.forEach(point => {
					//Se crea un marcador por cada punto
					let p = [point.latitude, point.longitude]
					let marker = L.marker(p, {icon: myIcon}) //se define el ícono del marcador
						.bindPopup(point.name + " se encuentra a " + point.distance + " metros") //Se agrega un popup con el nombre

					//Se agrega a la lista
					this.points.push(marker);
				});
				//Los puntos de la lista se agregan al mapa
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
		console.log(process.env.VUE_APP_ACCESS_TOKEN)
		//var firstPoint = this.$methods.addFirstPoint()
		console.log(this.firstPoint)
		var mymap = leaflet.map("map").setView([-33.456, -70.648], 7);
		/*Este marcador lo puse para probar. Así se pueden mostrar los voluntarios*/

		L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
			attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
			maxZoom: 18,
			id: 'mapbox/streets-v11',
			tileSize: 512,
			zoomOffset: -1,
			accessToken: process.env.VUE_APP_ACCESS_TOKEN
		}).addTo(mymap);

		console.log(this.firstPoint)
		/*
		var point = this;
		mymap.on("click", function(e) {
			point.location.latlng = e.latlng;
			if (point.marker) {
				mymap.removeLayer(point.marker);
			}
			point.marker = leaflet.marker([e.latlng.lat, e.latlng.lng]).addTo(mymap);

		});*/
		this.mymap = mymap;
		this.getPoints(this.mymap, 0);
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

.elegirVoluntarios {
	padding-right: 30rem;
	padding-left: 30rem;
}
</style>