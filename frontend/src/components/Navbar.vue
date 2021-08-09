<template>
	<v-app-bar app>

		<v-app-bar-nav-icon href="/" class="ml-4">
			<v-img max-width="10%" src="@/assets/logo.png"></v-img>
		</v-app-bar-nav-icon>

		<h2 class="pa-4 voluntarios">VOLUNTARIOS</h2>

		<v-spacer></v-spacer>

		<v-btn href="/urgencyReport" style="margin-right: 0.5%" dark color="primary">
			REPORTAR
		</v-btn>

		<v-btn icon href="/">
			<v-icon>mdi-home</v-icon>
		</v-btn>

		<v-btn href="/urgencies" icon>
			<v-icon>mdi-eye</v-icon>
		</v-btn>

		<v-btn icon href="/urgencyFinishedDetail">
			<v-icon>mdi-check-circle</v-icon>
		</v-btn>

		<v-btn icon href="/HeyEstoNoEstaListo">
			<v-icon>mdi-account</v-icon>
		</v-btn>

	</v-app-bar>
</template>
<script>
export default {
	data: () => ({
		drawer: false,
		group: null,
	}),
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap');

.voluntarios {
	font-family: 'Hammersmith One', sans-serif;
	color: #e05780;
}

</style>