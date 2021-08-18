print("Creando Base de Datos...");
conn = new Mongo("localhost");
db = conn.getDB("TBD");
db.dropDatabase();
db.createCollection("skillMongo");
db.createCollection("volunteerMongo");
print("Se ha creado la base de datos exitosamente!!");
