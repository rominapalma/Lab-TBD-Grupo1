<template>
	<v-flex class="boxUrgency">
		<h1 class="pa-16 display-3 secondary--text">Emergencias de tu comunidad</h1>
		<v-row>
			<v-col align="center">
				<UrgencyDetail/>
			</v-col>
		</v-row>
	</v-flex>
</template>
<script>

import UrgencyDetail from "@/components/UrgencyDetail";
export default {
	components: {
		UrgencyDetail
	},
	data() {
		return {
		}
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
