<template>
	<v-flex class="boxUrgencyF">
		<v-row class="pt-16">
			<v-col>
				<h1 class="display-3 secondary--text">Emergencias Finalizadas</h1>
			</v-col>
		</v-row>
		<v-row>
			<v-col class="d-flex justify-center pa-16" align="center" >
				<UrgencyFinished/>
			</v-col>
		</v-row>
	</v-flex>
</template>
<script>
import UrgencyFinished from "@/components/UrgencyFinished";
export default {
	components: {
		UrgencyFinished
	},
	created() {
		console.log("toy vivo")
	}
}

</script>
<style>
.boxUrgencyF {
	background: url("../assets/fondo-generico.png") fixed;
	background-size: cover;
	height: 100%;
}
</style>