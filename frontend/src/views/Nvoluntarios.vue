<template>
	<v-flex class="boxUrgency">
		<h1 class="pa-16 display-3 secondary--text">Mapa con voluntarios y voluntarias cercanas</h1>
		<v-row>
			<v-col align="center">
				<map2 ref="handleLocation" @handleLocation="handleLocation"/>
			</v-col>
		</v-row>
	</v-flex>
</template>

<script>

import axios from "axios";

import map2 from "@/components/map2";
export default {
	components: {
		map2
	},
	data() {
		return {
            urgencyDetailAux: undefined
		}
	},
    created() {
		axios.get('http://localhost:8082/volunteerLocation').then((resp) => {
			this.urgencyDetailAux = resp.data;
		});
	},
}
</script>
<style>
.boxUrgency {
	background: url("../assets/fondo-generico.png") fixed;
	background-size: cover;
	height: 100%;
}
</style>
