<template>
	<v-flex class="box pa-2">
		<h1 class="pa-6 secondary--text">Agrega una nueva emergencia</h1>
		<v-spacer></v-spacer>
		<v-row>
			<v-col align="center">
				<Stepper/>
			</v-col>
		</v-row>
	</v-flex>
</template>
<script>
import Stepper from "@/components/Stepper";

export default {
	components: {
		Stepper
	}
}
</script>
<style>
.box {
	background: url("../assets/fondo-generico.png") fixed;
	background-size: cover;
	height: 100%;
}
</style>