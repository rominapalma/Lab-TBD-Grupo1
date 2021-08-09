<template>
	<v-flex>
		<v-card v-for="urgencyTS in urgencyTS" :key="urgencyTS.id" class="pt-9 pb-10 pr-16 texto" max-width="50%">
			<h1 class="titulo text-left pb-6 accent--text ">
				{{ urgencyTS.name }}
			</h1>
			<v-row>
				<v-col cols="4">

					<h2 class="numero text-left">
						Número de emergencia: {{ urgencyTS.id }}
					</h2>

					<h3 class="text-left pt-6 descripcion secondary--text">¿Qué sucedió?</h3>
					<h3 class="descripcion text-left">
						{{ !urgencyTS.description ? "Hey, aqui no hay nada" : urgencyTS.description }}
					</h3>

					<h3 class="text-left pt-6 descripcion secondary--text">Fecha de inicio y/o final:</h3>
					<h3 class="descripcion text-left">
						Fecha Inicio: {{ !urgencyTS.start_date ? "Hey, aqui no hay nada" : urgencyTS.start_date }}
					</h3>
					<h3 class="descripcion text-left">
						Fecha Termino: {{ !urgencyTS.end_date ? "Hey, aqui no hay nada" : urgencyTS.end_date }}
					</h3>

					<h3 class="text-left pt-6 descripcion secondary--text">De los voluntarios:</h3>
					<h3 class="descripcion text-left">
						Voluntarios requeridos: {{ !urgencyTS.num_vol_req ? 0 : urgencyTS.num_vol_req }}
					</h3>
					<h3 class="descripcion text-left">
						Voluntarios inscritos: {{ !urgencyTS.num_vol_signin ? 0 : urgencyTS.num_vol_signin }}

					</h3>
					<v-row>
						<v-col class="pt-16">
							<v-btn class="d-flex justify-center" :href="`/map2/${urgencyTS.id}`" color="cyan darken-1" dark small>
								Voluntarios cercanos
							</v-btn>
						</v-col>
					</v-row>

				</v-col>
				<v-col cols="8">
					<v-row class="pr-15">
						<v-col class="pr-16" cols="8">
							<MapVolunteer ref="handleLocation"/>
						</v-col>
					</v-row>
				</v-col>
			</v-row>
		</v-card>

	</v-flex>
</template>
<script>

import axios from "axios";
import MapVolunteer from "@/components/MapVolunteer";

export default {
	components: {
		MapVolunteer,
	},
	data() {
		return {
			urgencyTS: [],
		}
	},
	async created() {
		this.urgencyTSId = this.$route.params.id;
		try {
			await axios.get('http://localhost:8082/urgency/' + this.urgencyTSId + '/taskStatus').then((resp) => {
				this.urgencyTS = resp.data;
			});

			if (this.urgencyTS.length == 0) {
				await axios.get('http://localhost:8082/urgency/' + this.urgencyTSId).then((resp2) => {
					this.urgencyTS = resp2.data;
				})
			}
		} catch (e) {
			console.log(e);
		}


	}
};
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Asap&display=swap');

.texto {
	font-family: 'Asap', sans-serif;
	padding-left: 6vh;
}
</style>