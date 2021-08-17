db.volunteerMongo.insertMany([
{"name": "Maria Jesus Canoles", "email": "qwerty@usach.cl", "skill":["HH1", "HH2"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Romina Palma", "email": "qwerty@usach.cl", "skill":["HH2", "HH3"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Bastian Diaz", "email": "qwerty@usach.cl", "skill":["HH3", "HH4"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Renato Gomez", "email": "qwerty@usach.cl", "skill":["HH4", "HH5"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Matias Osses", "email": "qwerty@usach.cl", "skill":["HH1", "HH2", "HH3"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Esteban Cruces", "email": "qwerty@usach.cl", "skill":["HH10", "HH11", "HH3"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Simon Montenegro", "email": "qwerty@usach.cl", "skill":["HH20", "HH19", "HH8", "HH11"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Diego Teacher", "email": "qwerty@usach.cl", "skill":["HH17", "HH16"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Luis Teacher", "email": "qwerty@usach.cl", "skill":["HH15", "HH2"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false},
{"name": "Juan Manuel Sol", "email": "qwerty@usach.cl", "skill":["HH18"], "birthday": new Date(1998, 11, 03), "password": "123", "availability": true, "delete": false}
]);

db.skillMongo.insertMany([
    {"name": "Habilidad 1", "description": "Descripcion de la habilidad.", "code": "HH1", "delete": false},
    {"name": "Habilidad 2", "description": "Descripcion de la habilidad.", "code": "HH2", "delete": false},
    {"name": "Habilidad 3", "description": "Descripcion de la habilidad.", "code": "HH3", "delete": false},
    {"name": "Habilidad 4", "description": "Descripcion de la habilidad.", "code": "HH4", "delete": false},
    {"name": "Habilidad 5", "description": "Descripcion de la habilidad.", "code": "HH5", "delete": false},
    {"name": "Habilidad 6", "description": "Descripcion de la habilidad.", "code": "HH6", "delete": false},
    {"name": "Habilidad 7", "description": "Descripcion de la habilidad.", "code": "HH7", "delete": false},
    {"name": "Habilidad 8", "description": "Descripcion de la habilidad.", "code": "HH8", "delete": false},
    {"name": "Habilidad 9", "description": "Descripcion de la habilidad.", "code": "HH9", "delete": false},
    {"name": "Habilidad 10", "description": "Descripcion de la habilidad.", "code": "HH10", "delete": false},
    {"name": "Habilidad 11", "description": "Descripcion de la habilidad.", "code": "HH11", "delete": false},
    {"name": "Habilidad 12", "description": "Descripcion de la habilidad.", "code": "HH12", "delete": false},
    {"name": "Habilidad 13", "description": "Descripcion de la habilidad.", "code": "HH13", "delete": false},
    {"name": "Habilidad 14", "description": "Descripcion de la habilidad.", "code": "HH14", "delete": false},
    {"name": "Habilidad 15", "description": "Descripcion de la habilidad.", "code": "HH15", "delete": false},
    {"name": "Habilidad 16", "description": "Descripcion de la habilidad.", "code": "HH16", "delete": false},
    {"name": "Habilidad 17", "description": "Descripcion de la habilidad.", "code": "HH17", "delete": false},
    {"name": "Habilidad 18", "description": "Descripcion de la habilidad.", "code": "HH18", "delete": false},
    {"name": "Habilidad 19", "description": "Descripcion de la habilidad.", "code": "HH19", "delete": false},
    {"name": "Habilidad 20", "description": "Descripcion de la habilidad.", "code": "HH20", "delete": false},

    ]);