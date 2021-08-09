import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: '#e05780',
                secondary: '#6e97f0',
                tertiary: '#425a90',
                quaternary: '#5878c0',
                accent: '#00ACC1',
                error: '#FF5252',
                info: '#2196F3',
                success: '#4CAF50',
                warning: '#FFC107',
                custom: '#3c3e55',
                letra: '#666666'
            }
        }
    }
});
