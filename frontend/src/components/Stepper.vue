<template>
	<v-stepper v-model="step" max-width="50%" outlined>
		<v-stepper-header>
			<v-stepper-step :complete="step > 1" editable step="1">
				Agrega detalles de la emergencia
			</v-stepper-step>
			<v-stepper-step :complete="step > 2" editable step="2">
				Agrega detalles de las tareas
			</v-stepper-step>
			<v-stepper-step :complete="step > 3" step="3">
				Envía tu emergencia
			</v-stepper-step>
		</v-stepper-header>

		<v-stepper-content step="1">

			<urgency-form ref="showUrgency" :info="step" @handleStep="handleStep()" @showUrgency="showUrgency"/>


		</v-stepper-content>

		<v-stepper-content step="2">

			<TaskForm ref="showTask" :info="step" @handleStep="handleStep()" @showTask="showTask"/>

		</v-stepper-content>

		<v-stepper-content step="3">
			<v-alert
				v-if="show"
				v-model="show"
				type="success"
			>Tu emergencia ha sido registrada correctamente
			</v-alert>

			<v-btn
				color="secondary"
				@click=" changeVisibility(); sendUrgency();"
			>
				Enviar
			</v-btn>
		</v-stepper-content>

	</v-stepper>
</template>
<script>
import UrgencyForm from "@/components/UrgencyForm";
import TaskForm from "@/components/TaskForm";
import axios from "axios";

export default {
	props: ['urgencyForm'],
	components: {
		TaskForm,
		UrgencyForm
	},
	data: () => ({
		show: false,
		step: 1,
		lastId: 0,
	}),
	methods: {
		handleStep() {
			switch (this.step) {
				case 1: {
					this.step = 2;
					break;
				}
				case 2: {
					this.step = 3;
					break;
				}
				default: {
					break;
				}
			}
		},
		changeVisibility() {
			this.show = true;
		},
		showUrgency() {
			console.log(this.$refs.showUrgency.urgencyForm.latitude + " latitude")
			console.log(this.$refs.showUrgency.urgencyForm.longitude + " longitude")
			/*console.log(this.$refs.showUrgency.urgencyForm.start_date);*/
		},
		showTask() {
			/*console.log("olaa");*/
		},
		sendUrgency() {
			try {
				axios.post("http://localhost:8082/urgency", {
					name: this.$refs.showUrgency.urgencyForm.name,
					description: this.$refs.showUrgency.urgencyForm.description,
					start_date: this.$refs.showUrgency.urgencyForm.start_date,
					end_date: this.$refs.showUrgency.urgencyForm.end_date,
					id_coordinator: this.$refs.showUrgency.urgencyForm.selectedCoordinator,
					latitude: this.$refs.showUrgency.urgencyForm.latitude,
					longitude: this.$refs.showUrgency.urgencyForm.longitude,
					delete: false,
				}).then((response) => {
					this.lastId = response.data.id;
					axios.post("http://localhost:8082/task/", {
						name: this.$refs.showTask.taskForm.name,
						description: this.$refs.showTask.taskForm.description,
						num_vol_req: this.$refs.showTask.taskForm.num_vol_req,
						num_vol_signin: 0,
						start_date: this.$refs.showTask.taskForm.start_date,
						end_date: "",
						id_urgency: this.lastId,
						id_status_task: 1,
						delete: false,
					})
				})

			} catch (err) {
				// Handle Error Here
				console.error(err);
			}

		},
	},
}
</script>