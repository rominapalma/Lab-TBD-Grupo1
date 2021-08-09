<template>
	<v-menu
		ref="menu"
		v-model="menu"
		:close-on-content-click="false"
		:return-value.sync="date"
		min-width="auto"
		offset-y
		transition="scale-transition"
	>
		<template v-slot:activator="{ on }">
			<v-text-field
				v-model="date"
				v-on="on"
				label="Selecciona la fecha"
				prepend-icon="mdi-calendar"
				readonly
			></v-text-field>
		</template>
		<v-date-picker
			v-model="date"
			no-title
			scrollable
		>
			<v-spacer></v-spacer>
			<v-btn
				color="primary"
				text
				@click="menu = false"
			>
				Cancelar
			</v-btn>
			<v-btn
				color="primary"
				text
				@click="handleDate();"
			>
				OK
			</v-btn>
		</v-date-picker>
	</v-menu>
</template>
<script>
export default {
	props: ['infoDate'],
	data: () => ({
		date: new Date().toISOString().substr(0, 10),
		menu: false,
	}),
	methods:{
		handleDate(){
			this.$refs.menu.save(this.date);
			this.$emit('handleDate', this.date);
		}
	}
}
</script>