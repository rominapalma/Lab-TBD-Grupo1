<template>
	<v-row class="justify-center pt-4 pa-4" width="100%">
		<v-col>
			<v-form ref="form" v-model="valid" lazy-validation>
				<v-text-field
					class="pa-2"
					v-model="urgencyForm.name"
					:rules="nameRules"
					label="¿Qué sucede?"
				></v-text-field>
				<v-text-field
					class="pa-2"
					v-model="urgencyForm.description"
					:rules="descriptionRules"
					label="Agrega más detalles."
				></v-text-field>

				<v-row class="pa-2">
					<v-col cols="6">
						<v-select
							v-model="urgencyForm.selectedInstitution"
							:items="institutions"
							dense
							item-text="name"
							item-value="id"
							label="Selecciona la institución a la que quieres acudir"
							@change="selectCoordinator()"
						></v-select>
					</v-col>
					<v-col cols="6">
						<v-select
							v-model="urgencyForm.selectedCoordinator"
							:items="coordinators"
							dense
							:disabled="disableCoordinator"
							item-text="name"
							item-value="id"
							label="Selecciona el/la coordinador/a que deseas acudir"
						></v-select>
					</v-col>
				</v-row>
				<v-row>
					<v-col cols="6">
            <p class="pl-2 letra--text" align="left">Fecha de inicio</p>
						<DatePicker ref="handleDateStart" @handleDate="handleDateStart"/>
					</v-col>
					<v-col cols="6">
						<!--El ref es el metodo del componente padre que se esta
						llamando aquí en conjunto con el parámetro entre comillas
						del @ y el @ es el del componente hijo que envía los datos-->
            <p class="pl-2 letra--text" align="left">Fecha de término</p>
						<DatePicker ref="handleDateEnd" @handleDate="handleDateEnd"/>
					</v-col>
				</v-row>

				<v-row class="pb-8">
					<p class="pl-5 letra--text" >Selecciona la ubicación de la emergencia</p>
					<v-col>
						<Map ref="handleLocation" @handleLocation="handleLocation"/>
					</v-col>
				</v-row>

				<v-btn
					:disabled="!valid"
					color="primary"
					@click="handleStep(); showUrgency();"
				>
					Continuar
				</v-btn>
			</v-form>

		</v-col>
	</v-row>
</template>
<script>
import axios from "axios";
import DatePicker from "@/components/DatePicker";
import Map from "@/views/Map";

export default {
	components: {
		DatePicker,
		Map,
	},
	props: ['info'],
	data: () => ({
		urgencyForm: {
			name: "",
			description: "",
			selectedInstitution: "",
			selectedCoordinator: "",
			start_date: "",
			end_date: "",
			latitude: "",
			longitude: "",
		},
		disableCoordinator: true,
		selected: null,
		institutions: [],
		coordinators: [],
		valid: true,
		nameRules: [
			v => !!v || "Debes ingresar un título o nombre de la emergencia.",
			v => v.length >= 0 || "No puedes dejar este campo vacío.",
		],
		descriptionRules: [
			v => !!v || "No puedes dejar este campo vacío.",
		]
	}),

	created: function () {
		axios.get("http://localhost:8082/allInstitutions").then((response) => {
			this.institutions = response.data;
		})
	},

	methods: {
		selectCoordinator() {
			axios.get("http://localhost:8082/coordinator/institution/" + this.urgencyForm.selectedInstitution).then((response) => {
				this.disableCoordinator = false;
				this.coordinators = response.data;
			});
		},
		showUrgency() {
			this.$emit('showUrgency', this.urgencyForm);
		},
		formatDate(date) {
			if (!date) return null
			const [year, month, day] = date.split('-')
			return `${year}-${month}-${day}`
		},
		handleStep() {
			if (this.$refs.form.validate()) {
				this.$emit('handleStep');
				return true;
			}
			return false;
		},
		handleDateStart(){
			this.urgencyForm.start_date = this.$refs.handleDateStart.date;
		},
		handleDateEnd(){
			this.urgencyForm.end_date = this.$refs.handleDateEnd.date;
		},
		handleLocation() {
			this.urgencyForm.latitude = this.$refs.handleLocation.location.latlng.lat;
			this.urgencyForm.longitude = this.$refs.handleLocation.location.latlng.lng;
		},
	},
};
</script>
