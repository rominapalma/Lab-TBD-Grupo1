<template>
	<v-flex class="box mt-3">

		<v-row class=" pt-8">
			<v-col class="pa-10">

				<h1 class="display-4 align-start primary--text">Reporta una nueva emergencia a la comunidad.</h1>

				<v-btn href="/urgencyReport" x-large class="justify-space-around ma-16" color="primary">
					Reporta una emergencia
				</v-btn>

			</v-col>
		</v-row>

		<v-row>
			<v-col class="pa-4">

				<h2 class="display-0 align-end secondary--text">Mira las emergencias activas dentro de tu
					comunidad.</h2>

				<v-btn href="/urgencies" large class="justify-space-around ma-10" dark color="tertiary">
					Emergencias de mi comunidad
				</v-btn>

			</v-col>
		</v-row>
		<v-row>
			<v-col class="pa-4">

				<h2 class="display-0 align-end secondary--text">Mira las emergencias finalizadas dentro de tu
					comunidad.</h2>


				<v-btn href="/UrgencyFinishedDetail" large class="justify-space-around ma-10" dark color="tertiary">
					Emergencias de finalizadas de mi comunidad
				</v-btn>

			</v-col>
		</v-row>


	</v-flex>
</template>
<style>
@import url('https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap');

.box {
	background: url("../assets/fondo-bombero.png") fixed;
	background-size: cover;
	height: 100%;
}
</style>