<template>
	<v-flex class="boxUrgency">
		<h1 class="pa-16 display-3 secondary--text">Emergencias de tu comunidad</h1>
		<v-row>
			<v-col class="timeline d-flex justify-center">
				<v-timeline class="pa-16">
					<v-timeline-item color="#FF4081" v-for="item in list" v-bind:key="item.id">
						<v-card>
							<h1 class="pt-6 accent--text">
								{{ item.name }}
							</h1>

							<h4 class="pl-2">
								Emergencia número {{ item.id }}
							</h4>

							<h4 class="pl-8 pt-6 text-left secondary--text">¿Qué sucedió?</h4>
							<h5 class="mr-8 ml-8 mt-2 text-left">
								{{ item.description }}
							</h5>

							<h4 class="pl-8 pt-6 text-left secondary--text">Fecha de inicio y/o final:</h4>
							<h5 class="mr-8 ml-8 mt-2 text-left">
								Fecha Inicio: {{ item.start_date }}
							</h5>
							<h5 class="mr-8 ml-8 mt-1 text-left">
								Fecha Termino: {{ item.end_date }}
							</h5>

							<v-card-text>
								<v-btn :href="`/urgency/${item.id}`" small dark color="cyan darken-1">
									Ver detalle
								</v-btn>
							</v-card-text>
						</v-card>
					</v-timeline-item>
				</v-timeline>
			</v-col>
		</v-row>
	</v-flex>
</template>
<script>
import axios from 'axios'

export default {
	name: "UrgencyList",
	data() {
		return {
			list: undefined
		}
	},
	mounted() {
		axios.get('http://localhost:8082/allUrgencies')
			.then((resp) => {
				this.list = resp.data;
			})
	}
}
</script>


<style>
.timeline {
	background-color: transparent !important;
}

.boxUrgency {
	background: url("../assets/fondo-generico.png") fixed;
	background-size: cover;
	height: 100%;
}

</style>