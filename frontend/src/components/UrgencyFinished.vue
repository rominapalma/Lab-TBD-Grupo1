<template>
	<v-flex class="pa-16" >
		<v-card max-width="55%" class="pb-10 mb-16 texto" v-for="urgencyDetailAux in urgencyDetailAux" :key="urgencyDetailAux.id">
			<v-row>
        <v-col cols="6">
          <h1 class="titulo text-left pt-6 accent--text ">
            {{ urgencyDetailAux.name }}
          </h1>
          <h2 class="numero text-left">
            Número de emergencia: {{ urgencyDetailAux.id }}
          </h2>
        </v-col>
      </v-row>
      <v-row>
				<v-col cols="6">
					<h3 class="text-left pl-2 descripcion secondary--text">¿Qué sucedió?</h3>
					<h3 class="descripcion pl-2 text-left">
						{{ urgencyDetailAux.description }}
					</h3>

					<h3 class="text-left pt-8 pl-2 descripcion secondary--text">Cantidad de tareas asignadas a la emergencia</h3>
					<h3 class="descripcion pl-2 text-left">
						{{ urgencyDetailAux.tasks }}
					</h3>

					<h3 class="text-left pt-6 pl-2 descripcion secondary--text">Cantidad de voluntarios/as asignados/as a la emergencia</h3>
					<h3 class="descripcion pl-2 text-left">
						{{ urgencyDetailAux.volunteers }}
					</h3>

				</v-col>
				<v-col cols="6">
          <h3 class="text-left pl-2 descripcion secondary--text">Fecha de inicio y/o final:</h3>
          <h3 class="descripcion pl-2 text-left">
            Fecha Inicio: {{ urgencyDetailAux.start_date }}
          </h3>
          <h3 class="descripcion pl-2 text-left">
            Fecha Termino: {{ urgencyDetailAux.end_date }}
          </h3>

          <v-row class="pt-4">
            <v-img class="pl-4" style="margin-top: 15px; margin-left: 16px" src="https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-red.png" max-height="33"
                   max-width="18"></v-img>
            <h3 class="text-left pt-4 pl-2 descripcion secondary--text">Ubicación</h3>
          </v-row>

          <h3 class="descripcion pt-4 pl-2 text-left">
            Latitud: {{ urgencyDetailAux.latitude }}
          </h3>
          <h3 class="descripcion pl-2 text-left">
            Longitud: {{ urgencyDetailAux.longitude }}
          </h3>
				</v-col>
			</v-row>

		</v-card>

	</v-flex>
</template>
<script>

import axios from "axios";

export default {
	data() {
		return {
			urgencyDetailAux: [],
		}
	},
	created() {
		axios.get('http://localhost:8082/allUrgencyDetailAux').then((resp) => {
			this.urgencyDetailAux = resp.data;
		});
	}
};
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Asap&display=swap');
.texto{
	font-family: 'Asap', sans-serif;
	padding-left: 6vh;
}
</style>