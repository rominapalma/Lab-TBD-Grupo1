<template>
	<v-row class="justify-center pt-4 pa-4" width="100%">
		<v-col>
			<v-form  width="100%" ref="form" v-model="valid" lazy-validation>
				<v-text-field
					class="mt-1" full-width
					v-model="taskForm.name"
					:rules="nameRules"
					label="Ingrese el nombre de una tarea de la urgencia"
					required
				></v-text-field>

				<v-text-field
					class="mt-1 mb-2"
					v-model="taskForm.description"
					:rules="descriptionRules"
					label="Agrega detalles de la tarea."
					required
				></v-text-field>

				<v-text-field
					class="mt-1"
					v-model.number="taskForm.num_vol_req"
					:rules="numberRules"
					label="Cantidad de voluntarios requeridos."
					required
				></v-text-field>

				<v-btn
					class="mt-1"
					:disabled="!valid"
					color="primary"
					@click="handleStep(); showTask();"
				>
					Continuar
				</v-btn>
			</v-form>

		</v-col>
	</v-row>
</template>

<script>

export default {
	props: ['info'],
	data: vm => ({
		taskForm: {
			name: "",
			description: "",
			selected: null,
			num_vol_req: "",
			num_vol_signin: "",
			start_date: vm.formatDate(new Date().toISOString().substr(0, 10)),
			end_date: "",
			id_status_task: "",
			id_urgency: "",
		},
		valid: true,
		nameRules: [
			v => !!v ||  "Debes ingresar un título o nombre de la tarea.",
			v => v.length >= 0 || "No puedes dejar este campo vacío.",
		],
		descriptionRules: [
			v => !!v || "No puedes dejar este campo vacío.",
		],
		numberRules: [
			v => typeof v === 'number',
		]
	}),
	methods: {
		showTask(){
			console.log(this.taskForm.name)
			this.$emit('showTask', this.taskForm);
		},
		formatDate(date) {
			if (!date) return null
			const [year, month, day] = date.split('-')
			return `${year}-${month}-${day}`
		},
		handleStep(){
			if (this.$refs.form.validate()) {
				this.$emit('handleStep');
				return true;
			}
			return false;
		},
	},
};
</script>
